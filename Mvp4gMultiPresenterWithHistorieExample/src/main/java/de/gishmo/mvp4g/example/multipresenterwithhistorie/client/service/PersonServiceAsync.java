package de.gishmo.mvp4g.example.multipresenterwithhistorie.client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.gishmo.mvp4g.example.multipresenterwithhistorie.shared.dto.Person;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.shared.dto.PersonSearch;

public interface PersonServiceAsync {

  void get(long id,
           AsyncCallback<Person> callback);

  void getAll(AsyncCallback<List<Person>> callback);

  void get(PersonSearch search,
           AsyncCallback<List<Person>> callback);

  void insert(Person person,
              AsyncCallback<Void> callback);

  void update(Person person,
              AsyncCallback<Void> callback);

}
