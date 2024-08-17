import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        TaskFreq[] freqs = new TaskFreq['Z' + 1];
        for (char task : tasks) {
            if (freqs[task] == null) {
                freqs[task] = new TaskFreq(task);
            } else {
                freqs[task].exec++;
            }
        }

        Queue<TaskFreq> pQueue = new PriorityQueue<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            if (freqs[c] != null) {
                pQueue.add(freqs[c]);
            }
        }

        Queue<TaskDate> waitingTasks = new PriorityQueue<>();
        int result = 0;

        while (!pQueue.isEmpty() || !waitingTasks.isEmpty()) {
            if (!waitingTasks.isEmpty()) {
                if (waitingTasks.peek().wake == result) {
                    TaskDate td = waitingTasks.poll();
                    pQueue.add(td.task);
                }
            }

            if (!pQueue.isEmpty()) {
                TaskFreq tf = pQueue.poll();
                tf.exec--;
                if (tf.exec != 0) {
                    waitingTasks.add(new TaskDate(tf, result + n + 1));
                }
            }

            result++;
        }

        return result;
    }

    public static class TaskFreq implements Comparable<TaskFreq> {
        public char task;
        public int exec;

        public TaskFreq(char task) {
            this.task = task;
            this.exec = 1;
        }

        @Override
        public int compareTo(TaskFreq tf) {
            return tf.exec - exec;
        }
    }

    public static class TaskDate implements Comparable<TaskDate> {
        public TaskFreq task;
        public int wake;

        public TaskDate(TaskFreq task, int wake) {
            this.task = task;
            this.wake = wake;
        }

        @Override
        public int compareTo(TaskDate td) {
            return wake - td.wake;
        }
    }
}
