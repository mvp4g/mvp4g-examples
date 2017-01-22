package de.gishmo.mvp4g.example.multipresenter.client.ui.multi;

import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.container.CssFloatLayoutContainer;
import com.sencha.gxt.widget.core.client.container.CssFloatLayoutContainer.CssFloatData;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;

import de.gishmo.mvp4g.example.multipresenter.client.utils.ReverseResizeComposite;
import de.gishmo.mvp4g.example.multipresenter.shared.dto.MultiPresenterModel;

public class MultiPresenterView
  extends ReverseResizeComposite<IMultiPresenterView.Presenter>
  implements IMultiPresenterView {

  private CssFloatLayoutContainer container;

  private TextField keyCurrentPresenterShowed;
  private TextField tsCreated;

  public MultiPresenterView() {
    super();
    createView();
  }

  public void createView() {
    // Initialisieren
    this.createFields();
    this.build();
    this.bind();
    initWidget(container);
  }

  private void bind() {
  }

  private void build() {
    container = new CssFloatLayoutContainer();
    FieldLabel fl01 = new FieldLabel(keyCurrentPresenterShowed,
                                     "Key der Daten:");
    fl01.setLabelWidth(192);
    container.add(fl01,
                  new CssFloatData(1,
                                   new Margins(6,
                                               12,
                                               6,
                                               12)));
    FieldLabel fl02 = new FieldLabel(tsCreated,
                                     "Zeitpunkt des Erzeugens:");
    fl02.setLabelWidth(192);
    container.add(fl02,
                  new CssFloatData(1,
                                   new Margins(6,
                                               12,
                                               6,
                                               12)));
  }

  private void createFields() {
    keyCurrentPresenterShowed = new TextField();
    keyCurrentPresenterShowed.setEnabled(false);
    tsCreated = new TextField();
    tsCreated.setEnabled(false);
  }

  @Override
  public void releaseResources() {
    // noop
  }

  @Override
  public void edit(String key,
                   MultiPresenterModel model) {
    keyCurrentPresenterShowed.setValue(model.getId());
    tsCreated.setValue(model.getCreated());
  }
}
