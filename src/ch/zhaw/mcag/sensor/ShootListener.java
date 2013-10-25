/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.zhaw.mcag.sensor;

import ch.zhaw.mcag.model.creature.Player;
import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Hand;
import com.leapmotion.leap.Listener;

/**
 *
 * @author sam
 */
public class ShootListener extends Listener {
    private Player player;
    
    public ShootListener(Player player){
        this.player = player;
    }
    
    @Override
    public void onInit(Controller controller){
        System.out.println("Initialized");
    }
    
    @Override
    public void onConnect(Controller controller){
        // check controller configuration to set
        // sensor as controller
        System.out.println("Connected!");
    }
    
    @Override
    public void onDisconnect(Controller controller){
        // if controller is disconnected inform game to
        // automatically switch controller to keyboard that
        // the user can continue the game with the keyboard
        System.out.println("Disconnected");
    }
    
    @Override
    public void onExit(Controller controller){
        System.out.println("Sensor has left the building!");
    }
    
    @Override
    public void onFrame(Controller controller){
        Frame frame = controller.frame();
        
        if(!frame.hands().isEmpty())
        {
            // take the first hand
            Hand hand = frame.hands().get(0);
            
            if(hand.fingers().isEmpty()){
                //shoot
                System.out.println("Shoot!");
                this.player.shoot();
            }
        }
        
    }
}
