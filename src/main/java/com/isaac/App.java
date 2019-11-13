package com.isaac;

import com.isaac.thread.MyRunnable;
import com.isaac.thread.NoThreadSafe;

import java.util.PriorityQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        String s = "Set-Cookie: rememberMe=deleteMe; Path=/ibank-web; Max-Age=0; Expires=Fri, 14-Jun-2019 09:37:46 GMT\n" +
                "Set-Cookie: rememberme=deleteMe; Path=/ibank-web; Max-Age=0; Expires=Fri, 14-Jun-2019 09:37:46 GMT\n" +
                "rememberme\n" +
                "Set-Cookie\n" +
                "Set-Cookie:  Path=/ibank-web; Max-Age=0; Expires=Fri, 14-Jun-2019 09:37:46 GMT;rememberme=deleteMe;";
        Pattern pattern = Pattern.compile("((Set-Cookie)[\\s\\S]+)|((rememberMe)[\\s\\S])",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()){
            String group = matcher.group();
            System.out.println(group);
        }
       /* System.out.println(System.getProperty("os.name").toLowerCase());
       *//* NoThreadSafe noThreadSafe = new NoThreadSafe();
        new Thread(new MyRunnable(noThreadSafe)).start();
        new Thread(new MyRunnable(noThreadSafe)).start();
        OSinfo.getOSname().toString().toLowerCase()+"-"+OSinfo.getSystemNum()*//*
       System.out.println(int.class);*/
    }
}
