package nuc.zm.netty.byrebuffer;

import java.nio.ByteBuffer;

public class TestByteBufferAllocate {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        ByteBuffer buffer = ByteBuffer.allocateDirect(10);

        System.out.println("allocate 分配堆内存 " + byteBuffer.getClass());
        System.out.println("allocateDirect 分配直接内存" +  buffer.getClass());
    }
}
