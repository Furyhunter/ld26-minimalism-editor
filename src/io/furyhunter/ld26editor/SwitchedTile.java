package io.furyhunter.ld26editor;

import java.awt.Color;
import java.awt.Graphics;
import java.io.PrintWriter;

public class SwitchedTile extends Entity {
	
	public SwitchedTile() {
		width = 64;
		height = 64;
	}
	
	@Override
	public void draw(Graphics g, int offx, int offy) {
		g.setColor(new Color(127, 0, 127));
		g.fillRect(Math.round(x) - offx, Math.round(y) - offy, Math.round(width), Math.round(height));
	}
	
	@Override
	public void save(PrintWriter write) {
		write.printf("SwitchedTile %f %f %s\n", x, y, metadata);
	}
}
