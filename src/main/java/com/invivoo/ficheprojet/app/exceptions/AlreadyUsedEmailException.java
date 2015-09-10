package com.invivoo.ficheprojet.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "ALREADY_USED_EMAIL_STATUS")
public class AlreadyUsedEmailException extends RuntimeException {

}
