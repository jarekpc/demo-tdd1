package com.example.demotdd1.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class CarNotFoundException extends RuntimeException {
}
