package com.mangosteen.app.exception;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // DRY: DON'T REPEAT YOURSELF
    @ExceptionHandler(ServiceException.class)
    ResponseEntity<ErrorResponse> handleInvalidParameterException(ServiceException ex) {
        return ResponseEntity.status(ex.getStatusCode())
                             .contentType(MediaType.APPLICATION_JSON)
                             .body(ErrorResponse.builder()
                                                .statusCode(ex.getStatusCode())
                                                .errorCode(ex.getErrorCode())
                                                .message(ex.getMessage())
                                                .errorType(ex.getErrorType())
                                                .build());
    }

    //    @ExceptionHandler(ResourceNotFoundException.class)
    //    ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
    //        return ResponseEntity.status(HttpStatus.NOT_FOUND)
    //                             .body(ErrorResponse.builder()
    //                                                .statusCode(HttpStatus.NOT_FOUND.value())
    //                                                .errorCode(BizErrorCode.NOT_FOUND)
    //                                                .message("There is no user")
    //                                                .errorType(ServiceException.ErrorType.Client)
    //                                                .build());
    //    }
}
