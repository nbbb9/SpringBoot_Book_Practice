package com.springboot.api.controller;

import com.springboot.api.dto.MemberDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {//Post API
    //-------- @RequestMapping사용---------------//
    //http://localhost:8880/api/v1/post-api/domain
    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample() {
        return "Hello Post Api";
    }

    //----@RequestBody 사용-----//
    //http://localhost:8880/api/v1/post-api/member
    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> postData){
        StringBuilder sb = new StringBuilder();
        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    //----@RequestBody & DTO 객체 사용-----//
    //http://localhost:8880/api/v1/post-api/member2
    @PostMapping(value = "/member2")
    public String postMember(@RequestBody MemberDTO dto) {
        return dto.toString();
    }

}
