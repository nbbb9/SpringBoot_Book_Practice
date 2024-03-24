package com.springboot.api.controller;

import com.springboot.api.dto.MemberDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {
    //----- @RequestBody 사용-------//
    //http://localhost:888-/api/v1/put-api/member
    @PutMapping(value = "/member")
    public String postMember (@RequestBody Map<String, Object> putData){
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map->{
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    //----- @RequestBody & DTO 객체 사용 & 리턴타입 String-------//
    //http://localhost:888-/api/v1/put-api/member1
    @PutMapping(value = "/member1")
    public String postMemberDTO1 (@RequestBody MemberDTO dto){
        return dto.toString();
    }

    //----- @RequestBody & DTO 객체 사용 & 리턴타입 MemberDTO-------//
    //http://localhost:8880/api/v1/put-api/member2
    @PutMapping(value = "/member2")
    public MemberDTO postMemberDTO2 (@RequestBody MemberDTO dto){
        return dto;
    }

    //---------@ResponseEntity를 활용한 PUT메서드---------//
    //http://localhost:8880/api/v1/put-api/member3
    @PutMapping(value = "/member3")
    public ResponseEntity<MemberDTO> postMemberDTO3 (@RequestBody MemberDTO dto){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(dto);
    }


}
