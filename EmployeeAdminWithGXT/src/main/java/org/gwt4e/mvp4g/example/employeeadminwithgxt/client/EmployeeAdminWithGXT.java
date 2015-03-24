package org.gwt4e.mvp4g.example.employeeadminwithgxt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.Mvp4gModule;

/**
 * application entry point
 */
public class EmployeeAdminWithGXT
    implements EntryPoint {

  @Override
  public void onModuleLoad() {
    Mvp4gModule module = GWT.create(Mvp4gModule.class);
    module.createAndStartModule();
    RootLayoutPanel.get()
                   .add((Widget) module.getStartView());
  }
}
