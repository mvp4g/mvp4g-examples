package de.gishmo.mvp4g.example.multipresenterwithhistorie.client.ui.person;

import com.google.gwt.user.client.ui.IsWidget;
import com.mvp4g.client.view.ReverseViewInterface;

import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.ui.person.IPersonView.Presenter;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.shared.dto.Person;

public interface IPersonView
  extends IsWidget,
          ReverseViewInterface<Presenter> {

  void releaseResources();

  void edit(Person model);

  interface Presenter {

    void doSave(Person flush);

    void doCancel();

  }
}
