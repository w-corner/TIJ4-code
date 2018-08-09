# 多线程

## 创建
1. extends Thread
2. implements Runable
3. implements Callable

    其中3支持返回值

## 线程状态

1. New 新建状态
2. Runable 就绪状态
3. Running 运行状态
4. Blocked 阻塞状态

    1. 等待阻塞：运行的线程执行wait()方法，JVM会把该线程放入等待池中。(wait会释放持有的锁)
    2. 同步阻塞：运行的线程在获取对象的同步锁时，若该同步锁被别的线程占用，则JVM会把该线程放入锁池中。
    3. 其他阻塞：运行的线程执行sleep()或join()方法，或者发出了I/O请求时，JVM会把该线程置为阻塞状态。当sleep()状态超时、join()等待线程终止或者超时、或者I/O处理完毕时，线程重新转入就绪状态。（注意,sleep是不会释放持有的锁）

5. Dead 死亡状态

## 线程池

## 线程调度



## 术语

1. daemon 后台线程、守护线程

    守护线程会在

    `setDaemon(Thread t)`
    
    `isDaemon()`

2. 

## 同步控制

1. synchronized
2. 
3. lock

