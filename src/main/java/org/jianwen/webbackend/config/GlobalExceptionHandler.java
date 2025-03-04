package org.jianwen.webbackend.config;

import lombok.Getter;
import lombok.Setter;
import org.jianwen.webbackend.config.exception.AuthException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AuthException.class)
    public ResponseEntity<?> handleAuthenticationException(AuthException exception) {
        var errDetails = new ErrorDetails(exception.getMessage());
        return new ResponseEntity<>(errDetails, HttpStatus.UNAUTHORIZED);
    }

    @Setter
    @Getter
    public static class ErrorDetails {
        // Getters and Setters
        private String message;

        public ErrorDetails(String message) {
            this.message = message;
        }

    }
}
