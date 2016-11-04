package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	private TripleFrog tripleFrog;
	private Texture playerImg;
	public World world;
	private Player player;
	private BoardRenderer boardRenderer;
    public static final int BLOCK_SIZE = 40;
    private Texture[] arrayImage = {
    		new Texture("lotus0.png"),
    		new Texture("lotus1.png"),
    		new Texture("lotus2.png"),
    		new Texture("lotus3.png"),
    		new Texture("frog.png")
    };
    private Texture howtoImage = new Texture("howto.png");
	
	public WorldRenderer(TripleFrog tripleFrog, World world) {
        this.tripleFrog = tripleFrog;
        this.world = world;
        this.player = world.getPlayer();
        boardRenderer = new BoardRenderer(tripleFrog.batch, world.getBoard());
    }
	
    public void render(float delta) {
    	boardRenderer.render();
        SpriteBatch batch = tripleFrog.batch;
        batch.begin();
        Vector2 pos = player.getPosition();
        playerImg = arrayImage[(int)player.getCurrentItem() - 48];
        batch.draw(playerImg, pos.x - BLOCK_SIZE/2, TripleFrog.HEIGHT - pos.y - BLOCK_SIZE/2);
        batch.draw(howtoImage, 500, 40);
        batch.end();
    }
}
