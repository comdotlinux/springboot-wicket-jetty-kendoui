package com.linux.infiniscroll.wicket.page;

import javax.inject.Inject;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import com.googlecode.wicket.jquery.ui.markup.html.link.AjaxLink;
import com.linux.infiniscroll.jpa.CustomerDao;
import com.linux.infiniscroll.jpa.ShortListedCustomerDao;
import com.linux.infiniscroll.jpa.entities.Customer;
import com.linux.infiniscroll.jpa.entities.ShortListedCustomer;
import com.linux.infiniscroll.wicket.page.model.CustomerModel;

public class ShowDataTablePage extends WebPage {

	private static final long serialVersionUID = 7183999236213164353L;
	
	@Inject
	private ShortListedCustomerDao shotlistedCustomerDao;
	
	@Inject
	private CustomerDao customerDao;

	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		CustomerModel cm = new CustomerModel();
		
		
		
		WebMarkupContainer listViewWrapper = new WebMarkupContainer("listViewWrapper");
		Label countLabel = new Label("count", new PropertyModel<>(cm, "size"));
		add(countLabel.setOutputMarkupPlaceholderTag(true));
		add(new AjaxLink<String>("clearDataLink", Model.of("Clear Customer Data")) {

			private static final long serialVersionUID = 6085567874168630922L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				customerDao.deleteAllInBatch();
				customerDao.flush();
				target.add(countLabel, listViewWrapper);
			}
			
		});
		
		ListView<Customer> customerView = new ListView<Customer>("customerView", cm) {
			
			private static final long serialVersionUID = 7850232429897257979L;

			@Override
			protected void populateItem(ListItem<Customer> item) {
				IModel<Customer> cModel = item.getModel();
				AbstractLink ajaxLink = new AjaxLink<String>("idLink", Model.of("Select")) {
					
					private static final long serialVersionUID = -2813409376314187568L;

					@Override
					public void onClick(AjaxRequestTarget target) {
						
						ShortListedCustomer shortlistedCustomer = new ShortListedCustomer();
						Customer customer = cModel.getObject();
						shortlistedCustomer.setCustomerId(customer.getId());
						shotlistedCustomerDao.saveAndFlush(shortlistedCustomer);
					}
				};
				item.add(ajaxLink);
				ajaxLink.add(new Label("id", new PropertyModel<>(cModel, "id")));
				ajaxLink.add(new Label("firstname", new PropertyModel<>(cModel, "firstName")));
				ajaxLink.add(new Label("lastname", new PropertyModel<>(cModel, "lastName")));
			}
		};
		
		add(listViewWrapper.add(customerView.setOutputMarkupPlaceholderTag(true)).setOutputMarkupPlaceholderTag(true));
		
	}

}
