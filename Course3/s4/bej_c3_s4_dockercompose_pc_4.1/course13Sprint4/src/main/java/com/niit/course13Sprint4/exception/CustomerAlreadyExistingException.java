package com.niit.course13Sprint4.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


//mark method exception class with status code and reason(message that should be return)
@ResponseStatus(code = HttpStatus.CONFLICT,reason = "Customer already exist")
public class CustomerAlreadyExistingException extends Exception {
}
