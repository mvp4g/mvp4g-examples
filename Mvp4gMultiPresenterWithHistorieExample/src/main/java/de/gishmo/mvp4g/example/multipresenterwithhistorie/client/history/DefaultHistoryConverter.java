package de.gishmo.mvp4g.example.multipresenterwithhistorie.client.history;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.mvp4g.client.annotation.History;
import com.mvp4g.client.annotation.History.HistoryConverterType;
import com.mvp4g.client.history.HistoryConverter;
import com.sencha.gxt.widget.core.client.ProgressBar;

import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.Mvp4gMultiPresenterWithHistorieEventBus;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.model.ApplicationContext;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.service.HistoryContextServiceAsync;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.shared.dto.HistoryContext;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.shared.dto.HistoryContext.HistoryItem;

@History(type = HistoryConverterType.SIMPLE)
public class DefaultHistoryConverter
  implements HistoryConverter<Mvp4gMultiPresenterWithHistorieEventBus> {

  @Inject
  private ApplicationContext applicationContext;

  @Inject
  private HistoryContextServiceAsync historyContextService;

  public DefaultHistoryConverter() {
  }

  @Override
  public void convertFromToken(String historyName,
                               String param,
                               final Mvp4gMultiPresenterWithHistorieEventBus eventBus) {
    final ProgressBar pb = new ProgressBar();
    pb.show();
    historyContextService.get(param,
                              new AsyncCallback<HistoryContext>() {
                                @Override
                                public void onFailure(Throwable throwable) {
                                  Window.alert("PANIC!!!!!");
                                  pb.hide();
                                }

                                @Override
                                public void onSuccess(HistoryContext historyContext) {
                                  applicationContext.getHistoryContext()
                                                    .setHistoryToken(historyContext.getHistoryToken());
                                  for (HistoryItem item : historyContext.getHistoryItems()) {
                                    if (EventName.EVENT_SHOW_PERSON.equals(item.getHistoryName())) {
                                      eventBus.dispatch(EventName.EVENT_SHOW_PERSON,
                                                        item.getParamLong());
                                    }
                                  }
                                  pb.hide();
                                }
                              });
  }

  @Override
  public boolean isCrawlable() {
    // we don't want to be crawled
    return false;
  }

  /**
   * create token fuer parameterlose Events
   *
   * @param historyName
   *   - Name des Events
   */
  public String convertToToken(String historyName) {
    return applicationContext.getHistoryContext()
                             .getHistoryToken();
  }

  /**
   * create token fuer Events mit einer ID. <br> Das sind im Normalfall die Presenter, die "multiple=true" definiert sind
   *
   * @param historyName
   *   - Name des Events
   * @param param
   *   - Parameter
   */
  public String convertToToken(String historyName,
                               Long param) {
    if (!doesHistoryItemAlreadyExist(historyName,
                                    param)) {
      if (EventName.EVENT_SHOW_PERSON.equals(historyName)) {
        applicationContext.getHistoryContext()
                          .getHistoryItems()
                          .add(new HistoryItem(historyName,
                                               param));
      }
      save();
    }
    return applicationContext.getHistoryContext()
                             .getHistoryToken();
  }

  private boolean doesHistoryItemAlreadyExist(String historyName,
                                              Long param) {
    for (HistoryItem historyItem : applicationContext.getHistoryContext()
                                                     .getHistoryItems()) {
      if (historyItem.getHistoryName().equals(historyName)) {
        if (param.equals(historyItem.getParamLong())) {
          return true;
        }
      }
    }
    return false;
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
