package com.example.demo.maincontroller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.InvalidInputException;
import com.example.demo.service.impl.StringReverseService;

@RestController
public class StringReverseController implements ErrorController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StringReverseService strRevService;
	private static final String PATH = "/error";

	@RequestMapping(value = "/stringreverse", produces = "application/json")
	public ResponseEntity<String> stringReverse(@RequestParam("str") String str) {
		log.info("String :" + str);
		JSONObject jsonObject = new JSONObject();
		try {
			if (str != null && !"".equalsIgnoreCase(str)) {
				jsonObject.put("reversed String", strRevService.reverse(str));
			} else {
				return new ResponseEntity<String>("Please enter a valid string", HttpStatus.NOT_FOUND);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);

	}

	@RequestMapping(value = "/reversestring/{str}", produces = "application/json")
	public ResponseEntity<String> reversedString(@PathVariable String str) {
		log.info("String :" + str);
		JSONObject jsonObject = new JSONObject();
		try {
			if (str != null && !"".equalsIgnoreCase(str)) {
				jsonObject.put("reversed String", strRevService.getStringReverse(str));
			} else {
				return new ResponseEntity<String>("Please enter a valid string", HttpStatus.NOT_FOUND);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);

	}

	@RequestMapping(value = PATH)
	public String defaultErrorMessage() {
		log.info("Request path not avilable :" + PATH);
		return "Resource not available. Please check the URI ";

	}

	@RequestMapping(value = "/fibseries", produces = "application/json")
	public ResponseEntity<String> fibbonacciSeries(@RequestParam("n") int n) throws InvalidInputException {
		log.info("Request data : " + n);
		JSONObject jsonObject = new JSONObject();
		try {
			if (n == 0 || n == 1) {
				return new ResponseEntity<String>("enter value greater than 1", HttpStatus.OK);
			} else {

				jsonObject.put("number  ", strRevService.getFibSeries(n));
			}
		} catch (Exception exception) {
			throw new InvalidInputException("Input parameter(s) should be in number");
		}
		return new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);

	}

	@RequestMapping(value = "/triangle", produces = "application/json")
	public ResponseEntity<String> TriangleType(@RequestParam("a") double a, @RequestParam("b") double b,
			@RequestParam("c") double c) throws InvalidInputException {
		log.info("Request Paramaters  a = " + a + "b = " + b + " c = " + c);
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("Triangle Type  ", strRevService.getTriangleType(a, b, c));
		} catch (Exception exception) {
			throw new InvalidInputException("Input parameter(s) should be in number");
		}
		return new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);

	}

	@Override
	public String getErrorPath() {

		return PATH;
	}

	@RequestMapping(value = "/singlearray", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> singleArray(@RequestBody HashMap<String, Integer[]> hashMap) throws Exception {
		Collection<Integer[]> collection = hashMap.values();
		Set<Integer> result = strRevService.getSingleArray(collection);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Array", result);
		return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.OK);
	}
}
