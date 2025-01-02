package com.curso.controller.test;

import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.curso.model.Hotel;
import com.curso.service.HotelService;

@SpringBootTest
@AutoConfigureMockMvc
class TestHotelController {
	@MockitoBean
	private HotelService service;
	@Autowired
	private MockMvc mockMvc;
	
	@BeforeEach
	void setUp() {
		Hotel hotel = new Hotel ();
		when(service.findById(1)).thenReturn(hotel);
		when(service.hoteles()).thenReturn(Arrays.asList(hotel));
	}

}
