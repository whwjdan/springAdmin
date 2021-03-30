package com.jeongmu.springstudy1.controller.api;

import com.jeongmu.springstudy1.ifs.CrudInterface;
import com.jeongmu.springstudy1.model.network.Header;
import com.jeongmu.springstudy1.model.network.request.UserApiRequest;
import com.jeongmu.springstudy1.model.network.response.UserApiResponse;
import com.jeongmu.springstudy1.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
// Log >> 롬복에 포함된 로그
@RestController
@RequestMapping("/api/user")
// /api/user의 주소를 가지는 컨트롤
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserApiLogicService userApiLogicService;

    // CRUD에 대해 작성
    @Override
    @PostMapping("") // ""으로 하면 /api/user로 매핑
    public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request){

        log.info("{}, {}", request, "ABC");
        return userApiLogicService.create(request);

    /*
    Controller >> 클라이언트로부터 요청이 들어왔을 때 처리하는곳
    Service >> 요청된 것을 수행 CRUD이므로
    컨트롤러에서 @RequestBody로 클라이언트로부터
    id, password 등 요청을 받으면
    해당 리퀘스트를 userApiLogicService create 메소드를 호출하여
    전달하고 서비스 단에서 JPA를 통해 DB에 저장

     */
    }

    @Override
    @GetMapping("{id}") // /api/user/{id}
    public Header<UserApiResponse> read(@PathVariable(name ="id") Long id) {
        log.info("read : {}", id);
        return userApiLogicService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> userApiRequest) {
        return null;
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        return null;
    }

}
