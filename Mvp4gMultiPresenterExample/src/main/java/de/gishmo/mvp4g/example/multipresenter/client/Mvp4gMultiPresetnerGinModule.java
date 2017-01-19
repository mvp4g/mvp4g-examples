package de.gishmo.mvp4g.example.multipresenter.client;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

import de.gishmo.mvp4g.example.multipresenter.client.model.ApplicationContext;
import de.gishmo.mvp4g.example.multipresenter.client.model.ApplicationContextProvider;

public class Mvp4gMultiPresetnerGinModule
  extends AbstractGinModule {

  @Override
  protected void configure() {
    bind(ApplicationContext.class).toProvider(ApplicationContextProvider.class)
                                  .in(Singleton.class);
  }
}