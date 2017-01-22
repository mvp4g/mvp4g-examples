package de.gishmo.mvp4g.example.multipresenterwithhistorie.client.model;

import java.io.Serializable;

import de.gishmo.mvp4g.example.multipresenterwithhistorie.shared.dto.HistoryContext;

@SuppressWarnings("serial")
public class ApplicationContext
  implements Serializable {

  private HistoryContext historyContext;

  public ApplicationContext() {
    super();
    this.historyContext = new HistoryContext();
  }

  public HistoryContext getHistoryContext() {
    return historyContext;
  }

  public void setHistoryContext(HistoryContext historyContext) {
    this.historyContext = historyContext;
  }
}
