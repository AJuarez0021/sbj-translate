/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.work.traductor.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author linux
 */
@Setter
@Getter
public class ResponseTranslatorDTO {

    private String translatedText;
    private List<String> alternatives;

    public ResponseTranslatorDTO() {
        this.translatedText = "";
        this.alternatives = new ArrayList<>();
    }

    public ResponseTranslatorDTO(String translatedText) {
        this.translatedText = translatedText;
        this.alternatives = new ArrayList<>();
    }

}
