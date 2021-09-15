package top.parak.Algorithm.Sort;


/**
 * @author KHighness
 * @since 2020-09-21
 * @apiNote 睡眠排序
 */

public class SleepSort {

    class SortThread extends Thread {
        int ms = 0;
        public SortThread(int ms) {
            this.ms = ms;
        }
        public void run() {
            try {
                sleep(ms * 10 + 10);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(ms);
        }
    }

    public void sort(int[] array) {
        SortThread[] sortThreads = new SortThread[array.length];
        for (int i = 0; i < array.length; i++) {
            sortThreads[i] = new SortThread(array[i]);
        }
        for (int i = 0; i < sortThreads.length; i++) {
            sortThreads[i].start();
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 4, 7, 9, 2, 5, 3, 0, 6, 8};
        new SleepSort().sort(array);
    }
}
