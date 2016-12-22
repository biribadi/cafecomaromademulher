package br.com.entelgy.controllers;

//import static org.springframework.test.web.client.match.MockRestRequestMatchers;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;



import br.com.entelgy.services.IngridientService;
import br.com.entelgy.services.SnackService;



@RunWith(SpringRunner.class)
@RestClientTest({ SnackService.class, IngridientService.class })
public class SnackControllerTest {

	private SnackService snackService;

	private IngridientService IngridientService;
	
	
	

//	@Autowired
//	private MockRestServiceServer server;
//	
//	@org.junit.Test
//    public void getVehicleDetailsWhenResultIsSuccessShouldReturnDetails()
//            throws Exception {
//		MockRestRequestMatchers
//        this.server.expect(requestTo("/greet/details"))
//                .andRespond(withSuccess("hello", MediaType.TEXT_PLAIN));
//        String greeting = this.service.callRestService();
//        assertThat(greeting).isEqualTo("hello");
//    }

}
