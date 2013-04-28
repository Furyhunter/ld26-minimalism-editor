package io.furyhunter.ld26editor;

import java.awt.Graphics;
import java.io.PrintWriter;

public class Spring extends Entity {
	@Override
	public void draw(Graphics g, int offx, int offy) {
		
	}
	
	@Override
	public void save(PrintWriter write) {
		write.printf("Spring %f %f ", x, y);
	}
}
