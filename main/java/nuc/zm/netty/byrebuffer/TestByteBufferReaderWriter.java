package nuc.zm.netty.byrebuffer;

import java.nio.ByteBuffer;

import  static  nuc.zm.netty.util.ByteBufferUtil.*;

/**
 * 测试字节缓冲区读写方法
 *
 * @author zm
 * @date 2023/04/04
 */
public class TestByteBufferReaderWriter {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        byteBuffer.put((byte) 'a');
        // 字节缓冲区工具类 方便打印
        debugAll(byteBuffer);

        byteBuffer.put(new byte[]{0x62, 0x63, 0x64});

        debugAll(byteBuffer);
        // 根部读不到任何内容
        System.out.println(byteBuffer.get());
        // 切换为读模式
        byteBuffer.flip();
        System.out.println(byteBuffer.get());
        debugAll(byteBuffer);

        byteBuffer.compact();

        debugAll(byteBuffer);
    }
}
