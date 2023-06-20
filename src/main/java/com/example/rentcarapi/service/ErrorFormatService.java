package com.example.rentcarapi.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ErrorFormatService {
    public Map<String, Object> ErrorFormatExceptionHandle(BindingResult bindingResult) {
        List<ObjectError> errors = bindingResult.getAllErrors();
         Map<String, Object> map = new HashMap<String, Object>();
        List<FieldError> fieldErrors = errors.stream()
                .filter(FieldError.class::isInstance)
                .map(FieldError.class::cast)
                .collect(Collectors.toList());

        List<String> errorMessages = fieldErrors.stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                .collect(Collectors.toList());

        map.put("message", "Validation Failed");
        map.put("data", errorMessages);
        return  map;
    }
}
