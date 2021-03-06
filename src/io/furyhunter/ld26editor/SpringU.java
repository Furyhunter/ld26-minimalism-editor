package io.furyhunter.ld26editor;

import java.awt.Color;
import java.awt.Graphics;
import java.io.PrintWriter;

public class SpringU extends Spring {
	public SpringU() {
		width = 32;
		height = 16;
	}
	
	@Override
	public void save(PrintWriter write) {
		super.save(write);
		write.printf("0\n");
	}
	
	@Override
	public void draw(Graphics g, int offx, int offy) {
		g.setColor(Color.GREEN);
		g.fillRect(Math.round(x) - offx, Math.round(y) - offy, 32, 8);
		g.setColor(Color.GRAY);
		g.fillRect(Math.round(x) - offx + 8, Math.round(y) - offy + 8, 16, 8);
	}
}
