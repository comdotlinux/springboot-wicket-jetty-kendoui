package com.linux.infiniscroll.wicket.page.model;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.linux.infiniscroll.jpa.CustomerDao;
import com.linux.infiniscroll.jpa.ShortListedCustomerDao;
import com.linux.infiniscroll.jpa.entities.Customer;
import com.linux.infiniscroll.jpa.entities.ShortListedCustomer;

public class ShortListedCustomerModel extends LoadableDetachableModel<List<Customer>> {

	private static final long serialVersionUID = 6481638266587472041L;

	@SpringBean
	private ShortListedCustomerDao shortListedCustomerDao;
	
	@SpringBean
	private CustomerDao customerDao;

	public ShortListedCustomerModel() {
		Injector.get().inject(this);
	}

	@Override
	protected List<Customer> load() {
		
		List<ShortListedCustomer> shortlistedCustomers = shortListedCustomerDao.findAll();
		List<Long> customerList = new ArrayList<>();
		for(ShortListedCustomer slc : shortlistedCustomers){
			customerList.add(slc.getCustomerId());
		}
		
		return customerDao.findAll(customerList); 
	}

}
