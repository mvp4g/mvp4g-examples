package de.gishmo.mvp4g.example.multipresenterwithhistorie.shared.dto;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

public class HistoryContext
  implements IsSerializable {

  private String            historyToken;
  private List<HistoryItem> historyItems;

  public HistoryContext() {
    this.historyItems = new ArrayList<>();
  }

  public String getHistoryToken() {
    return historyToken;
  }

  public void setHistoryToken(String historyToken) {
    this.historyToken = historyToken;
  }

  public List<HistoryItem> getHistoryItems() {
    return historyItems;
  }

  public void setHistoryItems(List<HistoryItem> historyItems) {
    this.historyItems = historyItems;
  }

  public static class HistoryItem
    implements IsSerializable {

    private String historyName;

    private Long paramLong;

    public HistoryItem() {
    }

    public HistoryItem(String historyName,
                       Long paramLong) {
      this.historyName = historyName;
      this.paramLong = paramLong;
    }

    public String getHistoryName() {
      return historyName;
    }

    public void setHistoryName(String historyName) {
      this.historyName = historyName;
    }

    public Long getParamLong() {
      return paramLong;
    }

    public void setParamLong(Long paramLong) {
      this.paramLong = paramLong;
    }
  }
}
