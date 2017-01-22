package de.gishmo.mvp4g.example.multipresenterwithhistorie.client.ui.toolbar;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.IsWidget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.CssFloatLayoutContainer;
import com.sencha.gxt.widget.core.client.container.CssFloatLayoutContainer.CssFloatData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;

import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.ui.AbstractReverseComposite;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.ui.toolbar.IToolbarView.Presenter;

public final class ToolbarView
  extends AbstractReverseComposite<Presenter>
  implements IToolbarView,
             IsWidget {

  /* panel */
  private CssFloatLayoutContainer container;
  /* Widgets */
  private TextButton              addButton;

  public ToolbarView() {
    // Widgets
    createWidget();
    bind();
    initWidget(container);
  }

  private void bind() {
    addButton.addSelectHandler(new SelectHandler() {
      @Override
      public void onSelect(SelectEvent selectEvent) {
        getPresenter().doAdd();
      }
    });
  }

  private void createWidget() {
    container = new CssFloatLayoutContainer();
    addButton = new TextButton(ToolbarConstants.CONSTANTS.buttonLabel());
    container.add(addButton,
                  new CssFloatData(1,
                                   new Margins(12,
                                               0,
                                               0,
                                               24)));
  }

  public HandlerRegistration addSelectHandler(SelectHandler handler) {
    return addButton.addSelectHandler(handler);
  }
}
