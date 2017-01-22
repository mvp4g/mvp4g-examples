package de.gishmo.mvp4g.example.multipresenterwithhistorie.client.ui.toolbar;

import com.google.gwt.user.client.ui.IsWidget;
import com.mvp4g.client.view.ReverseViewInterface;

import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.ui.toolbar.IToolbarView.Presenter;

public interface IToolbarView
  extends IsWidget,
          ReverseViewInterface<Presenter> {

  interface Presenter {
    void doAdd();
  }
}
