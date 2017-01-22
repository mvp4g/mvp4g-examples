package de.gishmo.mvp4g.example.multipresenterwithhistorie.client.ui.person;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.mvp4g.client.annotation.Presenter;
import com.sencha.gxt.widget.core.client.Dialog.PredefinedButton;
import com.sencha.gxt.widget.core.client.ProgressBar;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.sencha.gxt.widget.core.client.event.DialogHideEvent;
import com.sencha.gxt.widget.core.client.event.DialogHideEvent.DialogHideHandler;

import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.Mvp4gMultiPresenterWithHistorieEventBus;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.service.PersonServiceAsync;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.utils.AbstractEditPresenter;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.utils.TabPresenter;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.shared.dto.Person;

@Presenter(view = IPersonView.class,
           multiple = true)
public class PersonPresenter
  extends AbstractEditPresenter<IPersonView, Mvp4gMultiPresenterWithHistorieEventBus>
  implements TabPresenter,
             IPersonView.Presenter {

  @Inject
  private PersonServiceAsync personService;

  private Person person;

  public PersonPresenter() {
  }

  /**
   * Diese Methode wird beim Schliessen eines Tabs aufgerufen.
   * Hier hat der Entwickler die Möglichkeit Resoruces freizugeben.
   */
  @Override
  public void releaseResources() {
    view.releaseResources();
  }

  void edit(Person model) {
    this.person = model;
    view.edit(model);
  }

  @Override
  public void doSave(Person model) {
    final ProgressBar pb = new ProgressBar();
    pb.show();
    if (isNewData()) {
      personService.insert(model,
                           new AsyncCallback<Void>() {
                             @Override
                             public void onFailure(Throwable throwable) {
                               Window.alert("PANIC!!!!!");
                               pb.hide();
                             }

                             @Override
                             public void onSuccess(Void aVoid) {
                               eventBus.closeTabItem(getId());
                               eventBus.selectUebersicht();
                               pb.hide();
                             }
                           });
    } else {
      personService.update(model,
                           new AsyncCallback<Void>() {
                             @Override
                             public void onFailure(Throwable throwable) {
                               Window.alert("PANIC!!!!!");
                               pb.hide();
                             }

                             @Override
                             public void onSuccess(Void aVoid) {
                               eventBus.closeTabItem(getId());
                               eventBus.selectUebersicht();
                               pb.hide();
                             }
                           });
    }
  }

  @Override
  public void doCancel() {
    if (isEditData()) {
      ConfirmMessageBox messageBox = new ConfirmMessageBox("Person schliessen — Confirm",
                                                           "Soll die Bearneitung der Person wirklich abgebrochen werden?");
      messageBox.addDialogHideHandler(new DialogHideHandler() {
        @Override
        public void onDialogHide(DialogHideEvent event) {
          if (PredefinedButton.YES.equals(event.getHideButton())) {
            eventBus.closeTabItem(getId());
            eventBus.selectUebersicht();
          }
        }
      });
      messageBox.show();
    } else {
      eventBus.closeTabItem(getId());
      eventBus.selectUebersicht();
    }
  }

  public Long getPersonId() {
    return person.getId();
  }
}
