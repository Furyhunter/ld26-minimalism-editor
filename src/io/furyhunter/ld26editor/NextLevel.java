package io.furyhunter.ld26editor;

import java.awt.Color;
import java.awt.Graphics;
import java.io.PrintWriter;

public class NextLevel extends Entity {
	
	public NextLevel() {
		width = 32;
		height = 32;
	}
	
	@Override
	public void draw(Graphics g, int offx, int offy) {
		g.setColor(new Color(31, 31, 191));
		g.fillOval(Math.round(x) - offx, Math.round(y) - offy, Math.round(width), Math.round(height));
	}
	
	@Override
	public void save(PrintWriter write) {
		write.printf("NextLevel %f %f %s\n", x, y, metadata);
	}
}
