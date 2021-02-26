package com.usk.demo.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AddressDto {
	
	@NotEmpty
	private String houseNumber;
	
	@NotEmpty
	private String addressLine1;
	
	private String addressLine2;
	
	private String landMark;
	
	private String howToReach;

	@NotNull
	@Min(value = 111111)
	@Max(value = 666666)
	private Long pin;

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	public String getHowToReach() {
		return howToReach;
	}

	public void setHowToReach(String howToReach) {
		this.howToReach = howToReach;
	}

	public Long getPin() {
		return pin;
	}

	public void setPin(Long pin) {
		this.pin = pin;
	}
	
}
