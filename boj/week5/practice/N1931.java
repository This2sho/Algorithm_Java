package boj.week5.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 회의실 배정
public class N1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Room[] room = new Room[N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            room[i] = new Room(start, end);
        }
        room = Arrays.stream(room).sorted((a, b) -> {
            if(a.end == b.end) return a.start - b.start;
            return a.end - b.end;}).toArray(Room[]::new);
        for (Room room1 : room) {
            System.out.print(room1.start);
            System.out.println(" ~ " + room1.end);
        }
        System.out.println();
        System.out.println();
        int end = room[0].end;
        int res = 1;
        System.out.print(room[0].start);
        System.out.println(" ~ " + room[0].end);
        for(int i=1; i<N; i++){
            if(room[i].start < end) continue;
            System.out.print(room[i].start);
            System.out.println(" ~ " + room[i].end);
            end = room[i].end;
            res++;
        }
        System.out.print(res);
    }

    static class Room{
        int start;
        int end;

        public Room(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
