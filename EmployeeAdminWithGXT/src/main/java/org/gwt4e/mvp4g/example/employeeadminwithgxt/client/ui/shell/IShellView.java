package org.gwt4e.mvp4g.example.employeeadminwithgxt.client.ui.shell;

import com.google.gwt.user.client.ui.Widget;

public interface IShellView {

  void setMasterView(Widget widget);

  void setProfileView(Widget widget);

  void setRoleView(Widget widget);

  public interface IShellPresenter {

  }

}
