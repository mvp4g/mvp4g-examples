package org.gwt4e.mvp4g.example.employeeadminwithgxt.client.ui.user.list;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;
import org.gwt4e.mvp4g.example.employeeadminwithgxt.client.EmployeeAdminWithGXTEventBus;
import org.gwt4e.mvp4g.example.employeeadminwithgxt.client.service.UserServiceAsync;
import org.gwt4e.mvp4g.example.employeeadminwithgxt.shared.dto.UserBean;

import java.util.List;

@Presenter(view = IUserListView.class)
public class UserListPresenter
    extends BasePresenter<IUserListView, EmployeeAdminWithGXTEventBus>
    implements IUserListView.IUserListPresenter {

  @Inject
  private UserServiceAsync service;

  public void onStart() {
    eventBus.setMasterView(view.asWidget());
    eventBus.showUserList();
  }

  public void onSelectUser(UserBean user) {
    if (user != null) {
      view.setUserSelected(true);
    } else {
      view.setUserSelected(false);
    }
  }

  public void onUnselectUser() {
    view.setUserSelected(false);
  }

  public void onShowUserList() {
    service.getUsers(new AsyncCallback<List<UserBean>>() {
      public void onFailure(Throwable caught) {
        Window.alert("panic");
      }

      public void onSuccess(List<UserBean> result) {
        view.setUserList(result);
        eventBus.unselectUser();
      }
    });
  }

  @Override
  public void doDeleteUser(UserBean user) {
    service.deleteUser(user,
                       new AsyncCallback<Void>() {
                         @Override
                         public void onFailure(Throwable caught) {
                           Window.alert("PANIC!");
                         }

                         @Override
                         public void onSuccess(Void result) {
                           eventBus.showUserList();
                         }
                       });
  }

  @Override
  public void doNewUser() {
    eventBus.createNewUser(new UserBean());
  }

  @Override
  public void doShowUser(UserBean user) {
    eventBus.selectUser(user);
  }
}
