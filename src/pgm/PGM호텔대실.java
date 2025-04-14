package pgm;

import java.util.*;

class PGM호텔대실 {
    public int solution(String[][] book_time) {
        Arrays.sort(book_time, (a, b) -> a[0].compareTo(b[0]));

        PriorityQueue<Integer> roomQueue = new PriorityQueue<>();

        for (String[] time : book_time) {
            int start = toMinutes(time[0]);
            int end = toMinutes(time[1]) + 10; // 청소시간 10분 추가

            if (!roomQueue.isEmpty() && roomQueue.peek() <= start) {
                roomQueue.poll();
            }

            roomQueue.add(end);
        }

        return roomQueue.size();
    }

    private int toMinutes(String time) {
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        return hour * 60 + minute;
    }
}

