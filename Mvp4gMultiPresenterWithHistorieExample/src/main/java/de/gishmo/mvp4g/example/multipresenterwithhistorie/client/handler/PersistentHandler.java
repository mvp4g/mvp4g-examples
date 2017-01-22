package de.gishmo.mvp4g.example.multipresenterwithhistorie.client.handler;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.mvp4g.client.annotation.EventHandler;
import com.mvp4g.client.event.BaseEventHandler;

import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.Mvp4gMultiPresenterWithHistorieEventBus;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.model.ApplicationContext;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.service.HistoryContextServiceAsync;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.utils.GUID;

@EventHandler
public class PersistentHandler
  extends BaseEventHandler<Mvp4gMultiPresenterWithHistorieEventBus> {

  @Inject
  private ApplicationContext applicationContext;

  @Inject
  private HistoryContextServiceAsync historyContextService;

  public void onInitHistory() {
    applicationContext.getHistoryContext()
                      .setHistoryToken(GUID.get());
    save();
  }

  public void onPersistHistory() {
    save();
  }

  private void save() {
    historyContextService.save(applicationContext.getHistoryContext(),
                               new AsyncCallback<Void>() {
                                 @Override
                                 public void onFailure(Throwable throwable) {
                                   Window.alert("PANIC!!!!!");
                                 }

                                 @Override
                                 public void onSuccess(Void aVoid) {
                                 }
                               });
  }
}
