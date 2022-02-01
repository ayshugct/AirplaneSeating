package au.com.woolworths.application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import au.com.woolworths.application.business.AirplaneSeatingBusiness;
import au.com.woolworths.application.models.Request;
import au.com.woolworths.application.models.Response;

@RestController
@CrossOrigin
@RequestMapping("/airplaneSeating")
public class AirplaneSeatingController {

	@Autowired
	AirplaneSeatingBusiness airplaneSeatingBusiness;

	@PostMapping(value = "/allocatePassenger")
	public ResponseEntity<Response> allocatePassenger(@RequestBody Request request) throws Exception {

		Response response = new Response();
		try {
			int[][] array = request.getArrayInputSize();
			response = airplaneSeatingBusiness.getPassengerSeatDetails(array, request.getQueueSize());
		}
		catch(Exception e) {
			List<String> msg = new ArrayList<String>();
			msg.add("Error in the request input, Kindly provide valid request input to process the Seat allocation");
			response.setErrorMessage(msg);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
