package com.otiodarth.contract;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ContractTypeRepository extends JpaRepository<ContractType, UUID> {

    Optional<ContractType> findContractTypeByDescription(String description);

}
