package de.gishmo.mvp4g.example.multipresenterwithhistorie.server;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.service.HistoryContextService;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.shared.dto.HistoryContext;

@SuppressWarnings("serial")
public class HistoryContextServiceImpl
  extends RemoteServiceServlet
  implements HistoryContextService {

  private static HistoryContext historyContext;

  public void init(ServletConfig config)
    throws ServletException {
    super.init(config);
  }

  @Override
  public HistoryContext get(String id) {
    return HistoryContextServiceImpl.historyContext == null ? new HistoryContext() : HistoryContextServiceImpl.historyContext;
  }

  @Override
  public void save(HistoryContext historyContext) {
    HistoryContextServiceImpl.historyContext = historyContext;
  }
}
