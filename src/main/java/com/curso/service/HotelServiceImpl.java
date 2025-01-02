package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.model.Hotel;
import com.curso.repository.HotelRepository;

/**
 * Clase implementadora de la lógica de negocio del micrioservicio Hotel
 * @author Aitor Alejandro Martinez Cedillo \ Viewnext
 * @version 1.0 2024-12-31
 */
@Service
public class HotelServiceImpl implements HotelService {
	@Autowired
	HotelRepository repository;

	@Override
	public List<Hotel> hoteles() {
		return repository.findAll();
	}

	@Override
	public Hotel datosHotel(String nombre) {
		return repository.findFirstByNombre(nombre);
	}
	
}
