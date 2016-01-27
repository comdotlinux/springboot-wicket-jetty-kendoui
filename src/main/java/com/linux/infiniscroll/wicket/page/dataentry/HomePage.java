package com.linux.infiniscroll.wicket.page.dataentry;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import com.linux.infiniscroll.jpa.CustomerDao;
import com.linux.infiniscroll.jpa.entities.Customer;

public class HomePage extends WebPage {

	private static final String DOE = "Doe";

	private static final String DASH = "-";

	private static final String JOHN = "John";

	private static final long serialVersionUID = -2898363045500959956L;

	private static final int NUMBER_OF_ROWS = 1000;

	private int insertCount = NUMBER_OF_ROWS;
	
	@Inject
	private CustomerDao customerDao;

	@Override
	protected void onInitialize() {
		super.onInitialize();

		final IModel<Integer> insertCountModel = new PropertyModel<Integer>(this, "insertCount");
		Label insertCountLabel = new Label("insertData", insertCountModel);

		add(new TextField<Integer>("insertCountInput", insertCountModel).add(new AjaxFormComponentUpdatingBehavior("onchange") {
			
			
			private static final long serialVersionUID = 480766021609772357L;

			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				if(insertCountModel.getObject() == null || insertCountModel.getObject() == 0){
					insertCountModel.setObject(NUMBER_OF_ROWS);
				}
				target.add(insertCountLabel);
			}
		}));
		
		add(insertCountLabel.setOutputMarkupPlaceholderTag(true));
		Form<Void> dataForm = new Form<Void>("dataForm") {

			/**
			 * 
			 */
			private static final long serialVersionUID = 9050895073573740367L;
			
			@Override
			protected void onSubmit() {
				customerDao.save(generateCustomers(getInsertCount()));
				customerDao.flush();
				super.onSubmit();
			}

		};

		dataForm.add(new Button("button",Model.of("Send Data")));
		add(dataForm);

	}

	private List<Customer> generateCustomers(int numberOfCustomers) {
		final List<Customer> customerList = new ArrayList<>();
		for (int i = 1; i <= numberOfCustomers; i++) {
			StringBuilder fnb = new StringBuilder(JOHN).append(DASH).append(i);
			StringBuilder lnb = new StringBuilder(DOE).append(DASH).append(i);
			customerList.add(new Customer(fnb.toString(), lnb.toString()));
		}
		return customerList;
	}

	public int getInsertCount() {
		return insertCount;
	}

	public void setInsertCount(int insertCount) {
		this.insertCount = insertCount;
	}

}
