package com.greenfox.backendapiexercises.requestFilters;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class ArraysRequestFilter
{
	@NotNull
	private String what;

	@NotNull
	private int[] numbers;

}
