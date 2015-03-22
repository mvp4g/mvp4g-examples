package org.gwt4e.mvp4g.example.employeeadmin.client.widget.impl;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.FlexTable;
import org.gwt4e.mvp4g.example.employeeadmin.client.widget.interfaces.ITable;

public class MyTable
    extends FlexTable
    implements ITable {

  public int getRowForEvent(ClickEvent event) {
    return getCellForEvent(event).getRowIndex();
  }

  public void selectRow(int row) {
    getRowFormatter().addStyleName(row,
                                   "selected");

  }

  public void unSelectRow(int row) {
    getRowFormatter().removeStyleName(row,
                                      "selected");
  }

}
