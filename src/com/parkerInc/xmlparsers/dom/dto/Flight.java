package com.parkerInc.xmlparsers.dom.dto;

public class Flight {
	private int flightNumber;
	private String operatingAirLines;
	private String arrivalCity;
	private String dateOfJourney;
	private String estimatedDepartureTime;

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getOperatingAirLines() {
		return operatingAirLines;
	}

	public void setOperatingAirLines(String operatingAirLines) {
		this.operatingAirLines = operatingAirLines;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public String getDateOfJourney() {
		return dateOfJourney;
	}

	public void setDateOfJourney(String dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}

	public String getEstimatedDepartureTime() {
		return estimatedDepartureTime;
	}

	public void setEstimatedDepartureTime(String estimatedDepartureTime) {
		this.estimatedDepartureTime = estimatedDepartureTime;
	}

}
