package com.gf.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {

	//@GetMapping(value = "/index", produces = MediaType.TEXT_PLAIN_VALUE)
    //@GetMapping(value = "/index", produces = MediaType.TEXT_HTML_VALUE)
    @GetMapping(value = "/index", produces = MediaType.APPLICATION_JSON_VALUE)
    public String index() {
        return "Hola Mundo";
    }
}
