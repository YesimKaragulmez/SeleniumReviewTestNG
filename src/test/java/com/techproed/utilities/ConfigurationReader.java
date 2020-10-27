package com.techproed.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

    //surekli nesne olusturmayi istemedigim icin degiskenleri ve metodlari
    // static yapicam

    private static Properties properties;

  //projemde sadece biryerde static blok kullaniyorum oda propertiesi dosyasini
    // okuyabilmek icin

    static {
        //daha okunakli olsun diye path i stringe esitledim
        String dosyaYolu="C:\\Users\\user\\IdeaProjects\\SeleniumReviewTestNG\\configuration.properties";
       try {
           //okumak istedigimiz dosyanin dosya yolunu gondermek gerekir path
           FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
           properties = new Properties();
           properties.load(fileInputStream);

       }catch (Exception e){

       }

    }
    public static String getProperty(String key){
        String deger = properties.getProperty(key);
        return deger;
    }

   }


