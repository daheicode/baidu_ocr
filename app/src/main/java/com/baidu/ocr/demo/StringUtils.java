package com.baidu.ocr.demo;

import java.util.ArrayList;

/**
 * Created by dahei on 2017/9/19.
 * 匹配中文:[\u4e00-\u9fa5]

 英文字母:[a-zA-Z]

 数字:[0-9]
 */

public class StringUtils {
    public static ArrayList<String> string2Arr(String s){
        ArrayList<String> list=new ArrayList();
        if(s!=null){
            String[] split = s.split(",");
            for (int i = 0; i < split.length; i++) {
                if (i>1) {
                    split[i]=split[i].replaceAll("[^0-9\\u4e00-\\u9fa5]", "");
                    list.add(split[i]);
                }
            }
        }else{
            throw new IllegalArgumentException("result do not null");
        }
        return list;
    }
}
