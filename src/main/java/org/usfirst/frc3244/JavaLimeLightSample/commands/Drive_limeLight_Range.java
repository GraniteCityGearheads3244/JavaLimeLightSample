package org.usfirst.frc3244.JavaLimeLightSample.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc3244.JavaLimeLightSample.Robot;

/**
 *
 */
public class Drive_limeLight_Range extends Command {

    private double kpDistance = 0.09;
    private double m_moveValue;
    private double m_rotateValue;
  
    public Drive_limeLight_Range() {
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
  
      double ty = Robot.driveTrain.gLimeLight().getdegVerticalToTarget();
      boolean targetFound = Robot.driveTrain.gLimeLight().getIsTargetFound();
  
      if(targetFound){
        m_moveValue = ty * kpDistance;
        m_rotateValue = 0;
      }else{
        m_moveValue = 0;
        m_rotateValue = 0;
      }
  
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
  
    private double Estimated_Distance(double a2){
      double h1 = 6.0;
      double h2 = 36.0;
      double a1 = 0.0;
      return (h2-h1)/Math.tan(a1+a2);
    }
  }
  