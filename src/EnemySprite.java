import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class EnemySprite extends Sprite {
	
	private final int PROXIMITY = 200;
	private final double VELOCITY = 100;
	private PlayerSprite player;
	private int currentFrame = 0;
	private long elapsedTime = 0;
	private final int FRAMES = 4;
	private double framesPerSecond = 30;
	private double milliSecondsPerFrame = 1000 / framesPerSecond;
	protected Image[] frames = new Image[FRAMES];



	public EnemySprite(double currentX, double currentY) {
		super();

		this.milliSecondsPerFrame = 1000 / framesPerSecond;

		long startTime = System.currentTimeMillis();
		
		this.currentX = currentX;
		this.currentY = currentY;	
		try {
			frames[0] = ImageIO.read(new File("res/RoboRockHostile/RoboRock_Hostile.png"));
			frames[1] = ImageIO.read(new File("res/RoboRockHostile/RoboRock_Hostile2.png"));
			frames[2] = ImageIO.read(new File("res/RoboRockHostile/RoboRock_Hostile3.png"));
			frames[3] = ImageIO.read(new File("res/RoboRockHostile/RoboRock_Hostile4.png"));
//			defaultImage = frames[2];
			this.IMAGE_HEIGHT = 32;
			this.IMAGE_WIDTH = 32;
		}
//		catch (IOException e) {
//			System.out.println(e.toString());
//		}		
		catch (Exception e) {
			System.out.println(e.toString());
		}		
	}
	
	
	public void setPlayer(PlayerSprite player) {
		this.player = player;
	}


	@Override
	public void update(KeyboardInput keyboard, long actual_delta_time) {

		double newX = currentX;
		double newY = currentY;
		
		elapsedTime += actual_delta_time;
		long elapsedFrames = (long) (elapsedTime / milliSecondsPerFrame);
		currentFrame = (int) (elapsedFrames % FRAMES);
		
		if ((player.currentX + (player.getWidth() / 4) < this.currentX)) {
			newX -= actual_delta_time * 0.001 * VELOCITY;
		}
		if (player.currentY + (player.getHeight() / 4) < this.currentY) {
			newY -= actual_delta_time * 0.001 * VELOCITY;
		}
		if ((player.currentX + (player.getWidth() / 4)  > this.currentX)) {
			newX += actual_delta_time * 0.001 * VELOCITY;
		}
		if (player.currentY + (player.getHeight() / 4) > this.currentY) {
			newY += actual_delta_time * 0.001 * VELOCITY;
		}
		if (checkCollisionWithBarrier(newX, newY) == false) {
			this.currentX = newX;
			this.currentY = newY;
		} 
	}

	@Override
	public double getMinX() {
		return currentX;
	}

	@Override
	public double getMaxX() {
		return currentX + IMAGE_WIDTH;
	}

	@Override
	public double getMinY() {
		return currentY;
	}

	@Override
	public double getMaxY() {
		return currentY + IMAGE_HEIGHT;
	}

	@Override
	public long getHeight() {
		// TODO Auto-generated method stub
		return IMAGE_HEIGHT;
	}

	@Override
	public long getWidth() {
		// TODO Auto-generated method stub
		return IMAGE_WIDTH;
	}

	@Override
	public Image getImage() {
		return frames[currentFrame];
	}

	@Override
	public void setMinX(double currentX) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMinY(double currentY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBarriers(ArrayList<Rectangle> barriers) {
		this.barriers = barriers;
	}

	@Override
	public void setSprites(ArrayList<Sprite> sprites) {
		this.sprites = sprites;
	}

	@Override
	public void setKeyboard(KeyboardInput keyboard) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkCollisionWithSprites(double x, double y) {
		
		boolean colliding = false;

		boolean toLeft = (x + this.IMAGE_WIDTH) < player.getMinX();
		boolean toRight = x > player.getMaxX();
		boolean collidingX = !( toLeft || toRight);
		boolean above = (y + this.IMAGE_HEIGHT) < player.getMinY();
		boolean below = y > player.getMaxY();
		boolean collidingY = !( above || below);
		if (collidingX && collidingY) {
			colliding = true;			
		}		
		return colliding;	
	}

	@Override
	public boolean checkCollisionWithBarrier(double x, double y) {
		
		boolean colliding = false;

		for (Rectangle barrier : barriers) {
			boolean toLeft = (x + this.IMAGE_WIDTH) < barrier.getMinX();
			boolean toRight = x > barrier.getMaxX();
			boolean collidingX = !( toLeft || toRight);
			boolean above = (y + this.IMAGE_HEIGHT) < barrier.getMinY();
			boolean below = y > barrier.getMaxY();
			boolean collidingY = !( above || below);
			if (collidingX && collidingY) {
				colliding = true;
				break;
			}			
		}		
		return colliding;		
	}

}
