package org.gwt4e.mvp4g.example.modules.client.main.view;

import com.google.gwt.user.client.ui.Label;
import com.google.inject.Inject;
import org.gwt4e.mvp4g.example.modules.client.util.display.IndexDisplayer;

public class FirefoxMainView extends MainView {

	@Inject
	public FirefoxMainView( IndexDisplayer indexDisplayer ) {
		super( indexDisplayer );
		mainPanel.insert( new Label( "Welcome Firefox Users" ), 0 );
	}

}
