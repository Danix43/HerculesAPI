package com.herculesapi.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.herculesapi.model.termometru.Termometru;

@SpringBootTest
@AutoConfigureMockMvc
public class IoTControllerTests {

    @Autowired
    private MockMvc mvc;

    private Termometru termometruTest1, termometruTest2;

    @BeforeEach
    public void setup() {
	termometruTest1 = new Termometru();
	termometruTest1.setTermometruId(1);
	termometruTest1.setName("Test1");
	termometruTest1.setLocation("test1");
	termometruTest1.setFirstInsert(Timestamp.valueOf("2020-03-16 12:58:28.000"));
	termometruTest1.setLastInsert(Timestamp.valueOf("2020-03-16 12:58:28.000"));
	termometruTest1.setTemperatureInCelsius(10.00);
	termometruTest1.setHeatIndexCelsius(10.00);
	termometruTest1.setTemperatureInKelvin(12.00);
	termometruTest1.setHeatIndexKelvin(12.00);
	termometruTest1.setTemperatureInFahrenheit(13.00);
	termometruTest1.setHeatIndexFahrenheit(13.00);
	termometruTest1.setHumidity(14.00);

	termometruTest2 = new Termometru();
	termometruTest2.setTermometruId(2);
	termometruTest2.setName("Test2");
	termometruTest2.setLocation("test2");
	termometruTest2.setFirstInsert(Timestamp.valueOf("2020-03-16 12:58:28.000"));
	termometruTest2.setLastInsert(Timestamp.valueOf("2020-03-16 12:58:28.000"));
	termometruTest2.setTemperatureInCelsius(15.00);
	termometruTest2.setHeatIndexCelsius(15.00);
	termometruTest2.setTemperatureInKelvin(16.00);
	termometruTest2.setHeatIndexKelvin(16.00);
	termometruTest2.setTemperatureInFahrenheit(17.00);
	termometruTest2.setHeatIndexFahrenheit(17.00);
	termometruTest2.setHumidity(18.00);
    }

    @Test
    public void getAll_Test() throws Exception {
	List<Termometru> termometreAll = new ArrayList<>();
	termometreAll.add(termometruTest1);
	termometreAll.add(termometruTest2);

	mvc.perform(get("/termometre/all").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andExpect(jsonPath("$.[0].name", is(termometruTest1.getName())))
		.andExpect(jsonPath("$.[1].name", is(termometruTest2.getName())));
    }

    @Test
    public void getTermometruByName() throws Exception {
	mvc.perform(get("/termometru?name=Test1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
		.andExpect(jsonPath("$.name", is(termometruTest1.getName())));
    }

    @Test
    public void getTermometruById() throws Exception {
	mvc.perform(get("/termometru/1/status").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
		.andExpect(jsonPath("$.name", is(termometruTest1.getName())));
    }

    @Test
    public void deleteTermometru() throws Exception {
	mvc.perform(delete("/termometru/2/delete").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isAccepted());
    }

    @Test
    public void updateTermometru() throws Exception {
	Termometru terTest = new Termometru();
	terTest.setName("IsusDinNazaret");
	mvc.perform(post("/termometru/1/update").contentType(MediaType.APPLICATION_JSON).content(asJsonString(terTest)))
		.andExpect(status().isOk()).andExpect(jsonPath("$.name", is(terTest.getName())));
    }

    private static String asJsonString(final Object obj) {
	try {
	    return new ObjectMapper().writeValueAsString(obj);
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }


}
