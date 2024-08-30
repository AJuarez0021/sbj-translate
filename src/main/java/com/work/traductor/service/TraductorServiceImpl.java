package com.work.traductor.service;

import com.work.traductor.client.TranslateFeign;
import com.work.traductor.dto.ErrorDTO;
import com.work.traductor.dto.LanguagesDTO;
import com.work.traductor.dto.RequestTranslatorDTO;
import com.work.traductor.dto.ResponseTranslatorDTO;
import com.work.traductor.exception.ServiceException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 *
 * @author linux
 */
@Service
@Slf4j
public class TraductorServiceImpl implements TraductorService {

    @Autowired
    private TranslateFeign client;

    @Override
    public List<LanguagesDTO> getLanguages() {
        Languages[] langs = Languages.values();
        List<LanguagesDTO> list = new ArrayList<>();
        for (Languages lang : langs) {
            list.add(new LanguagesDTO(lang.getCode(), lang.toString()));
        }
        return list;
    }

    @Override
    public LanguagesDTO getLanguage(String code) {
        List<LanguagesDTO> languages = getLanguages();
        validateCode(languages, code);
        return findLanguage(languages, code).get();
    }

    @Override
    public ResponseTranslatorDTO translate(LanguagesDTO from, LanguagesDTO to, String text) {
        List<LanguagesDTO> languages = getLanguages();
        validateCode(languages, from.getCode());
        validateCode(languages, to.getCode());

        if (to.getCode().equals(Languages.NONE.getCode()) || from.getCode().equals(to.getCode())) {
            return new ResponseTranslatorDTO(text);
        }

        RequestTranslatorDTO req = new RequestTranslatorDTO();
        req.setAlternatives(3);
        req.setFormat("text");
        req.setSource(from.getCode());
        req.setTarget(to.getCode());
        req.setQ(text);
        req.setApiKey("");
        return client.translate(req);
    }

    @CircuitBreaker(name = "translateFeign", fallbackMethod = "fallbackTranslate")
    @Override
    public ResponseTranslatorDTO translate(LanguagesDTO to, String text) {
        List<LanguagesDTO> languages = getLanguages();
        validateCode(languages, to.getCode());
        
        if (to.getCode().equals(Languages.NONE.getCode())) {
            return new ResponseTranslatorDTO(text);
        }

        RequestTranslatorDTO req = new RequestTranslatorDTO();
        req.setAlternatives(3);
        req.setFormat("text");
        req.setSource("auto");
        req.setTarget(to.getCode());
        req.setQ(text);
        req.setApiKey("");
        return client.translate(req);
    }

    public ErrorDTO fallbackTranslate(Throwable t) {
        log.error("Error: ", t);
        ErrorDTO error = new ErrorDTO();
        error.setStatusCode(500);
        error.setError("Service not available");
        return error;
    }

    private void validateCode(List<LanguagesDTO> languages, String code) {
        Optional<LanguagesDTO> language = findLanguage(languages, code);
        if (!language.isPresent()) {
            throw new ServiceException(HttpStatus.NOT_FOUND,
                    String.format("Code %s does not exist", code));
        }
    }

    private Optional<LanguagesDTO> findLanguage(List<LanguagesDTO> languages, String code) {
        return languages.stream().filter(l -> l.getCode().equals(code)).findFirst();
    }
}
