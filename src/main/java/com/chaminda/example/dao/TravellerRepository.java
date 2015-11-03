package com.chaminda.example.dao;

import com.chaminda.example.entity.Traveller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravellerRepository extends JpaRepository<Traveller, Long> {

    Traveller findByFirstName(String firstName);

}
