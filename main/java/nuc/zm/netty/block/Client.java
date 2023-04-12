package nuc.zm.netty.block;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class Client {

    public static void main(String[] args) throws IOException {
        SocketChannel sc = SocketChannel.open();
//        sc.bind(new InetSocketAddress("localhost",8080));
//        连接端口 8080
          sc.connect(new InetSocketAddress("localhost",8080));
        System.out.println("waiting");
    }
}
