package org.gwt4e.mvp4g.example.employeeadmin.client.widget.interfaces;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasKeyUpHandlers;

public interface IListBox
    extends HasClickHandlers,
            HasKeyUpHandlers {

  public int getSelectedIndex();

  public void setSelectedIndex(int index);

  public String getSelectedValue();

  public void setSelectedValue(String value);

  public void addItem(String item);

  public void removeItem(String item);

  public void clear();

  public void setEnabled(boolean enabled);

}
