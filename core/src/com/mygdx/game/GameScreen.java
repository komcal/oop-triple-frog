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
	private Board board;
	private Texture background;
	private SpriteBatch batch;
	private boolean randoming = false;

	public GameScreen(TripleFrog tripleFrog) {
		this.tripleFrog = tripleFrog;
		world = new World(tripleFrog);
		player = world.getPlayer();
		board = world.getBoard();
		worldRenderer = new WorldRenderer(tripleFrog, world);
		background = new Texture("bg.png");
		this.batch = tripleFrog.batch;
	}

	@Override
	public void render(float delta) {
		batch.begin();
		batch.draw(background, 0, 0);
		batch.end();
		update(delta);
		worldRenderer.render(delta);
	}

	private void update(float delta) {
		updatePlayerDirection();
		updateBoard();
		world.update(delta);
	}

	private void updatePlayerDirection() {
		if (Gdx.input.isKeyPressed(Keys.UP)) {
			player.setNextDirection(player.DIRECTION_UP);
		} else if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			player.setNextDirection(player.DIRECTION_DOWN);
		} else if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			player.setNextDirection(player.DIRECTION_LEFT);
		} else if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			player.setNextDirection(player.DIRECTION_RIGHT);
		} else {
			player.setNextDirection(player.DIRECTION_STILL);
		}
	}

	private void updateBoard() {
		if (Gdx.input.isKeyPressed(Keys.SPACE) && !randoming) {
			randoming = true;
		}
		
		if (!Gdx.input.isKeyPressed(Keys.SPACE) && randoming) {
			randoming = false;
			int row = player.getRow();
			int column = player.getColumn();
			if (board.isEmptyArea(row, column)) {
				board.update(row, column, player.getCurrentItem());
				player.randomItem();	
			}
		}
	}

}
