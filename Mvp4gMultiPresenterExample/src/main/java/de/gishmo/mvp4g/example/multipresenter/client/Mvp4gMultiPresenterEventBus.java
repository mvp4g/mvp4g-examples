package de.gishmo.mvp4g.example.multipresenter.client;

import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.Debug;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.Start;
import com.mvp4g.client.event.EventBus;

import de.gishmo.mvp4g.example.multipresenter.client.ui.content.ContentPresenter;
import de.gishmo.mvp4g.example.multipresenter.client.ui.header.HeaderPresenter;
import de.gishmo.mvp4g.example.multipresenter.client.ui.multi.MultiPresenterHandler;
import de.gishmo.mvp4g.example.multipresenter.client.ui.shell.ShellPresenter;
import de.gishmo.mvp4g.example.multipresenter.client.ui.toolbar.ToolbarPresenter;

@Events(startPresenter = ShellPresenter.class,
        ginModules = Mvp4gMultiPresetnerGinModule.class)
@Debug(logLevel = Debug.LogLevel.DETAILED)
public interface Mvp4gMultiPresenterEventBus
  extends EventBus {

  @Start
  @Event(bind = { HeaderPresenter.class,
                  ToolbarPresenter.class,
                  ContentPresenter.class })
  void start();

  @Event(handlers = ShellPresenter.class)
  void setShellContent(Widget asWidget);

  @Event(handlers = ShellPresenter.class)
  void setHeader(Widget header);

  @Event(handlers = ShellPresenter.class)
  void setToolbar(Widget widget);

  /* closeTab */
  @Event(handlers = ContentPresenter.class)
  void closeTabItem(String id);

  @Event(handlers = ContentPresenter.class)
  void addTabItem(String id,
                  String name,
                  Widget container,
                  boolean isDirty);

  @Event(handlers = ContentPresenter.class)
  void refreshTabName(String id,
                      String newName,
                      boolean isDirty);

  @Event(handlers = ContentPresenter.class)
  void removeTabItem(String id);

  @Event(handlers = ContentPresenter.class)
  void selectTabItem(String id);

  /**
   * Anlage eines neuen "Multi-Datenmodels
   */
  @Event(handlers = MultiPresenterHandler.class)
  void newMulti();

  /**
   * Lesen und Anzeigen eines "Multi-Datenmodels mit dem uebergebenen Schluessel
   */
  @Event(handlers = MultiPresenterHandler.class)
  void showMulti(String multiKey);

  @Event(handlers = ContentPresenter.class)
  void selectUebersicht();
}
