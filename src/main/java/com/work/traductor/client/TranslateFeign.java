package com.work.traductor.client;

import com.work.traductor.dto.RequestTranslatorDTO;
import com.work.traductor.dto.ResponseTranslatorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author linux
 */
@FeignClient(name = "translateFeign", url = "https://translate.fedilab.app")
public interface TranslateFeign {

    @PostMapping("/translate")
    ResponseTranslatorDTO translate(@RequestBody RequestTranslatorDTO request);
}
