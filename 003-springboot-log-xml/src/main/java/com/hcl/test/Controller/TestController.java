package com.hcl.test.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping(value = "/test")
	public String exeTest() {
		String str = null;
		int length = str.length();
		return "Success";
	}

}
