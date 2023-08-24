package com.igc.productapp.exception;

import com.igc.productapp.responses.Response;
import com.igc.productapp.util.Constants;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /***
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<?> productNotFoundEx(ProductNotFoundException ex) {

        return new ResponseEntity<>(new Response(Constants.PRODUCT_ID_NOT_FOUND, HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);

    }
/*
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodeArgumentEx(MethodArgumentNotValidException ex) {
        return new ResponseEntity<>(new Response("Error in Input Data",HttpStatus.BAD_REQUEST),HttpStatus.BAD_REQUEST);
    }
*/
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return new ResponseEntity<>(new Response(Constants.USER_INPUT_NOT_VALID,HttpStatus.BAD_REQUEST,ex.getDetailMessageArguments()),HttpStatus.BAD_REQUEST);
    }
}
