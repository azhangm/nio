package nuc.zm.netty.byrebuffer;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * 测试收集中读
 *
 * @author zm
 * @date 2023/04/04
 */
public class TestGatheringWrites {
    public static void main(String[] args) {
        ByteBuffer hello = StandardCharsets.UTF_8.encode("hello");  // 10bit
        ByteBuffer world = StandardCharsets.UTF_8.encode("world"); // 10 bit
        ByteBuffer b3 = StandardCharsets.UTF_8.encode("===你好世界"); // 18bit
        try (FileChannel w = new RandomAccessFile("words.txt", "rw").getChannel()) {
            w.write(new ByteBuffer[]{hello,world,b3});
        } catch (IOException e) {
        }
    }
}
