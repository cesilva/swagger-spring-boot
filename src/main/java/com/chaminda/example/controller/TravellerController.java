package com.chaminda.example.controller;

import com.chaminda.example.dao.TravellerRepository;
import com.chaminda.example.entity.Traveller;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/travellers")
public class TravellerController {

    @Autowired
    private TravellerRepository travellerRepository;


    @ApiOperation(value="Creates Traveller",notes="Requires traveller's first name and last name")
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Traveller saveTraveller(@RequestBody Traveller traveller) {

        return travellerRepository.save(traveller);

    }

    @ApiOperation(value="Get Traveller by traveller id",notes="Returns a traveller for the given traveller id")
    @RequestMapping(value = "/{travellerId}",  method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Traveller getTravellerById(@PathVariable("travellerId") Long travellerId){
        return travellerRepository.findOne(travellerId);
    }

    @ApiOperation(value="Get all travellers",notes="Returns a list of travellers")
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Traveller> getAllTravellers(){
        return travellerRepository.findAll();
    }

    @ApiOperation(value="Delete traveller by traveller id",notes="Delete traveller by traveller id")
    @RequestMapping(value = "/{travellerId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteTraveller(@PathVariable("travellerId") Long travellerId ){
        travellerRepository.delete(travellerId);
    }

}
