package com.springrest.springrest.repository;

import com.springrest.springrest.model.Contact_Mech;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Contact_MechRepository extends JpaRepository<Contact_Mech, Integer> {
}
