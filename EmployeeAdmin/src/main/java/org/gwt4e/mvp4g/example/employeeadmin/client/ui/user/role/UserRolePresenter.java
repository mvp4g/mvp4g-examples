package org.gwt4e.mvp4g.example.employeeadmin.client.ui.user.role;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;
import org.gwt4e.mvp4g.example.employeeadmin.client.EmployeeAdminEventBus;
import org.gwt4e.mvp4g.example.employeeadmin.client.services.UserServiceAsync;
import org.gwt4e.mvp4g.example.employeeadmin.shared.dto.UserBean;

//This presenter illustrates how you can test your presenter
//by creating your own mock (without any external mock library)
@Presenter(view = IUserRoleView.class)
public class UserRolePresenter
    extends BasePresenter<IUserRoleView, EmployeeAdminEventBus>
    implements IUserRoleView.IUserRolePresenter {

  private UserBean user;
  private boolean enabled = false;

  @Inject
  private UserServiceAsync service;

  public void onStart() {
    eventBus.setRoleView(view.asWidget());
  }

  public void onSelectUser(UserBean user) {
    this.user = user;
    view.showUser(user);
  }

  public void onCreateNewUser(UserBean user) {
    this.user = user;
    view.clear();
    view.disable();
  }

  public void onUnselectUser() {
    view.clear();
    view.disable();
  }

  @Override
  public void doAddRole(String role) {
    user.getRoles()
        .add(role);
    updateUser();
  }

  private void updateUser() {
    service.updateUser(user,
                       new AsyncCallback<UserBean>() {
                         @Override
                         public void onFailure(Throwable caught) {
                           Window.alert("PANIC!");
                         }

                         @Override
                         public void onSuccess(UserBean result) {
                           view.clear();
                           view.disable();
                           eventBus.selectUser(result);
                         }
                       });
  }

  @Override
  public void doRemoveRole(String role) {
    user.getRoles()
        .remove(role);
    updateUser();
  }
}
