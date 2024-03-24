package com.springboot.test;

import org.junit.jupiter.api.*;

public class TestLifeCycle {

    @BeforeAll
    static void beforeAll(){
        System.out.println("##BeforeAll Annotation 호출");
        System.out.println();
    }

    @AfterAll
    static void AfterAll(){
        System.out.println("##AfterAll Annotation 호출");
        System.out.println();
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("##BeforeEach Annotation 호출");
        System.out.println();
    }

    @AfterEach
    void AfterEach(){
        System.out.println("##AfterEach Annotation 호출");
        System.out.println();
    }

    @Test
    void test1(){
        System.out.println("## test1 Start");
        System.out.println();
    }

    @Test
    @DisplayName("Test Case 2")
    void test2(){
        System.out.println("## test2 Start");
        System.out.println();
    }

    @Test
    @Disabled
    void test3(){
        System.out.println("## test3 Start");
        System.out.println();
    }

}
