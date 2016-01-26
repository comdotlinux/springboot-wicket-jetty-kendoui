package com.linux.infiniscroll.wicket.page.dataentry;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.event.Broadcast;
import org.apache.wicket.event.IEventSink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.component.IRequestablePage;

import com.linux.infiniscroll.jpa.CustomerDao;
import com.linux.infiniscroll.jpa.entities.Customer;

public class HomePage extends WebPage {

	private static final String DOE = "Doe";

	private static final String DASH = "-";

	private static final String JOHN = "John";

	private static final long serialVersionUID = -2898363045500959956L;

	private static final int NUMBER_OF_ROWS = 1000;

	@Inject
	private CustomerDao customerDao;

	@Override
	protected void onInitialize() {
		super.onInitialize();

		final List<Customer> customerList = new ArrayList<>();
		for (int i = 1; i <= NUMBER_OF_ROWS; i++) {
			StringBuilder fnb = new StringBuilder(JOHN).append(DASH).append(i);
			StringBuilder lnb = new StringBuilder(DOE).append(DASH).append(i);
			customerList.add(new Customer(fnb.toString(), lnb.toString()));
		}

		add(new Label("insertData", Model.of("Insert " + NUMBER_OF_ROWS + " John Doe's into the Database")));
		Form<Void> dataForm = new Form<Void>("dataForm") {

			/**
			 * 
			 */
			private static final long serialVersionUID = 9050895073573740367L;
			
			@Override
			protected void onSubmit() {
				customerDao.save(customerList);
				customerDao.flush();
				super.onSubmit();
			}

		};

		dataForm.add(new Button("button",Model.of("Send Data")));
		add(dataForm);

	}

}
