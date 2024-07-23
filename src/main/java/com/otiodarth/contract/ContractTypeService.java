package com.otiodarth.contract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractTypeService {

    @Autowired
    private ContractTypeRepository contractTypeRepository;

    public ContractType createContractType(ContractType contractType) {
        Optional<ContractType> contractTypeAlreadyExists = contractTypeRepository.findContractTypeByDescription(contractType.getDescription());
        if (contractTypeAlreadyExists.isPresent()) {
            throw new IllegalArgumentException("Contract type already exists");
        }
        return contractTypeRepository.save(contractType);
    }

}
