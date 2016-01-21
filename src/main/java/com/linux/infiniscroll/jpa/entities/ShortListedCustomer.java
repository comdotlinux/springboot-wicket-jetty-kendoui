package com.linux.infiniscroll.jpa.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name="SHORTLISTED_CUSTOMER")
public class ShortListedCustomer implements Serializable {

	/**
	 * Generated serial version UID
	 */
	private static final long serialVersionUID = -3395161204396896762L;

	@Id
	@GeneratedValue
	private Long id;
	
	private Long CustomerId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(Long customerId) {
		CustomerId = customerId;
	}
	
	
	
	
}
