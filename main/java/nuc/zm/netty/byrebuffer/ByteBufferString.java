package nuc.zm.netty.byrebuffer;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static nuc.zm.netty.util.ByteBufferUtil.*;

/**
 * 字节缓冲区字符串
 *
 * @author zm
 * @date 2023/04/04
 */
public class ByteBufferString {
    public static void main(String[] args) {
        byte[] bytes = "hello".getBytes();
        ByteBuffer allocate = ByteBuffer.allocate(10);
        allocate.put(bytes);
        debugAll(allocate);

        // CharSet 类 defaultCharset ： 使用当前操作系统的字符集
        Charset charset = Charset.defaultCharset();
        ByteBuffer encode = charset.encode("hello");
        debugAll(encode);

        ByteBuffer wrap = ByteBuffer.wrap(bytes);
        debugAll(wrap);
//        System.out.println(new String(wrap.array()));

//        System.out.println(new String(allocate.array()));

//        System.out.println(charset.decode(wrap));
        System.out.println( "指定字符集形式" + StandardCharsets.UTF_8.decode(wrap));
        debugAll(wrap);
        System.out.println("charset 形式 " + charset.decode(wrap));
    }
}
