package de.gishmo.mvp4g.example.multipresenter.client.ui.content;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.view.ReverseViewInterface;

import de.gishmo.mvp4g.example.multipresenter.client.delegate.ConfirmCommand;
import de.gishmo.mvp4g.example.multipresenter.client.ui.content.IContentView.Presenter;

public interface IContentView
  extends IsWidget,
          ReverseViewInterface<Presenter> {

  void addItem(String id,
               String name,
               Widget container,
               boolean isDirty);

  void close(String id);

  void remove(final String id);

  void refresh(String id,
               String newName,
               boolean isDirty);

  void select(String id);

  void selectUebersicht();

  interface Presenter {

    void doClose(String id);

    void doConfirmClose(String id,
                        ConfirmCommand confirmCommand);

    void doRemove(String id);

    void doSelect(String id);

  }
}
