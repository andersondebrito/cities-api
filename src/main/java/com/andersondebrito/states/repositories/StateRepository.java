package com.andersondebrito.states.repositories;

import com.andersondebrito.states.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
