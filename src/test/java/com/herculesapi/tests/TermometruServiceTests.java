package com.herculesapi.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.herculesapi.model.termometru.TermometruPOJO;
import com.herculesapi.services.termometru.TermometruService;

@SpringBootTest
public class TermometruServiceTests {

    @MockBean
    private TermometruService termometruService;

    private TermometruPOJO testSubject = new TermometruPOJO();

    @Test
    public void getTermometruByName_Test() {
	testSubject.setName("Isus");
	when(termometruService.getTermometruByName("Isus")).thenReturn(testSubject);

	assertEquals(testSubject, termometruService.getTermometruByName("Isus"));
	verify(termometruService).getTermometruByName("Isus");
    }

    @Test
    public void getTermometruByLocation_Test() {
	List<TermometruPOJO> list = new ArrayList<>();
	testSubject.setLocation("Nazaret");
	list.add(testSubject);
	when(termometruService.getTermometruByLocation("Nazaret")).thenReturn(list);

	assertEquals(list, termometruService.getTermometruByLocation("Nazaret"));
	verify(termometruService).getTermometruByLocation("Nazaret");
    }

    @Test
    public void getTermometruById_Test() {
	fail("Needs more research");
    }


}
