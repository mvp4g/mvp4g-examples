package de.gishmo.mvp4g.example.multipresenterwithhistorie.shared.exception;

import com.google.gwt.user.client.rpc.IsSerializable;

@SuppressWarnings("serial")
public class PersonNotFoundException
  extends Exception
  implements IsSerializable {

  /* for serialization only */
  @SuppressWarnings("unused")
  private PersonNotFoundException() {
  }
  
  public PersonNotFoundException(String message) {
    super(message);
  }
}
