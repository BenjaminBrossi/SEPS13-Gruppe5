/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.zhaw.mcag.adapter;

import ch.zhaw.mcag.Config;
import ch.zhaw.mcag.GameContext;
import ch.zhaw.mcag.model.Dimension;
import ch.zhaw.mcag.model.Position;
import ch.zhaw.mcag.sensor.IControlable;

/**
 * 
 * @author itz
 */
public class SensorAdapter implements IControlable {
	private GameContext gameContext;

	public SensorAdapter(GameContext context) {
		this.gameContext = context;
	}

	public void placePlayer(int currentX, int currentY) {
		// placement logic
		int dx, dy;
		// normalize
		if (currentX < -100) {
			currentX = -100;
		} else if (currentX > 100) {
			currentX = 100;
		}

		if (currentY < 100) {
			currentY = 100;
		} else if (currentY > 250) {
			currentY = 250;
		}

		currentX += 100;
		currentY -= 100;

		Dimension dPlayer = gameContext.getPlayer().getDimension();
		Dimension dBoard = Config.getBoardDimension();
		int maxWidth = dBoard.getLength() - dPlayer.getLength();
		int maxHeight = dBoard.getHeight() - dPlayer.getHeight();
		dx = (int) (currentX / 2 * maxWidth / 100);
		dy = maxHeight - (int) ((currentY / 1.50) * maxHeight / 100);

		// end logic
		Position position = new Position(dx, dy);
		this.gameContext.getPlayer().setPosition(position);
	}

	public void shoot() {
		this.gameContext.getPlayer().shoot(gameContext.getShots());
	}
}
