package de.gishmo.mvp4g.example.multipresenterwithhistorie.client;

import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.Debug;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.InitHistory;
import com.mvp4g.client.annotation.Start;
import com.mvp4g.client.event.EventBusWithLookup;

import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.delegate.CloseTabItemEvent;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.handler.PersistentHandler;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.history.DefaultHistoryConverter;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.history.EventName;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.ui.content.ContentPresenter;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.ui.header.HeaderPresenter;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.ui.person.PersonHandler;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.ui.shell.ShellPresenter;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.ui.toolbar.ToolbarPresenter;

@Events(startPresenter = ShellPresenter.class,
        historyOnStart = true,
        ginModules = Mvp4gMultiPresetnerWithHistorieGinModule.class)
@Debug(logLevel = Debug.LogLevel.DETAILED)
public interface Mvp4gMultiPresenterWithHistorieEventBus
  extends EventBusWithLookup {

  @Start
  @Event(bind = { HeaderPresenter.class,
                  ToolbarPresenter.class,
                  ContentPresenter.class })
  void start();

  @InitHistory
  @Event(handlers = PersistentHandler.class)
  void initHistory();

  @Event(handlers = ShellPresenter.class)
  void setShellContent(Widget asWidget);

  @Event(handlers = ShellPresenter.class)
  void setHeader(Widget header);

  @Event(handlers = ShellPresenter.class)
  void setToolbar(Widget widget);

  /* closeTab */
  @Event(broadcastTo = CloseTabItemEvent.class)
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

  @Event(handlers = ContentPresenter.class)
  void selectUebersicht();

  /**
   * Anlage eines neuen "Multi-Datenmodels
   */
  @Event(name = EventName.EVENT_NEW_PERSON,
         handlers = PersonHandler.class,
         historyConverter = DefaultHistoryConverter.class)
  void newPerson();

  @Event(name = EventName.EVENT_SHOW_PERSON,
         handlers = PersonHandler.class,
         historyConverter = DefaultHistoryConverter.class)
  void showPerson(long id);

  @Event(handlers = PersistentHandler.class)
  void persistHistory();
}
