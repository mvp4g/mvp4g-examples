package de.gishmo.mvp4g.example.multipresenterwithhistorie.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.gishmo.mvp4g.example.multipresenterwithhistorie.shared.dto.HistoryContext;

@RemoteServiceRelativePath("history")
public interface HistoryContextService
  extends RemoteService {

  HistoryContext get(String id);

  void save(HistoryContext historyContext);

}
