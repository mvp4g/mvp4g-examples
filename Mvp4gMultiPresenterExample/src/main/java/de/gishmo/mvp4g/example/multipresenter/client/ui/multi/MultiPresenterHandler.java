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

  //
//  @SuppressWarnings("unused")
//  private final String id = "FilialeEntry" + Long.toString(System.currentTimeMillis());
//
////------------------------------------------------------------------------------
//
//
//  @Inject
//  private ClientContext clientContext;
//
//  @Inject
//  private FilialeRemoteServiceAsync filialeService;
//
//  @Inject
//  private AdminModuleLogger logger;
//
////------------------------------------------------------------------------------
//
//  public void onCloseFiliale(long userNr) {
//    FilialeDetailPresenter presenter = this.getPresenterByFiNr(userNr);
//    if (presenter != null) {
//      eventBus.closeTabItem(presenter.getId());
//    }
//  }
//
//  private FilialeDetailPresenter getPresenterByFiNr(long fiNr) {
//    if (presenters.size() > 0) {
//      for (int i = 0; i < presenters.size(); i++) {
//        FilialeDetailPresenter presenter = (FilialeDetailPresenter) presenters.get(i);
//        if (presenter != null && presenter.getFiliale()
//                                          .getFiNr() == fiNr) {
//          return presenter;
//        }
//      }
//    }
//    return null;
//  }
//
//  public void onDeleteFiliale(String id) {
//    FilialeDetailPresenter presenter = this.getPresenterById(id);
//    if (presenter != null) {
//      eventBus.removeTabItem(presenter.getId());
//      presenter.delete(id);
//    }
//  }
//
//  private FilialeDetailPresenter getPresenterById(String id) {
//    if (presenters.size() > 0) {
//      for (int i = 0; i < presenters.size(); i++) {
//        FilialeDetailPresenter presenter = (FilialeDetailPresenter) presenters.get(i);
//        if (presenter != null && id.equals(presenter.getId())) {
//          return presenter;
//        }
//      }
//    }
//    return null;
//  }
//
//  public void onEditFiliale(long fiNr) {
//    logger.log("Oeffne Filiale it filialeNr >>" + Long.toString(fiNr) + "<<",
//               0);
//    if (fiNr > 0) {
//      FilialeDetailPresenter presenter = this.getPresenterByFiNr(fiNr);
//      if (presenter == null) {
//        presenter = eventBus.addHandler(FilialeDetailPresenter.class);
//        presenters.add(presenter);
//        eventBus.addTabItem(presenter.getId(),
//                             CommonConstants.CONSTANTS.loading(),
//                             presenter.getView()
//                                      .asWidget(),
//                             false);
//      } else {
//        eventBus.selectTabItem(presenter.getId());
//      }
//      presenter.setNew(false);
//      presenter.setEdit(true);
//      presenter.preapreViewWithGetData(fiNr);
//    }
//  }
//
//  public void onNewFiliale() {
//    view.requestNewFilialeName();
//  }
//
//  public void onRemovePresenter(String id) {
//    FilialeDetailPresenter presenter = this.getPresenterById(id);
//    if (presenter != null) {
//      presenters.remove(presenter);
//      presenter.releaseResources();
//      eventBus.removeHandler(presenter);
//
//      // Presenter entfernen
//      eventBus.manageItem(ContentManagementType.CLOSE,
//                          FilialeDetailPresenter.class.getName(),
//                          presenter.getFiliale().getFiNr(),
//                          true);
//    }
//  }
//
//  public void onRefreshFiliale(String id) {
//    FilialeDetailPresenter presenter = this.getPresenterById(id);
//    if (presenter != null) {
//      presenter.refresh(id);
//    }
//  }
//
////------------------------------------------------------------------------------
//
//  public void onSaveFiliale(String id) {
//    FilialeDetailPresenter presenter = this.getPresenterById(id);
//    if (presenter != null) {
//      presenter.save(id);
//    }
//  }
//
////------------------------------------------------------------------------------
//
//  public void onShowFiliale(long fiNr) {
//    logger.log("Oeffne Filiale it filialeNr >>" + Long.toString(fiNr) + "<<",
//               0);
//    if (fiNr > 0) {
//      FilialeDetailPresenter presenter = this.getPresenterByFiNr(fiNr);
//      if (presenter == null) {
//        presenter = eventBus.addHandler(FilialeDetailPresenter.class);
//        presenters.add(presenter);
//        presenter.setNew(false);
//        presenter.setEdit(false);
//        eventBus.addTabItem(presenter.getId(),
//                             CommonConstants.CONSTANTS.loading(),
//                             presenter.getView()
//                                      .asWidget(),
//                             false);
//      } else {
//        eventBus.selectTabItem(presenter.getId());
//      }
//      if (!presenter.isEdit()) {
//        presenter.setNew(false);
//        presenter.setEdit(false);
//        presenter.preapreViewWithGetData(fiNr);
//      }
//    }
//  }
//
//  public void doNewFiliale(final String newName) {
//    // neuer Name?
//    if (newName != null && newName.trim()
//                                  .length() > 0) {
//      // Meldung ausgeben
//      eventBus.showProgressBar(CommonConstants.CONSTANTS.vorbereitenDaten(),
//                               CommonConstants.CONSTANTS.warten(),
//                               CommonConstants.CONSTANTS.preparing());
//      // Anlegen!
//      final FilialeDetailPresenter presenter = eventBus.addHandler(FilialeDetailPresenter.class);
//      ClFiliale filiale = new ClFiliale();
//      filiale.setName1(newName);
//
//      presenter.setNew(true);
//      presenter.setEdit(true);
//
//      ClResults result = new ClResults();
//      result.setObject(ClFiliale.class.getName(),
//                       filiale);
//      presenter.bindDataToView(result);
//      // Tab erzeugen und in Tab-Liste haengen!
//      eventBus.addTabItem(presenter.getId(),
//                           "Filiale: " + filiale.getName1(),
//                           presenter.getView()
//                                    .asWidget(),
//                           true);
//      // Presenter sichern!
//      presenters.add(presenter);
//      // Screen freigeben
//      eventBus.hideProgressBar();
//    } else {
//      eventBus.showMessage(CommonConstants.CONSTANTS.keineDaten(),
//                           CommonConstants.CONSTANTS.erforderlicheEingabe(),
//                           null);
//    }
//  }
}