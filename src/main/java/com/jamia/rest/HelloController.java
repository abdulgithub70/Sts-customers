/**
 * 
 */
package com.jamia.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DELL
 *
 */

@RestController

public class HelloController {
	@GetMapping("get")
	public String helloService()
	{
		return "this is my spring rest service";
	}

}
