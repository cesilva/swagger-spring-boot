package com.chaminda.example.entity.builder;


import com.chaminda.example.entity.Traveller;

public class TravellerBuilder {

    private String firstName;

    private String lastName;

    public TravellerBuilder withFirstName(String first) {
        this.firstName = first;
        return this;
    }

    public TravellerBuilder withLastName(String last) {
        this.lastName = last;
        return this;
    }

    public Traveller build() {
        Traveller traveller = new Traveller();
        traveller.setFirstName(firstName);
        traveller.setLastName(lastName);
        return traveller;
    }
}
