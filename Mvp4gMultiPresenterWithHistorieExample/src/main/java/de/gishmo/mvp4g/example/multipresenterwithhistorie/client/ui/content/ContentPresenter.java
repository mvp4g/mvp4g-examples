package de.gishmo.mvp4g.example.multipresenterwithhistorie.client.ui.content;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;
import com.sencha.gxt.widget.core.client.Dialog.PredefinedButton;
import com.sencha.gxt.widget.core.client.ProgressBar;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.sencha.gxt.widget.core.client.event.DialogHideEvent;
import com.sencha.gxt.widget.core.client.event.DialogHideEvent.DialogHideHandler;

import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.Mvp4gMultiPresenterWithHistorieEventBus;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.delegate.ConfirmCommand;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.delegate.CloseTabItemEvent;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.service.PersonServiceAsync;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.shared.dto.Person;

@Presenter(view = IContentView.class)
public final class ContentPresenter
  extends BasePresenter<IContentView, Mvp4gMultiPresenterWithHistorieEventBus>
  implements IContentView.Presenter,
             CloseTabItemEvent {

  @Inject
  private PersonServiceAsync personService;

  public ContentPresenter() {
  }

  public void onAddTabItem(final String id,
                           String name,
                           Widget container,
                           boolean isDirty) {
    // ID in Container sichern
    container.getElement()
             .setId(id);
    // Item dem TabPanel hinzufuegen
    view.addItem(id,
                 name,
                 container,
                 isDirty);
    // Item sichern ...
    GWT.log("Fuege TabItem mit ID: >>" + id + "<< und Namen: >>" + name + "<< zu");
    // Selektieren
    eventBus.selectTabItem(id);
  }

  /**
   * Removes the referenced tab without confirmation
   *
   * @param id
   */
  public void onCloseTabItem(final String id) {
    GWT.log("TabItem mit ID: >>" + id + "<< entfernt");
    view.close(id);
  }

  public void onRefreshTabName(String id,
                               String newName,
                               boolean isDirty) {
    GWT.log("Aktualisiere Name/Status TabItem mit ID: >>" + id + "<<");
    view.refresh(id,
                 newName,
                 isDirty);
  }

  /**
   * Entfernt einen Tab unter Berücksichtigung ob der Tab dirty ...
   */
  public void onRemoveTabItem(final String id) {
    GWT.log("Entferne TabItem mit ID: >>" + id + "<<");
    view.remove(id);
  }

  public void onSelectTabItem(String id) {
    view.select(id);
  }

  public void onSelectUebersicht() {
    view.selectUebersicht();
  }

  @Override
  public void bind() {
    eventBus.setShellContent(view.asWidget());
    doUpdatePersonGrid();
  }

  @Override
  public void doClose(String id) {
    eventBus.closeTabItem(id);
    eventBus.selectUebersicht();
  }

  @Override
  public void doConfirmClose(final String id,
                             final ConfirmCommand command) {
    ConfirmMessageBox messageBox = new ConfirmMessageBox("Tab schliessen — Confirm",
                                                         "Soll der Tab wirklich geschlossen werden?");
    messageBox.addDialogHideHandler(new DialogHideHandler() {
      @Override
      public void onDialogHide(DialogHideEvent event) {
        if (PredefinedButton.YES.equals(event.getHideButton())) {
          eventBus.closeTabItem(id);
          eventBus.selectUebersicht();
        }
      }
    });
    messageBox.show();
  }

  @Override
  public void doRemove(String id) {
    eventBus.removeTabItem(id);
  }

  @Override
  public void doUpdatePersonGrid() {
    final ProgressBar pb = new ProgressBar();
    pb.show();
    personService.getAll(new AsyncCallback<List<Person>>() {
      @Override
      public void onFailure(Throwable throwable) {
        Window.alert("PANIC!!!!!");
        pb.hide();
      }

      @Override
      public void onSuccess(List<Person> people) {
        view.edit(people);
        pb.hide();
      }
    });
  }

  @Override
  public void doShowPerson(long id) {
    eventBus.showPerson(id);
  }
}
