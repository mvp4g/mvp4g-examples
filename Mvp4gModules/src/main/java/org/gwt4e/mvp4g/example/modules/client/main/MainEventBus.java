package org.gwt4e.mvp4g.example.modules.client.main;

import com.google.gwt.user.client.ui.IsWidget;
import com.mvp4g.client.annotation.*;
import com.mvp4g.client.annotation.Debug.LogLevel;
import com.mvp4g.client.annotation.module.*;
import com.mvp4g.client.event.EventBusWithLookup;
import com.mvp4g.client.history.ClearHistory;
import org.gwt4e.mvp4g.example.modules.client.Mvp4gGinModule;
import org.gwt4e.mvp4g.example.modules.client.company.CompanyModule;
import org.gwt4e.mvp4g.example.modules.client.main.historyConverter.MenuHistoryConverter;
import org.gwt4e.mvp4g.example.modules.client.main.presenter.*;
import org.gwt4e.mvp4g.example.modules.client.product.ProductModule;
import org.gwt4e.mvp4g.example.modules.client.util.HasBeenThereHandler;

@Events(startPresenter = MainPresenter.class,
        historyOnStart = true,
        ginModules = Mvp4gGinModule.class,
        ginModuleProperties = "ginModule")
@Debug(logLevel = LogLevel.DETAILED,
       logger = CustomLogger.class)
@ChildModules({ @ChildModule(moduleClass = CompanyModule.class),
                @ChildModule(moduleClass = ProductModule.class,
                             async = false,
                             autoDisplay = false)})
@Filters(filterClasses = {},
         forceFilters = true)
@PlaceService(CustomPlaceService.class)
public interface MainEventBus
  extends EventBusWithLookup {

  /* Navigation events */
  @Event(forwardToModules = CompanyModule.class,
         historyConverter = MenuHistoryConverter.class,
         handlers = MainPresenter.class,
         name = "companies",
         navigationEvent = true)
  void goToCompany(int start,
                   int end);

  //use Integer instead of int here just to test passing object, in real project, you should have int
  @Event(forwardToModules = ProductModule.class,
         historyConverter = MenuHistoryConverter.class,
         handlers = MainPresenter.class,
         navigationEvent = true)
  String goToProduct(Integer start,
                     Integer end);

  /* Business events */
  @DisplayChildModuleView(CompanyModule.class)
  @Event(handlers = MainPresenter.class)
  void changeBody(IsWidget newBody);

  @LoadChildModuleError
  @Event(handlers = MainPresenter.class)
  void errorOnLoad(Throwable reason);

  @BeforeLoadChildModule
  @Event(handlers = MainPresenter.class)
  void beforeLoad();

  @AfterLoadChildModule
  @Event(handlers = MainPresenter.class)
  void afterLoad();

  @Event(handlers = MainPresenter.class)
  void displayMessage(String message);

  @InitHistory
  @Event
  void start();

  @Event(handlers = MainPresenter.class)
  void selectProductMenu();

  @Event(handlers = MainPresenter.class)
  void selectCompanyMenu();

  @Event(handlers = MainPresenter.class,
         historyConverter = ClearHistory.class)
  void clearHistory();

  @Event(broadcastTo = HasBeenThereHandler.class,
         passive = true)
  void hasBeenThere();

  //this event is just here to validate array
  @Event(broadcastTo = HasBeenThereHandler.class,
         passive = true,
         generate = InfoReceiverPresenter.class)
  void broadcastInfo(String[] info);

  @Event(handlers = MainPresenter.class)
  void broadcastInfoFromProduct(String info);

  @Event(handlers = MainPresenter.class)
  void broadcastInfoFromProductPassive(String info);

  @Event(handlers = StatusContainerPresenter.class,
         bind = {DatePresenter.class, TimePresenter.class},
         forwardToModules = CompanyModule.class)
  void showStatus(String info);

  @Event(activate = {StatusContainerPresenter.class, DatePresenter.class, TimePresenter.class})
  void activateStatus();

  @Event(deactivate = {StatusContainerPresenter.class, DatePresenter.class, TimePresenter.class})
  void deactivateStatus();

}
