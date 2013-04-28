package io.furyhunter.ld26editor;

import java.awt.Color;
import java.awt.Graphics;
import java.io.PrintWriter;

public class SmallTile extends Entity {
	
	public SmallTile() {
		width = 16;
		height = 16;
	}
	
	@Override
	public void draw(Graphics g, int offx, int offy) {
		g.setColor(new Color(128, 128, 128));
		g.fillRect(Math.round(x) - offx, Math.round(y) - offy, Math.round(width), Math.round(height));
	}
	
	@Override
	public void save(PrintWriter write) {
		write.printf("SmallTile %f %f\n", x, y);
	}
}
