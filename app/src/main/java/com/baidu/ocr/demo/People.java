package com.baidu.ocr.demo;

import java.util.ArrayList;

/**
 * Created by dahei on 2017/9/19.
 */

public class People {
    private String address;
    private String idNumber;
    private String birthday;
    private String name;
    private String gender;
    private String ethnic;
    private final ArrayList<String> strings;
    public People(String message){
        strings = StringUtils.string2Arr(message);
    }

    public String getAll(){
        return strings.toString();
    }

    public String getAddress() {
        return strings.get(0).replace(",","");
    }

    public String getIdNumber() {
        return strings.get(1).replace(",","");
    }

    public String getBirthday() {
        return strings.get(2).replace(",","");
    }

    public String getName() {
        return strings.get(3).replace(",","");
    }

    public String getGender() {
        return strings.get(4).replace(",","");
    }

    public String getEthnic() {
        return strings.get(5).replace(",","");
    }
}
