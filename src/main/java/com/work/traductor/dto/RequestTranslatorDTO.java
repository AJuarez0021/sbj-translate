package com.work.traductor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author linux
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestTranslatorDTO {

    private String source;
    private String target;
    private String q;
    private String format;
    private int alternatives;
    @JsonProperty("api_key")
    private String apiKey;

}
