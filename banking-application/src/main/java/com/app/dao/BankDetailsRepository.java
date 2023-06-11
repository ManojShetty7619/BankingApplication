package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.BankDetails;

@Repository
public interface BankDetailsRepository extends JpaRepository<BankDetails, Integer> {

}
