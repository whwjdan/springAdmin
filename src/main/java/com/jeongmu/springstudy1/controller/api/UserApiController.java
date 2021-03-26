package com.jeongmu.springstudy1.controller.api;

import com.jeongmu.springstudy1.ifs.CrudInterface;
import com.jeongmu.springstudy1.model.network.Header;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
// /api/user의 주소를 가지는 컨트롤
public class UserApiController implements CrudInterface {

    // CRUD에 대해 작성
    @Override
    @PostMapping("") // ""으로 하면 /api/user로 매핑
    public Header create(){
        return null;
    }

    @Override
    @GetMapping("{id}") // /api/user/{id}
    public Header read(@PathVariable(name ="id") Long id) {
        return null;
    }

    @Override
    @PutMapping("")
    public Header update() {
        return null;
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        return null;
    }

}
