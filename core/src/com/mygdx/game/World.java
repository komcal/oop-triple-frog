package com.mygdx.game;

public class World {
    private Player player;
    private TripleFrog tripleFrog;
 
    World(TripleFrog tripleFrog) {
        this.tripleFrog = tripleFrog;
 
        player = new Player(100,100);
    }
 
    Player getPlayer() {
        return player;
    }
    
}
