package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends ScreenAdapter {
	private TripleFrog tripleFrog;
	private Texture playerImg;
	private Player player;
	private WorldRenderer worldRenderer;
	public World world;
    
	public GameScreen(TripleFrog tripleFrog) {
        this.tripleFrog = tripleFrog;
        world = new World(tripleFrog);
        player = world.getPlayer();
        worldRenderer = new WorldRenderer(tripleFrog, world);
    }
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    	update(delta);
    	worldRenderer.render(delta);
    	
    }
    private void update(float delta) {
        if(Gdx.input.isKeyPressed(Keys.UP)) {
            player.setNextDirection(player.DIRECTION_UP);
        }
        else if(Gdx.input.isKeyPressed(Keys.DOWN)) {
            player.setNextDirection(player.DIRECTION_DOWN);
        }
        else if(Gdx.input.isKeyPressed(Keys.LEFT)) {
            player.setNextDirection(player.DIRECTION_LEFT);
        }
        else if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
            player.setNextDirection(player.DIRECTION_RIGHT);
        }
		else {
			player.setNextDirection(player.DIRECTION_STILL);
		}
        world.update(delta);
    }

}
