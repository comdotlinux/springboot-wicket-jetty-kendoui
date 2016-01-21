package com.linux.infiniscroll.wicket.page.model;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.linux.infiniscroll.jpa.CustomerDao;
import com.linux.infiniscroll.jpa.entities.Customer;

public class CustomerModel extends LoadableDetachableModel<Customer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6481638266587472041L;

	@SpringBean
	private CustomerDao customerDao;

	private long id;

	public CustomerModel(Customer customer) {
		super(customer);
		this.id = customer.getId();
		Injector.get().inject(this);
	}

	// tag::load[]
	@Override
	protected Customer load() {
		return customerDao.findOne(id);
	}
	// end::load[]

}
