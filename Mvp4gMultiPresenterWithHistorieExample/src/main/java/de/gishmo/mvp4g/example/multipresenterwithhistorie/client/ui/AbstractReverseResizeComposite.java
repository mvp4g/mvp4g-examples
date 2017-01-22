package de.gishmo.mvp4g.example.multipresenterwithhistorie.client.ui;

import com.google.gwt.user.client.ui.ResizeComposite;
import com.mvp4g.client.view.ReverseViewInterface;

public abstract class AbstractReverseResizeComposite<P>
  extends ResizeComposite
  implements ReverseViewInterface<P> {

  private P presenter;

  public AbstractReverseResizeComposite() {
    super();
  }

  public P getPresenter() {
    return presenter;
  }

  public void setPresenter(P presenter) {
    this.presenter = presenter;
  }
}
