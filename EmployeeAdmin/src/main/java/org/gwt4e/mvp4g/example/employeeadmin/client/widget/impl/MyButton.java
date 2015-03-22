package org.gwt4e.mvp4g.example.employeeadmin.client.widget.impl;

import com.google.gwt.user.client.ui.Button;
import org.gwt4e.mvp4g.example.employeeadmin.client.widget.interfaces.IButton;

public class MyButton
    extends Button
    implements IButton {

  public MyButton() {
    //nothing to do
  }

  public MyButton(String text) {
    super(text);
  }

}
