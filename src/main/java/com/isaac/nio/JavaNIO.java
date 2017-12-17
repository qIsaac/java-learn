package com.isaac.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by Isaac on 2017/7/22.
 */
public class JavaNIO {
    public static void main (String [] args){
        JavaNIO javaNIO = new JavaNIO();
        try {
            javaNIO.server();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void server() throws Exception{
        //1.获取通道
        ServerSocketChannel ssc = ServerSocketChannel.open();
        //2.切换到非阻塞状态
        ssc.configureBlocking(false);
        //3.绑定链接
        ssc.bind(new InetSocketAddress(8999));
        //4.获取选择器
        Selector selector  = Selector.open();
        //5.将通道注册到选择器上,并指定接受监听事件
        ssc.register(selector, SelectionKey.OP_ACCEPT);
        //6. 轮询式的获取选择器上已经“准备就绪”的事件
        while (selector.select() > 0){
            //7. 获取当前选择器中所有注册的“选择键(已就绪的监听事件)”
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()){
                //8. 获取准备“就绪”的是事件
                SelectionKey sk = it.next();
                //9. 判断具体是什么事件准备就绪
                if (sk.isAcceptable()){
                    //10. 若“接收就绪”，获取客户端连接
                    SocketChannel sc = ssc.accept();
                    //11. 切换非阻塞模式
                    sc.configureBlocking(false);
                    //12. 将该通道注册到选择器上
                    sc.register(selector,SelectionKey.OP_READ);
                } else if (sk.isReadable()){
                    //13. 获取当前选择器上“读就绪”状态的通道
                    SocketChannel socketChannel = (SocketChannel) sk.channel();
                    //14. 读取数据
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    int len = 0;
                    while((len = socketChannel.read(buf)) > 0 ){
                        buf.flip();
                        System.out.println(new String(buf.array(), 0, len));
                        buf.clear();
                    }
                }
                //15. 取消选择键 SelectionKey
                it.remove();
            }
        }
    }
}
