package org.gwt4e.mvp4g.example.modules.client;

import com.google.gwt.inject.client.AbstractGinModule;
import org.gwt4e.mvp4g.example.modules.client.main.view.FirefoxMainView;
import org.gwt4e.mvp4g.example.modules.client.main.view.MainView;

public class FirefoxGinModule extends AbstractGinModule {

	@Override
	protected void configure() {
		bind( MainView.class ).to( FirefoxMainView.class );
	}

}
