package de.gishmo.mvp4g.example.multipresenterwithhistorie.client.ui.header;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.sencha.gxt.core.client.XTemplates;
import com.sencha.gxt.widget.core.client.container.AbstractHtmlLayoutContainer.HtmlData;
import com.sencha.gxt.widget.core.client.container.HtmlLayoutContainer;

import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.ui.AbstractReverseComposite;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.ui.header.IHeaderView.Presenter;

public final class HeaderView
  extends AbstractReverseComposite<Presenter>
  implements IHeaderView,
             IsWidget {

  /* panel */
  private HtmlLayoutContainer container;
  /* label */
  private Label               labelHeadline;
  /* Header Style */
  private HeaderStyle         style;

  public HeaderView() {
    // Widgets
    createWidget();
    initWidget(container);
  }

  private void createWidget() {
    Resources resources = GWT.create(Resources.class);
    style = resources.style();
    style.ensureInjected();

    ContainerTemplate containerTemplate = GWT.create(ContainerTemplate.class);
    container = new HtmlLayoutContainer(containerTemplate.getTemplate(style.container()));

    labelHeadline = new Label(HeaderConstants.CONSTANTS.headline());

    labelHeadline.addStyleName(style.leftColumn());

    container.add(labelHeadline,
                  new HtmlData(".leftColumn01"));
  }

  public interface ContainerTemplate
    extends XTemplates {
    @XTemplate("<table width=\"100%\" height=\"100%\" class=\"{container}\">" +
               "  <tbody>" +
               "    <tr>" +
               "      <td height=\"50%\" class=\"leftColumn01\"></td>" +
               "    </tr>" +
               "  </tbody>" +
               "</table>")
    SafeHtml getTemplate(String container);
  }

  interface Resources
    extends ClientBundle {

    @Source("Header.gss")
    HeaderStyle style();

  }

  interface HeaderStyle
    extends CssResource {

    String container();

    String leftColumn();

  }
}
