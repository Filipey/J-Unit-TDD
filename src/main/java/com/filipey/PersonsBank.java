package com.filipey;

import com.filipey.exceptions.EmptyBankException;
import com.filipey.exceptions.NamelessPersonException;
import com.filipey.models.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonsBank {

    private List<Person> persons;

    public PersonsBank() {
        this.persons = new ArrayList<>();
    }

    public List<Person> getPersons() {
        return this.persons;
    }

    public void add(Person person) {

        if (person.getName() == null) {
            throw new NamelessPersonException();
        }

        this.persons.add(person);
    }

    public void remove(Person person) {

        if (this.persons.isEmpty()) {
            throw new EmptyBankException();
        }

        this.persons.remove(person);
    }
}
