import GameLogic.Object;
import GameLogic.Room;
import User.Ally;
import User.Player;
import User.Enemy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Object> allObjects = new ArrayList<Object>();
    static ArrayList<Room> rooms = new ArrayList<Room>();
    static ArrayList<Ally> allAllies = new ArrayList<Ally>();
    static Player player = new Player();
    public Game(){
        allObjects.add(new Object("Health Potion", "common", (player) -> {
            player.setHealth(player.getHealth() + 50);
        }, "+25 Health"));
        allObjects.add(new Object("Poisoned Dagger", "common", (player) -> {
            player.setAttack(player.getAttack() + 30);
            player.setHealth(player.getHealth() - 5);
        }, "+10 Attack, -5 Attack"));
        allObjects.add(new Object("Iron Shield", "common", (player) -> {
            player.setHealth(player.getHealth() + 10);
            player.setDefense(player.getDefense() + 5);
        }, "+10 health, +5 Defense"));
        allObjects.add(new Object("Mana Crystal", "common", (player) -> {
            player.setKnowledge(player.getKnowledge() + 10);
        }, "+10 Knowledge"));
        allObjects.add(new Object("Leather Armor", "common", (player) -> {
            player.setHealth(player.getHealth() + 30);
            player.setDefense(player.getDefense() + 15);
        }, "+30 de health, +15 Defense"));
        allObjects.add(new Object("Wooden Club", "common", (player) -> {
            player.setAttack(player.getAttack() + 20);
        }, "+20 Attack"));
        allObjects.add(new Object("Scroll of Fireball", "common", (player) -> {
            player.setAttack(player.getAttack() + 30);
        }, "+30 Attack"));
        allObjects.add(new Object("Scroll of Ice Bolt", "common", (player) -> {
            player.setAttack(player.getAttack() + 25);
        }, "+25 Attack"));
        allObjects.add(new Object("Holy Water", "common", (player) -> {
            player.setAttack(player.getAttack() + 40);
        }, "+ 40 Attack"));
        allObjects.add(new Object("Silver Sword", "common", (player) -> {
            player.setAttack(player.getAttack() + 30);
        }, "+30 Attack"));

        // Especiales
        allObjects.add(new Object("Enchanted Amulet", "special", (player) -> {
            player.setHealth(player.getHealth() + 70);
            player.setDefense(player.getDefense() + 20);
        }, "+70 health, +20 Defense"));
        allObjects.add(new Object("Poisonous Bow", "special", (player) -> {
            player.setAttack(player.getAttack() + 300);
            player.setHealth(player.getHealth() - 100);
        }, "+ 300 Attack - 100 health"));
        allObjects.add(new Object("Robes of the Archmage", "special", (player) -> {
            player.setHealth(player.getHealth() + 100);
            player.setKnowledge(player.getKnowledge() + 40);
        }, "+100 health, 40 knowledge"));
        allObjects.add(new Object("Ring of Invisibility", "special", (player) -> {
            player.setDodgeChance(player.getDodgeChance() + .2);
        }, "20% Dodge chance"));
        allObjects.add(new Object("Ring of Power", "special", (player) -> {
            player.setAttack(player.getAttack() + 70);
        }, "+70 Attack"));
        // Épicos
        allObjects.add(new Object("Dragon Scale Armor", "epic", (player) -> {
            player.setHealth(player.getHealth() + 100);
            player.setDefense(player.getDefense() + 40);
        }, "+100 health, +40 defense"));
        allObjects.add(new Object("Staff of Arcane Might", "epic", (player) -> {
            player.setAttack(player.getAttack() + 70);
            player.setKnowledge(player.getKnowledge() + 60);
        }, "+70 Attack, +60 knowledge"));
        allObjects.add(new Object("Sword of the Divine", "legendary", (player) -> {
            player.setAttack(player.getAttack() + 80);
            player.setHealth(player.getHealth() + 80);
            player.setDefense(player.getDefense() + 40);
            player.setKnowledge(player.getKnowledge() + 70);
        }, "+80 Attack, +80 Health, +40 Defense, +70 Knowledge"));
        allObjects.add(new Object("Amulet of Eternal Life", "legendary", (player) -> {
            player.setHealth(player.getHealth() + 500);
        }, "+500 health"));
        // Legendarios
        allObjects.add(new Object("Cape of Invisibility", "legendary", (player) -> {
            player.setDodgeChance(player.getDodgeChance() + .5);
        }, "50% Dodge chance"));

        rooms.add(new Room("The Relaxation Room", 1));
        rooms.add(new Room("The Serenity Suite", 2));
        rooms.add(new Room("The Tranquility Garden", 3));
        rooms.add(new Room("The Harmony Chamber", 4));
        rooms.add(new Room("The Silent Retreat", 5));
        rooms.add(new Room("The Twilight Chamber", 6));
        rooms.add(new Room("The Mystery Room", 7));
        rooms.add(new Room("The Shadowed Quarters", 8));
        rooms.add(new Room("The Haunted Hall", 9));
        rooms.add(new Room("The Chamber of Horrors", 10));
        Ally aria = new Ally("Aria");
        Ally nina = new Ally("Nina");
        Ally isabella = new Ally("Isabella");
        Ally sophia = new Ally("Sophia");
        Ally landon = new Ally("Landon");
        Ally briar = new Ally("Briar");
        Ally evan = new Ally("Evan");
        Ally raven = new Ally("Raven");
        Ally dante = new Ally("Dante");
        Ally levi = new Ally("Levi");

        allAllies.add(aria);
        allAllies.add(nina);
        allAllies.add(isabella);
        allAllies.add(sophia);
        allAllies.add(landon);
        allAllies.add(briar);
        allAllies.add(evan);
        allAllies.add(raven);
        allAllies.add(dante);
        allAllies.add(levi);

        //Aria
        String[] ariaD1 = {"Nina: Hey there! How are you feeling today?",
                "Player: I'm feeling pretty good, thanks.",
                "Nina: That's great to hear. Do you come to this room often?",
                "Player: Yeah, I like to come here to relax.",
                "Nina: Same here. I love the calming atmosphere. Have you tried the meditation exercises?",
                "Player: Not yet, but I'm interested in trying them out.",
                "Nina: They're really helpful for calming the mind and reducing stress. Well, it was nice chatting with you. Take care!"};
        String[] ariaD2 = {
                "Nina: Hello there! How's your day going?",
                "Player: It's going pretty well, thanks for asking.",
                "Nina: That's good to hear. I noticed that you seem pretty knowledgeable about this room.",
                "Player: Yeah, I come here often to relax and clear my mind.",
                "Nina: I think that's a great idea. Taking time for yourself is really important. Have you tried any of the other rooms in this area?",
                "Player: No, I haven't. Do you have any recommendations?",
                "Nina: The Tranquility Garden is really nice, especially if you like being surrounded by nature. Well, I have to go now. Take care!"
        };

        String[] ariaD3 = {
                "Nina: Hi there! How are you doing today?",
                "Player: I'm doing well, thank you. How about you?",
                "Nina: I'm doing pretty well too. I noticed that you seem to have a good amount of knowledge about this room.",
                "Player: Yeah, I've spent a lot of time here and have learned a lot.",
                "Nina: That's really impressive. I'm still learning a lot about this room myself. Have you ever tried the relaxation exercises?",
                "Player: Yes, I have. They're really helpful for calming the mind and body.",
                "Nina: I totally agree. It's amazing how much of a difference a few minutes of deep breathing can make. Well, I have to get going now. See you later!"
        };
        aria.setDialogo1(ariaD1);
        aria.setDialogo2(ariaD2);
        aria.setDialogo1(ariaD3);
        Object[] ariaGifts = {
                new Object("Relaxation Potion", "Consumable", player -> player.setHealth(player.getHealth() + 50), "+50 Health"),
                new Object("Calm Music", "Consumable", player -> player.setAttack(player.getAttack() + 50),"+50 Attack" ),
                new Object("Aromatherapy Candles", "Consumable", player -> player.setDefense(player.getDefense() + 10), "+10 Defense"),
        };
        aria.setgift(ariaGifts); ;
        //nina
        String[] ninaD1 = {
                "Nina: Welcome to The Serenity Suite, player. How may I assist you today?",
                "Player: I'm just looking around. This room is so peaceful.",
                "Nina: Yes, this is one of our most tranquil spaces. Take your time and enjoy your stay.",
                "Player: Thank you, Nina. I'll be sure to come back soon.",
                "Nina: It was my pleasure. Have a good day."
        };

        String[] ninaD2 = {
                "Nina: Hello again, player. How are you today?",
                "Player: I'm doing well, Nina. How about you?",
                "Nina: I'm doing great, thank you. Have you tried our meditation exercises?",
                "Player: Not yet. I'm not really sure how to meditate.",
                "Nina: No problem. We have guided meditation sessions every morning at 8 AM. Would you like me to sign you up?",
                "Player: Yes, please. Thank you, Nina.",
                "Nina: You're welcome. I hope you find the meditation helpful."
        };

        String[] ninaD3 = {
                "Nina: Hello, player. You seem more relaxed today. How are you feeling?",
                "Player: I feel great, Nina. I've been meditating every day since we last spoke.",
                "Nina: That's wonderful to hear. How has your experience been?",
                "Player: It's been really helpful in reducing my stress levels. I feel more focused and centered.",
                "Nina: I'm glad to hear that. Did you know that meditation has been shown to improve cognitive function as well?",
                "Player: No, I didn't. That's really interesting.",
                "Nina: Yes, it's amazing what a little mindfulness can do. Keep up the good work, player.",
                "Player: Thanks, Nina. I appreciate your help and guidance.",
                "Nina: Anytime. Have a peaceful day."
        };
        nina.setDialogo1(ninaD1);
        nina.setDialogo2(ninaD2);
        nina.setDialogo3(ninaD3);
        Object[] ninaGifts = {
                new Object("Meditation Pillow", "Consumable", player -> player.setHealth(player.getHealth() + 100), "+100 Health"),
                new Object("Serenity Crystal", "Consumable", player -> player.setKnowledge(player.getKnowledge() + 50), "+50 knowledge"),
                new Object("Soothing Incense", "Consumable", player -> player.setDodgeChance(player.getDodgeChance() + 0.1), "+0.1 Dodge chance"),
        };
        nina.setgift(ninaGifts);
        //Isabella

        String[] isabellaD1 = {
                "Isabella: Hello, player. Welcome to the Tranquility Garden. How can I assist you?",
                "Player: Hi, Isabella. I was just exploring the garden and wanted to say hi.",
                "Isabella: Oh, that's wonderful. It's always nice to meet new people. I hope you enjoy your time here.",
                "Player: Thank you, Isabella. I'll make sure to come back and visit.",
                "Isabella: Take care, player. See you soon."
        };

        String[] isabellaD2 = {
                "Isabella: Greetings, player. I can sense that you possess some knowledge. Would you like to talk about something specific?",
                "Player: Hello, Isabella. I do have some questions about this garden. It's quite fascinating.",
                "Isabella: Of course, player. What would you like to know?",
                "Player: I was wondering about the different types of plants here and their medicinal properties.",
                "Isabella: Ah, that's a great question. Let me tell you about the healing properties of some of the herbs we have here...",
        };

        String[] isabellaD3 = {
                "Isabella: Ah, player. I sense that you possess great knowledge. It's an honor to converse with someone as learned as you.",
                "Player: Thank you, Isabella. Your garden is truly a remarkable place. I've learned so much here.",
                "Isabella: I'm glad to hear that, player. I've dedicated my life to cultivating this garden and sharing knowledge with others.",
                "Player: You've done an amazing job. I feel at peace here and have gained a greater appreciation for the natural world.",
                "Isabella: That is the greatest reward for me, player. Thank you for sharing your thoughts with me.",
        };
        isabella.setDialogo1(isabellaD1);
        isabella.setDialogo2(isabellaD2);
        isabella.setDialogo3(isabellaD3);
        Object[] isabellaGifts = {
                new Object("Tranquil Tea", "Consumable", player -> player.setHealth(player.getHealth() + 200), "+200 health"),
                new Object("Garden Scissors", "Consumable", player -> player.setAttack(player.getAttack() + 80), "+80 Attack"),
                new Object("Garden Seeds", "Consumable", player -> player.setKnowledge(player.getKnowledge() + 70), "70 knowledge"),
        };

        isabella.setgift(isabellaGifts);

        // Sophia
        String[] sophiaD1 = {
                "Sophia: Hello there, player. It's so nice to meet you!",
                "Player: Hi Sophia, it's nice to meet you too.",
                "Sophia: I'm so glad you decided to come to the Harmony Chamber. It's one of my favorite rooms in the whole place.",
                "Player: It's a beautiful room, for sure.",
                "Sophia: Yes, it really is. Well, I won't keep you any longer. Enjoy your stay here!",
                "Player: Thanks, Sophia. See you around!"
        };
        String[] sophiaD2 = {
                "Sophia: Hello again, player. I hope you're enjoying your stay in the Harmony Chamber.",
                "Player: Hi Sophia, yes, I am. It's a lovely room.",
                "Sophia: I'm so glad to hear that. Did you know that this room was inspired by ancient Greek architecture?",
                "Player: No, I didn't. That's interesting.",
                "Sophia: Yes, it's fascinating. The ancient Greeks believed that architecture could affect a person's mood and wellbeing, and I think this room is a perfect example of that.",
                "Player: That's really cool. Thanks for telling me, Sophia.",
                "Sophia: You're welcome, player. It's always a pleasure to share my knowledge with others.",
                "Player: I appreciate it. See you later, Sophia!",
                "Sophia: Goodbye, player. Enjoy the rest of your stay here."
        };
        String[] sophiaD3 = {
                "Sophia: Welcome back, player. I'm so glad to see you again.",
                "Player: Hi Sophia, it's great to see you too.",
                "Sophia: I was just reading a fascinating book about the history of architecture. Did you know that the ancient Egyptians were the first to use columns in their buildings?",
                "Player: No, I had no idea. That's really interesting.",
                "Sophia: Yes, it is. And did you know that the columns in the Harmony Chamber are based on the Ionic order of architecture, which was developed in ancient Greece?",
                "Player: Wow, that's really cool. I'm learning so much from you, Sophia.",
                "Sophia: I'm always happy to share my knowledge with others. It's what I love to do.",
                "Player: Well, I appreciate it. Thanks for being such a great guide.",
                "Sophia: You're welcome, player. It's been a pleasure. Have a wonderful day!",
                "Player: You too, Sophia. Goodbye!",
                "Sophia: Goodbye, player. Take care!"
        };
        sophia.setDialogo1(sophiaD1);
        sophia.setDialogo1(sophiaD2);
        sophia.setDialogo3(sophiaD3);
        Object[] sophiaGifts = {
                new Object("Harmony Elixir", "Consumable", player -> player.setHealth(player.getHealth() + 100), "100 Health"),
                new Object("Melodic Chimes", "Consumable", player -> player.setAttack(player.getAttack() + 70), "+70 Attack"),
                new Object("Symphony Sheet Music", "Consumable", player -> player.setKnowledge(player.getKnowledge() + 60), "+60 Knowledge"),
        };
        sophia.setgift(sophiaGifts);
        //Landon
        String[] landonD1 = {"Player: Hi there.",
                "Landon: Hello. Silence is golden, don't you think?",
                "Player: Yes, it can be peaceful.",
                "Landon: It's more than that. It's a way to clear the mind and find inner peace.",
                "Player: I can see how that would be helpful.",
                "Landon: Indeed. I've been coming here for years to meditate and find clarity. It's amazing what you can discover in the silence."};
        String[] landonD2 = {"Player: Hi, Landon.",
                "Landon: Hello. What brings you back to the Silent Retreat?",
                "Player: I was hoping to learn more about meditation.",
                "Landon: Ah, I see. Well, there's no better place to do that than here. What would you like to know?",
                "Player: How do you focus your mind during meditation?",
                "Landon: It takes practice, but the key is to let go of any distracting thoughts and focus on your breath. Once you do that, your mind will become still and you'll enter a state of deep relaxation."};

        String[] landonD3 = {"Player: Hi, Landon. I was hoping to chat again.",
                "Landon: Hello. Of course, I'm always happy to talk to fellow seekers of inner peace.",
                "Player: I wanted to know more about your experiences here.",
                "Landon: Well, as I said before, the Silent Retreat has been instrumental in my journey of self-discovery. I've found that the more I come here, the more I learn about myself and the world around me.",
                "Player: That sounds amazing. Do you think anyone can benefit from meditation?",
                "Landon: Absolutely. It doesn't matter who you are or what your beliefs are. Everyone can benefit from taking time to quiet their mind and reflect on their life."};
        landon.setDialogo1(landonD1);
        landon.setDialogo2(landonD2);
        landon.setDialogo3(landonD3);
        Object[] landonGifts = {
                new Object("Silence Potion", "Consumable", player -> player.setHealth(player.getHealth() + 100), "+100 health"),
                new Object("Meditation Bell", "Consumable", player -> player.setDefense(player.getDefense() + 70),"+70 Defense"),
                new Object("Whisper Book", "Consumable", player -> player.setKnowledge(player.getKnowledge() + 70), "+70 knowledge"),
        };
        landon.setgift(landonGifts);
        //Briar
        String[] briarD1 = {"Briar: Hello there, player. What brings you to this chamber of shadows?",
                "Player: Just exploring the area. What about you?",
                "Briar: I come here to find peace and quiet. It's the perfect place to meditate and reflect.",
                "Player: Sounds interesting. Maybe I'll try it out too.",
                "Briar: You're more than welcome to, but be careful not to get lost in the shadows."};
        String[] briarD2 = {"Briar: Ah, player. It's good to see you again. What brings you back to the shadows?",
                "Player: I've been learning more about this place and I wanted to ask you about it.",
                "Briar: I'm glad you're taking an interest in the mysteries of the Twilight Chamber. What would you like to know?",
                "Player: I've heard that there's a hidden room somewhere around here. Do you know anything about it?",
                "Briar: Yes, I do. But I can't reveal its location to just anyone. You'll have to prove your worth by solving a riddle first."};
        String[] briarD3 = {"Briar: Welcome back, player. You seem to have gained more knowledge since we last met.",
                "Player: Yes, I've been studying the secrets of this place. I find it fascinating.",
                "Briar: Indeed, the Twilight Chamber holds many secrets. Some of which even I have yet to uncover.",
                "Player: Really? What kind of secrets?",
                "Briar: Well, for example, there's a hidden door in this very room that leads to a chamber of wonders. But it's protected by a powerful enchantment that only the most knowledgeable can decipher."};

        briar.setDialogo1(briarD1);
        briar.setDialogo2(briarD2);
        briar.setDialogo3(briarD3);
        Object[] briarGifts = {
                new Object("Twilight Tonic", "Consumable", player -> player.setHealth(player.getHealth() + 120), "+120 health"),
                new Object("Starlight Pendant", "Consumable", player -> player.setAttack(player.getAttack() + 100), "+100 attack"),
                new Object("Night Sky Map", "Consumable", player -> player.setKnowledge(player.getKnowledge() + 90), "+09 knowledge"),
        };
        briar.setgift(briarGifts);
        //Evan
        String[] evanD1 = {"Evan: Welcome to the Mystery Room. Are you lost, player?",
                "Player: No, I just wanted to explore this area.",
                "Evan: Ah, I see. Well, be careful. There are many secrets hidden in this room.",
                "Player: Thanks for the warning, Evan.",
                "Evan: No problem. Enjoy your stay."};
        String[] evanD2 = {"Evan: Oh, hello again, player. Have you discovered anything interesting in the room?", "Player: Yes, I found a hidden passage behind a bookshelf.", "Evan: Very interesting. You're quite observant. Keep searching, there's more to discover.", "Player: Thanks for the tip, Evan.", "Evan: Anytime."};
        String[] evanD3 = {"Evan: Ah, I see you've returned, player. Tell me, have you solved any of the mysteries of this room?", "Player: Yes, I found a mysterious artifact hidden in a corner.", "Evan: Fascinating. That artifact has eluded me for years. You truly have a knack for discovery.", "Player: Thanks, Evan. I'll keep searching for more secrets.", "Evan: Good luck on your journey."};
        evan.setDialogo1(evanD1);
        evan.setDialogo2(evanD2);
        evan.setDialogo3(evanD3);
        Object[] evanGifts = {
                new Object("Mystery Elixir", "Consumable", player -> player.setHealth(player.getHealth() + 120), "get Health"),
                new Object("Cryptic Scroll", "Consumable", player -> player.setAttack(player.getAttack() + 100), "+100 attack"),
                new Object("Puzzle Box", "Consumable", player -> player.setDefense(player.getDefense() + 80), "+80 defense"),
        };
        evan.setgift(evanGifts);
        //Raven
        String[] ravenD1 = {"Raven: Hello there, player. What brings you to these dark quarters?",
                "Player: I was just exploring this place.",
                "Raven: Be careful around here, player. There are many secrets and dangers lurking in the shadows.",
                "Player: Thanks for the warning, Raven.",
                "Raven: You're welcome. Stay safe out there."};
        String[] ravenD2 = {"Raven: Ah, player. It's good to see you again. Have you learned anything new since we last spoke?",
                "Player: Yes, I've been gathering some knowledge on the mysteries of this place.",
                "Raven: Excellent. Knowledge is power in these shadowed quarters. Keep seeking the truth, player.",
                "Player: I will. Thanks, Raven.",
                "Raven: Farewell, player. Until we meet again."};
        String[] ravenD3 = {"Raven: Greetings, player. Your knowledge precedes you. You have proven yourself to be a true seeker of the shadows.",
                "Player: Thank you, Raven. I have been delving deep into the secrets of this place.",
                "Raven: I can see that. You have unlocked many doors that were hidden from view. But be careful, player. The more you know, the more dangerous this place becomes.",
                "Player: I understand. I won't let my guard down.",
                "Raven: Wise words, player. Stay vigilant and keep seeking the truth. Farewell."};
        raven.setDialogo1(ravenD1);
        raven.setDialogo1(ravenD2);
        raven.setDialogo1(ravenD3);
        Object[] ravenGifts = {
                new Object("Shadow Elixir", "Consumable", player -> player.setHealth(player.getHealth() + 150), "+150 health"),
                new Object("Darkness Candle", "Consumable", player -> player.setAttack(player.getAttack() + 110), "+110 attack"),
                new Object("Mystery Novel", "Consumable", player -> player.setKnowledge(player.getKnowledge() + 90), "+90 knowledge"),
        };
        raven.setgift(ravenGifts);
        //Dante
        String[] danteD1 = {
                "player: Hi there!",
                "dante: *coughs* Greetings... What brings you to this dreadful place?",
                "player: I'm just exploring this mansion. Have you seen anything strange around here?",
                "dante: *sighs* This entire hall is strange enough for me. But I have heard some whispers and eerie sounds coming from the basement.",
                "player: The basement, you say? I'll have to check it out. Thanks for the tip.",
        };

        String[] danteD2 = {
                "player: Hey, dante. Do you know anything about the history of this mansion?",
                "dante: *coughs* Oh, yes. It has a dark past. The previous owner was a wealthy man with a twisted mind. He used to experiment on humans and animals, trying to create his own creatures.",
                "player: That's horrifying. Did he succeed?",
                "dante: *shudders* I don't know for sure, but some say that the creatures still roam these halls at night...",
                "player: Thanks for the warning, dante. I'll be careful.",
        };

        String[] danteD3 = {
                "player: Hello again, dante. I've been exploring this mansion for a while now, and I can't seem to find my way out. Can you help me?",
                "dante: *chuckles* You're not the first one to get lost in this maze of a house. But fear not, I know the way out.",
                "player: That's great! Can you show me?",
                "dante: *smirks* Of course, but it won't be easy. You see, the exit is guarded by a powerful spirit, and you'll have to defeat it to escape.",
                "player: A spirit? How do I defeat it?",
                "dante: *whispers* I don't know for sure, but I've heard that it's vulnerable to fire...",
        };

        dante.setDialogo1(danteD1);
        dante.setDialogo1(danteD2);
        dante.setDialogo1(danteD3);
        Object[] danteGifts = {
                new Object("Haunted Tonic", "Consumable", player -> player.setHealth(player.getHealth() + 170), "+170 health"),
                new Object("Spooky Charm", "Consumable", player -> player.setAttack(player.getAttack() + 185), "+185 attack"),
                new Object("Cursed Tome", "Consumable", player -> player.setKnowledge(player.getKnowledge() + 100), "100 knowledge"),
        };
        raven.setgift(danteGifts);

        //Levi
        String[] leviD1 = {"Levi: Welcome to the Chamber of Horrors, player. What brings you to this terrifying place?",
                "Levi: You seem brave, player. Do you have what it takes to face your fears?",
                "Levi: Fear is a powerful emotion, player. It can both paralyze and motivate. Which one is it for you?"};

        String[] leviD2 = {"Levi: I see that you've returned, player. Did you find what you were looking for?",
                "Levi: Your fear can be your greatest ally or your worst enemy, player. Which one will it be for you?",
                "Levi: The Chamber of Horrors is not for the faint of heart, player. But I can see that you're different."};

        String[] leviD3 = {"Levi: It's good to see you again, player. Your courage is truly remarkable.",
                "Levi: Fear is a strange thing, player. Sometimes it's hard to tell whether it's holding us back or pushing us forward.",
                "Levi: The Chamber of Horrors is a place of great power, player. And I can see that you've tapped into that power."};

        levi.setDialogo1(leviD1);
        levi.setDialogo2(leviD2);
        levi.setDialogo3(leviD3);
        Object[] leviGifts = {
                new Object("Horror Elixir", "Consumable", player -> player.setHealth(player.getHealth() + 250), "+250 health"),
                new Object("Terrifying Mask", "Consumable", player -> player.setDefense(player.getDefense() + 140), "+140 defense"),
                new Object("Dark Ritual Book", "Consumable", player -> player.setAttack(player.getAttack() + 200), "+200 attack"),
        };
        levi.setgift(leviGifts);

    }
    public static void start() throws InterruptedException, IOException {
        System.out.println("Hi welcome to Safoi's game");
        System.out.println("This game have 10 rooms");
        Thread.sleep(500);
        for (Room room : rooms) {
            System.out.println(room.getRoomName());
            enterToContinue();
        }
        System.out.println("You start with this stats");
        player.showStats();
        enterToContinue();
        principalMenu();
    }
    public static void principalMenu() throws IOException, InterruptedException {
        System.out.println("What are you gonna do?");
        System.out.println("Show your stats: 0");
        System.out.println("Inventory Menu: 1");
        int numberOfRoom = 1;
        for (Room room: rooms) {
            if((room.getDificulty()) <= player.getCurrentRoom()){
                numberOfRoom++;
                System.out.println(room.getRoomName() + ": " + (numberOfRoom));
            }
        }
        int responseUser = verifyUserInt(numberOfRoom);
        userWorld(responseUser);
    }
    public static void inventoryMenu() throws IOException, InterruptedException {

        int allInventory = player.getInventory().size();
        int userInt;
        do{
            player.showInventory();
            System.out.println("Use that item: numberOfIndex");
            System.out.println("Principal menu " + allInventory + 1);
            userInt = verifyUserInt(allInventory + 1);
        }while(userInt != (allInventory + 1));
        principalMenu();;
    }
    public static void userWorld(int option) throws IOException, InterruptedException {
        switch (option) {
            case 0:
                player.showStats();
                principalMenu();
                break;
            case 1:
                inventoryMenu();
                break;
            case 2:
                theRelaxationRoom();
                break;
            case 3:
                theSerenitySuite();
                break;
            case 4:
                theHarmonyChamber();
                break;
            case 5:
                theSilentRetreat();
                break;
            case 6:
                theTwilightChamber();
                break;
            case 7:
                theMysteryRoom();
                break;
            case 8:
                theShadowedQuarters();
                break;
            case 9:
                theHauntedHall();
                break;
            case 10:
                theChamberofHorrors();
                break;
            case 11:
                break;
        }
    }

    /**
     * In this function the user have to use enter to continue
     * */
    public static void enterToContinue() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Press Enter to continue...");

        String input = reader.readLine();

        System.out.println("Continuing...");
    }

    /**
     * Get a Random object from our ArrayList call all objects
     * if the object is common have more chance to appear ond so on
     * @return the object selected
     */
    public static Object getRandomObject(){
        Random random = new Random();
        ArrayList<Object> randomObj = new ArrayList<>();
        double randomValue = Math.random() * 100;
        if(randomValue < 70){
            for (Object obj: allObjects) {
                if(obj.getType().equals("commom")){
                    randomObj.add(obj);
                }
            }
        } else if (randomValue < 90) {
            for (Object obj: allObjects) {
                if(obj.getType().equals("special")){
                    randomObj.add(obj);
                }
            }
        } else if (randomValue < 98) {
            for (Object obj: allObjects) {
                if(obj.getType().equals("epic")){
                    randomObj.add(obj);
                }
            }
        } else{
            for (Object obj: allObjects) {
                if(obj.getType().equals("legendary")){
                    randomObj.add(obj);
                }
            }
        }
        int indexRandom = random.nextInt(randomObj.size());
        return randomObj.get(indexRandom);
    }
    public static int verifyUserInt(int options){
        int userInt;
        while(true){
            if(scanner.hasNextInt()){
                userInt = scanner.nextInt();
                if (userInt > options){
                    System.out.println("It's not an option");
                    scanner.nextLine();
                    continue;
                }
                scanner.nextLine();
                break;
            } else{
                System.out.println("Use an integer");
                scanner.nextLine();
            }
        }
        return userInt;
    }
    public  static void roomMenu(int index, int d1, int d2) throws IOException, InterruptedException {
        System.out.println("Welcome to" + rooms.get(index));
        System.out.println("Here is " + allAllies.get(index).getName());
        System.out.println("Talk to" + allAllies.get(index).getName());
        boolean isTrue = false;
        do{
            System.out.println("Knowledge stats: 0");
            System.out.println("Conversation: 1");
            System.out.println("Undestanding: 2 " + d1 + " knowledge");
            System.out.println("Learning: 3 " + d2 + " knowledge");
            System.out.println("Principal Menu: 4");
            int userInt = verifyUserInt(4);
            switch (userInt){
                case 0:
                    System.out.println(player.getKnowledge());
                    break;
                case 1:
                    isTrue = talkTo(1,index, 0);
                    break;
                case 2:

                    isTrue =  talkTo(2,index, d1);
                    break;
                case 3:
                    isTrue = talkTo(3,index, d1);
                    break;
                case 4:
                    principalMenu();
                    break;
            }
        }while(!isTrue);

        roomSecondMenu(index);
    }
    public  static void roomSecondMenu(int index) throws IOException, InterruptedException {
        System.out.println("In this room there are " + rooms.get(index).getEnemies().size() + " enemies");
        System.out.println("What do you wanna do?");
        int response;
        do{
            Thread.sleep(500);
            System.out.println("Show stats: 0");
            System.out.println("Fight: 1");
            System.out.println("Retire: 2 (principal menu)");
            response = verifyUserInt(2);
            enterToContinue();
            if(response == 0){
                player.showStats();
            }
        }while(response == 0);

        switch (response){
            case 1:
                fightMenu(index);
                break;
            case 2:
                principalMenu();
                break;
        }

    }
    public static boolean dodgeAttack(double dodgePercentage){
        double random = Math.random();
        return dodgePercentage <= random;
    }
    public static void fightMenu(int index) throws IOException, InterruptedException {
        ArrayList<Enemy> enemies = rooms.get(index).getEnemies();
        ArrayList<Integer> currentHealth = new ArrayList<>();
        ArrayList<Integer> currentAttack = new ArrayList<>();
        ArrayList<Integer> currentDefense = new ArrayList<>();
        ArrayList<Double> currentDodge = new ArrayList<>();

        int enemyIndex = 0;
        for (Enemy enemy : enemies) {
            currentHealth.add(enemy.getHealth());
            currentAttack.add(enemy.getAttack());
            currentDefense.add(enemy.getDefense());
            currentDodge.add(enemy.getDodgeChance());

            if(enemy.getHealth() == 0){
                continue;
            } else{
                enemyIndex = enemies.indexOf(enemy);
                break;
            }
        }
        Enemy enemyFighter = rooms.get(index).getEnemies().get(enemyIndex);
        System.out.println("You're gonna fight with this motherfucker");
        enemyFighter.showStats();
        enterToContinue();
        System.out.println("You attack first");
        while(enemyFighter.getHealth() >= 0 || player.getHealth() >= 0){
            int netPlayerDamage = Math.max(enemyFighter.getAttack() - player.getDefense(), 0);
            int netEnemyDamage = Math.max(player.getAttack() - enemyFighter.getDefense(), 0);
            if(dodgeAttack(enemyFighter.getDodgeChance())){
                System.out.println("Esquivo tu ataque!!!");
            } else{
                enemyFighter.setHealth(enemyFighter.getHealth() - netEnemyDamage);
            }
            System.out.println("His health: " + enemyFighter.getHealth());
            enterToContinue();
            System.out.println("He's gonna attack you");
            if(dodgeAttack(player.getDodgeChance())){
                System.out.println("You dodgeeee!!!");
            } else{
                player.setHealth(player.getHealth() - netPlayerDamage);
            }
            System.out.println("Your health: " + player.getHealth());
            if(attackOrRetire()){
                principalMenu();
            }
            enterToContinue();
            System.out.println("You're gonna attack!!");
        }
        if(enemyFighter.getHealth() <= 0){
            System.out.println("Congratulations!!!");
            System.out.println("You're gifts");
            if (index == 0) index = 1;
            for (int i = 0; i <= (index * 2); i++) {
                Object winnerGift = getRandomObject();
                player.setInventory(winnerGift);
                enterToContinue();
            }
            if(enemies.get(enemies.size() - 1).getHealth() == 0){
                System.out.println("Congratulations!");
                System.out.println("You beat the last enemy");
                System.out.println("New room unlocked!");
                System.out.println(rooms.get(index).getRoomName());
                enterToContinue();
                for (int i = 0; i < enemies.size(); i++) {
                    enemies.get(i).setHealth(currentHealth.get(i) * 2);
                    enemies.get(i).setAttack(currentAttack.get(i) * 2);
                    enemies.get(i).setDefense(currentDefense.get(i) * 2);
                    enemies.get(i).setDodgeChance(currentDodge.get(i) * .5);
                }
                System.out.println("You can came back to this room whenever you want!");
                System.out.println("The next time wouldn't be too easy");
            }
        }
        if(player.getHealth() <= 0){
            System.out.println("Game over");
        }
        principalMenu();
    }
    public static boolean attackOrRetire(){
        int userInt;
        do{
            System.out.println("Stats: 0");
            System.out.println("Attack: 1");
            System.out.println("Retire: 2");
            userInt = verifyUserInt(2);
        }while(userInt == 0);
        return userInt == 2;
    }

    // Room function
    public static void theRelaxationRoom() throws IOException, InterruptedException {
        roomMenu(0,50,70);
    }
    public static void theSerenitySuite() throws IOException, InterruptedException {
        roomMenu(1, 80, 100);
    }
    public static void theTranquilityGarden() throws IOException, InterruptedException {
        roomMenu(2, 110, 130);
    }
    public static void theHarmonyChamber() throws IOException, InterruptedException {
        roomMenu(3, 140, 150);
    }
    public static void theSilentRetreat() throws IOException, InterruptedException {
        roomMenu(4, 160, 200);
    }
    public static void theTwilightChamber() throws IOException, InterruptedException {
        roomMenu(5, 220, 300);
    }
    public static void theMysteryRoom() throws IOException, InterruptedException {
        roomMenu(6, 350, 400);
    }
    public static void theShadowedQuarters() throws IOException, InterruptedException {
        roomMenu(7, 500, 600);
    }
    public static void theHauntedHall() throws IOException, InterruptedException {
        roomMenu(8, 650, 800);
    }
    public static void theChamberofHorrors() throws IOException, InterruptedException {
        roomMenu(9, 900, 1000);
    }
    public static boolean talkTo(int  dialog, int index, int knowledge) throws IOException {
        String[] conversation = new String[0];
        Boolean heTalked = false;
        if(dialog == 1){
            conversation = allAllies.get(index).getDialogo1();
            heTalked = true;
        }
        if(dialog == 2 && player.getKnowledge() >= knowledge){
            conversation = allAllies.get(index).getDialogo2();
            heTalked = true;
        }
        if(dialog == 3 && player.getKnowledge() >= knowledge){
            conversation = allAllies.get(index).getDialogo3();
            heTalked = true;
        }
        if(player.getKnowledge() < knowledge){
            System.out.println("You don't have enough knowledge");
        }
        for (String sentence: conversation) {
            System.out.println(sentence);
            enterToContinue();
        }
        if(dialog == 2 && allAllies.get(index).isD2() && player.getKnowledge() >= knowledge){
            System.out.println("Congratulations!!");
            System.out.println(allAllies.get(index).getName() + " have give you this");
            Object gift = allAllies.get(index).sentGift(player);
            System.out.println(gift.getEffect().toString());
            allAllies.get(index).setD2(false);
            enterToContinue();
        }
        if(dialog == 2 && !allAllies.get(index).isD2()){
            System.out.println("You already use this conversation");
        }
        if(dialog == 3 && allAllies.get(index).isD3() && player.getKnowledge() >= knowledge){
            System.out.println("Congratulations!!");
            System.out.println(allAllies.get(index) + " have give you this");
            Object gift = allAllies.get(index).sentGift(player);
            System.out.println(gift.getEffect().toString());
            System.out.println("And this!!!");
            Object gift2 = allAllies.get(index).sentGift(player);
            System.out.println(gift2.getEffect().toString());
            allAllies.get(index).setD3(false);
            enterToContinue();
        }
        if(dialog == 3 && !allAllies.get(index).isD3()){
            System.out.println("You already use this conversation");
        }
        return heTalked;
    }
}
