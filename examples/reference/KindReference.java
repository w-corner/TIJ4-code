package reference;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class KinfReference {

    /**
     * 弱引用的对象 在GC调用时 会被回收
     * 软引用的对象 在GC调用时 会不会被回收，需要看情况：
     *   1. 内存足够时不会被回收
     *   2. 内存不足时才会被回收
     */

    private static void weak() {
        System.out.println("########### weak ############");

        // 这种方式 "hello" 不会被回收的， 需要用 new String() 的方式才可以
//        WeakReference<String> sr = new WeakReference<>("hello");
        WeakReference<String> sr = new WeakReference<>(new String("hello"));

        System.out.println(sr.get());
        System.gc();                //通知JVM的gc进行垃圾回收
        System.out.println(sr.get());
    }

    private static void soft() {
        System.out.println("########### soft ############");
        SoftReference<String> sr = new SoftReference<>(new String("soft"));

        System.out.println(sr.get());
        System.gc();                //通知JVM的gc进行垃圾回收
        System.out.println(sr.get());
    }

    public static void main(String[] args) {
        weak();
        soft();
    }
}
