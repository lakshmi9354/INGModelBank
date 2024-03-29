package com.ing.modelbank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.modelbank.dto.LoginDto;
import com.ing.modelbank.dto.LoginResponseDto;
import com.ing.modelbank.service.LoginService;

@RestController
@CrossOrigin(allowedHeaders = {"*","/"},origins ={"*","/"})
@RequestMapping("/api")
public class LoginController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	LoginService loginService;
	
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto loginDto)
	{
		LOGGER.info("inside modelbank");
		LoginResponseDto loginResponseDto=loginService.login(loginDto);
		return new ResponseEntity<>(loginResponseDto,HttpStatus.OK);
	}
		
	 
	

}
