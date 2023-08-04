package ru.kao.kaonotebackend.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Account {
    public Account() {
    }

    public Account(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Account(String email, String firstName, String lastName, List<Note> notes, List<Task> tasks) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.notes = notes;
        this.tasks = tasks;
    }

    @Id
    @SequenceGenerator(name = "ACCOUNT_SEQ", allocationSize = 10)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ACCOUNT_SEQ")
    public Long id;

    public String email;

    public String firstName;

    public String lastName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    public List<Note> notes = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    public List<Task> tasks = new ArrayList<>();

}
