package com.jeongmu.springstudy1.service;

import com.jeongmu.springstudy1.ifs.CrudInterface;
import com.jeongmu.springstudy1.model.entity.User;
import com.jeongmu.springstudy1.model.network.Header;
import com.jeongmu.springstudy1.model.network.request.UserApiRequest;
import com.jeongmu.springstudy1.model.network.response.UserApiResponse;
import com.jeongmu.springstudy1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserRepository userRepository;

    // 1. request data
    // 2. user 생성
    // 3. 생성된 데이터 -> UserApiResponse return
    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {

        // 1. request data 가져오기
        UserApiRequest userApiRequest = request.getData();

        // 2. User 생성
        User user = User.builder()
                .account(userApiRequest.getAccount())
                .password(userApiRequest.getPassword())
                .status("REGISTERED")
                .phoneNumber(userApiRequest.getPhoneNumber())
                .email(userApiRequest.getEmail())
                .registeredAt(LocalDateTime.now())
                .build();

        /*
        User auser = new User();

        auser.setAccount(~~);
        auser.setPassword(~~);

        위에 빌더 패턴은 User객체를 생성해서
        변수를 지정해주는 것과 동일

        서비스 로직이 개발되면 테스트 메소드를 통해 테스트 수행
        */

        User newUser = userRepository.save(user);

        // 3. 생성된 데이터 -> userApiResponse return
        return response(newUser);
    }

    @Override
    public Header<UserApiResponse> read(Long id) {

        // id -> repository getOne, getById
        Optional<User> optional = userRepository.findById(id);

        // user -> userApiResponse return

        return optional.map(user -> response(user))
                .orElseGet(
                        ()->Header.ERROR("데이터 없음")
                );

        /*
        return userRepository.findById(id)
            .map(user -> response(user))
            .orElseGet(
                    () -> Header.ERROR("데이터 없음")
            );
            으로도 가능
         */

    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
        return null;
    }

    @Override
    public Header delete(Long id) {
        return null;
    }

    private Header<UserApiResponse> response(User user){
        // user -> userApiResponse

        UserApiResponse userApiResponse = UserApiResponse.builder()
                .id(user.getId())
                .account(user.getAccount())
                .password(user.getPassword()) // todo 암호화, 길이
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .status(user.getStatus())
                .registeredAt(user.getRegisteredAt())
                .unRegisteredAt(user.getRegisteredAt())
                .build();

        // Header + data return

        return Header.OK(userApiResponse);
    }
}
