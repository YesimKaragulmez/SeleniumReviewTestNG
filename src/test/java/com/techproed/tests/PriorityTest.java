package com.techproed.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.annotation.Target;

public class PriorityTest {
    @BeforeMethod//her methoddan once bir kere calisir yani 4 defa calisir
    //prioritize la ilgisi yok
    public void setUp(){
        System.out.println("setUp");
    }
    @Test(priority = 1)
    public void amazonTest(){
        System.out.println("amazonTest");
    }
    @Test(priority = 2)
    public void googleTest(){
        System.out.println("googleTest");
    }
    @Test(priority = 3)
    public void facebookTest(){
        System.out.println("facebookTest");
    }
    @Test(priority = 4)
    public void appleTest(){
        System.out.println("appleTest");
    }










}
