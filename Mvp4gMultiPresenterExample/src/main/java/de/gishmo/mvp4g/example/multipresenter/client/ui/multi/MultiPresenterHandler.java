package de.gishmo.mvp4g.example.multipresenter.client.ui.multi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.inject.Inject;
import com.mvp4g.client.annotation.EventHandler;
import com.mvp4g.client.event.BaseEventHandler;
import com.mvp4g.client.event.EventHandlerInterface;

import de.gishmo.mvp4g.example.multipresenter.client.Mvp4gMultiPresenterEventBus;
import de.gishmo.mvp4g.example.multipresenter.client.model.ApplicationContext;
import de.gishmo.mvp4g.example.multipresenter.client.utils.GUID;
import de.gishmo.mvp4g.example.multipresenter.shared.dto.MultiPresenterModel;

@EventHandler
public class MultiPresenterHandler
  extends BaseEventHandler<Mvp4gMultiPresenterEventBus> {

  private List<EventHandlerInterface<Mvp4gMultiPresenterEventBus>> presenters = new ArrayList<>();

  @Inject
  private ApplicationContext applicationContext;

  public MultiPresenterHandler() {
  }

  /**
   * Anlage eines neuen "Multi-Datenmodels
   */
  public void onNewMulti() {
    final MultiPresenter presenter = eventBus.addHandler(MultiPresenter.class);
    // Statis setzen
    presenter.setNewData(true);
    presenter.setEditData(true);
    // Presenter mit Daten anreichern
    String key = GUID.get();
    MultiPresenterModel model = new MultiPresenterModel();
    model.setId(key);
    model.setCreated(DateTimeFormat.getFormat("yyyy.MM.dd - HH.mm.ss")
                                   .format(new Date()));
    presenter.edit(key,
                   model);
    // tabItem erzeugen
    eventBus.addTabItem(model.getId(),
                        "MultiPresenter: " + model.getId(),
                        presenter.getView()
                                 .asWidget(),
                        true);
    // Presenter sichern!
    presenters.add(presenter);
  }

  /**
   * Lesen und Anzeigen eines "Multi-Datenmodels mit dem uebergebenen Schluessel
   */
  public void onShowMulti(String multiKey) {
    final MultiPresenter presenter = eventBus.addHandler(MultiPresenter.class);
    // Statis setzen
    presenter.setNewData(false);
    presenter.setEditData(true);
    // Presenter mit Daten anreichern ==> lesen vom Server
    MultiPresenterModel model = new MultiPresenterModel();
    model.setId(multiKey);
    model.setCreated(DateTimeFormat.getFormat("yyyy.MM.dd - HH.mm.ss")
                                   .format(new Date()));
    presenter.edit(multiKey,
                   model);
    // tabItem erzeugen
    eventBus.addTabItem(model.getId(),
                        "MultiPresenter: " + model.getId(),
                        presenter.getView()
                                 .asWidget(),
                        true);
    // Presenter sichern!
    presenters.add(presenter);
  }
}