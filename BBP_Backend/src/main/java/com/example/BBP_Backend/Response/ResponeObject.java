package com.example.BBP_Backend.Response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponeObject {

    private String status;
    private String message;
    private Object data;

}
