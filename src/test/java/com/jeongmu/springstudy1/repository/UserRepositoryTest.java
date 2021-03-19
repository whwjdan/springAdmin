package com.jeongmu.springstudy1.repository;

import com.jeongmu.springstudy1.Springstudy1ApplicationTests;
import com.jeongmu.springstudy1.model.entity.Item;
import com.jeongmu.springstudy1.model.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends Springstudy1ApplicationTests {

    //DI 의존성 주입
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        // String sql = insert into user (%s, %s, %d) value (account, email, age);
        User user = new User();
        user.setAccount("TestUser03");
        user.setEmail("TestUser01@gmail.com");
        user.setPhoneNumber("010-1111-1111");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");
        user.setUpdatedBy("admin");
        user.setUpdatedAt(LocalDateTime.now());

        User newUser = userRepository.save(user);
        System.out.println("newUser : " + newUser);
    }

    @Test
    @Transactional
    public void read(){
        // id가 Long 타입이므로 2뒤에 L붙임
        // Optional 있을 수 도 있고 없을 수 도 있다.
        // StackOverflow시 롬북의 ToString 메서드에서 외래키 객체를 exclude
        //Optional<User> user = userRepository.findByAccountAndEmail("TestUser03", "TestUser01@gmail.com");

        // cnt + shift + /
/*        user.ifPresent(selectUser ->{
           selectUser.getOrderDetailList().stream().forEach(detail ->{
                Item item = detail.getItem();
                System.out.println(item);
            });

        } );*/

    }

    @Test
    public void update(){
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser ->{
            selectUser.setAccount("pppp");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
              } );
    }

    @Test
    @Transactional
    // 데이터베이스 커밋하지 않고 롤백시킴
    public void delete(){
        Optional<User> user = userRepository.findById(3L);

        Assert.assertTrue(user.isPresent());

        user.ifPresent(selectUser->{
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(2L);

        if(deleteUser.isPresent()){
            System.out.println("데이터 존재 : "+deleteUser.get());
        }else {
            System.out.println("데이터 삭제 데이터 없음");
        }

        Assert.assertFalse(deleteUser.isPresent());
   }

}
