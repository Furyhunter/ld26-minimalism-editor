package io.furyhunter.ld26editor;

import java.awt.Color;
import java.awt.Graphics;
import java.io.PrintWriter;

public class SpringL extends Spring {
	public SpringL() {
		width = 32;
		height = 16;
	}
	
	@Override
	public void save(PrintWriter write) {
		super.save(write);
		write.printf("2\n");
	}
	
	@Override
	public void draw(Graphics g, int offx, int offy) {
		g.setColor(Color.GREEN);
		g.fillRect(Math.round(x) - offx, Math.round(y) - offy, 8, 32);
		g.setColor(Color.GRAY);
		g.fillRect(Math.round(x) - offx + 8, Math.round(y) - offy + 8, 8, 16);
	}
}
