package de.gishmo.mvp4g.example.multipresenterwithhistorie.client.ui.person;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Float;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.CssFloatLayoutContainer;
import com.sencha.gxt.widget.core.client.container.CssFloatLayoutContainer.CssFloatData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;

import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.ui.person.IPersonView.Presenter;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.client.utils.ReverseResizeComposite;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.shared.dto.Person;

public class PersonView
  extends ReverseResizeComposite<Presenter>
  implements IPersonView,
             Editor<Person> {

  TextField firstName;
  TextField name;
  @Path("address.street")
  TextField street;
  @Path("address.city")
  TextField city;
  private CssFloatLayoutContainer container;
  private TextButton saveButton;
  private TextButton cancelButton;

  private Driver driver;

  public PersonView() {
    super();
    createView();
  }

  public void createView() {
    // Initialisieren
    this.createButtons();
    this.createFields();
    this.build();
    this.bind();
    initWidget(container);
  }

  private void createButtons() {
    saveButton = new TextButton("Save");
    cancelButton = new TextButton("Cancel");
  }

  private void createFields() {
    firstName = new TextField();
    name = new TextField();
    street = new TextField();
    city = new TextField();
  }

  private void build() {
    container = new CssFloatLayoutContainer();
    FieldLabel fl01 = new FieldLabel(firstName,
                                     "Vorname");
    fl01.setLabelWidth(192);
    container.add(fl01,
                  new CssFloatData(1,
                                   new Margins(6,
                                               12,
                                               6,
                                               12)));
    FieldLabel fl02 = new FieldLabel(name,
                                     "Name");
    fl02.setLabelWidth(192);
    container.add(fl02,
                  new CssFloatData(1,
                                   new Margins(6,
                                               12,
                                               6,
                                               12)));
    FieldLabel fl03 = new FieldLabel(street,
                                     "Strasse");
    fl03.setLabelWidth(192);
    container.add(fl03,
                  new CssFloatData(1,
                                   new Margins(6,
                                               12,
                                               6,
                                               12)));
    FieldLabel fl04 = new FieldLabel(city,
                                     "Ort");
    fl04.setLabelWidth(192);
    container.add(fl04,
                  new CssFloatData(1,
                                   new Margins(6,
                                               12,
                                               6,
                                               12)));

    CssFloatLayoutContainer buttonContainer = new CssFloatLayoutContainer();
    buttonContainer.setStyleFloat(Float.RIGHT);
    container.add(buttonContainer,
                  new CssFloatData(1));
    buttonContainer.add(cancelButton,
                        new CssFloatData(64,
                                         new Margins(10)));
    buttonContainer.add(saveButton,
                        new CssFloatData(64,
                                         new Margins(10)));
  }

  private void bind() {
    saveButton.addSelectHandler(new SelectHandler() {
      @Override
      public void onSelect(SelectEvent selectEvent) {
        getPresenter().doSave(driver.flush());
      }
    });
    cancelButton.addSelectHandler(new SelectHandler() {
      @Override
      public void onSelect(SelectEvent selectEvent) {
        getPresenter().doCancel();
      }
    });
    driver = GWT.create(Driver.class);
    driver.initialize(this);
  }

  @Override
  public void releaseResources() {
    // noop
  }

  @Override
  public void edit(Person model) {
    driver.edit(model);
  }

  interface Driver
    extends SimpleBeanEditorDriver<Person, PersonView> {
  }
}
