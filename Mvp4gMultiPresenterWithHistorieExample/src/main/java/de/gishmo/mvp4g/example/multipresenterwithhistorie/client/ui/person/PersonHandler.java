package de.gishmo.mvp4g.example.multipresenterwithhistorie.client.ui.person;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.mvp4g.client.annotation.EventHandler;
import com.mvp4g.client.event.BaseEventHandler;
import com.sencha.gxt.widget.core.client.ProgressBar;

import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.Mvp4gMultiPresenterWithHistorieEventBus;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.delegate.CloseTabItemEvent;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.history.EventName;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.model.ApplicationContext;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.service.PersonServiceAsync;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.shared.dto.HistoryContext.HistoryItem;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.shared.dto.Person;

@EventHandler
public class PersonHandler
  extends BaseEventHandler<Mvp4gMultiPresenterWithHistorieEventBus>
  implements CloseTabItemEvent {

  private List<PersonPresenter> presenters = new ArrayList<>();

  @Inject
  private ApplicationContext applicationContext;

  @Inject
  private PersonServiceAsync personService;

  public PersonHandler() {
  }

  /**
   * Anlage eines neuen "Multi-Datenmodels
   */
  public void onNewPerson() {
    final PersonPresenter presenter = eventBus.addHandler(PersonPresenter.class);
    // Statis setzen
    presenter.setNewData(true);
    presenter.setEditData(true);
    // Presenter mit Daten anreichern
    Person person = new Person();
    presenter.edit(person);
    // tabItem erzeugen
    eventBus.addTabItem(presenter.getId(),
                        "Person: Neue Person",
                        presenter.getView()
                                 .asWidget(),
                        true);
    // Presenter sichern!
    presenters.add(presenter);
  }

  /**
   * Lesen und Anzeigen eines "Multi-Datenmodels mit dem uebergebenen Schluessel
   */
  public void onShowPerson(long id) {
    PersonPresenter existingPresenter = getPresenterForId(id);
    if (existingPresenter != null) {
      eventBus.selectTabItem(existingPresenter.getId());
    } else {
      final PersonPresenter presenter = eventBus.addHandler(PersonPresenter.class);
      // Statis setzen
      presenter.setNewData(false);
      presenter.setEditData(true);
      // Presenter mit Daten anreichern ==> lesen vom Server
      final ProgressBar pb = new ProgressBar();
      pb.show();
      personService.get(id,
                        new AsyncCallback<Person>() {
                          @Override
                          public void onFailure(Throwable throwable) {
                            Window.alert("PANIC!!!!!");
                            pb.hide();
                          }

                          @Override
                          public void onSuccess(Person model) {
                            presenter.edit(model);
                            // tabItem erzeugen
                            eventBus.addTabItem(presenter.getId(),
                                                "Person: " + model.getName() + ", " + model.getFirstName(),
                                                presenter.getView()
                                                         .asWidget(),
                                                true);
                            // Presenter sichern!
                            presenters.add(presenter);
                            pb.hide();
                          }
                        });
    }
  }

  private PersonPresenter getPresenterForId(long id) {
    for (PersonPresenter presenter : presenters) {
      if (id == presenter.getPersonId()) {
        return presenter;
      }
    }
    return null;
  }

  @Override
  public void onCloseTabItem(String id) {
    for (PersonPresenter presenter : presenters) {
      if (presenter.getId()
                   .equals(id)) {
        for (HistoryItem historyItem : applicationContext.getHistoryContext()
                                                         .getHistoryItems()) {
          if (EventName.EVENT_SHOW_PERSON.equals(historyItem.getHistoryName())) {
            if (historyItem.getParamLong()
                           .equals(presenter.getPersonId())) {
              applicationContext.getHistoryContext()
                                .getHistoryItems()
                                .remove(historyItem);
              eventBus.persistHistory();
              break;
            }
          }
        }
      }
    }
  }
}