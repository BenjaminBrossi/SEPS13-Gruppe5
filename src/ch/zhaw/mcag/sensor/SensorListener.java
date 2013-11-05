/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.zhaw.mcag.sensor;

import com.leapmotion.leap.*;

/**
 * 
 * @author sam
 */
public class SensorListener extends Listener {
	private IControlable adapter;

	public SensorListener(IControlable controller) {
		this.adapter = controller;
	}

	@Override
	public void onInit(Controller controller) {
		System.out.println("Initialized");
	}

	@Override
	public void onConnect(Controller controller) {
		// check controller configuration to set
		// sensor as controller
		System.out.println("Connected!");
	}

	@Override
	public void onDisconnect(Controller controller) {
		// if controller is disconnected inform game to
		// automatically switch controller to keyboard that
		// the user can continue the game with the keyboard
		System.out.println("Disconnected");
	}

	@Override
	public void onExit(Controller controller) {
		System.out.println("Sensor has left the building!");
	}

	@Override
	public void onFrame(Controller controller) {
		Frame frame = controller.frame();

		if (!frame.hands().isEmpty()) {
			// take the first hand
			Hand hand = frame.hands().get(0);

			Vector position = hand.palmPosition();
			adapter.placePlayer((int) position.getX(), (int) position.getY());
		}

	}
}
