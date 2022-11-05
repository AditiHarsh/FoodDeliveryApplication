package com.example.Restaurant.ExceptionHandler;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class CustomerAlreadyPresent extends Exception {
	String message;
}
