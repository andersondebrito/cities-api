package com.andersondebrito.countries.repositories;

import com.andersondebrito.countries.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
