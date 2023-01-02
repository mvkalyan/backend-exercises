package com.niit.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "product already exists")
public class ProductAlreadyExistsException extends Exception{
}
