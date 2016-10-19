package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	private TripleFrog tripleFrog;
	private Texture playerImg;
	public World world;
	private Player player;
	
	public WorldRenderer(TripleFrog tripleFrog, World world) {
        this.tripleFrog = tripleFrog;
        this.world = world;
        this.player = world.getPlayer();
 
        playerImg = new Texture("player.png");
    }
	
    public void render(float delta) {
        SpriteBatch batch = tripleFrog.batch;
        batch.begin();
        Vector2 pos = player.getPosition();
        batch.draw(playerImg, pos.x, pos.y);
        batch.end();
    }
}
