package org.gwt4e.mvp4g.example.modules.client.product.view;

import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;
import org.gwt4e.mvp4g.example.modules.client.widget.LabelWithValue;

public class ProductDisplayView extends AbstractProductView {

	private LabelWithValue name = null;

	@Override
	protected Widget createAndGetNameWidget() {
		name = new LabelWithValue();
		return name;
	}

	@Override
	protected String getLeftButtonName() {
		return "Edit";
	}

	@Override
	protected String getRightButtonName() {
		return "Delete";
	}

	public HasValue<String> getName() {
		return name;
	}

}
