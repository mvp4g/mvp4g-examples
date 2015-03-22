package org.gwt4e.mvp4g.example.employeeadmin.client.ui.user.role;

import com.google.gwt.user.client.ui.IsWidget;
import com.mvp4g.client.view.ReverseViewInterface;
import org.gwt4e.mvp4g.example.employeeadmin.shared.dto.UserBean;

public interface IUserRoleView
    extends IsWidget,
            ReverseViewInterface<IUserRoleView.IUserRolePresenter> {

  public void clear();

  public void disable();

  public void showUser(UserBean user);

  public interface IUserRolePresenter {

    public void doAddRole(String role);

    public void doRemoveRole(String role);

  }
}
