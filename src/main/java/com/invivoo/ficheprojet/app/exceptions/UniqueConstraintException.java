package com.invivoo.ficheprojet.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "UNIQUE_CONSTRAINT_VIOLATION_STATUS")
public class UniqueConstraintException extends RuntimeException {

}
