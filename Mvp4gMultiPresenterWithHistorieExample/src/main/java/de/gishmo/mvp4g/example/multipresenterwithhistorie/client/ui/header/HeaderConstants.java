package de.gishmo.mvp4g.example.multipresenterwithhistorie.client.ui.header;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Constants;

public interface HeaderConstants
  extends Constants {

  HeaderConstants CONSTANTS = GWT.create(HeaderConstants.class);

  String headline();

}
