package com.jb.flightmanagement;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jb.flightmanagement.models.flights.CreateFlightRequest;
import com.jb.flightmanagement.models.flights.Flight;
import com.jb.flightmanagement.services.FlightService;


@AutoConfigureMockMvc
@SpringBootTest
class FlightmanagementApplicationTests {

	@Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private FlightService flightService;

	@Test
	void contextLoads() {
	}

	@Test
    void CreateFlight_Ok() throws Exception {

        Flight mock = new Flight(1L, "EWR", "LAX", "JB-789", "2025-03-15T10:00:00Z","2025-03-15T10:00:00Z",100, "Scheduled");

        when(flightService.createFlight(any(Flight.class))).thenReturn(mock);

        CreateFlightRequest request = new CreateFlightRequest(mock);

		ObjectMapper objectMapper = new ObjectMapper();
    	String jsonRequest = objectMapper.writeValueAsString(request);

		mockMvc.perform(post("/api/flights")
				.contentType("application/json")
				.content(jsonRequest))
				.andExpect(status().isOk());
    }

	@Test
    void CreateFlight_NullError() throws Exception {

        Flight mock = new Flight();

        when(flightService.createFlight(any(Flight.class))).thenReturn(mock);

        CreateFlightRequest request = new CreateFlightRequest(null);

		ObjectMapper objectMapper = new ObjectMapper();
    	String jsonRequest = objectMapper.writeValueAsString(request);

		mockMvc.perform(post("/api/flights")
				.contentType("application/json")
				.content(jsonRequest))
				.andExpect(status().is5xxServerError());
    }
}
