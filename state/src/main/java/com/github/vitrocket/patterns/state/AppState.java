package com.github.vitrocket.patterns.state;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

/**
 * Example "State" pattern.
 */
@Log4j2
public class AppState {

	public static void main(String[] args) {

		log.info("Example \"State\" pattern.");

		Player player = new Player();

		PlayState playState = new PlayState();
		playState.doAction(player);
		log.info(player.getState().toString());

		StopState stopState = new StopState();
		stopState.doAction(player);
		log.info(player.getState().toString());
	}
}

@NoArgsConstructor
@Getter
@Setter
class Player {
	private State state;
}

interface State {
	void doAction(Player player);
}

@Log4j2
class PlayState implements State {

	public void doAction(Player player) {
		player.setState(this);
	}

	public String toString() {
		return "Player is playing.";
	}
}

@Log4j2
class StopState implements State {

	public void doAction(Player player) {
		player.setState(this);
	}

	public String toString() {
		return "Player is stopping.";
	}
}
