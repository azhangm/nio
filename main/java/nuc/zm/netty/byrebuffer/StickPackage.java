package nuc.zm.netty.byrebuffer;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import static nuc.zm.netty.util.ByteBufferUtil.*;

/**
 * 模拟粘包、半包问题
 *
 * @author zm
 * @date 2023/04/05
 */
public class StickPackage {
    public static void main(String[] args) {
        ByteBuffer allocate = ByteBuffer.allocate(32);
        allocate.put("hello,world\nI'm xiaolin\nHo".getBytes(StandardCharsets.UTF_8));
        split(allocate);
        allocate.put("w are you\n".getBytes(StandardCharsets.UTF_8));
        split(allocate);
    }

    private static void split(ByteBuffer allocate) {
        // byteBuffer 切换至读模式
        allocate.flip();

        for (int i = 0 ; i < allocate.limit(); i ++) {
            byte b = allocate.get(i);
            if (b == '\n') {
                // 存入新的 ByteBuffer
                int len = i - allocate.position() + 1;
                ByteBuffer target = ByteBuffer.allocate(len);
                for (int j = 0; j < len; j++) {
                    target.put(allocate.get());
                }
                // 拆分
                System.out.println("postion    "+ allocate.position());
                debugAll(target);
            }
        }
        // 压缩已读，并切换到写模式
        allocate.compact();
    }


}
