package de.gishmo.mvp4g.example.multipresenterwithhistorie.client.ui.shell;

import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.view.ReverseViewInterface;

public interface IShellView
  extends ReverseViewInterface<IShellView.Presenter> {

  void setShellContent(Widget content);

  void setHeader(Widget header);

  void setToolbar(Widget toolbar);

  interface Presenter {

  }
}
