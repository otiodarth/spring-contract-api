package com.otiodarth.contract.service;

import com.otiodarth.contract.model.ContractType;
import com.otiodarth.contract.repository.ContractTypeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractTypeServiceImpl implements ContractTypeService {
    private final ContractTypeRepository contractTypeRepository;

    public ContractTypeServiceImpl(ContractTypeRepository contractTypeRepository) {
        this.contractTypeRepository = contractTypeRepository;
    }

    @Override
    public ContractType createContractType(ContractType contractType) {
        Optional<ContractType> contractTypeAlreadyExists = contractTypeRepository.findContractTypeByDescription(contractType.getDescription());
        if (contractTypeAlreadyExists.isPresent()) {
            throw new IllegalArgumentException("Contract type already exists");
        }
        return contractTypeRepository.save(contractType);
    }
}
