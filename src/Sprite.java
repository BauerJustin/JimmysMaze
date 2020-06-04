import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public abstract class Sprite {

	protected Image defaultImage;
	protected double currentX = 0;
	protected double currentY = 0;
	protected int IMAGE_WIDTH = 50; // sprite.get_width()
	protected int IMAGE_HEIGHT = 50; //sprite.get_height()
	private boolean dispose = false;
	
//	double currentX = 0;
//	double currentY = 0;
//	protected Image image_default;
	
	public boolean getDispose() {
		return dispose;
	}

	public void setDispose() {
		this.dispose = true;
	}
	ArrayList<Rectangle> barriers;
	ArrayList<Sprite> sprites;
	KeyboardInput keyboard;
		
	public Sprite() {
//		try {
//			this.image_default = ImageIO.read(new File("res/player-left.png"));
//		}
//		catch (IOException e) {
//		}
	}

	public abstract void update(KeyboardInput keyboard, long actual_delta_time);
	
	public abstract double getMinX();
	public abstract double getMaxX();
	public abstract double getMinY();
	public abstract double getMaxY();
	public abstract long getHeight();
	public abstract long getWidth();
	public abstract Image getImage();
	
	public abstract void setMinX(double currentX);
	public abstract void setMinY(double currentY);
	
	public abstract void setBarriers(ArrayList<Rectangle> barriers);
	public abstract void setSprites(ArrayList<Sprite> staticSprites);
	public abstract void setKeyboard(KeyboardInput keyboard); 
	
	public abstract boolean checkCollisionWithSprites(double x, double y);
	public abstract boolean checkCollisionWithBarrier(double x, double y);
	
}
