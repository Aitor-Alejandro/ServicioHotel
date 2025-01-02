package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.curso.model.Hotel;
import com.curso.service.HotelService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Clase controladora de la api rest del microservicio Hotel
 * @author Aitor Alejandro Martinez Cedillo \ Viewnext
 * @version 1.0 2024-12-31
 */
@Tag(name = "Servicio de hoteles", description = "API para las operaciones con el servicio de hoteles")
@RestController
@RequestMapping(value="/api/hoteles")
public class HotelController {
	@Autowired
	HotelService service;
	@Autowired
	RestTemplate template;
	@Operation(summary = "Obtencion de hoteles", description = "Devuelve todos los hoteles existentes en la base de datos", responses = {
			@ApiResponse(responseCode = "200", description = "Se devuelven todos los hoteles")
	})
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Hotel>> hoteles(){
		return new ResponseEntity<>(service.hoteles(), HttpStatus.OK);
	}
	
	@GetMapping(value="/{nombre}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Hotel> dataHotel(@PathVariable String nombre) {
		Hotel hotel = service.datosHotel(nombre);
		HttpStatus responseStatus = hotel != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(hotel, responseStatus);
	}
}
