package de.gishmo.mvp4g.example.multipresenter.client.model;

import javax.inject.Provider;

public class ApplicationContextProvider
  implements Provider<ApplicationContext> {

  static ApplicationContext applicationContext = new ApplicationContext();

  @Override
  public ApplicationContext get() {
    return applicationContext;
  }
}
