package com.aerobase.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Aeronave não encontrada")
public class AeronaveNotFoundException extends RuntimeException {
}
