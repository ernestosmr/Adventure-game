package User;
import GameLogic.Object;

import java.util.Random;

public class Ally {
    String name;
    String[] dialogo1;
    String[] dialogo2;
    boolean d2 = true;
    String[] dialogo3;
    boolean d3 = true;
    Object[] gift;
    private java.lang.Object Random;

    public Object[] getgift() {
        return gift;
    }

    public void setgift(Object[] gift) {
        this.gift = gift;
    }

    public Ally(String name){
        this.name = name;
    }

    public String[] getDialogo1() {
        return dialogo1;
    }

    public String getName() {
        return name;
    }
    public void setDialogo1(String[] dialogo1) {
        this.dialogo1 = dialogo1;
    }

    public String[] getDialogo2() {
        return dialogo2;
    }

    public void setDialogo2(String[] dialogo2) {
        this.dialogo2 = dialogo2;
    }

    public String[] getDialogo3() {
        return dialogo3;
    }

    public void setDialogo3(String[] dialogo3) {
        this.dialogo3 = dialogo3;
    }

    public Object sentGift(Player player){
        Random random = new Random();
        int index = random.nextInt(gift.length);
        player.setInventory(gift[index]);
        return gift[index];
    }

    public boolean isD2() {
        return d2;
    }

    public void setD2(boolean d2) {
        this.d2 = d2;
    }

    public boolean isD3() {
        return d3;
    }

    public void setD3(boolean d3) {
        this.d3 = d3;
    }
}
