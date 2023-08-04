package ru.kao.kaonotebackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Note {
    @Id
    public String path;

    public String text;

    @ManyToOne
    @JoinColumn(name = "acc_ID", nullable = false)
    public Account account;
}
