package de.gishmo.mvp4g.example.multipresenter.client.ui.toolbar;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Constants;

public interface ToolbarConstants
  extends Constants {

  ToolbarConstants CONSTANTS = GWT.create(ToolbarConstants.class);

  String buttonLabel();

}
