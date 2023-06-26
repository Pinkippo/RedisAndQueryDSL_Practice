package com.example.traffic.prac_one;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 *  JUNIT 5 생성주기 테스트 파일
 */
class PracEntityTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("## BeforeAll Annotation 호출 ##");
        System.out.println();
    }

    @AfterAll
    static void afterAll() {
        System.out.println("## afterAll Annotation 호출 ##");
        System.out.println();
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("## beforeEach Annotation 호출 ##");
        System.out.println();
    }

    @AfterEach
    void afterEach() {
        System.out.println("## afterEach Annotation 호출 ##");
        System.out.println();
    }

    @Test
    void test1() {
        System.out.println("## test1 시작 ##");
        System.out.println();
    }

    @Test
    @DisplayName("Test Case 2!!!")
    void test2() {
        System.out.println("## test2 시작 ##");
        System.out.println();
    }

    @Test
    @Disabled
        // Disabled Annotation : 테스트를 실행하지 않게 설정하는 어노테이션
    void test3() {
        System.out.println("## test3 시작 ##");
        System.out.println();
    }

//    실행 과정 -> 작성 순서가 아닌 호출 순서대로 실행됨
//    ## BeforeAll Annotation 호출 ##
//
//    ## beforeEach Annotation 호출 ##
//
//    ## test1 시작 ##
//
//    ## afterEach Annotation 호출 ##
//
//    ## beforeEach Annotation 호출 ##
//
//    ## test2 시작 ##
//
//    ## afterEach Annotation 호출 ##
//
//    ## afterAll Annotation 호출 ##

}