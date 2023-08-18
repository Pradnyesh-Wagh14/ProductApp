package com.igc.productapp.responses;

import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class Response {

    private String message;
    private HttpStatus statuscode;
    private Object object;

    public Response(String message) {
        this.message = message;
    }

    public Response(String message,HttpStatus statuscode) {
        this.message = message;
        this.statuscode = statuscode;
    }

    public Response(String message,HttpStatus statuscode,Object object) {
        this.message = message;
        this.statuscode = statuscode;
        this.object = object;
    }

}
