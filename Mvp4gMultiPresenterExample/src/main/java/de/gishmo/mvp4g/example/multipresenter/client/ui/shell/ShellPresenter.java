package de.gishmo.mvp4g.example.multipresenter.client.ui.shell;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

import de.gishmo.mvp4g.example.multipresenter.client.Mvp4gMultiPresenterEventBus;
import de.gishmo.mvp4g.example.multipresenter.client.model.ApplicationContext;

@Presenter(view = IShellView.class)
public final class ShellPresenter
  extends BasePresenter<IShellView, Mvp4gMultiPresenterEventBus>
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

//  public void onExitApplication() {
//    Info.display("Exit Application",
//                 "Anwendung wird beendet");
//    if (taaClientContext.isTAA()) {
//      getEventBus().crmSprung(CRMType.CRM_TARGET_STEP_CANCEL,
//                              true);
//    } else {
//      Window.Location.replace(Window.Location.getHref());
//    }
//  }
//
//  public void onSetButtonBar(Widget buttonBar) {
//    view.setButtonBar(buttonBar);
//  }

  public void onSetShellContent(Widget content) {
    view.setShellContent(content);
  }

  public void onSetToolbar(Widget navigation) {
    view.setToolbar(navigation);
  }

  public void onSetHeader(Widget header) {
    view.setHeader(header);
  }

//  @Override
//  public void onUpdateBeitrag() {
//    view.updateBeitrag(taaClientContext.getAntrag(),
//                       taaClientContext.getKeyTables());
//  }
//
//  @Override
//  public void doDispatch(String key01,
//                         String key02) {
//    TaaDispatcher.get()
//                 .dispatch(key01,
//                           key02);
//  }
}
