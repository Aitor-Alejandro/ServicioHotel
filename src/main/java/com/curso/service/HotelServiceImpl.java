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
	/**
	 * @return listHotel la lista de todos los hoteles existentes
	 */
	@Override
	public List<Hotel> hoteles() {
		List<Hotel> listHotel = repository.findAll();
		return listHotel;
	}
	/**
	 * @param nombre Parametro de busqueda, el nombre del hotel 
	 * @return hotel El primer hotel que coincida en nombre con el parametro de busqueda
	 */
	@Override
	public Hotel datosHotel(String nombre) {
		Hotel hotel = repository.findFirstByNombre(nombre);
		return hotel;
	}

	/**
	 * @param id Identificador unico del hotel
	 * @return hotel Hotel con el id determinado, null si no existe
	 */
	@Override
	public Hotel findById(long id) {
		Hotel hotel = repository.findById(id).orElse(null);
		return hotel;
	}
	
}
