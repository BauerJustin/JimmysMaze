import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class AnimatedSprite extends Sprite {
	
	private int currentFrame = 0;
	private long elapsedTime = 0;
	private final int FRAMES = 150;
	private double framesPerSecond = 30;
	private double milliSecondsPerFrame = 1000 / framesPerSecond;
	protected Image[] frames = new Image[FRAMES];
	private int VELOCITY = 2000;
			
	public AnimatedSprite(double currentX, double currentY, double framesPerSecond) {

		super();
		this.framesPerSecond = framesPerSecond;
		this.milliSecondsPerFrame = 1000 / framesPerSecond;

		long startTime = System.currentTimeMillis();
		
		this.currentX = currentX;
		this.currentY = currentY;		
		
		for (int frame = 0; frame < FRAMES; frame++) {
			String filename = "res/animated-earth/frame_" + String.format("%03d", frame) + "_delay-0.04s.gif";
			try {
				frames[frame] = ImageIO.read(new File(filename));
			}
			catch (IOException e) {
				System.out.println(e.toString());
			}		
		}
		
		IMAGE_WIDTH = frames[0].getWidth(null);
		IMAGE_HEIGHT = frames[0].getHeight(null);
		
		System.out.println(String.format("AnimatedSprite() elapsed time: %.3f seconds", (System.currentTimeMillis() - startTime) / 1000.0));		
	}
	
		
	public void setBarriers(ArrayList<Rectangle> barriers) {
		this.barriers = barriers;
	}
	
	public void setPlayers(ArrayList<Sprite> players) {
		this.sprites = players;
	}
	

	@Override
	public long getHeight() {
		return frames[currentFrame].getHeight(null);
	}

	@Override
	public long getWidth() {		
		return frames[currentFrame].getWidth(null);
	}	
	
	public double getMinX() {
		return currentX;
	}

	@Override
	public double getMaxX() {
		// TODO Auto-generated method stub
		return currentX + IMAGE_WIDTH;
	}

	public void setMinX(double currentX) {
		this.currentX = currentX;
	}

	public void setMinY(double currentY) {
		this.currentY = currentY;
	}

	public double getMinY() {
		return currentY;
	}

	@Override
	public double getMaxY() {
		// TODO Auto-generated method stub
		return currentY + IMAGE_HEIGHT;
	}
	

	@Override
	public Image getImage() {
		return frames[currentFrame];
//		return rotatedImage;
	}
		
	@Override
	public void update(KeyboardInput keyboard, long actual_delta_time) {

		double newX = this.currentX;
		double newY = this.currentY;
		
		elapsedTime += actual_delta_time;
		long elapsedFrames = (long) (elapsedTime / milliSecondsPerFrame);
		currentFrame = (int) (elapsedFrames % FRAMES);
		

		
		//LEFT	
		if (keyboard.keyDown(37)) {
			newX -= actual_delta_time * 0.001 * VELOCITY;
		}
		//UP
		if (keyboard.keyDown(38)) {
			newY -= actual_delta_time * 0.001 * VELOCITY; //moves 50 pixels per second;
			
		}
		// RIGHT
		if (keyboard.keyDown(39)) {
			newX +=  actual_delta_time * 0.001 * VELOCITY;
		}
		// DOWN
		if (keyboard.keyDown(40)) {
			newY +=  actual_delta_time * 0.001 * VELOCITY;
		}
		
		if (checkCollisionWithBarrier(newX, newY) == false) {
			this.currentX = newX;
			this.currentY = newY;
		}
	}			

	public boolean checkCollisionWithPlayers(double x, double y) {
		boolean isColliding = false;
		return isColliding;		
	}

	@Override
	public boolean checkCollisionWithBarrier(double x, double y) {
		boolean isColliding = false;
		return isColliding;		
	}

	@Override
	public void setSprites(ArrayList<Sprite> staticSprites) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setKeyboard(KeyboardInput keyboard) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkCollisionWithSprites(double x, double y) {
		// TODO Auto-generated method stub
		return false;
	}

}
