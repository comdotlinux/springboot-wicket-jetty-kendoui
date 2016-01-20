package com.linux.infiniscroll.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.linux.infiniscroll.wicket.page.Customer;

public interface CustomerDao extends JpaRepository<Customer, Long> {

	// tag::methods[]
	long countByLastNameStartsWithIgnoreCase(String lastName);

	Page<Customer> findByLastNameStartsWithIgnoreCase(String lastName, Pageable pageable);
	// end::methods[]

}
