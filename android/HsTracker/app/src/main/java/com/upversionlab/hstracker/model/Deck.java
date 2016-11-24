package com.upversionlab.hstracker.model;

import java.io.Serializable;

/**
 * Created by rborcat on 11/24/2016.
 */

public class Deck implements Serializable {
    private Integer id;
    private String deckName;
    private String deckClass;

    public Deck(Integer id, String deckName, String deckClass) {
        this.id = id;
        this.deckName = deckName;
        this.deckClass = deckClass;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    public String getDeckClass() {
        return deckClass;
    }

    public void setDeckClass(String deckClass) {
        this.deckClass = deckClass;
    }

    @Override
    public String toString() {
        return "{Deck Id: " + getId() + "," +
                "Deck Name: " + getDeckName() + "," +
                "Deck Class: " + getDeckClass() + "}";
    }
}
