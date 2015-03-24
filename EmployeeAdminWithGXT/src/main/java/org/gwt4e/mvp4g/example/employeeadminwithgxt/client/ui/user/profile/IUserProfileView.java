package org.gwt4e.mvp4g.example.employeeadminwithgxt.client.ui.user.profile;

import com.google.gwt.user.client.ui.IsWidget;
import org.gwt4e.mvp4g.example.employeeadminwithgxt.shared.dto.UserBean;

/**
 * Created by hoss on 01.08.14.
 */
public interface IUserProfileView
    extends IsWidget {

  public void clear();

  public void showUser(UserBean user,
                       boolean create);

  public interface IUserProfilePresenter {

    public void doCancel();

    public void doCreateUser(UserBean user);

    public void doUpdateUser(UserBean user);

  }
}
