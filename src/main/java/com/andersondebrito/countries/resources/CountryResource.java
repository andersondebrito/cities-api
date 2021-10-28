package com.andersondebrito.countries.resources;

import com.andersondebrito.countries.entities.Country;
import com.andersondebrito.countries.repositories.CountryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryResource {

    private final CountryRepository repository;

    public CountryResource(final CountryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<Country> countries(final Pageable page) {
     return repository.findAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountry(@PathVariable("id") Long id){
        Optional<Country> optionalCountry = repository.findById(id);
        return optionalCountry.isPresent()
                ? ResponseEntity.ok().body(optionalCountry.get())
                : ResponseEntity.notFound().build();
    }
}
