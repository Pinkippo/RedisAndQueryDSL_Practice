package com.example.traffic.prac_one;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *      객체 생성 테스트 assertThat 연습
 */
class PracEntityTest2 {

    @Test
    @DisplayName("Post 생성 테스트") //테스트 이름
    void CreatePrac(){
        System.out.println("## Create Prac 시작 ##");
        System.out.println();

        Long id = 123456789L;
        String name = "테스트";
        int age = 24;
        String email = "hseungwan@naver.com";

        PracEntity prac = new PracDTO(id,name,age,email).toEntity();

        assertEquals(prac.getName(),"테스트"); // 비교
    }

    // assertEquals(a, b): a와 b의 값이 동일한지 확인
    // assertSame(a, b): a와 b의 객체가 동일한지 확인
    // assertNull(a): a가 null인지 확인
    // assertNotNull(a): a가 null이 아닌지 확인
    // assertTrue(a): a가 true인지 확인
    // assertFalse(a): a가 false인지 확인
    // assertThrows(입셉션 에러 종류 a, 발생하는 로직 b) : b 로직시에 a 입셉션이 발생하는지 확인
    // assertThat : AssertJ 라이브러리에 포함된 메서드, 어떤 조건이 참인지 확인

}