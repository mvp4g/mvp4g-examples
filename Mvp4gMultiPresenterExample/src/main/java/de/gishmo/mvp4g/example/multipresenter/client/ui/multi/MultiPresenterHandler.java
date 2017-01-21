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
import de.gishmo.mvp4g.example.multipresenter.shared.dto.MultiPresenterModel;

@EventHandler
public class MultiPresenterHandler
  extends BaseEventHandler<Mvp4gMultiPresenterEventBus> {

  private List<EventHandlerInterface<Mvp4gMultiPresenterEventBus>> presenters = new ArrayList<>();

  @Inject
  private ApplicationContext applicationContext;

  public MultiPresenterHandler() {
  }

  public void onAddMultiPresenter(String key) {
    final MultiPresenter presenter = eventBus.addHandler(MultiPresenter.class);
    // Statis setzen
    presenter.setNewData(true);
    presenter.setEditData(true);
    // Presenter mit Daten anreichern
    MultiPresenterModel model = new MultiPresenterModel();
    model.setId(key);
    model.setCreated(DateTimeFormat.getFormat("yyyy.MM.dd - HH.mm.ss")
                                   .format(new Date()));
    presenter.edit(model);
    // tabItem erzeugen
    eventBus.addTabItem(presenter.getId(),
                        "MultiPresenter: " + model.getId(),
                        presenter.getView()
                                 .asWidget(),
                        true);
    // Presenter sichern!
    presenters.add(presenter);
  }
}