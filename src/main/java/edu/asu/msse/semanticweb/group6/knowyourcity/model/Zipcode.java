package edu.asu.msse.semanticweb.group6.knowyourcity.model;

/**
 * @author Akshay Ashwathanarayana
 *
 */

public class Zipcode {
	private int zipcode;
	private double crimeRisk;
	private double earthquakeRisk;
	private double airPollutionIndex;
	private double medianTime;
	
	public double getMedianTime() {
		return medianTime;
	}

	public void setMedianTime(double medianTime) {
		this.medianTime = medianTime;
	}

	public double getCrimeRisk() {
		return crimeRisk;
	}

	public void setCrimeRisk(double crimeRisk) {
		this.crimeRisk = crimeRisk;
	}

	public double getEarthquakeRisk() {
		return earthquakeRisk;
	}

	public void setEarthquakeRisk(double earthquakeRisk) {
		this.earthquakeRisk = earthquakeRisk;
	}

	public double getAirPollutionIndex() {
		return airPollutionIndex;
	}

	public void setAirPollutionIndex(double airPollutionIndex) {
		this.airPollutionIndex = airPollutionIndex;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

}
