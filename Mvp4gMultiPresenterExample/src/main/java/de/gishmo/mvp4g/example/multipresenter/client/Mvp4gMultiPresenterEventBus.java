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
        historyOnStart = true,
        ginModules = Mvp4gMultiPresetnerGinModule.class)
@Debug(logLevel = Debug.LogLevel.DETAILED)
public interface Mvp4gMultiPresenterEventBus
  extends EventBus {

  @Start
  @Event(bind = { HeaderPresenter.class,
                  ToolbarPresenter.class,
                  ContentPresenter.class })
  void start();

//  @Event(handlers = NavigationPresenter.class,
//         historyConverter = ClearHistory.class)
//  void clearHistory();
//
//  @InitHistory
//  @Event(handlers = ApplicationHandler.class)
//  void initHistory();
//
//  @Event(handlers = ApplicationHandler.class)
//  void startApplication(String eventName,
//                        String... params);
//
//  /**
//   * see: {@link LoadViewEvent}
//   */
//  @Event(broadcastTo = LoadViewEvent.class)
//  void loadView();
//
//  /**
//   * Persistiere Daten im Vorgangskontext
//   */
//  @Event(handlers = PersistenceHandler.class)
//  void persist(boolean isAutoSave);
//
//  @Event(handlers = PersistenceHandler.class)
//  void crmSprung(CRMType pCRMType,
//                 boolean isAutoSave);
//
//  @Event(handlers = ShellPresenter.class)
//  void exitApplication();
//
//  /**
//   * Aktualisiert den Complete-Status der Navigation
//   */
//  @Event(broadcastTo = UpdateNavigationCompleteStateEvent.class)
//  void updateNavigationCompleteState();
//
//  /**
//   * Druckt den übergebenen Antrag
//   *
//   * @param pUUID
//   *   uuid
//   */
//  @Event(handlers = PrintingHandler.class)
//  void print(String pUUID);
//
//  /**
//   * Druckt für den übergebenen Antrag die Tarifkonfiguration
//   *
//   * @param pUUID
//   *   UUID des Antrages
//   */
//  @Event(handlers = PrintingHandler.class)
//  void printTarifKonfiguration(String pUUID);
//
//  /**
//   * Druckt für den übergebenen Antrag das Beratungsprotokoll
//   *
//   * @param pUUID
//   *   UUID des Antrages
//   */
//  @Event(handlers = PrintingHandler.class)
//  void printBeratungsprotokoll(String pUUID);
//
//  /**
//   * Druckt für den übergebenen Antrag die Kundeninformationen
//   *
//   * @param pUUID
//   *   UUID des Antrages
//   */
//  @Event(handlers = PrintingHandler.class)
//  void printKundeninfo(String pUUID);
//
//  /**
//   * Erstellung Vorschlagsdruck
//   *
//   * @param pUuid
//   *   UUID des Antrages
//   */
//  @Event(handlers = PrintingHandler.class)
//  void printVorschlag(String pUuid);
//
//  /**
//   * Log Meldungen auf dem Server
//   *
//   * @param pLoglevel
//   *   Kennzeichnet den Schweregrad des LogEintrages<br>
//   *   LogLevel:
//   *   <li>Debug</li>
//   *   <li>Info</li>
//   *   <li>Warning</li>
//   *   <li>Error</li>
//   *   <li>Critical</li>
//   * @param pMessage
//   *   Die Nachricht die an den Server übermittelt werden soll
//   */
//  @Event(handlers = LoggingHandler.class)
//  void logOnServer(LoggingInfo.Loglevel pLoglevel,
//                   String methodName,
//                   String pMessage);
//
//  /**
//   * Versenden des Antrags
//   */
//  @Event(handlers = SetOrderHandler.class)
//  void setOrder(String pUUID);
//
//  /**
//   * Der Event wird gefeuert, wenn ein Widget aus dem Content-Bereich entfernt wird.
//   *
//   * @param token
//   *   eindeutiger Key des Presenters
//   */
//  @Event(broadcastTo = RemoveContentEventHandler.class)
//  void removeContent(String token);
//
//  @Event(handlers = ButtonBarPresenter.class)
//  void removeAllButtons();
//
//  @Event(handlers = ButtonBarPresenter.class)
//  void setGoBackButtonCommand(Command command);
//
//  @Event(handlers = ButtonBarPresenter.class)
//  void setGoOnButtonCommand(Command command);
//
//  @Event(handlers = ButtonBarPresenter.class)
//  void setButtonBarCommands(ButtonBarCommands commands);
//
//  @Event(handlers = ButtonBarPresenter.class)
//  void setButtonBarUseDefault(Command pSaveCommand);
//
//  @Event(handlers = ButtonBarPresenter.class)
//  void setPrintButtonCommand(String label,
//                             int width,
//                             Command command);
//
//  @Event(handlers = ToolbarPresenter.class)
//  void setUpHeader();
//
//  /**
//   * Enablen & Disablen der Navigation, um unerwuenschte Eingaben zu verhindern
//   *
//   * @param enable
//   *   true -> Navigation ist enbaled
//   */
//  @Event(handlers = NavigationPresenter.class)
//  void enableNavigation(boolean enable);
//
//  @Event(handlers = NavigationPresenter.class)
//  void select(String navigationID);
//
//  @Event(handlers = NavigationPresenter.class)
//  void setNavigationState(String navigationID,
//                          NavigationTreeDto.IconStyle icon);
//
//  @Event(handlers = ShellPresenter.class)
//  void setButtonBar(Widget buttonBar);
//
//  /**
//   * Setzt das Widget in den Content-Bereich der Anwendung. Der Token ist ein eindeutiger Key zur Identifizierung des Presenters
//   *
//   * @param token
//   *   eindeutiger Key des Presenters
//   * @param content
//   *   Widget, dass im Content Bereich anzuzeigen ist
//   */
//  @Event(handlers = ContentPresenter.class)
//  void setContent(String token,
//                  Widget content);

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

  @Event(handlers = MultiPresenterHandler.class)
  void addMultiPresenter(String key);

//  /**
//   * Verarbeitet das Entfernen eines Produktes aus der Produktiste.
//   * Der User wird vor dem Entfernen gefragt, ob er das Produkt wirklich entfernen moechte.
//   * <p>
//   * Dieser Event wird gefeuert bevor das Datenmodel aktualisiert wurde
//   *
//   * @param produkt
//   *   betroffenes Produkt
//   */
//  @Event(broadcastTo = BeforeExcludeProduktEvent.class)
//  void beforeExcludeProdukt(GsKeyValue produkt);
//
//  /**
//   * Verarbeitet das Entfernen eines Produktes aus der Produktiste.
//   * Der User wird vor dem Entfernen gefragt, ob er das Produkt wirklich entfernen moechte.
//   * <p>
//   * Dieser Event wird gefeuert nachdem das Datenmodel aktualisiert wurde
//   *
//   * @param produkt
//   *   betroffenes Produkt
//   */
//  @Event(broadcastTo = ExcludeProduktEvent.class)
//  void excludeProdukt(GsKeyValue produkt);
//
//  /**
//   * Verarbeitet das Hinzufuegen eines Produktes aus der Produktiste.
//   *
//   * @param produkt
//   *   betroffenes Produkt
//   */
//  @Event(broadcastTo = IncludeProduktEvent.class)
//  void includeProdukt(GsKeyValue produkt);
//
//  /**
//   * Verarbeitet das Setup bestehender Produkte bei reload der Anwendung
//   *
//   * @param produkt
//   *   betroffenes Produkt
//   */
//  @Event(broadcastTo = LoadProduktEvent.class)
//  void loadProdukt(GsKeyValue produkt);
//
//  @Event(name = HistoryEventnamen.GEVO_NEU_TAA_CONFIG,
//         historyConverter = DefaultTaaHistoryConverter.class,
//         handlers = TaaGevoNeuConfigPresenter.class)
//  void showTaaGevoNeuConfig();
//
//  @Event(name = HistoryEventnamen.GEVO_NEU_TR_CONFIG,
//         historyConverter = DefaultTaaHistoryConverter.class,
//         handlers = TrGevoNeuConfigPresenter.class)
//  void showTrGevoNeuConfig();
//
//  @Event(name = HistoryEventnamen.GEVO_AENDERUNG_CONFIG,
//         historyConverter = DefaultTaaHistoryConverter.class,
//         handlers = GevoAenderungConfigPresenter.class)
//  void showGevoAenderungConfig();
//
//  @Event(name = HistoryEventnamen.GEVO_FREIGABE_VORBEREITEN_CONFIG,
//         historyConverter = DefaultTaaHistoryConverter.class,
//         handlers = GevoFreigabeVorbereitenHandler.class)
//  void handleGevoFreigabeVorbereitenConfig();
//
//  @Event(name = HistoryEventnamen.GEVO_FREIGABE_CONFIG,
//         historyConverter = DefaultTaaHistoryConverter.class,
//         handlers = GevoFreigegebenHandler.class)
//  void handleFreigegebenConfig();
//
//  @Event(name = HistoryEventnamen.ALLGEMEINE_GGP_DATEN,
//         handlers = { AllgemeinGGPPresenter.class },
//         historyConverter = DefaultTaaHistoryConverter.class,
//         navigationEvent = true)
//  void gotoAllgemeinGPG();
//
//  @Event(name = HistoryEventnamen.ALLGEMEINE_VSH_DATEN,
//         handlers = { AllgemeinVSHPresenter.class },
//         historyConverter = DefaultTaaHistoryConverter.class,
//         navigationEvent = true)
//  void gotoAllgemeinVSH();
//
//  @Event(name = HistoryEventnamen.ANTRAGSFRAGEN,
//         historyConverter = DefaultTaaHistoryConverter.class,
//         handlers = { AntragsfragenPresenter.class },
//         navigationEvent = true)
//  void gotoAntragsfragen();
//
//  @Event(name = HistoryEventnamen.BETRIEBSHAFTPFLICHT,
//         historyConverter = DefaultTaaHistoryConverter.class,
//         handlers = { BetriebshaftpflichtPresenter.class },
//         navigationEvent = true)
//  void gotoBetriebshaftplicht();
//
//  @Event(name = HistoryEventnamen.BEITRAGSZAHLER,
//         historyConverter = DefaultTaaHistoryConverter.class,
//         handlers = { BeitragszahlerPresenter.class },
//         navigationEvent = true)
//  void gotoBeitragszahler();
//
//  @Event(name = HistoryEventnamen.PARTNER,
//         historyConverter = DefaultTaaHistoryConverter.class,
//         handlers = { PartnerPresenter.class },
//         navigationEvent = true)
//  void gotoPartner();
//
//  @Event(name = HistoryEventnamen.DRUCKSTUECKE,
//         historyConverter = DefaultTaaHistoryConverter.class,
//         handlers = { AbschlussPresenter.class },
//         navigationEvent = true)
//  void gotoDruckstueckAuswahl();
//
//  @Event(name = HistoryEventnamen.ERGEBNIS,
//         historyConverter = DefaultTaaHistoryConverter.class,
//         handlers = { ErgebnisPresenter.class },
//         navigationEvent = true)
//  void gotoErgebnis();
//
//  @Event(name = HistoryEventnamen.GEBAEUDE,
//         historyConverter = DefaultTaaHistoryConverter.class,
//         handlers = { GebaeudePresenter.class },
//         navigationEvent = true)
//  void gotoGebaeude();
//
//  @Event(name = HistoryEventnamen.INHALT,
//         historyConverter = DefaultTaaHistoryConverter.class,
//         handlers = { InhaltPresenter.class },
//         navigationEvent = true)
//  void gotoInhalt();
//
//  @Event(name = HistoryEventnamen.ELEKTRONIK,
//         historyConverter = DefaultTaaHistoryConverter.class,
//         handlers = { ElektronikPresenter.class },
//         navigationEvent = true)
//  void gotoElektronik();
//
//  @Event(name = HistoryEventnamen.MASCHINEN_STATIONAER,
//         historyConverter = DefaultTaaHistoryConverter.class,
//         handlers = { MaschinenStationaerPresenter.class },
//         navigationEvent = true)
//  void gotoMaschinenStationaer();
//
//  @Event(name = HistoryEventnamen.MASCHINEN_FAHRBAR,
//         historyConverter = DefaultTaaHistoryConverter.class,
//         handlers = { MaschinenFahrbarPresenter.class },
//         navigationEvent = true)
//  void gotoMaschinenFahrbar();
//
//  @Event(name = HistoryEventnamen.TARIF_KONFIGURATION,
//         historyConverter = DefaultTaaHistoryConverter.class,
//         handlers = { TarifKonfigurationPresenter.class },
//         navigationEvent = true)
//  void gotoTarifKonfiguration();
//
//  @Event(name = HistoryEventnamen.VERSICHERUNGSNEHMER,
//         historyConverter = DefaultTaaHistoryConverter.class,
//         handlers = { VersicherungsnehmerPresenter.class },
//         navigationEvent = true)
//  void gotoVersicherungsnehmer();
//
//  @Event(name = HistoryEventnamen.WERKVERKEHR,
//         historyConverter = DefaultTaaHistoryConverter.class,
//         handlers = { WerkverkehrPresenter.class },
//         navigationEvent = true)
//  void gotoWerkverkehr();
//
//  @Event(name = HistoryEventnamen.BETRIEBSSCHLIESSUNG,
//      historyConverter = DefaultTaaHistoryConverter.class,
//      handlers = { BetriebsschliessungPresenter.class },
//      navigationEvent = true)
//  void gotoBetriebsschliessung();
//
//  @Event(name = HistoryEventnamen.ZEICHNUNGSVOLLMACHT,
//         historyConverter = DefaultTaaHistoryConverter.class,
//         handlers = { ZeichnungsEntscheidungPresenter.class },
//         navigationEvent = true)
//  void gotoZeichnungsvollmacht();
//
//  @Event(name = HistoryEventnamen.PHOTOVOLTAIK,
//         historyConverter = DefaultTaaHistoryConverter.class,
//         handlers = { PhotovoltaikPresenter.class },
//         navigationEvent = true)
//  void gotoPhotovoltaik();
//
//  @Event(handlers = { AllgemeinGGPPresenter.class })
//  void openTaetigkeitenEditorGGP();
//
//  @Event(handlers = { AllgemeinVSHPresenter.class })
//  void openTaetigkeitenEditorVSH();
//
//  /**
//   * <p>Der Event ist eine Aufforderung an alle Presenter
//   * den Beitrag zu aktualisieren</p>
//   */
//  @Event(broadcastTo = UpdateBeitragEvent.class)
//  void updateBeitrag();
//
//  @Event(handlers = { BeitragszahlerPresenter.class })
//  void updateZahlweise();
//
//  /**
//   * @param model
//   *   Das Datenmodell des Risikoortes, zur Füllung des Widgets
//   * @param targetTabName
//   *   Text/Titel des aktiv zu schalten Reiters, kann NULL sein
//   * @param pDelegate
//   *   Delegate, um nach dem Verlassen des Dialogs noch Aktionen auszuführen, kann NULL sein
//   */
//  @Event(handlers = { RisikoOrtPresenter.class })
//  void showRisikoOrt(RisikoOrt model,
//                     String targetTabName,
//                     RisikoOrtDelegate pDelegate);
//
//  /**
//   * <p>
//   * Fuegt der Navigation den Menue-Punkt Zeichnung hinzu.
//   * </p>
//   */
//  @Event(handlers = { NavigationPresenter.class })
//  void addZeichnungToNavigation();
//
//  /**
//   * <p>
//   * Entfernt den Menue-Punkt aus der Navigation
//   * </p>
//   */
//  @Event(handlers = { NavigationPresenter.class })
//  void removeZeichnungFromNavigation();
//
//  @Event(handlers = NavigationPresenter.class)
//  void updateNavigationPartner();

}
