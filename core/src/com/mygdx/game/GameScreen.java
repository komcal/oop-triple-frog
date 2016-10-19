package com.mygdx.game;

import com.badlogic.gdx.ScreenAdapter;

public class GameScreen extends ScreenAdapter {
	private TripleFrog tripleFrog;
    
	public GameScreen(TripleFrog tripleFrog) {
        this.tripleFrog = tripleFrog;
    }
    @Override
    public void render(float delta) {
        System.out.println("Hello " + delta);
    }

}
