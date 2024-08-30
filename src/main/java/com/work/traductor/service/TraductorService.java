package com.work.traductor.service;

import com.work.traductor.dto.LanguagesDTO;
import com.work.traductor.dto.ResponseTranslatorDTO;
import java.util.List;

/**
 *
 * @author linux
 */
public interface TraductorService {

    List<LanguagesDTO> getLanguages();
    
    LanguagesDTO getLanguage(String code);

    ResponseTranslatorDTO translate(LanguagesDTO from, LanguagesDTO to, String text);

    ResponseTranslatorDTO translate(LanguagesDTO to, String text);
}
