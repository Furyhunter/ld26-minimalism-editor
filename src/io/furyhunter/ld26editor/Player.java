package io.furyhunter.ld26editor;

import java.awt.Color;
import java.awt.Graphics;
import java.io.PrintWriter;

public class Player extends Entity {
	
	public Player() {
		width = 32;
		height = 32;
	}
	
	@Override
	public void draw(Graphics g, int offx, int offy) {
		g.setColor(Color.BLUE);
		
		g.fillRect(Math.round(x) - offx, Math.round(y) - offy, Math.round(width), Math.round(height));
	}

	@Override
	public void save(PrintWriter write) {
		write.printf("Player %f %f\n", x, y);
	}
}
