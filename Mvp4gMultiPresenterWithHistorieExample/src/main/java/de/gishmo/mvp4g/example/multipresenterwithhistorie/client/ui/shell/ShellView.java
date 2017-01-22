package de.gishmo.mvp4g.example.multipresenterwithhistorie.client.ui.shell;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.themebuilder.base.client.config.ThemeDetails;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;
import com.sencha.gxt.widget.core.client.container.Viewport;

import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.ui.AbstractReverseResizeComposite;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.ui.shell.IShellView.Presenter;

public final class ShellView
  extends AbstractReverseResizeComposite<Presenter>
  implements IShellView {

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
    shell.add(content,
              new MarginData(4));
  }

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
}
