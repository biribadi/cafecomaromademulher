package br.com.entelgy.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.entelgy.dtos.IngridientDto;
import br.com.entelgy.dtos.SnackDto;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class SnackControllerTest {
	
	@Autowired
	private RestTemplateBuilder restTemplate;
	
	@Autowired
    private MockMvc mvc;

    @MockBean
    private SnackDto userVehicleService;
	
	@Autowired
    private JacksonTester<IngridientDto> json;
	
	@Test
	public void test(){
		
		
		restTemplate.
		
	}

}
