package com.filipey;

import com.filipey.exceptions.EmptySaveException;
import com.filipey.exceptions.NamelessPersonException;
import com.filipey.models.Person;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PersonBankTest {

    @Test
    public void shouldCreateThePersonSave() {

        PersonsBank bank = new PersonsBank();

        Assertions.assertThat(bank.getPersons()).isEmpty();

    }

    @Test
    public void shouldAddOnePerson() {

        PersonsBank bank = new PersonsBank();
        Person person = new Person();
        person.setName("John Doe");

        bank.add(person);

        Assertions.assertThat(bank.getPersons()).isNotEmpty().hasSize(1).contains(person);

    }

    @Test(expected = NamelessPersonException.class)
    public void shouldDontSavePersonWithNoName() {

        PersonsBank bank = new PersonsBank();
        Person person = new Person();

        bank.add(person);

    }

    @Test
    public void shouldRemoveOnePerson() {

        PersonsBank bank = new PersonsBank();
        Person person = new Person();
        person.setName("John Doe");
        bank.add(person);

        bank.remove(person);

        Assertions.assertThat(bank.getPersons()).isEmpty();
    }

    @Test(expected = EmptySaveException.class)
    public void shouldThrowErrorWhenTryRemoveOnePersonInEmptyBank() {

        PersonsBank bank = new PersonsBank();
        Person person = new Person();

        bank.remove(person);
    }
}
