package org.gwt4e.mvp4g.example.employeeadminwithgxt.client.widgets;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * container takes label & widget
 */
public class FieldContainer
    extends Composite {

  private FlowPanel container;

  public FieldContainer(String label,
                        Widget widget) {
    createWidget(label,
                 widget);
    initWidget(container);
  }

  private void createWidget(String label,
                            Widget widget) {
    container = new FlowPanel();
  }
}
