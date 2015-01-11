package robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;

public class Robot extends SampleRobot {
	Talon frontLeft;
	Talon rearLeft;
	Talon frontRight;
	Talon rearRight;	
	RobotDrive myRobot;  // class that handles basic drive operations
    XBoxJoystick gamepad; // declare gamepad as a Joystick object to get Joystick functionality, but with different buttons
    
    public Robot() {
    	frontLeft = new Talon(0); //change port to appropriate PWM port on roboRIO
    	rearLeft = new Talon(1); //change port to appropriate PWM port on roboRIO
    	frontRight = new Talon(2); //change port to appropriate PWM port on roboRIO
    	rearRight = new Talon(3); //change port to appropriate PWM port on roboRIO
        myRobot = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight); // robot drivetrain functionality; takes in front left motor, rear left motor, front right motor, rear right motor ports
        gamepad = new XBoxJoystick(1); // port gamepad is plugged into
    }

    
    /**
     * Runs the motors with tank steering.
     */
    public void operatorControl() {
        myRobot.setSafetyEnabled(false);
        while (isOperatorControl() && isEnabled()) {
        	myRobot.tankDrive(gamepad.getLeftY(), gamepad.getRightY());
            Timer.delay(0.005);		// wait for a motor update time
        }
    }

}