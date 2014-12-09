package model.door;

import model.player.Player;
import model.point.Point;
//import model.question.QuestionTF;
import contracts.I_HaveDoorState;

// TODO: Auto-generated Javadoc

// TODO add interaction
public class DoorStateQuestion implements I_HaveDoorState {

//	private QuestionTF _questionTF;
	private Door _door;
	

	public DoorStateQuestion() {
//		_questionTF = new QuestionTF();
	}

	@Override
	public int getSymbol() {
		return "?".codePointAt(0);
	}

	@Override
	public int getSymbolSimple() {
		return 1;
	}

	@Override
	public void interact(Player player, Point direction) {
		player.move(Point.refuse(direction));
		_door.setDoorState(new DoorStateCleared());
	}

	@Override
	public void setdoor(Door door) {
		_door = door;
	}
}