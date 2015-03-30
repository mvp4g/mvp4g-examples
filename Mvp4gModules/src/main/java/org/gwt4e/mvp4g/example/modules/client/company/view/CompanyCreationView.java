package org.gwt4e.mvp4g.example.modules.client.company.view;

import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class CompanyCreationView extends AbstractCompanyView {

	private TextBox name = null;

	@Override
	protected String getLeftButtonName() {
		return "Create";
	}

	@Override
	protected Widget createAndGetNameWidget() {
		name = new TextBox();
		return name;
	}

	@Override
	protected String getRightButtonName() {
		return "Clear";
	}

	public HasValue<String> getName() {
		return name;
	}

}
