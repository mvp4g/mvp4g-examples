package de.gishmo.mvp4g.example.multipresenter.client.ui.multi;

import com.mvp4g.client.annotation.Presenter;

import de.gishmo.mvp4g.example.multipresenter.client.Mvp4gMultiPresenterEventBus;
import de.gishmo.mvp4g.example.multipresenter.client.utils.AbstractMultiPresenter;
import de.gishmo.mvp4g.example.multipresenter.client.utils.TabPresenter;
import de.gishmo.mvp4g.example.multipresenter.shared.dto.MultiPresenterModel;

@Presenter(view = IMultiPresenterView.class, multiple = true)
public class MultiPresenter
  extends AbstractMultiPresenter<IMultiPresenterView, Mvp4gMultiPresenterEventBus>
  implements TabPresenter,
             IMultiPresenterView.Presenter {

  public MultiPresenter() {
  }


  /**
   * Diese Methode wird beim Schliessen eines Tabs aufgerufen.
   * Hier hat der Entwickler die Möglichkeit Resoruces freizugeben.
   */
  @Override
  public void releaseResources() {
    view.releaseResources();
  }

  public void edit(MultiPresenterModel model) {
    view.edit(model);
  }

  //
//  private final String id = "FilialeDetail" + Long.toString(System.currentTimeMillis());
//
//  private ClFiliale filiale;
//  private boolean isEdit = false;
//  private boolean isNew  = false;
//
//  @Inject
//  private ClientContext clientContext;
//
//  @Inject
//  private AdminModuleLogger logger;
//
//  @Inject
//  private FilialeRemoteServiceAsync filialeService;
//
////------------------------------------------------------------------------------
//
//
////------------------------------------------------------------------------------
//
//
//  public void onCancelFiliale(final String id) {
////  if (id.equals(this.id)) {
////    logger.log("Filiale bearbeiten gecanceled", 0);
////    // Meldung ausgeben
////    eventBus.showProgressBar(CommonConstants.CONSTANTS.vorbereitenDaten(),
////                             CommonConstants.CONSTANTS.warten(),
////                             CommonConstants.CONSTANTS.preparing());
////    // Clear Grids ...
////    view.clearErrors();
////    view.selectTabErrors();
////    // Daten config ...
////    isNew = false;
////    isEdit = false;
////    // Daten lesen
////    this.getData(filiale.getFiNr());
////  }
//  }
//
//  public void onDeleteFiliale(final String id) {
////    if (id.equals(this.id)) {
////      logger.log("Filiale mit >>" + id + "<< loeschen", 0);
////      eventBus.showProgressBar(CommonConstants.CONSTANTS.loeschenDaten(),
////                               CommonConstants.CONSTANTS.warten(),
////                               CommonConstants.CONSTANTS.deleting());
////      // Grids zurueck setzen
////      view.clearErrors();
////      view.selectTabErrors();
////      // Daten loeschen
////      filialeService.delete(filiale,
////                         clientContext.getUserId(),
////                         clientContext.getSecurityToken(),
////                         new AsyncCallback<Void>() {
////        @Override
////        public void onSuccess(Void result) {
////          // Screen freigeben
////          eventBus.hideProgressBar();
////          // Meldung ausgeben
////          Info.display(CommonConstants.CONSTANTS.statusMeldung(),
////                       CommonConstants.CONSTANTS.geloescht());
////          // Reiter schliessen
////          eventBus.removeTabItem(id);
////          eventBus.refreshFilialeList();
////        }
////
////        @Override
////        public void onFailure(Throwable caught) {
////          logger.log(caught.getMessage(), 0);
////          eventBus.hideProgressBar();
////          try {
////            throw caught;
////          } catch (ClValidationException e) {
//////            view.getInfoPanelBar().getGridErrors().getStore().add(e.getList());
////          } catch (ClOldDataException e) {
////            eventBus.showErrorOldDataMessage();
////          } catch (ClDataNotFoundException e) {
////            eventBus.removeTabItem(id);
////            eventBus.handleExceptions(caught, true);
////          } catch (Throwable e) {
////            eventBus.handleExceptions(caught, true);
////            // Name aendern ...
////            refreshTab("Filiale -> FEHLER!!! ", false);
////            // Screen freigeben
////            eventBus.hideProgressBar();
////          }
////        }
////      });
////    }
//  }
//
//  public void onSetFilialeToEditMode(final String id) {
////    if (id.equals(this.id)) {
////      logger.log("Filiale bearbeiten", 0);
////      // Meldung ausgeben
////      eventBus.showProgressBar(CommonConstants.CONSTANTS.vorbereitenDaten(),
////                               CommonConstants.CONSTANTS.warten(),
////                               CommonConstants.CONSTANTS.preparing());
////      // Clear Grids ...
//////      view.clearErrors();
////      view.selectTabErrors();
////      // Daten config ...
////      isNew = false;
////      isEdit = true;
////      // Daten lesen
////      this.getData(filiale.getFiNr());
////      this.doConfigTabs();
////    }
//  }
//
//  public void refresh(final String id) {
//    if (id.equals(this.id)) {
//      logger.log("Filiale aktualisieren",
//                 0);
////      eventBus.showProgressBar(CommonConstants.CONSTANTS.vorbereitenDaten(),
////                               CommonConstants.CONSTANTS.warten(),
////                               CommonConstants.CONSTANTS.loading());
////      // Clear Grids ...
////      view.clearErrors();
//////      view.selectTabTasks();
////      // Daten config ...
////      isNew = false;
////      isEdit = false;
//      // Daten lesen
//      this.preapreViewWithGetData(filiale.getFiNr());
//    }
//  }
//
//////  public void onLoadGroupRelations(final String id) {
//////    if (id.equals(this.id)) {
//////      logger.log("GruppenList aktualisieren", 0);
//////      eventBus.showProgressBar(CommonConstants.CONSTANTS.vorbereitenDaten(),
//////                               CommonConstants.CONSTANTS.warten(),
//////                               CommonConstants.CONSTANTS.loading());
//////      // Daten lesen ..
//////      // Suchobjekt erzeugen
//////      ClGroupRelationSearch search = new ClGroupRelationSearch();
//////      search.setFilialeNr(filiale.getFiNr());
//////      // Daten lesen ..
//////      groupService.getAll(search,
//////                          new ClSortField[] { new ClSortField("name", ClSortField.ASCENDING), new ClSortField("vorname", ClSortField.ASCENDING) },
//////                          clientContext.getUserId(),
//////                          clientContext.getSecurityToken(),
//////                          new AsyncCallback<List<ClGroupRelation>>() {
//////        @Override
//////        public void onSuccess(List<ClGroupRelation> result) {
//////          view.setGroupRelations(result);
//////          // ersten aus der Liste auswaehlen, wenn was da ist ...
//////          view.configToolBarGroupRelations(clientContext, filiale);
//////          // Screen freigeben
//////          eventBus.hideProgressBar();
//////        }
//////        @Override
//////        public void onFailure(Throwable caught) {
//////          eventBus.handleExceptions(caught);
//////          // Screen freigeben
//////          eventBus.hideProgressBar();
//////        }
//////      });
//////    }
//////  }
//
//  public void onLoadFilialeUserRelations(final String id) {
//    if (id.equals(this.id)) {
//      logger.log("FilialeList aktualisieren",
//                 0);
//      eventBus.showProgressBar(CommonConstants.CONSTANTS.vorbereitenDaten(),
//                               CommonConstants.CONSTANTS.warten(),
//                               CommonConstants.CONSTANTS.loading());
//      // Suchobjekt erzeugen
//      ClFilialeRelationSearch search = new ClFilialeRelationSearch();
//      search.setSecNr(clientContext.getUser().getSecNr());
//      search.setFiNr(filiale.getFiNr());
//      // Daten lesen ..
//      filialeService.getAll(search,
//                            new ClSortField[]{new ClSortField("name1",
//                                                              ClSortField.ASCENDING)},
//                            clientContext.getUserId(),
//                            clientContext.getSecurityToken(),
//                            new AsyncCallback<List<ClFilialeRelation>>() {
//                              @Override
//                              public void onSuccess(List<ClFilialeRelation> result) {
//                                view.setFilialeUserRelations(result);
//                                view.configToolBarFilialeUserRelations(clientContext,
//                                                                       filiale);
//                                eventBus.hideProgressBar();
//                              }
//
//                              @Override
//                              public void onFailure(Throwable caught) {
//                                eventBus.handleExceptions(caught,
//                                                          true);
//                                eventBus.hideProgressBar();
//                              }
//                            });
//    }
//  }
//
//  public void delete(String id) {
//    if (id.equals(this.id)) {
//      logger.log("Filiale delete",
//                 0);
//      // Meldung
//      eventBus.showProgressBar(CommonConstants.CONSTANTS.loeschenDaten(),
//                               CommonConstants.CONSTANTS.warten(),
//                               CommonConstants.CONSTANTS.deleting());
//      // Das Loeschen!
//      filialeService.delete(filiale.getFiNr(),
//                            clientContext.getUserId(),
//                            clientContext.getSecurityToken(),
//                            new AsyncCallback<Void>() {
//                              @Override
//                              public void onSuccess(Void result) {
//                                eventBus.hideProgressBar();
//                                Info.display(CommonConstants.CONSTANTS.statusMeldung(),
//                                             CommonConstants.CONSTANTS.geloescht());
//                                eventBus.refreshFilialeList();
//                              }
//
//                              @Override
//                              public void onFailure(Throwable caught) {
//                                logger.log(caught.getMessage(),
//                                           0);
//                                eventBus.hideProgressBar();
//                                try {
//                                  throw caught;
//                                } catch (ClDataNotFoundException e) {
//                                  eventBus.refreshFilialeList();
//                                } catch (Throwable e) {
//                                  eventBus.handleExceptions(caught,
//                                                            true);
//                                }
//                              }
//                            });
//    }
//  }
//
//
//  public void save(String id) {
//    if (id.equals(this.id)) {
//      if (isEdit) {
//        logger.log("Filiale sichern",
//                   0);
//        // Filiale-Objekt fuellen
//        // Neuanlage oder aktualisieren ...d as ist hier die Frage ...
//        if (view.isValid()) {
//          // Meldung
//          eventBus.showProgressBar(CommonConstants.CONSTANTS.sichernDaten(),
//                                   CommonConstants.CONSTANTS.warten(),
//                                   CommonConstants.CONSTANTS.saving());
//          // Daten flushen ...
//          view.bindViewToData();
//          // Fehlermeldungen loeschen
//          view.clearErrors();
//          // FilialeId setzen
//          filiale.setLogUser(clientContext.getUserId());
//          if (isNew) {
//            // FilialeId setzen
//            filiale.setInsertLogUser(clientContext.getUserId());
//            // der Call ... zum Server ...
//            filialeService.insert(filiale,
//                                  clientContext.getUserId(),
//                                  clientContext.getSecurityToken(),
//                                  new AsyncCallback<ClResults>() {
//                                    @Override
//                                    public void onSuccess(ClResults result) {
//                                      // Daten config ...
//                                      isNew = false;
//                                      isEdit = false;
//                                      // filiale mit der Rueckgabe aktualisieren ...
//                                      bindDataToView(result);
//                                      // Screen freigeben
//                                      eventBus.hideProgressBar();
//                                      // Meldung ausgeben ...
//                                      Info.display(CommonConstants.CONSTANTS.statusMeldung(),
//                                                   CommonConstants.CONSTANTS.gesichert());
//                                      // Liste aktualisieren
//                                      eventBus.refreshFilialeList();
//                                    }
//
//                                    @Override
//                                    public void onFailure(Throwable caught) {
//                                      logger.log(caught.getMessage(),
//                                                 0);
//                                      eventBus.hideProgressBar();
//                                      try {
//                                        throw caught;
//                                      } catch (ClValidationException e) {
//                                        view.setErrors(e.getList());
//                                        eventBus.showErrorHintMessage();
//                                      } catch (ClOldDataException e) {
//                                        eventBus.showErrorOldDataMessage();
//                                      } catch (Throwable e) {
//                                        eventBus.handleExceptions(caught,
//                                                                  true);
//                                        // Name aendern ...
//                                        refreshTab("Filiale -> FEHLER!!! ",
//                                                   false);
//                                        // Screen freigeben
//                                        eventBus.hideProgressBar();
//                                      }
//                                    }
//                                  });
//          } else {
//            // der Call ... zum Server ...
//            filialeService.update(filiale,
//                                  clientContext.getUserId(),
//                                  clientContext.getSecurityToken(),
//                                  new AsyncCallback<ClResults>() {
//                                    @Override
//                                    public void onSuccess(ClResults result) {
//                                      // Daten config ...
//                                      isNew = false;
//                                      isEdit = false;
//                                      // filiale mit der Rueckgabe aktualisieren ...
//                                      bindDataToView(result);
//                                      // Screen freigeben
//                                      eventBus.hideProgressBar();
//                                      // Meldung ausgeben ...
//                                      Info.display(CommonConstants.CONSTANTS.statusMeldung(),
//                                                   CommonConstants.CONSTANTS.gesichert());
//                                      // Liste aktualisieren
//                                      eventBus.refreshFilialeList();
//                                    }
//
//                                    @Override
//                                    public void onFailure(Throwable caught) {
//                                      logger.log(caught.getMessage(),
//                                                 0);
//                                      eventBus.hideProgressBar();
//                                      try {
//                                        throw caught;
//                                      } catch (ClValidationException e) {
//                                        view.setErrors(e.getList());
//                                        eventBus.showErrorHintMessage();
//                                      } catch (ClOldDataException e) {
//                                        eventBus.showErrorOldDataMessage();
//                                      } catch (Throwable e) {
//                                        eventBus.handleExceptions(caught,
//                                                                  true);
//                                        // Name aendern ...
//                                        refreshTab("Filiale -> FEHLER!!! ",
//                                                   false);
//                                        // Screen freigeben
//                                        eventBus.hideProgressBar();
//                                      }
//                                    }
//                                  });
//          }
//        } else {
//          eventBus.showMessage(CommonConstants.CONSTANTS.fehlerhafteDaten(),
//                               CommonConstants.CONSTANTS.korrigieren(),
//                               null);
//        }
//      }
//    }
//  }
//
//
//  public void preapreView(long filialeNr) {
//    // Meldung ausgeben
//    eventBus.showProgressBar(CommonConstants.CONSTANTS.ermitttelnDaten(),
//                             CommonConstants.CONSTANTS.warten(),
//                             CommonConstants.CONSTANTS.loading());
//    // Info-Panel loeschen
//    view.clearErrors();
//    // Daten lesen
//    filialeService.get(filialeNr,
//                       clientContext.getUserId(),
//                       clientContext.getSecurityToken(),
//                       new AsyncCallback<ClResults>() {
//                         @Override
//                         public void onSuccess(ClResults result) {
//                           // filiale mit der Rueckgabe aktualisieren ...
//                           bindDataToView(result);
//                           // Screen freigeben
//                           eventBus.hideProgressBar();
//                         }
//
//                         @Override
//                         public void onFailure(Throwable caught) {
//                           logger.log(caught.getMessage(),
//                                      0);
//                           refreshTab("Filiale -> FEHLER!!! ",
//                                      false);
//                           if (caught instanceof ClDataNotFoundException) {
//                             eventBus.removeTabItem(id);
//                           }
//                           eventBus.handleExceptions(caught,
//                                                     true);
//                           // Screen freigeben
//                           eventBus.hideProgressBar();
//                         }
//                       });
//
//  }
//
//
//  public void preapreViewWithGetData(long filialeNr) {
//    // Meldung ausgeben
//    eventBus.showProgressBar(CommonConstants.CONSTANTS.ermitttelnDaten(),
//                             CommonConstants.CONSTANTS.warten(),
//                             CommonConstants.CONSTANTS.loading());
//    // Info-Panel loeschen
//    view.clearErrors();
//    // Daten lesen
//    filialeService.get(filialeNr,
//                       clientContext.getUserId(),
//                       clientContext.getSecurityToken(),
//                       new AsyncCallback<ClResults>() {
//                         @Override
//                         public void onSuccess(ClResults result) {
//                           // filiale mit der Rueckgabe aktualisieren ...
//                           bindDataToView(result);
//                           // Screen freigeben
//                           eventBus.hideProgressBar();
//                         }
//
//                         @Override
//                         public void onFailure(Throwable caught) {
//                           logger.log(caught.getMessage(),
//                                      0);
//                           refreshTab("Filiale -> FEHLER!!! ",
//                                      false);
//                           if (caught instanceof ClDataNotFoundException) {
//                             eventBus.removeTabItem(id);
//                           }
//                           eventBus.handleExceptions(caught,
//                                                     true);
//                           // Screen freigeben
//                           eventBus.hideProgressBar();
//                         }
//                       });
//
//  }
//
////------------------------------------------------------------------------------
//
////  private void getData(long filialeNr) {
////    // Meldung ausgeben
////    eventBus.showProgressBar(CommonConstants.CONSTANTS.ermitttelnDaten(),
////                             CommonConstants.CONSTANTS.warten(),
////                             CommonConstants.CONSTANTS.loading());
////    // Info-Panel loeschen
////    view.clearErrors();
////    // Daten lesen
////    filialeService.get(filialeNr,
////                    clientContext.getUserId(),
////                    clientContext.getSecurityToken(),
////                    new AsyncCallback<ClResults>() {
////      @Override
////      public void onSuccess(ClResults result) {
////        // filiale mit der Rueckgabe aktualisieren ...
////        bindDataToView(result);
////        // Screen freigeben
////        eventBus.hideProgressBar();
////      }
////
////      @Override
////      public void onFailure(Throwable caught) {
////        logger.log(caught.getMessage(), 0);
////        refreshTab("Filiale -> FEHLER!!! ", false);
////        if (caught instanceof ClDataNotFoundException) {
////          eventBus.removeTabItem(id);
////        }
////        eventBus.handleExceptions(caught, true);
////        // Screen freigeben
////        eventBus.hideProgressBar();
////      }
////    });
////  }
//
////------------------------------------------------------------------------------
//
//  /**
//   * Methodis called when presenter should be built (ie all its attributes should be
//   * instantiated).
//   */
//  public void createPresenter() {
//    logger.log("createPresenter is called",
//               0);
//    return;
//  }
//
//  /**
//   * Method where required bindings between this Presenter and its View should be done
//   */
//  public void bindView() {
//    /**Aufruf loggen **/
//    logger.log("bindView is called",
//               0);
//  }
//
//  private void refreshTab(String newName,
//                          boolean isDirty) {
//    eventBus.refreshTabName(this.id,
//                            newName,
//                            isDirty);
//  }
//
//  public void bindDataToView(ClResults result) {
//    // Initailiasieren ...
//    view.reset();
//    // Bereiche Initialisieren
//    view.clearErrors();
//    // filiale mit der Rueckgabe aktualisieren ...
//    filiale = (ClFiliale) result.getObject(ClFiliale.class.getName());
//    // Felder fuellen
//    view.bindDataToView(filiale);
//    // FilialeRelation fuellen
//    view.clearFilialeUserRelations();
//    // Statusbar fuellen
//    view.setFormStatusBar(filiale);
//    // Reiter fuellen
//    // Name aendern ...
//    refreshTab("Filiale: " + filiale.getName1(),
//               isEdit);
//    // View konfigurieren
//    view.configForm(isEdit);
//    view.configToolBar(isEdit,
//                       clientContext,
//                       filiale);
////    view.configToolBarFilialeUserRelations(clientContext, filiale);
////    // Screen freigeben
////    view.selectTabTasks();
//  }
//
//
////  public void doAddFiliale() {
////    eventBus.addFilialeRelation(id, filiale);
////  }
////
////  public void doAddGroup() {
////    eventBus.addGroupRelation(id, filiale);
////  }
////
////  public void doAddSpecialRight() {
////    eventBus.addSpecialRight(id, filiale);
////  }
//
//  public void doCancel() {
//    eventBus.showConfirmMessage(CommonConstants.CONSTANTS.confirmCancel(),
//                                FilialeDetailConstants.CONSTANTS.cancelText(),
//                                new DialogHideEvent.DialogHideHandler() {
//                                  @Override
//                                  public void onDialogHide(DialogHideEvent event) {
//                                    if (event.getHideButton().equals(Dialog.PredefinedButton.YES)) {
//                                      if (isNew) {
//                                        eventBus.removeTabItem(id);
//                                      } else {
//                                        setEdit(false);
//                                        setNew(false);
//                                        eventBus.showFiliale(filiale.getFiNr());
//                                      }
//                                    }
//                                  }
//                                });
//  }
////
////  public void doConfigFormsRight() {
////    view.configToolBarRights(clientContext, filiale);
////  }
////
////  public void doConfigFormsSpecialRight() {
////    view.configToolBarSpecialRights(clientContext, filiale);
////  }
////
////  public void doConfigFormsFilialen() {
////    view.configToolBarFilialeUserRelations(clientContext, filiale);
////  }
////
////  public void doConfigFormsGroups() {
////    view.configToolBarGroupRelations(clientContext, filiale);
////  }
//
//  public void doConfigTabs() {
//    if (isNew || isEdit) {
////      view.hideTabRights();
////      view.hideTabSpecialRights();
////      view.selectTabContact();
//    } else {
////      view.showTabRights();
////      view.showTabSpecialRights();
//    }
//  }
//
//  public void doConfigFilialeUserRelations() {
//    view.configToolBarFilialeUserRelations(clientContext,
//                                           filiale);
//  }
//
//  public void doDelete() {
//    eventBus.showConfirmMessage(CommonConstants.CONSTANTS.confirmDelete(),
//                                FilialeDetailConstants.CONSTANTS.deleteText(),
//                                new DialogHideEvent.DialogHideHandler() {
//                                  @Override
//                                  public void onDialogHide(DialogHideEvent event) {
//                                    if (event.getHideButton().equals(Dialog.PredefinedButton.YES)) {
//                                      // TODO
////                                      eventBus.deleteFiliale(id);
//                                    }
//                                  }
//                                });
//  }
//
////  public void doDeleteFiliale(final List<ClFilialeRelation> filialen) {
////    eventBus.showConfirmMessage(CommonConstants.CONSTANTS.confirmDelete(),
////                                FilialeDetailConstants.CONSTANTS.deleteFilialeText(),
////                                new HideHandler() {
////                                  public void onHide(HideEvent event) {
////                                    Dialog btn = (Dialog) event.getSource();
////                                    if (btn.getHideButton().getText().toLowerCase().equals("ja" ) ||
////                                       btn.getText().toLowerCase().equals("yes" )) {
////                                      // Progressbar
////                                      eventBus.showProgressBar(CommonConstants.CONSTANTS.loeschenDaten(),
////                                                               CommonConstants.CONSTANTS.warten(),
////                                                               CommonConstants.CONSTANTS.deleting());
////                                      // Loeschen
////                                      filialeService.delete(filialen,
////                                                            clientContext.getUserId(),
////                                                            clientContext.getSecurityToken(),
////                                                            new AsyncCallback<Void>() {
////                                                              @Override
////                                                              public void onFailure(Throwable caught) {
////                                                                logger.log(caught.getMessage(), 0);
////                                                                eventBus.hideProgressBar();
////                                                                eventBus.handleExceptions(caught);
////                                                              }
////                                                              @Override
////                                                              public void onSuccess(Void arg0) {
////                                                                Info.display(CommonConstants.CONSTANTS.statusMeldung(),
////                                                                             CommonConstants.CONSTANTS.geloescht());
////                                                                eventBus.loadFilialeRelations(id);
////                                                              }
////                                      });
////                                    }
////                                  }
////                                });
////  }
////
////  public void doDeleteGroup(final List<ClGroupRelation> groups) {
////    eventBus.showConfirmMessage(CommonConstants.CONSTANTS.confirmDelete(),
////                                FilialeDetailConstants.CONSTANTS.deleteGroupText(),
////                                new HideHandler() {
////                                  public void onHide(HideEvent event) {
////                                    Dialog btn = (Dialog) event.getSource();
////                                    if (btn.getHideButton().getText().toLowerCase().equals("ja" ) ||
////                                       btn.getText().toLowerCase().equals("yes" )) {
////                                      // Progressbar
////                                      eventBus.showProgressBar(CommonConstants.CONSTANTS.loeschenDaten(),
////                                                               CommonConstants.CONSTANTS.warten(),
////                                                               CommonConstants.CONSTANTS.deleting());
////                                      // Loeschen
////                                      groupService.delete(groups,
////                                                          clientContext.getUserId(),
////                                                          clientContext.getSecurityToken(),
////                                                          new AsyncCallback<Void>() {
////                                                            @Override
////                                                            public void onFailure(Throwable caught) {
////                                                              logger.log(caught.getMessage(), 0);
////                                                              eventBus.hideProgressBar();
////                                                              eventBus.handleExceptions(caught);
////                                                            }
////                                                            @Override
////                                                            public void onSuccess(Void arg0) {
////                                                              Info.display(CommonConstants.CONSTANTS.statusMeldung(),
////                                                                           CommonConstants.CONSTANTS.geloescht());
////                                                              eventBus.loadGroupRelations(id);
////                                                            }
////                                      });
////                                    }
////                                  }
////                                });
////  }
////
////  public void doDeleteSpecialRight(final List<ClSpecialRight> specialRights) {
////    eventBus.showConfirmMessage(CommonConstants.CONSTANTS.confirmDelete(),
////                                FilialeDetailConstants.CONSTANTS.deleteSpecialRightText(),
////                                new HideHandler() {
////                                  public void onHide(HideEvent event) {
////                                    Dialog btn = (Dialog) event.getSource();
////                                    if (btn.getHideButton().getText().toLowerCase().equals("ja" ) ||
////                                       btn.getText().toLowerCase().equals("yes" )) {
////                                      // Progressbar
////                                      eventBus.showProgressBar(CommonConstants.CONSTANTS.loeschenDaten(),
////                                                               CommonConstants.CONSTANTS.warten(),
////                                                               CommonConstants.CONSTANTS.deleting());
////                                      // Loeschen
////                                      filialeService.delete(specialRights,
////                                                         clientContext.getUserId(),
////                                                         clientContext.getSecurityToken(),
////                                                         new AsyncCallback<Void>() {
////                                                          @Override
////                                                          public void onFailure(Throwable caught) {
////                                                            logger.log(caught.getMessage(), 0);
////                                                            eventBus.hideProgressBar();
////                                                            eventBus.handleExceptions(caught);
////                                                          }
////                                                          @Override
////                                                          public void onSuccess(Void arg0) {
////                                                            Info.display(CommonConstants.CONSTANTS.statusMeldung(),
////                                                                         CommonConstants.CONSTANTS.geloescht());
////                                                            eventBus.refreshFiliale(id);
////                                                         }
////                                      });
////                                    }
////                                  }
////                                });
////  }
////
////  public void doEditRights(String context) {
////    eventBus.editRight(id,
////                       filiale,
////                       context);
////
////  }
//
//  public void doNewFiliale() {
//    eventBus.newFiliale();
//  }
//
//  public void doRefreshFiliale() {
//    eventBus.refreshFiliale(id);
//  }
//
//  public void doRefreshFilialeUserRelations() {
//    eventBus.loadFilialeUserRelations(id);
//  }
//
////  public void doRefreshGroupRelations() {
////    eventBus.loadGroupRelations(id);
////  }
//
//  public void doSaveFiliale() {
//    eventBus.saveFiliale(id);
//  }
//
//  public void doEditFiliale() {
//    eventBus.editFiliale(filiale.getFiNr());
//  }
//
////------------------------------------------------------------------------------
//
//  public ClFiliale getFiliale() {
//    return filiale;
//  }
//
////  public void setFiliale(ClFiliale filiale) {
////    this.filiale = filiale;
////  }
//
////------------------------------------------------------------------------------
//
//  @Override
//  public String getId() {
//    return id;
//  }
//
//  @Override
//  public boolean isNew() {
//    return isNew;
//  }
//
//  @Override
//  public void setNew(boolean isNew) {
//    this.isNew = isNew;
//  }
//
//  @Override
//  public boolean isEdit() {
//    return isEdit;
//  }
//
//  @Override
//  public void setEdit(boolean isEdit) {
//    this.isEdit = isEdit;
//  }
//
}
