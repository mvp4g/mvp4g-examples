package de.gishmo.mvp4g.example.multipresenter.client.utils;

import com.mvp4g.client.event.EventBus;
import com.mvp4g.client.presenter.BasePresenter;

public abstract class AbstractMultiPresenter<V, E extends EventBus>
  extends BasePresenter<V, E> {

  public final String presenterId = GUID.get();

  /* Kennzeichen, ob es sich um einen Presenter mit neuen fachlichen Daten handelt */
  private boolean newData;
  /* Kennzeichen, ob sich der Presenter im Bearbeitungsmodus (Edt-Modus) befindet */
  private boolean editData;

  public AbstractMultiPresenter() {
    super();
  }

  public String getId() {
    return presenterId;
  }

  public boolean isNewData() {
    return newData;
  }

  public void setNewData(boolean newData) {
    this.newData = newData;
  }

  public boolean isEditData() {
    return editData;
  }

  public void setEditData(boolean editData) {
    this.editData = editData;
  }
}

