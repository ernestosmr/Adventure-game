package GameLogic;

import User.Player;

import java.util.function.Consumer;

public class Object {
    private Consumer<Player> effect;
    private String name;
    private String type;
    private String effectDescription;


    public Object(String name, String type, Consumer<Player> effect, String description) {
        this.name = name;
        this.effect = effect;
        this.type = type;
        this.effectDescription = description;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Consumer<Player> getEffect() {
        return effect;
    }
    public String getEffectDescription(){
        return effectDescription;
    }
    public void use(Player player){
        effect.accept(player);
    }

}
