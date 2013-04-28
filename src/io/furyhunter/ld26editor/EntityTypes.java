package io.furyhunter.ld26editor;

public enum EntityTypes {
	Tile(Tile.class, "Tile"),
	Player(Player.class, "Player"),
	SpringU(SpringU.class, "Spring Up"),
	SpringD(SpringD.class, "Spring Down"),
	SpringL(SpringL.class, "Spring Left"),
	SpringR(SpringR.class, "Spring Right"),
	Switch(Switch.class, "Switch"),
	SwitchedTile(SwitchedTile.class, "Switched Tile"),
	SmallTile(SmallTile.class, "Small Tile"),
	AboveTile(AboveTile.class, "Above Tile"),
	NextLevel(NextLevel.class, "Next Level"),
	EndGameGate(EndGameGate.class, "End Game Gate");
	
	Class<?> type;
	String display;
	
	private EntityTypes(Class<?> simple, String display) {
		this.type = simple;
		this.display = display;
	}
	
	@Override
	public String toString() {
		return display;
	}
}
