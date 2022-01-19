package com.zensar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.entity.AddressEntity;

public interface AddressRepo extends JpaRepository<AddressEntity, Integer> {

}
