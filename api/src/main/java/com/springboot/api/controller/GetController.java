package com.springboot.api.controller;

import com.springboot.api.dto.MemberDTO;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("api/v1/get-api")
public class GetController {//GET API
    //-------- @RequestMapping사용---------------//
    //http://localhost:8880/api/v1/get-api/hello
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello(){
        return "Hello SpringBoot_use RequestMapping";
    }

    //-------------@GetMapping사용------------//
    //http://localhost:8880/api/v1/get-api/name
    @GetMapping(value = "/name")
    public String getName(){
        return "Hello SpringBoot_use GetMapping";
    }

    //-----@GetMapping & @PathVariable 사용1-----//
    //http://localhost:8880/api/v1/get-api/variable1/{String 값}
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){
        return variable;
    }

    //-----@GetMapping & @PathVariable 사용2-----//
    //http://localhost:8880/api/v1/get-api/variable2/{String 값}
    @GetMapping(value = "/variable2/{variable}")
    public String getVariabl2(@PathVariable("variable") String var){
        return var;
    }

    //-----@GetMapping & @RequestParam 사용------//
    //http://localhost:8880/api/v1/get-api/request1?name=이름&email=이메일&organization=조직
    @GetMapping(value = "/request1")
    public String getRequestParam1( @RequestParam String name,
                                    @RequestParam String email,
                                    @RequestParam String organization){
        return name + " " + email + " " + organization;
    }

    //-----@GetMapping & @RequestParam & Map<K,V> 사용------//
    //http://localhost:8880/api/v1/get-api/request2?key1=값1&key2=값2
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param){
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }
    //------------------DTO----------------------//
    //http://localhost:8880/api/v1/get-api/request3?name=값1&email=값2&organization=값3
    @GetMapping(value="/request3")
    public String getRequestParam3(MemberDTO memberDTO){
        System.out.println("Debug >>> input value : " + memberDTO.toString());
        return memberDTO.toString();
    }

}
