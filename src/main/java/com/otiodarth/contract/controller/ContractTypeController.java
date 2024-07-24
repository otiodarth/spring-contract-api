package com.otiodarth.contract.controller;

import com.otiodarth.contract.model.ContractType;
import com.otiodarth.contract.service.ContractTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("contracts-types")
public class ContractTypeController {

    @Autowired
    private ContractTypeServiceImpl contractTypeServiceImpl;

    @PostMapping
    public ResponseEntity<?> createContractType(@RequestBody ContractType contractType, UriComponentsBuilder ucb) {
        try {
            ContractType createdContractType = contractTypeServiceImpl.createContractType(contractType);
            URI createdContractTypeLocation = ucb
                    .path("contracts-types/{id}")
                    .buildAndExpand(createdContractType.getId())
                    .toUri();
            return ResponseEntity.created(createdContractTypeLocation).body(createdContractType);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
        }
    }
}
