package de.gishmo.mvp4g.example.multipresenter.client.utils;

public interface TabPresenter {

  String getId();

  boolean isNewData();

  boolean isEditData();

  void setEditData(boolean isNew);

  void setNewData(boolean isNew);

  void releaseResources();

}
