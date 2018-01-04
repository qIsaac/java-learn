package com.isaac.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Isaac on 2017/7/22.
 */
public class NIOMain  {
    public static  void main(String[] args){
        NIOMain jnio = new NIOMain();
        try {
            jnio.client();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void client() {
        SocketChannel sc = null;
        try {
            //1.获取通道
            sc = SocketChannel.open(new InetSocketAddress("127.0.0.1",8999));
            //2.切换非阻塞模式
            sc.configureBlocking(false);
            //3.分陪指定大小的缓存
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            //4.发送信息到服务端
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()){
                String str = scanner.next();
                byteBuffer.put((new Date().toString()+"\n"+str).getBytes());
                byteBuffer.flip();
                sc.write(byteBuffer);
                byteBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sc != null){
                try {
                    sc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
