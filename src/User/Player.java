package User;

import GameLogic.Object;

import java.util.ArrayList;

public class Player extends User {

    private int currentRoom = 1;

    public int getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(int currentRoom) {
        this.currentRoom = currentRoom;
    }

    private ArrayList<Object> inventory;
    public ArrayList<Object> getInventory() {
        return inventory;
    }
    public void showInventory(){
        for (Object element : inventory) {
            System.out.println("Name: " + element.getName());
            System.out.println("Type: " + element.getType());
            System.out.println("Effect: " + element.getEffectDescription());
            System.out.println("Index: " + inventory.indexOf(element));
        }
    }
    public void useObj(int index,Player player){
        inventory.get(index).use(player);
    }
    public void setInventory(Object obj) {
        inventory.add(obj);
        System.out.println("Haz añadido " + obj.getName());
        System.out.println(obj.getEffectDescription());
    }
    public Player(){
        this.setAttack(100);
        this.setHealth(200);
        this.setKnowledge(0);
        this.setDodgeChance(0);
        inventory = new ArrayList<Object>();
    }
}
