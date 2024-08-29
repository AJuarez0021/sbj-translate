package com.work.traductor.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author linux
 */
@Setter
@Getter
public class RequestDTO implements java.io.Serializable {

    private LanguagesDTO from;
    private LanguagesDTO to;
    private String text;
}
