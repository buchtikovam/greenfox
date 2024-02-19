package com.greenfox.avuspopcode.controllers;

import com.greenfox.avuspopcode.dtos.*;
import com.greenfox.avuspopcode.entities.User;
import com.greenfox.avuspopcode.enums.RentStatus;
import com.greenfox.avuspopcode.mappers.MapStructMapper;
import com.greenfox.avuspopcode.services.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class RentController {
  private final RentService rentService;

  private final MapStructMapper mapper;

  @Autowired
  public RentController(RentService rentService, MapStructMapper mapper) {
    this.rentService = rentService;
    this.mapper = mapper;
  }

  @GetMapping("/rents")
  public ResponseEntity<Set<RentDTO>> getRents(
      @RequestParam(required = false, name = "status") List<String> statusList,
      @AuthenticationPrincipal User user
  ) {
    Long userId = user.getId();
    System.out.println(statusList);

    try {
      return ResponseEntity.ok(
          this.mapper.rentSetToDTO(this.rentService.getRentsByUserIdAndStatus(userId, statusList))
      );
    } catch (IllegalArgumentException e) {
      return ResponseEntity.badRequest().build();
    }
  }


  @PostMapping("/rents")
  public ResponseEntity<SuccessDTO> saveRent(
          @RequestBody RentPostDTO rentPostDTO,
          @AuthenticationPrincipal User user
  ) {
    Long userId = user.getId();
    this.rentService.saveRent(userId, rentPostDTO.getId());
    return ResponseEntity.ok(
            new SuccessDTO("Your rent is placed on the vehicle. Don't forget to checkout!")
    );
  }

  @PutMapping("/rents")
  public ResponseEntity<SuccessDTO> updateRentStatus(@RequestBody RentPutDTO rentPutDTO) {
    this.rentService.updateRentsStatus(rentPutDTO);
    return ResponseEntity.ok(
            new SuccessDTO("Rents were successfully updated")
    );
  }
}