package com.zensar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.entity.BillingInfoEntity;

public interface BillingInfoRepo extends JpaRepository<BillingInfoEntity, Integer>{

	
}
