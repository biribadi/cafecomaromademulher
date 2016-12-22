package br.com.entelgy.controllers;

import javax.servlet.ServletContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.web.client.RestTemplate;

import br.com.entelgy.dtos.IngridientDto;
import br.com.entelgy.dtos.SnackDto;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class SnackControllerTestComCOisa {
	
	@Autowired
	private RestTemplateBuilder restTemplate;
	
	@Autowired
    private MockMvc mvc;

    @MockBean
    private SnackDto userVehicleService;
    
    @Autowired
    private RequestBuilder requestBuilder;
	
	@Autowired
    private JacksonTester<IngridientDto> json;
	
	TestRestTemplate testRestTemplate;
	
public void test(){
    
    //	mvc.perform(requestBuilder.buildRequest())
    }


//    @Test
//    public void getUserList() throws Exception {
//        mockMvc.perform(get("/user"))
//            .andExpect(status().isOk())
//            .andExpect(content().contentType("application/json;charset=UTF-8")) 
//            .andExpect(content().encoding("UTF-8"))
//            .andExpect(jsonPath("$", hasSize(8)))
//            .andExpect(jsonPath("$[0].id").exists())
//            .andExpect(jsonPath("$[0].alias").exists())
//            .andExpect(jsonPath("$[0].name").exists())
//        );
//    }

}
