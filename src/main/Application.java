/*
 * 
 */
package main;

import model.player.Player;
import model.region.RegionMaze;
import terminal.Terminal;
import util.maze.MazeBuilder;
import util.maze.MazeTraverser;
import util.saver.SaverGame;
import util.text.TextMessage;
import view.View;

import com.googlecode.blacken.helper.ViewerHelper;

import control.player.ControlPlayer;

// TODO: Auto-generated Javadoc
/**
 * The Class Application.
 * 
 * @author jeremy
 */
public class Application {

	/**
	 * Checks for completed maze.
	 * 
	 * @param player
	 *            the player
	 * @param maze
	 *            the maze
	 * @return true, if successful
	 */
	public static boolean hasCompletedMaze(Player player, RegionMaze maze) {
		return maze.getRoomEnd().contains(player.getPlayerPosition());
	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		SaverGame saver = new SaverGame();

		// create models
		Terminal mazeIO = new Terminal();

		RegionMaze maze = new RegionMaze(3);
		MazeBuilder mBuilder = new MazeBuilder();
		mBuilder.create(maze);
		
		Player player = new Player(maze.getRoomStart());

		MazeTraverser trav = new MazeTraverser(maze, player);

		// create control
		ControlPlayer userInterface = new ControlPlayer(mazeIO, player);

		// create view
		new ViewerHelper(mazeIO.getTerminal(), "Lazer Slug Trivia Maze",
				TextMessage.START_MESSAGE).run();
		View view = new View(maze, player, mazeIO.getTerminal());
		while (!hasCompletedMaze(player, maze) && !player.hasQuit()
				&& maze.isTraversable()) {
			userInterface.checkCommand();
			view.refresh();

			maze.isTraversable(trav.solveMaze());
		}

		if (player.hasQuit()) {
			player.hasQuit(false);
			saver.save(maze, player);
		} else
			saver.clean();

		new ViewerHelper(mazeIO.getTerminal(), "Credits",
				TextMessage.END_MESSAGE).run();
		mazeIO.close();
	}

}