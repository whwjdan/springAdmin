package com.jeongmu.springstudy1.model.network;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Header<T> {

    // api 통신시간
    // LocalDateTime을 쓰나 프론트엔드와 인터페이스 시에는 스트링을 사
    private LocalDateTime transactionTime;
    // ISO, YYYY-MM-DD 등 형식 따라

    // api 응답 코드
    private String resultCode;

    // api 부가 설명
    private String description;

    // GetController로 오브젝트를 호출시 Jacson을 통해
    // 자동으로 JSON형식으로 리턴해줌

    private T data;

    // OK
    public static <T> Header<T> OK(){
        return (Header<T>)Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .build();
    }

    // DATA OK
    public static <T> Header<T> OK(T data){
        return (Header<T>)Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .data(data)
                .build();
    }

    // ERROR
    public static <T> Header<T> ERROR(String description){
        return (Header<T>)Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("ERROR")
                .description(description)
                .build();
    }

    /*
    계속해서 바뀌는 data부분을 정의할 때 일반적으로 제네릭으로 많이 정의함
    따라서 class Header 뒤에 제네릭을 붙여주고
    data부분에 해당 제네릭으로 지정한 타입이 들어가게 된다.

    수정해야 할 부분 : 일반적으로 API를 작성한다고 할 때 스네이크 케이스를
    많이 사용하는데 내려주는 리스폰스 바디부분을 보면 카멜 케이스로 작성되어있음.
    >> 직접 @JsonProperty("")로 이름을 지어줌
    >> 일반적으로 모든 부분에 써주기는 불편하기 때문에
    어플리케이션 프로퍼티에 spring.jackson.property-naming-strategy=SNAKE_CASE
    를 써줌
    추가적으로 @JsonInclue로 사용 가능

     */
}
