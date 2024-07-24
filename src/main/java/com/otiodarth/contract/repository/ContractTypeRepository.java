package com.otiodarth.contract.repository;

import com.otiodarth.contract.model.ContractType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ContractTypeRepository extends JpaRepository<ContractType, UUID> {

    Optional<ContractType> findContractTypeByDescription(String description);

}
