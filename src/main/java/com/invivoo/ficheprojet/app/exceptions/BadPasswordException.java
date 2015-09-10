package com.invivoo.ficheprojet.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "INCORRECT_PASSWORD_STATUS")
public class BadPasswordException extends RuntimeException {

}
