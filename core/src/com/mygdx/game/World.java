package com.mygdx.game;

public class World {
    private Player player;
    private TripleFrog tripleFrog;
    private Board board;
    private Score score;
 
    World(TripleFrog tripleFrog) {
        this.tripleFrog = tripleFrog;
        player = new Player(60, 60, this);
        score = new Score(0);
        board = new Board(score);
        
    }
 
    Player getPlayer() {
        return player;
    }
    
    Board getBoard() {
    	return board;
    }
    
    Score getScore() {
    	return score;
    }
    
    public void update(float delta) {
        player.update();
    }
}
