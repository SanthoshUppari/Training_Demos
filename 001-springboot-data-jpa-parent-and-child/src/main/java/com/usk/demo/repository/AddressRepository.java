package com.usk.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usk.demo.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{
	
	public Address findByUser_Id(Long id);

}
