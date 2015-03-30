package org.gwt4e.mvp4g.example.modules.client.company.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import org.gwt4e.mvp4g.example.modules.client.company.presenter.CompanyNameSelectorPresenter;

public class CompanyNameSelectorView extends DialogBox implements CompanyNameSelectorPresenter.CompanyNameSelectorViewInterface {

	private ListBox names;
	private Button select;

	public ListBox getNames() {
		return names;
	}

	public HasClickHandlers getSelectButton() {
		return select;
	}

	public void createView() {
		setText( "Name Selector" );

		names = new ListBox();
		select = new Button( "Select" );

		HorizontalPanel mainPanel = new HorizontalPanel();
		mainPanel.add( new Label( "Name: " ) );
		mainPanel.add( names );
		mainPanel.add( select );

		setWidget( mainPanel );

	}

}
