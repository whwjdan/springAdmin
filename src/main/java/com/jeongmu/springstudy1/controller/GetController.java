package com.jeongmu.springstudy1.controller;

import com.jeongmu.springstudy1.model.SearchParam;
import com.jeongmu.springstudy1.model.network.Header;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") // localhost:8080/api
public class GetController {

    @RequestMapping(method = RequestMethod.GET, path = "/getMethod")
    public String getRequest(){

        return "Hi getMethod";
    }

    @GetMapping("/getParameter") // localhost:8080/api/getParameter?id=1234&password=1234
    public String getParameter(@RequestParam String id, @RequestParam String password){
        System.out.println("id : "+id);
        System.out.println("password : "+password);
        return id+password;
    }

    //localhost:8080/api/getMultiParameter?account=as&email=ww@n.com&page=123
    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        // { "account" : "", "email" : "", "page" : 0}
        // JSON 형태 jackson library 사용 스프링 부트 내장
        return searchParam;
    }

    @GetMapping("/header")
    public Header getHeader(){

        // {"resultCode: ": "OK", "description" : "OK"}
        return Header.builder().resultCode("OK").description("OK").build();
    }
}
