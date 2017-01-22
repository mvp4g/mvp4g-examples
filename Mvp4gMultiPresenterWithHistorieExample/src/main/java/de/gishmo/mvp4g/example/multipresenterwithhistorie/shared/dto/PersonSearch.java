package de.gishmo.mvp4g.example.multipresenterwithhistorie.shared.dto;

import com.google.gwt.user.client.rpc.IsSerializable;

public class PersonSearch
  implements IsSerializable {
  
  private String name;
  private String city;
  
  public PersonSearch() {
    super();
  }

  public PersonSearch(String name, String city) {
    super();
    this.name = name;
    this.city = city;
  }

  public String getName() {
    return name;
  }

  public String getCity() {
    return city;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCity(String city) {
    this.city = city;
  }
}
