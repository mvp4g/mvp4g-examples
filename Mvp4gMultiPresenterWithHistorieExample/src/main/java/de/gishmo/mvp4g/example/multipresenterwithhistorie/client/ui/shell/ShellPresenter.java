package de.gishmo.mvp4g.example.multipresenterwithhistorie.client.ui.shell;

import javax.inject.Inject;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.Mvp4gMultiPresenterWithHistorieEventBus;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.model.ApplicationContext;

@Presenter(view = IShellView.class)
public final class ShellPresenter
  extends BasePresenter<IShellView, Mvp4gMultiPresenterWithHistorieEventBus>
  implements IShellView.Presenter {

  @Inject
  protected ApplicationContext taaClientContext;

  @Override
  public void bind() {
    Element loadingIndicator = DOM.getElementById("loading");
    if (loadingIndicator != null) {
      loadingIndicator.removeFromParent();
    }
  }

  public void onSetShellContent(Widget content) {
    view.setShellContent(content);
  }

  public void onSetToolbar(Widget navigation) {
    view.setToolbar(navigation);
  }

  public void onSetHeader(Widget header) {
    view.setHeader(header);
  }
}
