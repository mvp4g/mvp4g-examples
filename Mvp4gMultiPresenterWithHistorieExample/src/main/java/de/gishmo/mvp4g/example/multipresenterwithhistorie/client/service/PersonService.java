package de.gishmo.mvp4g.example.multipresenterwithhistorie.client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.gishmo.mvp4g.example.multipresenterwithhistorie.shared.dto.Person;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.shared.dto.PersonSearch;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.shared.exception.PersonException;
import de.gishmo.mvp4g.example.multipresenterwithhistorie.shared.exception.PersonNotFoundException;

@RemoteServiceRelativePath("person")
public interface PersonService
  extends RemoteService {

  Person get(long id)
    throws PersonNotFoundException;

  List<Person> getAll();

  List<Person> get(PersonSearch search);

  void insert(Person person)
    throws PersonException;

  void update(Person person)
    throws PersonException;

}
