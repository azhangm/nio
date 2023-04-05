package nuc.zm.netty.byrebuffer;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import static nuc.zm.netty.util.ByteBufferUtil.*;
/**
 * 测试分散读取
 *
 * @author zm
 * @date 2023/04/04
 */
public class TestScatteringReads {
    public static void main(String[] args) {
        String  s = (String) System.getProperties().get("user.dir");
        System.out.println(s);
        try (FileChannel channel = new RandomAccessFile(s + "/words.txt", "r").getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(3);
            ByteBuffer buffer1 = ByteBuffer.allocate(3);
            ByteBuffer buffer2 = ByteBuffer.allocate(5);
            channel.read(new ByteBuffer[]{buffer, buffer1, buffer2});
            buffer.flip();
            buffer1.flip();
            buffer2.flip();
            debugAll(buffer);
            debugAll(buffer1);
            debugAll(buffer2);
        } catch (IOException e) {
        }
    }

}
