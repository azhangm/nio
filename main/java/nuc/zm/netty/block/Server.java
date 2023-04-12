package nuc.zm.netty.block;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;
import static nuc.zm.netty.util.ByteBufferUtil.*;

public class Server {
    public static void main(String[] args) throws IOException {
        // 创建服务器
        ServerSocketChannel open = ServerSocketChannel.open();
        ByteBuffer buffer = ByteBuffer.allocate(32);
        // 绑定监听端口
        open.bind(new InetSocketAddress(8080));
        open.configureBlocking(false);
        List<SocketChannel> socketChannelList = new ArrayList<>();
        while (true){
            // SocketChannel 与客户端进行通信
            System.out.println("等待连接~~~~~");
            SocketChannel socketChannel = open.accept();
            System.out.println("连接成功~~~~");
            socketChannelList.add(socketChannel);
            for (SocketChannel channel : socketChannelList) {
                channel.    read(buffer);
                buffer.flip();
                debugRead(buffer);
                buffer.clear();
            }
        }
    }
}
