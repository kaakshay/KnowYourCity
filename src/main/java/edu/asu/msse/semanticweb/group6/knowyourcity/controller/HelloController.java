package edu.asu.msse.semanticweb.group6.knowyourcity.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.asu.msse.semanticweb.group6.knowyourcity.sparql.SparqlQueryEngine;


/**
 * @author Akshay Ashwathanarayana
 *
 */

@Controller
public class HelloController {

	String message = "Welcome to Spring MVC!";

	@RequestMapping("/hello")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		System.out.println("in controller");

		ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("message", message);
		mv.addObject("name", name);
		return mv;
	}

	@RequestMapping(value = "/getCities", method=RequestMethod.POST)
	@ResponseBody
	public String getCities(HttpServletResponse response, @RequestParam String state) {
		String response2 = "{val1 : 'option1', val2 : 'option2'}"; 
		return response2;
	}


	@RequestMapping(value = "/states", method = RequestMethod.GET)
	public @ResponseBody
	Set<String> findAllStates() {
		Set<String> set = new HashSet<String>();
		System.out.println("Here");
		SparqlQueryEngine engine = SparqlQueryEngine.getInstance();
		set = engine.runGetStatesQuery();
		return set;
	}


	@RequestMapping(value = "/cities", method = RequestMethod.GET)
	public @ResponseBody
	Collection<String> citiesForState(
			@RequestParam(value = "stateName", required = true) String state) {
		Set<String> set = new HashSet<String>();
		SparqlQueryEngine engine = SparqlQueryEngine.getInstance();
		Map<String, String> cities = engine.runGetCitiesForStateQuery(state);
		return cities.values();
	}
	
	@RequestMapping(value = "/getZipcodes", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, Object> getZipcodes(
			@RequestParam(value = "stateName", required = true) String state,
			@RequestParam(value = "cityName", required = true) String city) {
		System.out.println(state);
		System.out.println(city);
		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put("stateName", state);
		responseMap.put("cityName", city);
		return responseMap;
	}
}
