package org.gwt4e.mvp4g.example.employeeadmin.client.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import org.gwt4e.mvp4g.example.employeeadmin.shared.dto.UserBean;

import java.util.List;

@RemoteServiceRelativePath("userService")
public interface UserService
    extends RemoteService {

  public List<UserBean> getUsers();

  public void deleteUser(UserBean user);

  public UserBean createUser(UserBean user);

  public UserBean updateUser(UserBean user);

}
