package de.gishmo.mvp4g.example.multipresenterwithhistorie.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.gishmo.mvp4g.example.multipresenterwithhistorie.shared.dto.HistoryContext;

public interface HistoryContextServiceAsync {
  void get(String id,
           AsyncCallback<HistoryContext> async);

  void save(HistoryContext historyContext,
            AsyncCallback<Void> async);
}
