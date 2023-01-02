package com.niit.userauthenticationservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "Already registered")

//custom exception for same credential entered by customer while register
public class RegisteredException extends Exception {
}
