package de.gishmo.mvp4g.example.multipresenter.client.ui.multi;

import com.google.gwt.user.client.ui.IsWidget;
import com.mvp4g.client.view.ReverseViewInterface;

import de.gishmo.mvp4g.example.multipresenter.client.ui.multi.IMultiPresenterView.Presenter;
import de.gishmo.mvp4g.example.multipresenter.shared.dto.MultiPresenterModel;

public interface IMultiPresenterView
  extends IsWidget,
          ReverseViewInterface<Presenter> {

  void releaseResources();

  void edit(MultiPresenterModel model);

  interface Presenter {

  }
}
