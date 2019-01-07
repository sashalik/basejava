package ru.javawebinar.basejava;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MainConcurrency {
    private static final int THREADS_NUMBER = 10000;
    private static int counter;
    private final AtomicInteger atomicCounter = new AtomicInteger();

    private static final ReentrantReadWriteLock reentrantreadWriteLock = new ReentrantReadWriteLock();
    private static Lock WRITE_LOCK = reentrantreadWriteLock.writeLock();
    private static Lock READ_LOCK = reentrantreadWriteLock.readLock();
    private static final ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        }
    };

    /*private static class Mouse {
        private String name;

        public Mouse(String name) {
            this.name = name;
        }

        public String getName() {
            return String.valueOf(this.name);
        }

        public synchronized void Squeak(Mouse mouse) {
            System.out.println("Name mouse " + this.name + " " + mouse.getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mouse.SqueakRepeat(this);
        }

        public synchronized void SqueakRepeat(Mouse mouse) {
            System.out.println("Name mouse " + this.name + " " + mouse.getName());
        }
    }*/

    public static void main(String[] args) throws InterruptedException {
        /*final Mouse norushka = new Mouse("Норушка");
        final Mouse notNorushka = new Mouse("Не Норушка");

        new Thread(() -> norushka.Squeak(notNorushka)).start();

        new Thread(() -> notNorushka.Squeak(norushka)).start();*/

        System.out.println(Thread.currentThread().getName());
        Thread thread0 = new Thread() {
            @Override
            public void run() {
                System.out.println(getName() + "," + getState());
            }
        };
        thread0.start();

        new Thread(() -> System.out.println(Thread.currentThread().getName() + "," + Thread.currentThread().getState())).start();

        System.out.println(thread0.getState());

        final MainConcurrency mainConcurrency = new MainConcurrency();
        CountDownLatch latch = new CountDownLatch(THREADS_NUMBER);
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        for (int i = 0; i < THREADS_NUMBER; i++) {
            executorService.submit(() -> {
                for (int j = 0; j < 100; j++) {
                    mainConcurrency.inc();
                    System.out.println(threadLocal.get().format(new Date()));
                }
                latch.countDown();
                return 5;
            });
        }

        latch.await(10, TimeUnit.SECONDS);
        executorService.shutdown();
        System.out.println(mainConcurrency.atomicCounter.get());
    }

    private void inc() {
        atomicCounter.incrementAndGet();
    }
}
