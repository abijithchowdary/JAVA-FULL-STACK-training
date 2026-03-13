package com.capg.demat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.demat.entity.DematAccount;

public interface DematRepository extends JpaRepository<DematAccount, Long> {

    List<DematAccount> findByCustomerId(Long customerId);

}
