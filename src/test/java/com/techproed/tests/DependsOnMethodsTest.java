package com.techproed.tests;

import org.testng.annotations.Test;

public class DependsOnMethodsTest {
   //bu sefer onceligi priority belirledi
   //o olmasaydi test02 metodu ndan once test01 calisacakti depends old.icin

    @Test (priority = 1)
    public void test01(){  // sisteme giriş testiniz
        System.out.println("test01");
    }
    @Test (priority = 2,dependsOnMethods = "test01")
    public void test02(){ // sisteme giriş yaptıktan sonraki işlemler
        System.out.println("test02");
    }
    @Test (priority = 3)
    public void test03(){
        System.out.println("test03");
    }






}
