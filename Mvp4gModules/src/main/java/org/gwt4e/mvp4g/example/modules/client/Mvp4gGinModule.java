package org.gwt4e.mvp4g.example.modules.client;

import com.google.gwt.inject.client.AbstractGinModule;
import org.gwt4e.mvp4g.example.modules.client.util.display.FullNameIndexDisplayer;
import org.gwt4e.mvp4g.example.modules.client.util.display.IndexDisplayer;
import org.gwt4e.mvp4g.example.modules.client.util.index.IndexGenerator;
import org.gwt4e.mvp4g.example.modules.client.util.index.SameIndexGenerator;
import org.gwt4e.mvp4g.example.modules.client.util.token.BaseTokenGenerator;
import org.gwt4e.mvp4g.example.modules.client.util.token.TokenGenerator;

public class Mvp4gGinModule extends AbstractGinModule {

	@Override
	protected void configure() {
		bind( IndexGenerator.class ).to( SameIndexGenerator.class );
		bind( TokenGenerator.class ).to( BaseTokenGenerator.class );
		bind( IndexDisplayer.class).to( FullNameIndexDisplayer.class );
	}

}
