package robot;

import edu.wpi.first.wpilibj.Joystick;

public class XBoxJoystick {
        private Joystick joystick;
        private int port;

        private final double DEAD_ZONE = 0.08; // Chief Delphi said 0.05;

        public XBoxJoystick(int port) {
                this.port = port;
                this.joystick = new Joystick(port);
        }

        public double getLeftX() {
                return correctDeadSpot(joystick.getRawAxis(1));
        }

        public double getLeftY() {
                return correctDeadSpot(joystick.getRawAxis(2));
        }

        public double getZ() {
                return joystick.getRawAxis(3);
        }

        public double getRightX() {
                return correctDeadSpot(joystick.getRawAxis(4));
        }

        public double getRightY() {
                return correctDeadSpot(joystick.getRawAxis(5));
        }

        public double getDpadX() {
                return joystick.getRawAxis(6);
        }

        // WARNING this doesn't work with vanilla driver station
        public double getDpadY() {
                return joystick.getRawAxis(7);
        }

        public boolean getAButton() {
                return getButton(1);
        }

        public boolean getBButton() {
                return getButton(2);
        }

        public boolean getXButton() {
                return getButton(3);
        }

        public boolean getYButton() {
                return getButton(4);
        }

        public boolean getLBButton() {
                return getButton(5);
        }

        public boolean getRBButton() {
                return getButton(6);
        }

        public boolean getBackButton() {
                return getButton(7);
        }

        public boolean getStartButton() {
                return getButton(8);
        }

        public boolean getLSButton() {
                return getButton(9);
        }

        public boolean getRSButton() {
                return getButton(10);
        }

        private double correctDeadSpot(double value) {
                if (Math.abs(value) < DEAD_ZONE)
                        return 0;
                return value;
        }

        private boolean getButton(int buttonNumber) {
                return joystick.getRawButton(buttonNumber);
        }

}