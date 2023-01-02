package com.niit.userauthenticationservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED,reason = "Check id or password")

//custom exception for wrong credential entered by customer while login
public class CredentialsException extends Exception{
}
