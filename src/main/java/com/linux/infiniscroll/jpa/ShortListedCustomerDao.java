package com.linux.infiniscroll.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.linux.infiniscroll.jpa.entities.ShortListedCustomer;

public interface ShortListedCustomerDao extends JpaRepository<ShortListedCustomer, Long>{
	

}
