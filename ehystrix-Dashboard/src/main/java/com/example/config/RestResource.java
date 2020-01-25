package com.example.config;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
@RequestMapping("/rest")
public class RestResource
{
	
	@HystrixCommand(fallbackMethod = "fallback",commandKey ="hello",groupKey = "hello")
	@GetMapping("/hello")
	public String hello()
	{
		if(RandomUtils.nextBoolean())
		{
			throw new RuntimeException("failed :) ");
		}
		return "hello sandhya";
	}
	
	public String fallback()
	{
		return "fall back here: ";
	}

}
