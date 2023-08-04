package ru.kao.kaonotebackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity
public class Task {
    @Id
    public String path;

    public String text;

    public Date dateStart = new Date();

    public Date dateEnd;

    public Long priority;

    public Boolean isDone;

    @ManyToOne
    @JoinColumn(name = "acc_ID", nullable = false)
    public Account account;
}
