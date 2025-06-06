package com.think.vendor_demo.response;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class VendorResponseHandler {

    public static ResponseEntity<Object> responseBuilder(
        String message, HttpStatus httpStatus, Object responseObject
    )
    {
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("httpStatus", httpStatus);
        response.put("data", responseObject);

        return new ResponseEntity<>(response, httpStatus);
    }

}
