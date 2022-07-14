package com.filipey;

import com.filipey.exceptions.EmptyBankException;
import com.filipey.exceptions.NamelessPersonException;
import com.filipey.models.Person;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class PersonBankTest {

    @Test
    @DisplayName("Should create the Persons Bank")
    public void shouldCreateThePersonBank() {

        PersonsBank bank = new PersonsBank();

        Assertions.assertThat(bank.getPersons()).isEmpty();

    }

    @Test
    @DisplayName("Should add one person to the Persons Bank")
    public void shouldAddOnePerson() {

        PersonsBank bank = new PersonsBank();
        Person person = new Person();
        person.setName("John Doe");

        bank.add(person);

        Assertions.assertThat(bank.getPersons()).isNotEmpty().hasSize(1).contains(person);

    }

    @Test
    @DisplayName("Should dont save a person without name")
    public void shouldDontSavePersonWithNoName() {

        final PersonsBank bank = new PersonsBank();
        final Person person = new Person();

        org.junit.jupiter.api.Assertions
                .assertThrows(NamelessPersonException.class, () -> bank.add(person));

    }

    @Test
    @DisplayName("Should remove one person from the Persons Bank")
    public void shouldRemoveOnePerson() {

        PersonsBank bank = new PersonsBank();
        Person person = new Person();
        person.setName("John Doe");
        bank.add(person);

        bank.remove(person);

        Assertions.assertThat(bank.getPersons()).isEmpty();
    }

    @Test
    @DisplayName("Should Throw the EmptyBankException when try to remove a person in a empty Person Bank")
    public void shouldThrowErrorWhenTryRemoveOnePersonInEmptyBank() {

        PersonsBank bank = new PersonsBank();
        Person person = new Person();

        org.junit.jupiter.api.Assertions
                .assertThrows(EmptyBankException.class, () -> bank.remove(person));
    }
}
