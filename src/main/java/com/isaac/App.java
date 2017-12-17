package com.isaac;

import com.isaac.thread.MyRunnable;
import com.isaac.thread.NoThreadSafe;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.println(System.getProperty("os.name").toLowerCase());
       /* NoThreadSafe noThreadSafe = new NoThreadSafe();
        new Thread(new MyRunnable(noThreadSafe)).start();
        new Thread(new MyRunnable(noThreadSafe)).start();
        OSinfo.getOSname().toString().toLowerCase()+"-"+OSinfo.getSystemNum()*/
    }
}
