package de.gishmo.mvp4g.example.multipresenter.client.ui.shell;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.themebuilder.base.client.config.ThemeDetails;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;
import com.sencha.gxt.widget.core.client.container.Viewport;

import de.gishmo.mvp4g.example.multipresenter.client.ui.AbstractReverseResizeComposite;
import de.gishmo.mvp4g.example.multipresenter.client.ui.shell.IShellView.Presenter;

public final class ShellView
  extends AbstractReverseResizeComposite<Presenter>
  implements IShellView {

  //  private BorderLayoutContainer   shellContent;
//  private ContentPanel            messages;
//  /* Fehler-Modubox */
//  private MbMessage               mbMessageContentArea;
//  private MbApplicationInfoWidget mbApplicationInfoArea;
  /* ThemeDetails des aktuell verwendeten Themes */
  private static ThemeDetails themeDetails = GWT.create(ThemeDetails.class);
  private BorderLayoutContainer shell;
  //  private SimpleContainer         buttonBar;
  private SimpleContainer       headerArea;
  private ContentPanel          toolbarArea;
  //  private SimpleContainer         navigationArea;
  private SimpleContainer       content;

  public ShellView() {
    // // Viewport fomatieren
    Viewport viewport = new Viewport();
    // Shell erzeugen
    shell = new BorderLayoutContainer();
    headerArea = new SimpleContainer();
    toolbarArea = new ContentPanel();
    content = new SimpleContainer();
    content.setSize("100%", "100%");
//    messages = new ContentPanel();
//    mbMessageContentArea = new MbMessage(new MbMessageDelegate() {
//      @Override
//      public void hideMessageWidget() {
//        shellContent.hide(LayoutRegion.NORTH);
//      }
//
//      @Override
//      public void showMessageWidget() {
//        shellContent.show(LayoutRegion.NORTH);
//      }
//    });
//    mbApplicationInfoArea = new MbApplicationInfoWidget();
//    mbApplicationInfoArea.setDispatcherDelegate(new DispatcherDelegate() {
//      @Override
//      public void dispatch(String key01,
//                           String key02) {
//        getPresenter().doDispatch(key01,
//                                  key02);
//      }
//    });

    createApplicationShell();

    viewport.add(shell);
    // Aufruf init wegen Composite
    initWidget(viewport);
  }

  private void createApplicationShell() {
    BorderLayoutContainer.BorderLayoutData layoutDataHeader = new BorderLayoutContainer.BorderLayoutData(64);
    shell.setNorthWidget(headerArea,
                         layoutDataHeader);

    BorderLayoutContainer.BorderLayoutData ldWestWidget = new BorderLayoutContainer.BorderLayoutData(192);
    ldWestWidget.setCollapsible(false);
    ldWestWidget.setCollapseHeaderVisible(false);
    ldWestWidget.setSplit(false);
    ldWestWidget.setCollapseMini(false);
    toolbarArea.setHeading("Toolbar");
    toolbarArea.setBodyStyle("background-color: white; border-right: solid 1px " +
                             themeDetails.borderLayout()
                                         .collapsePanelBorder()
                                         .color() +
                             ";");
    shell.setWestWidget(toolbarArea,
                        ldWestWidget);

//    BorderLayoutContainer westContainer = new BorderLayoutContainer();
//    toolbarArea.add(westContainer);
//
//    westContainer.setSouthWidget(mbApplicationInfoArea,
//                                 new BorderLayoutData(100));
//
//    westContainer.setCenterWidget(navigationArea);

    shell.add(content,
              new MarginData(4));

////    BorderLayoutData ldMessages = new BorderLayoutData(Constants.MESSAGES_HEIGHT);
////    ldMessages.setCollapsed(false);
////    messages.setHeaderVisible(false);
////    messages.setBorders(false);
////    messages.setBodyBorder(false);
////    messages.setBodyStyle("background: none; padding-left: 8px");
////    shellContent.setNorthWidget(messages,
////                                ldMessages);
////    messages.add(mbMessageContentArea);
////    shellContent.hide(LayoutRegion.NORTH);
//
//    BorderLayoutContainer.BorderLayoutData ldButtonBar = new BorderLayoutContainer.BorderLayoutData(Constants.BUTTON_BAR_HEIGHT);
//    buttonBar.setBorders(false);
//    buttonBar.getElement()
//             .getStyle()
//             .setProperty("borderTop",
//                          "solid 1px " +
//                          UiUtils.getBorderDetails()
//                                 .color());
//    buttonBar.getElement()
//             .getStyle()
//             .setProperty("borderLeft",
//                          "solid 1px " +
//                          UiUtils.getBorderDetails()
//                                 .color());
//    shellContent.setSouthWidget(buttonBar,
//                                ldButtonBar);
//
//    BorderLayoutContainer.BorderLayoutData ldCenter = new BorderLayoutContainer.BorderLayoutData();
//    ldCenter.setMinSize(Constants.CONTENT_MIN_WIDTH);
//    // Center-Panel
//    content.setHeaderVisible(false);
//    content.setBorders(false);
//    content.setBodyBorder(false);
//    shellContent.setCenterWidget(content,
//                                 ldCenter);
//    Scheduler.get()
//             .scheduleDeferred(new ScheduledCommand() {
//               @Override
//               public void execute() {
//                 shell.forceLayout();
//               }
//             });
  }

//  @Override
//  public void setButtonBar(Widget buttonBar) {
//    this.buttonBar.setWidget(buttonBar);
//  }

  @Override
  public void setShellContent(Widget content) {
    if (this.content.getWidget() != null) {
      this.content.getWidget()
                  .removeFromParent();
    }
    this.content.add(content);
  }

  @Override
  public void setHeader(Widget headerArea) {
    if (this.headerArea.getWidget() != null) {
      this.headerArea.getWidget()
                     .removeFromParent();
    }
    this.headerArea.add(headerArea);
  }

  @Override
  public void setToolbar(final Widget navigation) {
    if (this.toolbarArea.getWidget() != null) {
      this.toolbarArea.getWidget()
                      .removeFromParent();
    }
    this.toolbarArea.add(navigation);
  }

//  @Override
//  public void updateBeitrag(Antrag antrag,
//                            KeyTables pKeytables) {
//    if (mbApplicationInfoArea != null) {
//      mbApplicationInfoArea.edit(antrag,
//                                 pKeytables);
//    }
//  }
}
