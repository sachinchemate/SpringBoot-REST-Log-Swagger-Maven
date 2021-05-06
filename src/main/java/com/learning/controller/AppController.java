package com.learning.controller;
/**
 * 
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learning.model.Person;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author SACHIN
 *
 */
@RestController
@RequestMapping("/api")
@Api(value = "Rest controller for this app", description = "REST APIs related to this application!!!!")
public class AppController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(AppController.class);
			
	@Value("${app.welcomeMessage}")
	private String welcomeMsg;
	
	
	@GetMapping(path="/access", produces = "application/json")
	 public String getAccess(){
	    //String welcomeMsg = "Welcome to SpringBoot and REST API demo"; 
		return welcomeMsg;
	   }
	
	
	 @GetMapping("/")
	 public String index() {
		return "Greetings!!!!";
	 }
	 
	 @ApiOperation(value = "Welcome message for given name",notes = "Also returns welcome message")
	 @GetMapping(path="/welcome/{name}")
	 public String nameByPathVariable(@PathVariable String name) {
		 return "Welcome " + name;
	 }

	 @RequestMapping(value="/hello", method = RequestMethod.GET)
	 public String nameByRequestParam(@RequestParam String name) {
		 LOGGER.info("Given name: "+name);
		 return "Hello " + name;
	 }
	 
	 @ApiOperation(value = "Get contact details ", response = String.class, tags = "getContact")
	 @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Suceess|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"), 
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	 @PostMapping(value="/contact")
	 public String objectByReqBody(@RequestBody Person person) {
		 return String.format("Full name: %s %s", person.getFirstName(), person.getLastName());
	 }
	 
	 
}
