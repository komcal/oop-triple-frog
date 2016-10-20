package com.mygdx.game;

public class World {
    private Player player;
    private TripleFrog tripleFrog;
    private Board board;
 
    World(TripleFrog tripleFrog) {
        this.tripleFrog = tripleFrog;
        board = new Board();
        player = new Player(60,60, this);
        board = new Board();
    }
 
    Player getPlayer() {
        return player;
    }
    
    Board getBoard() {
    	return board;
    }
    
    public void update(float delta) {
        player.update();
    }
}
