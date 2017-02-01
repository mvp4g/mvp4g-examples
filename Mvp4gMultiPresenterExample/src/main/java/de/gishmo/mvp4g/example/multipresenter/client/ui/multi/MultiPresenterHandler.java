package de.gishmo.mvp4g.example.multipresenter.client.ui.multi;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.GWT;
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

  private Map<String, EventHandlerInterface<Mvp4gMultiPresenterEventBus>> presenters = new HashMap<>();

  @Inject
  private ApplicationContext applicationContext;

  public MultiPresenterHandler() {
  }

  /**
   * <p>Creates a new tab and add it to the tab-panel.
   * <br/><br/>
   * New tabs will be also added to the grid of open tabs.</p>
   */
  public void onNewMulti() {
    // create a new instance of the presenter
    final MultiPresenter presenter = eventBus.addHandler(MultiPresenter.class);
    // set state in presenter
    // it's a new presenter
    presenter.setNewData(true);
    // data can be edit
    presenter.setEditData(true);
    // create unique ID for presenter
    String key = GUID.get();
    // create a instance of MultiPresenterModel to store informations
    // about the new presetner instance
    MultiPresenterModel model = new MultiPresenterModel();
    model.setId(key);
    model.setCreated(DateTimeFormat.getFormat("yyyy.MM.dd - HH.mm.ss")
                                   .format(new Date()));
    // store the information in a map with the generated key
    presenter.edit(key,
                   model);
    // create tab
    eventBus.addTabItem(model.getId(),
                        "MultiPresenter: " + model.getId(),
                        presenter.getView()
                                 .asWidget(),
                        true);
    // store presenter registration for further removement
    presenters.put(key,
                   presenter);
  }

  /**
   * <p>Removes the presenter with the given id from the list of stored presenter references.</p>
   *
   * @param id
   *   id of the presentr that has to be removed.
   */
  public void onRemoveTabItem(String id) {
    GWT.debugger();
    // get the presenter registration
    EventHandlerInterface<Mvp4gMultiPresenterEventBus> presenter = this.presenters.get(id);
    if (presenter != null) {
      // derigister the presenter at the eventbus
      eventBus.removeHandler(presenter);
      // remove from map
      this.presenters.remove(id);
    }
  }
}
