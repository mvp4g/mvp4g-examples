package de.gishmo.mvp4g.example.multipresenterwithhistorie.client.ui.toolbar;

import com.google.inject.Inject;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.Mvp4gMultiPresenterWithHistorieEventBus;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.model.ApplicationContext;

@Presenter(view = IToolbarView.class)
public final class ToolbarPresenter
  extends BasePresenter<IToolbarView, Mvp4gMultiPresenterWithHistorieEventBus>
  implements IToolbarView.Presenter {

  @Inject
  private ApplicationContext applicationContext;

  @Override
  public void bind() {
    eventBus.setToolbar(view.asWidget());
  }

  @Override
  public void doAdd() {
    eventBus.newPerson();
  }
}
