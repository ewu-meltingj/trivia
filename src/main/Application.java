package main;

import model.player.Player;
import model.region.RegionMaze;
import terminal.Terminal;
import util.maze.Interactive;
import util.maze.MazeBuilder;
import util.maze.MazeTraverser;
import util.text.TextMessage;
import view.View;

import com.googlecode.blacken.helper.ViewerHelper;

import control.player.ControlPlayer;

public class Application {

	public static boolean hasCompletedMaze(Player player, RegionMaze maze) {
		return maze.getRoomEnd().contains(player.getPosition());
	}

	public static void main(String[] args) {

		// create models
		Terminal mazeIO = new Terminal();

		RegionMaze maze = new RegionMaze(3);
		MazeBuilder mBuilder = new MazeBuilder();

		Interactive activeElements = new Interactive(mBuilder.create(maze));

		Player player = new Player(maze.getRoomStart());

		MazeTraverser trav = new MazeTraverser(maze, player);

		// create control
		ControlPlayer playerControl = new ControlPlayer(mazeIO, player,
				activeElements);

		// create view
		new ViewerHelper(mazeIO.getTerminal(), "Lazer Slug Trivia Maze",
				TextMessage.START_MESSAGE).run();
		View view = new View(maze, player, mazeIO.getTerminal());
		while (!hasCompletedMaze(player, maze) && !player.hasQuit()
				&& maze.isTraversable()) {
			playerControl.checkCommand();
			view.refresh();

			maze.isTraversable(trav.solveMaze());

			trav.printMaze();
		}

		new ViewerHelper(mazeIO.getTerminal(), "Credits",
				TextMessage.END_MESSAGE).run();
		mazeIO.close();
	}
}