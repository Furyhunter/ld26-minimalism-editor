package io.furyhunter.ld26editor;

public enum EntityTypes {
	Tile("Tile", "Tile"),
	Player("Player", "Player"),
	SpringU("SpringU", "Spring Up"),
	SpringD("SpringD", "Spring Down"),
	SpringL("SpringL", "Spring Left"),
	SpringR("SpringR", "Spring Right"),
	Switch("Switch", "Switch"),
	SwitchedTile("SwitchedTile", "Switched Tile"),
	SmallTile("SmallTile", "Small Tile"),
	AboveTile("AboveTile", "Above Tile");
	
	String simple;
	String display;
	
	private EntityTypes(String simple, String display) {
		this.simple = simple;
		this.display = display;
	}
	
	@Override
	public String toString() {
		return display;
	}
}
