package de.gishmo.mvp4g.example.multipresenter.client.ui.header;

import com.google.inject.Inject;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

import de.gishmo.mvp4g.example.multipresenter.client.Mvp4gMultiPresenterEventBus;
import de.gishmo.mvp4g.example.multipresenter.client.model.ApplicationContext;

@Presenter(view = IHeaderView.class)
public final class HeaderPresenter
  extends BasePresenter<IHeaderView, Mvp4gMultiPresenterEventBus>
  implements IHeaderView.Presenter {

  @Inject
  private ApplicationContext applicationContext;

  @Override
  public void bind() {
    eventBus.setHeader(view.asWidget());
  }
}
