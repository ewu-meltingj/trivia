package model.door;

import model.player.Player;
import model.point.Point;
import model.question.QuestionTF;
import contracts.I_HaveDoorStates;

// TODO: Auto-generated Javadoc

// TODO add interaction
public class DoorStateQuestion implements I_HaveDoorStates {

	QuestionTF _questionTF;

	public DoorStateQuestion() {
		_questionTF = new QuestionTF();
	}

	// @Override
	// public void accept(ObserveDoor viewObserveDoor) {
	// viewObserveDoor.handleState(this);
	// }

	// public QuestionTF getQuestion() {
	// return _questionTF;
	// }

	@Override
	public int getSymbol() {
		return "?".codePointAt(0);
	}

	@Override
	public int getSymbolSimple() {
		return 1;
	}

	// @Override
	// public boolean interact(Door door) {
	// door.getPassage().isStateChanged(true);
	// return false;
	// }

	@Override
	public void interactedWell(Player player, Point direction) {
	}
}