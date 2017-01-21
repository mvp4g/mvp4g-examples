package de.gishmo.mvp4g.example.multipresenter.client.ui.shell;

import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.view.ReverseViewInterface;

public interface IShellView
  extends ReverseViewInterface<IShellView.Presenter> {

//  void setButtonBar(Widget buttonBar);

  void setShellContent(Widget content);

  void setHeader(Widget header);

  void setToolbar(Widget toolbar);

//  void updateBeitrag(Antrag antrag, KeyTables pKeyTables);

  interface Presenter {

//    void doDispatch(String key01,
//                    String key02);

  }
}
