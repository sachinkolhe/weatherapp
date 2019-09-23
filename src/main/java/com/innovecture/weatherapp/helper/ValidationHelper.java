package com.innovecture.weatherapp.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.innovecture.weatherapp.exception.ValidationException;

public class ValidationHelper {

	public static void validateZipCode(String zipCode) {

		String regex = "^[0-9]{5}(?:-[0-9]{4})?$";

		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(zipCode);

		if (matcher.matches()) {
			return;
		}

		throw new ValidationException("Zipcode is wrong.");
	}

}
