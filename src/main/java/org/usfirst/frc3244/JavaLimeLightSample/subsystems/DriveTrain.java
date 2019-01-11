package org.usfirst.frc3244.JavaLimeLightSample.subsystems;

import org.usfirst.frc3244.JavaLimeLightSample.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import oi.limelightvision.limelight.frc.LimeLight;



/**
 *
 */
public class DriveTrain extends Subsystem {

    private LimeLight _limelight;
    private WPI_TalonSRX motorLeft;
    private WPI_TalonSRX motorRight;
    private DifferentialDrive differentialDrive1;


    public DriveTrain() {

        _limelight = new LimeLight();

        motorLeft = new WPI_TalonSRX(0);
        addChild("MotorLeft",motorLeft);
       
        
        motorRight = new WPI_TalonSRX(1);
        addChild("MotorRight",motorRight);
        
        
        differentialDrive1 = new DifferentialDrive(motorLeft, motorRight);
        addChild("Differential Drive 1",differentialDrive1);
        differentialDrive1.setSafetyEnabled(true);
        differentialDrive1.setExpiration(0.1);
        differentialDrive1.setMaxOutput(1.0);

        
    }

    @Override
    public void initDefaultCommand() {

        setDefaultCommand(new Drive_With_Joysticks());


        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void My_DriveArchade(double xSpeed, double zRotation) {
        differentialDrive1.arcadeDrive(xSpeed, zRotation);
    }

    public LimeLight gLimeLight(){
        return _limelight;
    }
}

