package org.gwt4e.mvp4g.example.modules.client.company.view;

import com.google.gwt.user.client.ui.PopupPanel;
import org.gwt4e.mvp4g.example.modules.client.company.presenter.CompanyTimePresenter;

public class CompanyTimeView extends PopupPanel implements CompanyTimePresenter.ICompanyTimeView {

	public CompanyTimeView(){
		setAutoHideEnabled( true );
	}
	
	@Override
	public void showTime() {
		getElement().setInnerText( "It's 5 o'clock!" );
		show();
	}

}
