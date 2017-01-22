package de.gishmo.mvp4g.example.multipresenter.client.ui.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor.Path;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.widget.core.client.Portlet;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.container.PortalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.BeforeCloseEvent;
import com.sencha.gxt.widget.core.client.event.CloseEvent;
import com.sencha.gxt.widget.core.client.event.RowDoubleClickEvent;
import com.sencha.gxt.widget.core.client.event.RowDoubleClickEvent.RowDoubleClickHandler;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;

import de.gishmo.mvp4g.example.multipresenter.client.delegate.ConfirmCommand;
import de.gishmo.mvp4g.example.multipresenter.client.ui.AbstractReverseResizeComposite;
import de.gishmo.mvp4g.example.multipresenter.client.ui.content.IContentView.Presenter;

public final class ContentView
  extends AbstractReverseResizeComposite<Presenter>
  implements IContentView {

  private static final TabItemValueProperties properties = GWT.create(TabItemValueProperties.class);

  /* Brauchen die Map, um Statis und Referenzen auf Tab zu halten ... */
  private Map<String, TabItemValue> tabs;
  private TabItemValue              tabItemValue;

  private VerticalLayoutContainer contentContaineer;
  private TabPanel                tabPanel;
  private TabItemConfig           tabUebersicht;

  private PortalLayoutContainer portal;

  private Grid<TabItemValue>      grid;
  private ListStore<TabItemValue> store;

  public ContentView() {
    tabs = new HashMap<>();
    contentContaineer = new VerticalLayoutContainer();
    contentContaineer.setBorders(false);
    tabPanel = new TabPanel();
    tabUebersicht = new TabItemConfig("Portal");
    // Tab-Panel
    tabPanel.setBorders(false);
    tabPanel.setBodyBorder(false);
    tabPanel.setTabScroll(true);
    // Portal-Tab (immer vorhanden)
    tabUebersicht.setClosable(false);
    tabUebersicht.setEnabled(true);
    tabPanel.add(createUebersicht(),
                 tabUebersicht);
    contentContaineer.add(tabPanel,
                          new VerticalLayoutData(1,
                                                 1));
    createAndAddGridPortlet();
    bind();
    initWidget(contentContaineer);
  }

  private PortalLayoutContainer createUebersicht() {
    portal = new PortalLayoutContainer(2);
    portal.setSize("100%",
                   "100%");
    portal.getElement()
          .getStyle()
          .setBackgroundColor("white");
    portal.setBorders(false);
    // Portal-Aufteilung setzen
    portal.setColumnWidth(0,
                          .50);
    portal.setColumnWidth(1,
                          .50);
    return portal;
  }

  private void createAndAddGridPortlet() {
    store = new ListStore<>(properties.key());
    ColumnConfig<TabItemValue, String> idColumn = new ColumnConfig<>(properties.id(),
                                                                     1200,
                                                                     "ID");
    List<ColumnConfig<TabItemValue, ?>> columns = new ArrayList<>();
    columns.add(idColumn);
    ColumnModel<TabItemValue> cm = new ColumnModel<>(columns);
    grid = new Grid<>(store,
                      cm);
    grid.getView()
        .setAutoExpandColumn(idColumn);
    grid.getView()
        .setForceFit(true);
    grid.getView()
        .setStripeRows(true);
    grid.getView()
        .setColumnLines(true);
    grid.setHeight(512);
    Portlet portlet01 = new Portlet();
    portlet01.setHeading("Offene Tabs");
    portlet01.add(grid);
    portal.add(portlet01,
               0);
  }

  private void bind() {
    // CloseListener auf das Panel setzen
    tabPanel.addBeforeCloseHandler(new BeforeCloseEvent.BeforeCloseHandler<Widget>() {
      @Override
      public void onBeforeClose(BeforeCloseEvent<Widget> event) {
        GWT.log("event.getItem().getElement().getId(): " +
                event.getItem()
                     .getElement()
                     .getId());
        GWT.log("event.getSource().getId(): " +
                event.getSource()
                     .getId());
        tabItemValue = tabs.get(event.getItem()
                                     .getElement()
                                     .getId());
        if (tabItemValue != null) { // TabItem gefunden?
          if (tabItemValue.isDirty) { // In Bearbeitung?
            if (!tabItemValue.isCloseConfirmed) { // Schon mal gefragt?
              event.setCancelled(true);
              getPresenter().doRemove(event.getItem()
                                           .getElement()
                                           .getId());
            }
          }
        }
      }
    });
    // Beim Schliessen den Presenter raus werfen
    tabPanel.addCloseHandler(new CloseEvent.CloseHandler<Widget>() {
      @Override
      public void onClose(CloseEvent<Widget> event) {
        tabItemValue = tabs.get(event.getItem()
                                     .getElement()
                                     .getId());
        if (tabItemValue != null) { // TabItem gefunden?
          getPresenter().doRemove(event.getItem()
                                       .getElement()
                                       .getId());
        }
      }
    });
    // Grid Handler
    grid.addRowDoubleClickHandler(new RowDoubleClickHandler() {
      @Override
      public void onRowDoubleClick(RowDoubleClickEvent rowDoubleClickEvent) {
        TabItemValue tiv = store.get(rowDoubleClickEvent.getRowIndex());
        if (tiv != null) {
          getPresenter().doSelect(tiv.getId());
        }
      }
    });
  }

  @Override
  public void addItem(String id,
                      String name,
                      Widget container,
                      boolean isDirty) {
    // Portal-Tab (immer vorhanden)
    TabItemConfig tab = new TabItemConfig();
    tab.setClosable(true);
    tab.setEnabled(true);
    String tabName = name;
    if (isDirty) {
      tabName += "*";
    }
    tab.setText(tabName);
    // Container an das TabPanel setzen
    tabPanel.add(container,
                 tab);
    // Tab in Liste sichern!
    TabItemValue tabValue = new TabItemValue(id,
                                             isDirty,
                                             tab,
                                             container);
    tabs.put(id,
             tabValue);
    store.add(tabValue);
  }

  @Override
  public void close(String id) {
    tabItemValue = tabs.get(id);
    if (tabItemValue != null) { // TabItem gefunden?
      tabPanel.remove(tabItemValue.getWidget());
      if (tabItemValue.isOpen) {
        tabItemValue.setOpen(false);
        tabs.put(id,
                 tabItemValue);
      }
      tabs.remove(id);
      store.remove(tabItemValue);
      tabItemValue = null;
    }
  }

  @Override
  public void remove(final String id) {
    tabItemValue = tabs.get(id);
    if (tabItemValue != null) { // TabItem gefunden?
      if (tabItemValue.isDirty) { // In Bearbeitung?
        if (!tabItemValue.isCloseConfirmed) { // Schon mal gefragt?
          getPresenter().doConfirmClose(id,
                                        new ConfirmCommand() {
                                          @Override
                                          public void cancel() {
                                            tabItemValue.setCloseConfirmed(false);
                                            tabs.put(id,
                                                     tabItemValue);
                                          }

                                          @Override
                                          public void ok() {
                                            tabItemValue.setCloseConfirmed(true);
                                            tabs.put(id,
                                                     tabItemValue);
                                            getPresenter().doClose(id);
                                          }
                                        });
        } else {
          getPresenter().doClose(id);
        }
      } else {
        getPresenter().doClose(id);
      }
    }
  }

  @Override
  public void refresh(String id,
                      String newName,
                      boolean isDirty) {
    TabItemValue tabItemValue = tabs.get(id);
    if (tabItemValue != null) {
      String newValue = newName;
      tabItemValue.setDirty(isDirty);
      if (newValue != null) {
        if (isDirty) {
          newValue = newValue + "*";
          tabItemValue.getItem()
                      .setText(newName + "*");
        } else {
          tabItemValue.getItem()
                      .setText(newName);
        }
      } else {
        newValue = tabItemValue.getItem()
                               .getText();
        if (isDirty) {
          if (!newValue.endsWith("*")) {
            tabItemValue.getItem()
                        .setText(newValue + "*");
          }
        } else {
          if (newValue.endsWith("*")) {
            tabItemValue.getItem()
                        .setText(newValue.substring(0,
                                                    newValue.length() - 1));
          }
        }
      }
      // In die liste uebertragen
      tabs.put(id,
               tabItemValue);
      // Reiter aktualisieren
      TabItemConfig config = tabPanel.getConfig(tabItemValue.getWidget());
      if (config != null) {
        config.setText(newValue);
        tabPanel.update(tabItemValue.getWidget(),
                        config);
      }
    }
  }

  @Override
  public void select(String id) {
    // Und jetzt den gewuenschten Tab auswaehlen ...
    TabItemValue tabItemValue = tabs.get(id);
    if (tabItemValue != null) {
      tabPanel.setActiveWidget(tabItemValue.getWidget());
    }
  }

  @Override
  public void selectUebersicht() {
    tabPanel.scrollToTab(portal,
                         true);
    tabPanel.setActiveWidget(portal);
  }

  @Override
  public void onResize() {
    contentContaineer.forceLayout();
  }

  public interface TabItemValueProperties
    extends PropertyAccess<TabItemValue> {
    @Path("id")
    ModelKeyProvider<TabItemValue> key();

    ValueProvider<TabItemValue, String> id();
  }

  public class TabItemValue {
    private boolean isDirty;
    private boolean isCloseConfirmed = false;
    private boolean isOpen           = true;
    private String        id;
    private TabItemConfig item;
    private Widget        widget;

    private TabItemValue(String id,
                         boolean isDirty,
                         TabItemConfig item,
                         Widget widget) {
      setDirty(isDirty);
      setId(id);
      setItem(item);
      setCloseConfirmed(false);
      setOpen(true);
      setWidget(widget);
    }

    @SuppressWarnings("unused")
    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public TabItemConfig getItem() {
      return item;
    }

    public void setItem(TabItemConfig item) {
      this.item = item;
    }

    @SuppressWarnings("unused")
    public boolean isDirty() {
      return isDirty;
    }

    public void setDirty(boolean isDirty) {
      this.isDirty = isDirty;
    }

    @SuppressWarnings("unused")
    public boolean isCloseConfirmed() {
      return isCloseConfirmed;
    }

    public void setCloseConfirmed(boolean isCloseConfirmed) {
      this.isCloseConfirmed = isCloseConfirmed;
    }

    @SuppressWarnings("unused")
    public boolean isOpen() {
      return isOpen;
    }

    public void setOpen(boolean isOpen) {
      this.isOpen = isOpen;
    }

    public Widget getWidget() {
      return widget;
    }

    public void setWidget(Widget widget) {
      this.widget = widget;
    }
  }
}
