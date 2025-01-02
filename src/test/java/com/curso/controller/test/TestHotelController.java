package com.curso.controller.test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
		Hotel hotel = new Hotel (1, "hotelBonito", "Playa", 99.99d, true);
		when(service.findById(1)).thenReturn(hotel);
		when(service.hoteles()).thenReturn(Arrays.asList(hotel));
	}
	@Test
	void testGetHotel() throws Exception{
		mockMvc.perform(get("/api/hoteles"))
			.andExpect(status().isOk());
	}
}
