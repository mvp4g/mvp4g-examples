package org.gwt4e.mvp4g.example.employeeadminwithgxt.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import org.gwt4e.mvp4g.example.employeeadminwithgxt.shared.dto.UserBean;

import java.util.List;

public interface UserServiceAsync {

  public void getUsers(AsyncCallback<List<UserBean>> callback);

  public void deleteUser(UserBean user,
                         AsyncCallback<Void> callback);

  public void createUser(UserBean user,
                         AsyncCallback<UserBean> callback);

  public void updateUser(UserBean user,
                         AsyncCallback<UserBean> callback);

}
