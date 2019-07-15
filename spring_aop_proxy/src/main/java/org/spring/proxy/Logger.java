package org.spring.proxy;

import java.util.Date;

/**
 * Created by chenqifeng on 2017/3/29.
 */
public class Logger {
    public static void info(String info){
        System.out.println(new Date()+"--------------"+info);
    }
}
