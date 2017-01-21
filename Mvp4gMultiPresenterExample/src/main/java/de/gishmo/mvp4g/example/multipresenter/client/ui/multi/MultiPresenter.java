package de.gishmo.mvp4g.example.multipresenter.client.ui.multi;

import com.mvp4g.client.annotation.Presenter;

import de.gishmo.mvp4g.example.multipresenter.client.Mvp4gMultiPresenterEventBus;
import de.gishmo.mvp4g.example.multipresenter.client.utils.AbstractMultiPresenter;
import de.gishmo.mvp4g.example.multipresenter.client.utils.TabPresenter;
import de.gishmo.mvp4g.example.multipresenter.shared.dto.MultiPresenterModel;

@Presenter(view = IMultiPresenterView.class, multiple = true)
public class MultiPresenter
  extends AbstractMultiPresenter<IMultiPresenterView, Mvp4gMultiPresenterEventBus>
  implements TabPresenter,
             IMultiPresenterView.Presenter {

  public MultiPresenter() {
  }


  /**
   * Diese Methode wird beim Schliessen eines Tabs aufgerufen.
   * Hier hat der Entwickler die Möglichkeit Resoruces freizugeben.
   */
  @Override
  public void releaseResources() {
    view.releaseResources();
  }

  public void edit(MultiPresenterModel model) {
    view.edit(model);
  }
}
