package com.chaminda.example.builder;


import com.chaminda.example.entity.Traveller;
import com.chaminda.example.entity.builder.TravellerBuilder;
import com.jayway.restassured.internal.assertion.Assertion;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TravellerBuilderTest {

    @Test
    public void shouldBuildTraveller(){
        //given
        final String firstName = "First";
        final String lastName = "Last";

        //when
        Traveller traveller = new TravellerBuilder().withFirstName(firstName).withLastName(lastName).build();

        //then
        assertThat(firstName).isEqualTo(traveller.getFirstName());
        assertThat(lastName).isEqualTo(traveller.getLastName());
    }
}
