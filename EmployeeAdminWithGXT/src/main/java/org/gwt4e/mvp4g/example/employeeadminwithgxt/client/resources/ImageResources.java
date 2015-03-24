package org.gwt4e.mvp4g.example.employeeadminwithgxt.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface ImageResources
    extends ClientBundle {

  ImageResources IMAGES = (ImageResources) GWT.create(ImageResources.class);

  @Source("iconDelete.png")
  ImageResource iconDelete();

  @Source("iconNew.png")
  ImageResource iconNew();

}
