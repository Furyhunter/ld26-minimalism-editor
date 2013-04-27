package io.furyhunter.ld26editor;

public enum EntityTypes {
	Tile("Tile", "Tile"),
	Player("Player", "Player");
	
	String simple;
	String display;
	
	private EntityTypes(String simple, String display) {
		this.simple = simple;
		this.display = display;
	}
}
