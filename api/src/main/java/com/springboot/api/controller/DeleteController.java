package com.springboot.api.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteController {
    //-----@pathVariable을 활용한 DELETE메서드 구현-------//
    @DeleteMapping(value = "/{str}")
    public String DeleteVariable(@PathVariable String str ){
        return str;
    }

    //-----@RequestParam을 활용한 DELETE메서드 구현-----//
    //http://localhost:8880/api/v1/delete-api/request1?email=값
    @DeleteMapping(value = "/request1")
    public String DeleteParam(@PathVariable String email ){
        return "e-mail : " + email;
    }

}