package com.greenfox.orientationtrialexam.controllers;

import com.greenfox.orientationtrialexam.DTOs.DeleteAliasDTO;
import com.greenfox.orientationtrialexam.DTOs.GetAliasDTO;
import com.greenfox.orientationtrialexam.models.Alias;
import com.greenfox.orientationtrialexam.models.Link;
import com.greenfox.orientationtrialexam.services.AliasService;
import com.greenfox.orientationtrialexam.services.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

	private final AliasService aliasService;
	private final LinkService linkService;

	@Autowired
	public MainController(
		AliasService aliasService,
		LinkService linkService
	) {
		this.aliasService = aliasService;
		this.linkService = linkService;
	}



	@GetMapping("/")
	public String index(
		Model model,
		@RequestParam(name = "reaction", required = false) String reaction,
		@RequestParam(name = "aliasId", required = false) Long aliasId
	) {

		if (reaction != null) {
			model.addAttribute(
				"reaction",
				this.aliasService.decideReaction(reaction, aliasId)
			);

			model.addAttribute(
				"color",
				this.aliasService.decideColorByReaction(reaction)
			);

			return "index";
		}

		model.addAttribute(
			"aliases",
			this.aliasService.getAllAliases()
		);

		return "index";
	}



	@PostMapping("/save-link")
	public String saveLink(
		@RequestParam String link,
		@RequestParam String alias,
		RedirectAttributes rd
	) {
		if (this.aliasService.checkIfAliasExistsInDatabase(alias)) {
			rd.addAttribute("reaction", "fail");
			return "redirect:/";
		}

		Link link1 = new Link(link);
		Alias alias1 = new Alias(alias);
		this.linkService.saveLinkAndAlias(link1, alias1);
		Long aliasId = alias1.getId();

		rd.addAttribute("reaction", "success");
		rd.addAttribute("aliasId", aliasId);

		return "redirect:/";
	}



	@GetMapping("/a/{alias}")
	private ResponseEntity showUrlByAlias(@PathVariable String alias) {

		Optional<Alias> aliasOptional = this.aliasService.findByAlias(alias);

		if (aliasOptional.isPresent()) {
			Alias alias1 = aliasOptional.get();
			alias1.addHitCount();
			this.aliasService.save(alias1);

			String url =  alias1.getLink().getUrl();
			return ResponseEntity
				.status(HttpStatus.FOUND)
				.location(URI.create(url))
				.build();
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}



	@GetMapping("/api/aliases")
	public ResponseEntity apiAliasesGetIndex() {
		List<GetAliasDTO> arrayList = new ArrayList<>();
		for (Alias alias : this.aliasService.getAllAliases()) {
			arrayList.add(
				new GetAliasDTO(alias)
			);
		}

		return ResponseEntity.status(200).body(arrayList);
	}



	@DeleteMapping("/api/aliases/{id}")
	public ResponseEntity apiAliasesDelete(
		@PathVariable String id,
		@RequestBody(required = false) DeleteAliasDTO deleteAliasDTO
	) {
		if (deleteAliasDTO == null) {
			return new ResponseEntity(HttpStatus.FORBIDDEN);
		}

		Optional<Alias> aliasOptional = this.aliasService.findById(Long.valueOf(id));
		if (aliasOptional.isPresent()) {
			Alias alias = aliasOptional.get();
			if (deleteAliasDTO.getSecretCode().equals(alias.getSecretCode())) {
				this.aliasService.delete(alias);
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity(HttpStatus.FORBIDDEN);
		}

		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}
}