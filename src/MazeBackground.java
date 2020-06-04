
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class MazeBackground extends Background {

    private Image wall;
    private Image path;
    private int backgroundWidth = 0;
    private int backgroundHeight = 0;
    private int maxCols = 0;
    private int maxRows = 0;
    
    public static final int WORLD_HEIGHT = 1600;
    public static final int WORLD_WIDTH = 1600;
    public static int START_X = 1200;
    public static int START_Y = 600;

	private int map[][] = new int[][] { 
		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
		{1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		{1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		{1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		{1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,1,1,1,1,0,0,0,1},
		{1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1},
		{1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1},
		{1,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1},
		{1,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1},
		{1,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		{1,0,0,0,1,1,1,1,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		{1,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		{1,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1},
		{1,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1},
		{1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1},
		{1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1},
		{1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,1,1,1,1,0,0,0,1,0,0,0,1},
		{1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1},
		{1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1},
		{1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1},
		{1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1},
		{1,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,1},
		{1,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,1},
		{1,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,1},
		{1,0,0,0,1,1,1,1,1,1,1,1,1,0,0,0,1,0,0,0,1,1,1,1,1,0,0,0,1,0,0,0,1},
		{1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1},
		{1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1},
		{1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1},
		{1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,1,1,1,1,1,1,1,1,0,0,0,1,0,0,0,1},
		{1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		{1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		{1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
	};
    
    public MazeBackground() {
    	try {
    		this.wall = ImageIO.read(new File("res/wall.jpg"));
    		this.path = ImageIO.read(new File("res/path.png"));    		
    		backgroundWidth = 50;
    		backgroundHeight = 50;    		
    	}
    	catch (IOException e) {
    		//System.out.println(e.toString());
    	}
    	maxRows = map.length - 1;
    	maxCols = map[0].length - 1;
    }
	
	public Tile getTile(int col, int row) {
		
		Image image = null;
		
		if (row < 0 || row > maxRows || col < 0 || col > maxCols) {
			image = wall;
		}
		else if (map[row][col] == 0) {
			image = path;
		}
		else if (map[row][col] == 1) {
			image = wall;
		}
		else {
			image = null;
		}
			
		int x = (col * backgroundWidth);
		int y = (row * backgroundHeight);
		
		Tile newTile = new Tile(image, x, y, backgroundWidth, backgroundHeight, false);
		
		return newTile;
	}
		
	public int getHorizontal(int x) {
		//which tile is x sitting at?
		return 0;
	}

	public int getCol(int x) {
		//which col is x sitting at?
		int col = 0;
		if (backgroundWidth != 0) {
			col = (x / backgroundWidth);
			if (x < 0) {
				return col - 1;
			}
			else {
				return col;
			}
		}
		else {
			return 0;
		}
	}
	
	public int getRow(int y) {
		//which row is y sitting at?
		int row = 0;
		
		if (backgroundHeight != 0) {
			row = (y / backgroundHeight);
			if (y < 0) {
				return row - 1;
			}
			else {
				return row;
			}
		}
		else {
			return 0;
		}
	}
	
	public ArrayList<Rectangle> getBarriers() {
		ArrayList<Rectangle> barriers = new ArrayList<Rectangle>();
		for (int row = 0; row < map[0].length; row++) {
			for (int col = 0; col < map.length; col++) {
				if (map[col][row] == 1) {
					barriers.add(new Rectangle(row * backgroundWidth, col * backgroundHeight, backgroundWidth, backgroundHeight ));
				}
			}
		}
		return barriers;
	}
	
}
