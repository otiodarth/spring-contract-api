package com.otiodarth.contract.service;

import com.otiodarth.contract.model.ContractType;
import com.otiodarth.contract.repository.ContractTypeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractTypeService {
    private final ContractTypeRepository contractTypeRepository;

    public ContractTypeService(ContractTypeRepository contractTypeRepository) {
        this.contractTypeRepository = contractTypeRepository;
    }

    public ContractType createContractType(ContractType contractType) {
        Optional<ContractType> contractTypeAlreadyExists = contractTypeRepository.findContractTypeByDescription(contractType.getDescription());
        if (contractTypeAlreadyExists.isPresent()) {
            throw new IllegalArgumentException("Contract type already exists");
        }
        return contractTypeRepository.save(contractType);
    }

}
