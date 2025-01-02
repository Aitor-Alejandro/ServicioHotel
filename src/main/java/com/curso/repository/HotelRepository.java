package com.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
	Hotel findFirstByNombre(String nombre);
}
