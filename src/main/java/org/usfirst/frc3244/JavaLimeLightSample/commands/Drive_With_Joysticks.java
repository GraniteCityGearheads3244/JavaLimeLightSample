package org.usfirst.frc3244.JavaLimeLightSample.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc3244.JavaLimeLightSample.Robot;

/**
 *
 */
public class Drive_With_Joysticks extends Command {

    public Drive_With_Joysticks() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.driveTrain);

    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {

        double m_moveValue = Robot.oi.joystick1.getRawAxis(1);
        double m_rotateValue = Robot.oi.joystick1.getRawAxis(4);
        
        Robot.driveTrain.My_DriveArchade(m_moveValue, m_rotateValue);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.driveTrain.My_DriveArchade(0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
