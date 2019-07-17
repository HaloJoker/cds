package com.bfgy.cds.common.utils;

import java.util.UUID;

public class UUIDGenerator
{
    /**
     * 获得一个UUID
     * 
     * @return String UUID
     */
    public static String getUUID()
    {
        String s = UUID.randomUUID().toString();
        // 去掉“-”符号
        return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
    }
    public static void main(String[] args){
        System.out.println(UUIDGenerator.getUUID());
    }
}
