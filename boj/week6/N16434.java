package boj.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 드래곤 앤 던전
public class N16434 {
    static final boolean MONSTER = true;
    static final boolean POTION = false;
    static int atk;
    static long result;
    static Room[] rooms;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        atk = Integer.parseInt(st.nextToken());

        rooms = new Room[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            rooms[i] = new Room(Integer.parseInt(st.nextToken()) == 1 ? MONSTER : POTION, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        binarySearch();
        System.out.print(result);
    }

    static class Room{
        boolean type;
        int atk;
        int hp;

        public Room(boolean type, int atk, int hp) {
            this.type = type;
            this.atk = atk;
            this.hp = hp;
        }
    }

    static void binarySearch() {
        long lowHP = 1;
        long highHP = (long) Math.pow(10, 18);

        while (lowHP <= highHP) {
            long maxHP = (lowHP + highHP) / 2;
            long curHP = maxHP;
            long cAtk = atk;
            first :
            for (Room room : rooms) {
                if (room.type == MONSTER) {
                    long cnt = (room.hp % cAtk) == 0 ? room.hp / cAtk : (room.hp / cAtk) + 1;
                    if(cnt > 1) curHP -= (cnt-1) * room.atk;
                    if(curHP <= 0) break;
                }
                else {
                    curHP = curHP + room.hp >= maxHP ? maxHP : curHP + room.hp;
                    cAtk += room.atk;
                }
            }
            if (curHP > 0) {
                result = maxHP;
                highHP = maxHP - 1;
            }else lowHP = maxHP + 1;
        }
    }
}
