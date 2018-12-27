package ru.javawebinar.basejava;

public class MainConcurrency {
    //private static final int THREADS_NUMBER = 10000;
    //private static int counter;

    private static class Mouse {
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
    }

    public static void main(String[] args) {
        final Mouse norushka = new Mouse("Норушка");
        final Mouse notNorushka = new Mouse("Не Норушка");

        new Thread(() -> norushka.Squeak(notNorushka)).start();

        new Thread(() -> notNorushka.Squeak(norushka)).start();

//        System.out.println(Thread.currentThread().getName());
//        Thread thread0 = new Thread() {
//            @Override
//            public void run() {
//                System.out.println(getName() + "," + getState());
//            }
//        };
//        thread0.start();
//
//        new Thread(() -> System.out.println(Thread.currentThread().getName() + "," + Thread.currentThread().getState())).start();
//
//        System.out.println(thread0.getState());
//
//        final MainConcurrency mainConcurrency = new MainConcurrency();
//        List<Thread> threads = new ArrayList<>(THREADS_NUMBER);
//        for (int i = 0; i < THREADS_NUMBER; i++) {
//            Thread thread = new Thread(() -> {
//                for (int j = 0; j < 100; j++) {
//                    mainConcurrency.inc();
//                }
//            });
//            thread.start();
//            threads.add(thread);
//        }
//
//        threads.forEach(t -> {
//            try {
//                t.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        System.out.println(counter);
    }

//    private synchronized void inc() {
//        counter++;
//    }
}
