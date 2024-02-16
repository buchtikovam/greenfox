package com.greenfoxacademy.bankofsimba.controllers;

import com.greenfoxacademy.bankofsimba.BankOfSimbaApplication;
import com.greenfoxacademy.bankofsimba.models.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class BankController {

	List<BankAccount> banks = new ArrayList<>(Arrays.asList(
		new BankAccount(
			"Simba",
			20000,
			"Lion",
			true,
			true
		),
		new BankAccount(
			"Mufasa",
			5000,
			"Lion",
			true,
			true
		),
		new BankAccount(
			"Scar",
			3000,
			"Lion",
			false,
			false
		),
		new BankAccount(
			"Timon",
			1800,
			"Meerkat",
			false,
			true
		),
		new BankAccount(
			"Sarabi",
			2200,
			"Lioness",
			false,
			true
		),
		new BankAccount(
			"Shenzi",
			2400,
			"Hyena",
			false,
			true
		)
	));



	// List all the bank accounts currently present
	@RequestMapping(
		value = "/",
		method = RequestMethod.GET
	)
	public String index(Model model) {
		model.addAttribute("banks", banks);
		return "index";
	}



	// Show a specified bank account
	@RequestMapping(
		value = "/detail/{id}",
		method = RequestMethod.GET
	)
	public String showBankAccount(@PathVariable("id") int id, Model model) {
		Optional<BankAccount> bankAccountOptional = findBankAccountById(id);

		if (bankAccountOptional.isPresent()) {
			BankAccount bank = bankAccountOptional.get();
			model.addAttribute("bank", bank);
			return "show";
		}

		return "redirect:/";
	}



	// Add a new bank account
	@PostMapping("/save-bankAccount")
	public String save(
		@ModelAttribute BankAccount bank
	) {
		banks.add(bank);
//		bank.incrementCounter();
		return "redirect:/";
	}



	// Raise amount of specified animal
	@PostMapping("/add-money")
	public String addMoney(@RequestParam int id) {
		Optional<BankAccount> bankAccountOptional = findBankAccountById(id);

		if (bankAccountOptional.isPresent()) {
			BankAccount bank = bankAccountOptional.get();

			if (bank.isKing()) {
				bank.addBalance(100);
			} else {
				bank.addBalance(10);
			}
		}

		return "redirect:/";
	}



	// Helper method to find a specified bank
	private Optional<BankAccount> findBankAccountById(int id){
		return banks.stream()
			.filter(bank -> bank.getId() == id)
			.findFirst();
	}
}