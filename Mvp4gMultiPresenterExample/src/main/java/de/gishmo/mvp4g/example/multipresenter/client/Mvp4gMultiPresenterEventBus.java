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

@Events(startPresenter = ShellPresenter.class, ginModules = Mvp4gMultiPresetnerGinModule.class)
@Debug(logLevel = Debug.LogLevel.DETAILED)
public interface Mvp4gMultiPresenterEventBus
  extends EventBus {

  /**
   * Hack to set up the shell ....
   */
  @Start
  @Event(bind = { HeaderPresenter.class, ToolbarPresenter.class, ContentPresenter.class })
  void start();

  /**
   * sets a widget in the content area of the shell
   *
   * @param asWidget
   *   the widget to set in the content area of the shell
   */
  @Event(handlers = ShellPresenter.class)
  void setShellContent(Widget asWidget);

  /**
   * sets a widget in the header of the shell
   *
   * @param header
   *   the widget to set in the header area of the shell
   */
  @Event(handlers = ShellPresenter.class)
  void setHeader(Widget header);

  /**
   * sets a widget in the toolbar area of the shell
   *
   * @param widget
   *   the widget to set in the toolbar area of the shell
   */
  @Event(handlers = ShellPresenter.class)
  void setToolbar(Widget widget);

  /**
   * close the tab item with the id.
   *
   * @param id
   *   id of the presenter to close
   */
  /* closeTab */
  @Event(handlers = ContentPresenter.class)
  void closeTabItem(String id);

  /**
   * Creates a new presenter and adds it to the tab panel
   *
   * @param id
   *   id the Presenters
   * @param name
   *   name of the tab
   * @param container
   *   the widget
   * @param isDirty
   *   true ->  show tab as dirty
   */
  @Event(handlers = ContentPresenter.class)
  void addTabItem(String id,
                  String name,
                  Widget container,
                  boolean isDirty);

  /**
   * refresh the text ot the tab
   *
   * @param id
   *   id of the presenter
   * @param newName
   *   new text
   * @param isDirty
   *   true -> show tab as dirty
   */
  @Event(handlers = ContentPresenter.class)
  void refreshTabName(String id,
                      String newName,
                      boolean isDirty);

  /**
   * close the tab with the given ID
   *
   * @param id
   *   ID of the tab to close
   */
  @Event(handlers = { MultiPresenterHandler.class, ContentPresenter.class })
  void removeTabItem(String id);

  /**
   * select the tab (bring it to front) with the given id
   *
   * @param id
   *   id of the tab to show
   */
  @Event(handlers = ContentPresenter.class)
  void selectTabItem(String id);

  /**
   * Create a new multi presenter
   */
  @Event(handlers = MultiPresenterHandler.class)
  void newMulti();

  /**
   * select the portal tab
   */
  @Event(handlers = ContentPresenter.class)
  void selectPortal();
}
