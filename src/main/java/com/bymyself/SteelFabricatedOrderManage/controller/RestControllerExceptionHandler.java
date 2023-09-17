package com.bymyself.SteelFabricatedOrderManage.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RestControllerExceptionHandler {
    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<?> handleRuntimeExcetion(RuntimeException ex){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", "error");
        map.put("error", ex.getMessage());
        return ResponseEntity.ok(map);
    }
}
