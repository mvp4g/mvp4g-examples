package org.gwt4e.mvp4g.example.employeeadmin.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.Mvp4gModule;
import org.gwt4e.mvp4g.example.employeeadmin.client.resources.Resources;

/**
 * application entry point
 */
public class EmployeeAdmin
    implements EntryPoint {

  @Override
  public void onModuleLoad() {
    Resources.CSS.employeeAdmin()
                 .ensureInjected();

    Mvp4gModule module = GWT.create(Mvp4gModule.class);
    module.createAndStartModule();
    RootLayoutPanel.get()
                   .add((Widget) module.getStartView());
  }
}
