package de.gishmo.mvp4g.example.multipresenter.client.ui.multi;

import com.google.gwt.user.client.ui.IsWidget;
import com.mvp4g.client.view.ReverseViewInterface;

import de.gishmo.mvp4g.example.multipresenter.client.ui.multi.IMultiPresenterView.Presenter;
import de.gishmo.mvp4g.example.multipresenter.shared.dto.MultiPresenterModel;

public interface IMultiPresenterView
  extends IsWidget,
          ReverseViewInterface<Presenter> {

  void releaseResources();

  void edit(MultiPresenterModel model);

  //
//  void bindDataToView(ClFiliale filiale);
//
//  ClFiliale bindViewToData();
//
//  void clearFilialeUserRelations();
//
//  void configForm(boolean isEdit);
//
//  void configToolBar(boolean isEdit,
//                     ClientContext clientContext,
//                     ClFiliale filiale);
//
//  void configToolBarFilialeUserRelations(ClientContext clientContext,
//                                         ClFiliale filiale);
//
//  boolean isValid();
//
//  void reset();
//
//  void setErrors(List<ClServiceMessage> list);
//
//  void setFilialeUserRelations(List<ClFilialeRelation> result);
//
  public interface Presenter {

//    void doCancel();
//
//    void doConfigFilialeUserRelations();
//
//    void doDelete();
//
//    void doEditFiliale();
//
//    void doNewFiliale();
//
//    void doRefreshFiliale();
//
//    void doRefreshFilialeUserRelations();
//
//    void doSaveFiliale();
  }
}
