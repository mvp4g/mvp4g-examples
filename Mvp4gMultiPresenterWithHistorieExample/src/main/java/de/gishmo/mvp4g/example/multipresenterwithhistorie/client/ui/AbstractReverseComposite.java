package de.gishmo.mvp4g.example.multipresenterwithhistorie.client.ui;

import com.google.gwt.user.client.ui.Composite;
import com.mvp4g.client.view.ReverseViewInterface;

public abstract class AbstractReverseComposite<P>
  extends Composite
  implements ReverseViewInterface<P> {

  private P presenter;

  public AbstractReverseComposite() {
    super();
  }

  public P getPresenter() {
    return presenter;
  }

  public void setPresenter(P presenter) {
    this.presenter = presenter;
  }
}
