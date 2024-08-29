package com.work.traductor.service;

import com.work.traductor.client.TranslateFeign;
import com.work.traductor.dto.LanguagesDTO;
import com.work.traductor.dto.RequestTranslatorDTO;
import com.work.traductor.dto.ResponseTranslatorDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author linux
 */
@Service
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
    public ResponseTranslatorDTO translate(LanguagesDTO from, LanguagesDTO to, String text) {
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

    @Override
    public ResponseTranslatorDTO translate(LanguagesDTO to, String text) {
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
}
