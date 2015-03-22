package org.gwt4e.mvp4g.example.employeeadmin.client.widget.impl;

import com.google.gwt.user.client.ui.ListBox;
import org.gwt4e.mvp4g.example.employeeadmin.client.widget.interfaces.IListBox;

public class MyListBox
    extends ListBox
    implements IListBox {

  public String getSelectedValue() {
    int selectedIndex = getSelectedIndex();

    return (selectedIndex == -1) ? null : getValue(getSelectedIndex());
  }

  public void setSelectedValue(String value) {
    if (value != null) {
      int itemCount = getItemCount();
      for (int i = 0; i < itemCount; i++) {
        if (value.equals(getValue(i))) {
          setSelectedIndex(i);
          break;
        }
      }
    }
  }

  public void removeItem(String item) {
    if (item != null) {
      int itemCount = getItemCount();
      for (int i = 0; i < itemCount; i++) {
        if (item.equals(getValue(i))) {
          removeItem(i);
          break;
        }
      }
    }
  }

}
