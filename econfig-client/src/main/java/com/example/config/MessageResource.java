package com.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/rest")
public class MessageResource
{
	@Value("${msg : Default hello}")
	private String msg;
	
	@GetMapping("/msg")
	public String msg()
	{
		return msg;
		
	}

}
