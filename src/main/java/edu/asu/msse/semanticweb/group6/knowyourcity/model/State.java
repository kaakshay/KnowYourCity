package edu.asu.msse.semanticweb.group6.knowyourcity.model;

import java.util.List;

/**
 * @author Akshay Ashwathanarayana
 *
 */

public class State {

	List<City> cities;

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	
	public void addCity(City city){
		this.cities.add(city);
	}
}
