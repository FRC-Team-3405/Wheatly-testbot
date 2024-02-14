package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
// import com.revrobotics.CANSparkMax.SoftLimitDirection;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkPIDController;

public class Intake extends SubsystemBase{

    public VictorSPX m_intakeMotor1;
    public VictorSPX m_intakeMotor2;
    public CANSparkMax m_barMotor;
    public RelativeEncoder barEncoder;
    // public SparkPIDController barPID;
    private boolean deployed;
    public AnalogInput ultrasonicSensor;

    public double kP, kI, kD, kMaxOut, kMinOut, maxRPM, maxVel, maxAcc;


    public Intake(int m_barMotorId, int m_intakeMotor1ID, int m_intakeMotor2ID, int ultrasonicSensorID) {
        // SmartDashboard.putNumber("test",3);
        m_barMotor = new CANSparkMax(m_barMotorId, com.revrobotics.CANSparkLowLevel.MotorType.kBrushless);
        m_intakeMotor1 = new VictorSPX(m_intakeMotor1ID);
        m_intakeMotor2 = new VictorSPX(m_intakeMotor2ID);
        ultrasonicSensor = new AnalogInput(ultrasonicSensorID);

        m_barMotor.restoreFactoryDefaults();

        barEncoder = m_barMotor.getEncoder();
        // barPID = m_barMotor.getPIDController();

        // kP = Constants.Intake.barP;
        // kI = Constants.Intake.barI;
        // kD = Constants.Intake.barD;
    
        // kMaxOut = Constants.Intake.barMaxOut;
        // kMinOut = Constants.Intake.barMinOut;

        // maxRPM = Constants.Intake.barMaxRPM;
        // maxVel = Constants.Intake.barMaxVel;
        // maxAcc = Constants.Intake.barMaxAcc;

        // set PID coefficients
        // barPID.setP(kP);
        // barPID.setI(kI);
        // barPID.setD(kD);
        // barPID.setIZone(0);
        // barPID.setFF(0);
        // barPID.setOutputRange(kMinOut, kMaxOut);


        m_barMotor.enableSoftLimit(CANSparkMax.SoftLimitDirection.kForward, true);
        m_barMotor.enableSoftLimit(CANSparkMax.SoftLimitDirection.kReverse, true);
    
        m_barMotor.setSoftLimit(CANSparkMax.SoftLimitDirection.kForward, 15);
        m_barMotor.setSoftLimit(CANSparkMax.SoftLimitDirection.kReverse, 0);
    
        SmartDashboard.putBoolean("Forward Soft Limit Enabled",
                                  m_barMotor.isSoftLimitEnabled(CANSparkMax.SoftLimitDirection.kForward));
        SmartDashboard.putBoolean("Reverse Soft Limit Enabled",
                                  m_barMotor.isSoftLimitEnabled(CANSparkMax.SoftLimitDirection.kReverse));                          
        SmartDashboard.putNumber("Forward Soft Limit",
                                  m_barMotor.getSoftLimit(CANSparkMax.SoftLimitDirection.kForward));
        SmartDashboard.putNumber("Reverse Soft Limit",
                                  m_barMotor.getSoftLimit(CANSparkMax.SoftLimitDirection.kReverse));
        
        // barPID.setReference(-0.3, CANSparkMax.ControlType.kDutyCycle);
    }

    public void startIntake() {
        m_intakeMotor1.set(VictorSPXControlMode.PercentOutput, Constants.Intake.intakeVel);
        m_intakeMotor2.set(VictorSPXControlMode.PercentOutput, Constants.Intake.intakeVel);
        // barPID.setReference(0.3, CANSparkMax.ControlType.kDutyCycle);
        m_barMotor.enableSoftLimit(CANSparkMax.SoftLimitDirection.kForward, true);
        m_barMotor.enableSoftLimit(CANSparkMax.SoftLimitDirection.kReverse, false);
        m_barMotor.set(0.3);
        
        System.out.println("Start");
    }
    
    public void endIntake() {
        m_intakeMotor1.set(VictorSPXControlMode.PercentOutput, 0);
        m_intakeMotor2.set(VictorSPXControlMode.PercentOutput, 0);
        // barPID.setReference(-0.3, CANSparkMax.ControlType.kDutyCycle);
        m_barMotor.enableSoftLimit(CANSparkMax.SoftLimitDirection.kForward, false);
        m_barMotor.enableSoftLimit(CANSparkMax.SoftLimitDirection.kReverse, true);
        m_barMotor.set(-0.3);
        System.out.println("End");
    }

    public void runIntake() {
        // m_barMotor.enableSoftLimit(CANSparkMax.SoftLimitDirection.kForward, SmartDashboard.getBoolean("Forward Soft Limit Enabled", true));
        // m_barMotor.enableSoftLimit(CANSparkMax.SoftLimitDirection.kReverse, SmartDashboard.getBoolean("Reverse Soft Limit Enabled", true));
        m_barMotor.setSoftLimit(CANSparkMax.SoftLimitDirection.kForward, (float)SmartDashboard.getNumber("Forward Soft Limit", 15));
        m_barMotor.setSoftLimit(CANSparkMax.SoftLimitDirection.kReverse, (float)SmartDashboard.getNumber("Reverse Soft Limit", 0));
    }

    public void breakIntake(){
        m_intakeMotor1.setNeutralMode(NeutralMode.Brake);
        m_intakeMotor2.setNeutralMode(NeutralMode.Brake);
    }

    public boolean checkForNote() {
        // return (ultrasonicSensor.getValue() <= Constants.Intake.noteDetectionDistance);
        return false;
    }

    public void pushIntake(boolean stop) {
        if(!stop) {
        m_intakeMotor1.set(VictorSPXControlMode.PercentOutput, -0.3);
        m_intakeMotor2.set(VictorSPXControlMode.PercentOutput, -0.3);
        } else {
        m_intakeMotor1.set(VictorSPXControlMode.PercentOutput, 0);
        m_intakeMotor2.set(VictorSPXControlMode.PercentOutput, 0);
        }
    }

    public void toggleDeploy() {
        if(!deployed) {
            deployed = true;
            startIntake();
        } else {
            deployed = false;
            endIntake();
        }
    }

    public void setDeploy(boolean mode) {
        if(mode && !deployed) {
            deployed = true;
        } else if(!mode && deployed) {
            deployed = false;
        }
    }

    public boolean getMode() {
        return deployed;
    }
    


}
