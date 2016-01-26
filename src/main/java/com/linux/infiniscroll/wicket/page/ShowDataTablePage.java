package com.linux.infiniscroll.wicket.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import com.linux.infiniscroll.jpa.entities.Customer;
import com.linux.infiniscroll.wicket.page.model.CustomerModel;

public class ShowDataTablePage extends WebPage {

	private static final long serialVersionUID = 7183999236213164353L;
	
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		CustomerModel cm = new CustomerModel();
		
		
		ListView<Customer> customerView = new ListView<Customer>("customerView", cm) {
			
			private static final long serialVersionUID = 7850232429897257979L;

			@Override
			protected void populateItem(ListItem<Customer> item) {
				IModel<Customer> cModel = item.getModel();
				item.add(new Label("customerLabel", new PropertyModel<>(cModel, "firstName")));
			}
		};
		
		add(customerView);
		
	}

}
