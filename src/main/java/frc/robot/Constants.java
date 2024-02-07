// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

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
    public static final double noteDetectionDistance = 30;
    public static final double barP = 5e-5;
    public static final double barI = 1e-6;
    public static final double barD = 0;

    public static final double barMaxOut = 1;
    public static final double barMinOut = -1;

    public static final double barMaxRPM = 570;
    public static final double barMaxVel = 200;
    public static final double barMaxAcc = 150;

    public static final double barOutPoint = 100;
    public static final double barInPoint = -100;

    public static final double intakeVel = 1;
}
}
