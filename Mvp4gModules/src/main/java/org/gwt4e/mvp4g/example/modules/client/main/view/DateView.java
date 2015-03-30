package org.gwt4e.mvp4g.example.modules.client.main.view;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.inject.Singleton;
import org.gwt4e.mvp4g.example.modules.client.main.presenter.DatePresenter;

import java.util.Date;

@Singleton
public class DateView extends Composite implements DatePresenter.IDateView {

	private Label status = new Label();

	public DateView() {
		initWidget( status );
	}

	@Override
	public void setDate( Date date ) {
		status.setText( "Date: " + DateTimeFormat.getFormat( PredefinedFormat.DATE_FULL ).format( date ) );
	}

}
