package com.work.traductor.controller;

import com.work.traductor.dto.LanguagesDTO;
import com.work.traductor.dto.RequestDTO;
import com.work.traductor.dto.ResponseTranslatorDTO;
import com.work.traductor.service.TraductorService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author linux
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/translator")
public class TraductorController {

    private final TraductorService service;

    public TraductorController(TraductorService service) {
        this.service = service;
    }

    @GetMapping(path = "/languages", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity< List<LanguagesDTO>> languages() {
        List<LanguagesDTO> response = this.service.getLanguages();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @GetMapping(path = "/language/{code}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<LanguagesDTO> language(@PathVariable("code") String code) {
        LanguagesDTO response = this.service.getLanguage(code);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path = "/translate", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResponseTranslatorDTO> translate(@RequestBody RequestDTO request) {
        LanguagesDTO from = request.getFrom();
        LanguagesDTO to = request.getTo();
        ResponseTranslatorDTO response = this.service.translate(from, to, request.getText());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
