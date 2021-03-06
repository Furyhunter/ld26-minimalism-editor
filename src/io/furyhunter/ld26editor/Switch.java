package io.furyhunter.ld26editor;

import java.awt.Color;
import java.awt.Graphics;
import java.io.PrintWriter;

public class Switch extends Entity {
	
	public Switch() {
		width = 16;
		height = 16;
	}
	
	@Override
	public void draw(Graphics g, int offx, int offy) {
		g.setColor(new Color(127, 31, 31));
		g.fillRect(Math.round(x) - offx, Math.round(y) - offy, Math.round(width), Math.round(height));
	}
	
	@Override
	public void save(PrintWriter write) {
		write.printf("Switch %f %f %s\n", x, y, metadata);
	}
}
