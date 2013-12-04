/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.zhaw.mcag.sensor;

/**
 *
 * @author itz
 */
public interface IControlable {

	/**
	 * Place the player item on the board
	 *
	 * @param x location x axis
	 * @param y location y axis
	 */
	public void placePlayer(int x, int y);

	/**
	 * Fire a shot
	 */
	public void shoot();
}
