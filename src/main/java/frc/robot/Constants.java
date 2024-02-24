// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.util.Color;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  public static final class Intake {
    public static final int RollerCAN1 = 9;
    public static final int RollerCAN2 = 10;
    public static final int ActuatorCAN = 11;
    
    public static final int forwardLim = 60;
    public static final int reversLim = 0;

    public static final double noteDetectionDistance = 30;
    public static final double barP = 5e-5;
    public static final double barI = 1e-6;
    public static final double barD = 0;

    public static final double barMaxOut = 1;
    public static final double barMinOut = -1;

    public static final double barMaxRPM = 570;
    public static final double barMaxVel = 200;
    public static final double barMaxAcc = 150;

    public static final double barOutPoint = 1000;
    public static final double barInPoint = -1000;

    public static final double intakeVel = 0.75;
    public static final double acuateVel = 1;
}
  public static final class Launcher {
    public static final int RightCAN = 13;
    public static final int LeftCAN = 12;

    public static final double LaunchV = 100;
    public static final double LaunchP = 1;

    public static final double LaunchASAPTime = 2;
    public static final double LaunchStopTime = 1;

    public static final double P = 0.08;
    public static final double I = 0.05;
    public static final double D = 0.00;

    public static final double FF = 0.000156;

    public static final double MaxOut = 1;
    public static final double MinOut = -1;

    public static final double MaxRPM = 2000;
    public static final double MaxVel = 1500;
    public static final double MaxAcc = 500;

    public static final double OutPoint = 1000;
    public static final double InPoint = -1000;
}

public static final class Mode {
        public static final double blinkTime = 5.0;
        // Mode modifiers, in percentages, controlor input is multiplied by these
        // max forward speed (1) * 40% speed (.40) = .40 output
        public static final class Modifiers {
            public static final class Intake {
                public static final double driveSpeed = 0.4;
                public static final double rotSpeed = 0.4;
            }
            public static final class Lock {
                public static final double driveSpeed = 0.3;
                public static final double rotSpeed = 0.0;
            }
        }

        public static final class Colors {
            public static final Color D = Color.kPurple; // Default Color
            public static final Color I = Color.kRed;    // Intake Color
            public static final Color IO = Color.kDarkRed;    // Intake Out Blink Color
            public static final Color R = Color.kOrange; // Ready/Note Color
            public static final Color RB = Color.kDarkOrange; // Ready Blink Color
            public static final Color KP = Color.kYellow;// Lock Pending color
            public static final Color K = Color.kGreen;  // Lock color
            public static final Color L = Color.kSkyBlue;// Launching color

            public static final Color C = Color.kYellow; // Climber Blink Color
            public static final Color CE = Color.kRed;   // Climber Extenidng other Blink Color
            public static final Color CR = Color.kOrange;   // Climber Ready other Blink Color
            public static final Color CC = Color.kSkyBlue;   // Climber Climbing other Blink Color
            public static final Color CL = Color.kGreen;   // Climber Locked other Blink Color

        }
    }
}
