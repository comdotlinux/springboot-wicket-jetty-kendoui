package com.linux.infiniscroll.wicket.page;

import javax.inject.Inject;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import com.googlecode.wicket.jquery.ui.markup.html.link.AjaxLink;
import com.linux.infiniscroll.jpa.ShortListedCustomerDao;
import com.linux.infiniscroll.jpa.entities.Customer;
import com.linux.infiniscroll.jpa.entities.ShortListedCustomer;
import com.linux.infiniscroll.wicket.page.model.CustomerModel;

public class ShowDataTablePage extends WebPage {

	private static final long serialVersionUID = 7183999236213164353L;
	
	@Inject
	private ShortListedCustomerDao shotlistedCustomerDao;
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		CustomerModel cm = new CustomerModel();
		
		
		ListView<Customer> customerView = new ListView<Customer>("customerView", cm) {
			
			private static final long serialVersionUID = 7850232429897257979L;

			@Override
			protected void populateItem(ListItem<Customer> item) {
				IModel<Customer> cModel = item.getModel();
				item.add(new Label("id", new PropertyModel<>(cModel, "id")));
				item.add(new AjaxLink<String>("idLink") {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick(AjaxRequestTarget target) {
						
						ShortListedCustomer shortlistedCustomer = new ShortListedCustomer();
						Customer customer = cModel.getObject();
						shortlistedCustomer.setId(customer.getId());
						shotlistedCustomerDao.saveAndFlush(shortlistedCustomer);
					}
				});
				item.add(new Label("firstname", new PropertyModel<>(cModel, "firstName")));
				item.add(new Label("lastname", new PropertyModel<>(cModel, "lastName")));
			}
		};
		
		add(customerView);
		
	}

}
