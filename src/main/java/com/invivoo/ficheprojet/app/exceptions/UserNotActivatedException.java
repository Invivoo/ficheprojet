package com.invivoo.ficheprojet.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "USER_NOT_ACTIVATED_STATUS")
public class UserNotActivatedException extends RuntimeException {

}
