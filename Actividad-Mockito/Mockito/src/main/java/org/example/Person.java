package org.example;

import java.time.LocalDate;

public class Person {
    private final Integer id;
    private final String firts;
    private final String last;
    private final LocalDate dob;

    public Person(Integer id, String firts, String last, LocalDate dob) {
        this.id = id;
        this.firts = firts;
        this.last = last;
        this.dob = dob;
    }

    public Integer getId() {
        return id;
    }

    public String getFirts() {
        return firts;
    }

    public String getLast() {
        return last;
    }

    public LocalDate getDob() {
        return dob;
    }


}
