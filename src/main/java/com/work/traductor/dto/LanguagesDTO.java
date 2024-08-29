package com.work.traductor.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 *
 * @author linux
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LanguagesDTO implements java.io.Serializable{

    private String code;
    private String description;

}
