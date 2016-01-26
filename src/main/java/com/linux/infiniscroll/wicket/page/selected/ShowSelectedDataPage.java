package com.linux.infiniscroll.wicket.page.selected;

import javax.inject.Inject;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import com.googlecode.wicket.kendo.ui.markup.html.link.AjaxLink;
import com.linux.infiniscroll.jpa.ShortListedCustomerDao;
import com.linux.infiniscroll.jpa.entities.Customer;
import com.linux.infiniscroll.wicket.page.ShowDataTablePage;
import com.linux.infiniscroll.wicket.page.model.ShortListedCustomerModel;

public class ShowSelectedDataPage extends WebPage {

	private static final long serialVersionUID = 7183999236213164353L;

	@Inject
	private ShortListedCustomerDao shotlistedCustomerDao;

	@Override
	protected void onInitialize() {
		super.onInitialize();
		ShortListedCustomerModel cm = new ShortListedCustomerModel();

		ListView<Customer> customerView = new ListView<Customer>("customerView", cm) {

			private static final long serialVersionUID = 7850232429897257979L;

			@Override
			protected void populateItem(ListItem<Customer> item) {
				IModel<Customer> cModel = item.getModel();
				item.add(new Label("id", new PropertyModel<>(cModel, "id")));
				item.add(new Label("firstname", new PropertyModel<>(cModel, "firstName")));
				item.add(new Label("lastname", new PropertyModel<>(cModel, "lastName")));
			}
		};

		add(new AjaxLink<String>("clearData", Model.of("Clear Selected")) {
			private static final long serialVersionUID = -1161201449253973452L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				shotlistedCustomerDao.deleteAllInBatch();
				shotlistedCustomerDao.flush();
				setResponsePage(ShowDataTablePage.class);
			}

		});
		add(customerView);

	}

}
