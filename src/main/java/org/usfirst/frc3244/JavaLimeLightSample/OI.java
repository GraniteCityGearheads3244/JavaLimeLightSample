package org.usfirst.frc3244.JavaLimeLightSample;

import org.usfirst.frc3244.JavaLimeLightSample.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import org.usfirst.frc3244.JavaLimeLightSample.subsystems.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    public JoystickButton joystickButton1;
    public JoystickButton joystickButton2;
    public JoystickButton joystickButton3;
    public Joystick joystick1;


    public OI() {

        joystick1 = new Joystick(0);
        
        joystickButton3 = new JoystickButton(joystick1, 3);
        joystickButton3.whileHeld(new Drive_limeLight_Aim_n_Range());
        joystickButton2 = new JoystickButton(joystick1, 2);
        joystickButton2.whileHeld(new Drive_limeLight_Range());
        joystickButton1 = new JoystickButton(joystick1, 1);
        joystickButton1.whileHeld(new Drive_limeLight_Aim());


        // SmartDashboard Buttons
        SmartDashboard.putData("Drive_limeLight_Aim", new Drive_limeLight_Aim());
        SmartDashboard.putData("Drive_limeLight_Ain_n_Range", new Drive_limeLight_Aim_n_Range());
        SmartDashboard.putData("Drive_limeLight_Range", new Drive_limeLight_Range());
    }

    public Joystick getJoystick1() {
        return joystick1;
    }


}

