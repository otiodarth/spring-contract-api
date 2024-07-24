package com.otiodarth.contract.controller;

import com.otiodarth.contract.model.ContractType;
import com.otiodarth.contract.response.ApiResponse;
import com.otiodarth.contract.service.ContractTypeServiceImpl;
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
    private final ContractTypeServiceImpl contractTypeServiceImpl;

    ContractTypeController(ContractTypeServiceImpl contractTypeServiceImpl) {
        this.contractTypeServiceImpl = contractTypeServiceImpl;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createContractType(@RequestBody ContractType contractType, UriComponentsBuilder ucb) {
        try {
            ContractType createdContractType = contractTypeServiceImpl.createContractType(contractType);
            URI createdContractTypeLocation = ucb
                    .path("contracts-types/{id}")
                    .buildAndExpand(createdContractType.getId())
                    .toUri();
            ApiResponse<ContractType> response = ApiResponse.success(
                    createdContractType,
                    "Created successfully",
                    HttpStatus.CREATED.value());
            return ResponseEntity.created(createdContractTypeLocation).body(response);

        } catch (IllegalArgumentException e) {
            ApiResponse<String> response = ApiResponse.error(e.getMessage(), HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.badRequest().body(response);
        } catch (Exception e) {
            ApiResponse<String> response = ApiResponse.error(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
            return ResponseEntity.internalServerError().body(response);
        }
    }
}
