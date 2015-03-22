package org.gwt4e.mvp4g.example.employeeadmin.client.widgets;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import org.gwt4e.mvp4g.example.employeeadmin.client.resources.Resources;

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

    FlowPanel fpLabel = new FlowPanel();
    fpLabel.addStyleName(Resources.CSS.employeeAdmin()
                                      .fieldContainerLabel());
    Label label01 = new Label(label);
    label01.setStyleName(Resources.CSS.employeeAdmin()
                                      .label());
    fpLabel.add(label01);
    container.add(fpLabel);

    FlowPanel widgetContainer = new FlowPanel();
    widgetContainer.addStyleName(Resources.CSS.employeeAdmin()
                                              .fieldContainerWidget());
    widgetContainer.add(widget);
    container.add(widgetContainer);

    FlowPanel clearFp = new FlowPanel();
    clearFp.setStyleName(Resources.CSS.employeeAdmin()
                                      .clear());
    container.add(clearFp);
  }
}
