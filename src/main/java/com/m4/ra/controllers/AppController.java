package com.m4.ra.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppController {

	@RequestMapping("/app")
	public String showExecutionSystemHome() {
		System.out.println(">> Application's main page.");
		return "app";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public @ResponseBody
	Map<String, String> testMe() {

		System.out.println(">> Test Me");
		Map<String, String> test = new HashMap<String, String>();
		for (int i = 0; i < 5; i ++) {
			test.put("key - " + i, "value - " + i);
		}

		return test;
	}

}
