package io.furyhunter.ld26editor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;

public class EditorPanel extends JPanel {

	private Level level;
	
	public static final int GRID_SIZE = 16;
	
	public int offx;
	public int offy;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4523300610111813322L;

	/**
	 * Create the panel.
	 */
	public EditorPanel() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					Class type = level.remove(e.getX(), e.getY());
					System.out.println(type.getName());
				}
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				repaint();
			}
		});
		level = new Level();
		
		setPreferredSize(new Dimension(640, 480));
	}
	
	public void setLevel(Level l) {
		level = l;
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		g.fillRect(0, 0, 640, 480);
		level.offx = offx;
		level.offy = offy;
		level.draw(g);
		
		g.setColor(new Color(32, 32, 32));
		for (int i = 0; i < 640; i += GRID_SIZE) {
			g.drawLine(i, 0, i, 480);
		}
		
		for (int i = 0; i < 480; i += GRID_SIZE) {
			g.drawLine(0, i, 640, i);
		}
	}
}
