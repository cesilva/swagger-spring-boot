package com.chaminda.example.controller;


import com.chaminda.example.dao.TravellerRepository;
import com.chaminda.example.entity.Traveller;
import com.chaminda.example.entity.builder.TravellerBuilder;
import com.jayway.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

public class TravellerControllerIT extends AbstractIntegrationTest {

    @Autowired
    private TravellerRepository travellerRepository;

    private Traveller savedTraveller;

    @Override
    protected void doBeforeEachTest() {
        savedTraveller = travellerRepository.save(getTestTraveller());
    }

    @Override
    protected void doAfterEachTest() {
        travellerRepository.delete(savedTraveller.getId());
    }

    @Test
    public void shouldSuccessfullyCreateNewTraveller() {

        //given:
        Traveller traveller = getTestTraveller();

        //and
        given().
                body(traveller).
                contentType(ContentType.JSON).
        when().
                post("/travellers").
        then().
                statusCode(HttpStatus.SC_CREATED).
                body("firstName", equalTo(traveller.getFirstName())).
                body("lastName", equalTo(traveller.getLastName())).
                body("id", notNullValue());
    }

    private Traveller getTestTraveller(){
       return new TravellerBuilder().withFirstName("FirstName").withFirstName("LastName").build();
    }

    @Test
    public void shouldRetrieveSavedTravellerByTravellerId(){
        given().
                contentType(ContentType.JSON).
        when().
                get("/travellers/" + savedTraveller.getId()).
        then().
                statusCode(HttpStatus.SC_OK).
                body("firstName", equalTo(savedTraveller.getFirstName())).
                body("lastName", equalTo(savedTraveller.getLastName())).
                body("id", equalTo(savedTraveller.getId().intValue()));
    }

    @Test
    public void shouldReturnAllTravellers(){
        given().
                contentType(ContentType.JSON).
        when().
                get("/travellers").
        then().
                statusCode(HttpStatus.SC_OK);

    }

    @Test
    public void shouldDeleteGivenTravellerByTravellerId(){

        // given
        Traveller toBeDeleted = travellerRepository.save(getTestTraveller());

        // and
        given().
                contentType(ContentType.JSON).
        when().
                delete("/travellers/" + toBeDeleted.getId()).
        then().
                statusCode(HttpStatus.SC_OK);


    }


}
