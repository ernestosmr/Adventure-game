package GameLogic;

import User.Enemy;

import java.util.ArrayList;

public class Room {
    String roomName;

    int dificulty;
    ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    public Room(String roomName, int dificulty) {
        this.roomName = roomName;
        this.dificulty = dificulty;
        for (int i = 0; i < 5; i++) {
            enemies.add(new Enemy(dificulty));
        }
    }

    public String getRoomName() {
        return roomName;
    }

    public int getDificulty() {
        return dificulty;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }
}
