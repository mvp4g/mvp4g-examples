package org.gwt4e.mvp4g.example.employeeadminwithgxt.client.ui.user.role;

import com.google.gwt.user.client.ui.IsWidget;
import org.gwt4e.mvp4g.example.employeeadminwithgxt.shared.dto.UserBean;

/**
 * Created by hoss on 01.08.14.
 */
public interface IUserRoleView
    extends IsWidget {

  public void clear();

  public void disable();

  public void showUser(UserBean user);

  public interface IUserRolePresenter {

    public void doAddRole(String role);

    public void doRemoveRole(String role);

  }
}
