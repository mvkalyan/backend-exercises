package com.stackroute.muzixservice.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Track Not Found")
public class TrackNotFoundException extends Exception {

}
