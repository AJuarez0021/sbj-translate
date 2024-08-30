package com.work.traductor.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO implements java.io.Serializable {

    private Integer statusCode;
    private String error;
}
