package nuc.zm.netty;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Properties;

public class TestByteBuffer {

    public static void main(String[] args) throws IOException {
//        获取 FileChannel
//        通过输入流或者输出流 获得 FileChannel
        // 原来根目录 E:\work_space\netty_demo
        Properties properties = System.getProperties();

        String  s = (String) System.getProperties().get("user.dir");
        try (FileChannel channel = new FileInputStream(s + "\\a.txt").getChannel()) {
            // 分配一个新的字节缓冲区。 划分一块内存作为缓冲区。划分的大小 有 allocate 参数决定
            ByteBuffer byteBuffer = ByteBuffer.allocate(10);
            // 从信道里读取数据  向缓冲区写入
            channel.read(byteBuffer);
            // byteBuffer 现在有内容了   flip 切换到 buffer 的读模式
             byteBuffer.flip();
            // 是否还有剩余的未读的数据
             while(byteBuffer.hasRemaining()) {
                 char c = (char) byteBuffer.get();
                 System.out.println(c);
             }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
