package frc.robot.subsystems;
import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkBase;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Launcher extends SubsystemBase {

    public CANSparkMax m_launcherRight;
    public SparkPIDController m_RPID;
    public CANSparkMax m_launcherLeft;
    public SparkPIDController m_LPID;
    public Intake s_Intake;
    
    public Launcher(int lMotorId, int rMotorId) {
        m_launcherLeft = new CANSparkMax(lMotorId, com.revrobotics.CANSparkLowLevel.MotorType.kBrushless);
        m_launcherRight = new CANSparkMax(rMotorId, com.revrobotics.CANSparkLowLevel.MotorType.kBrushless);
        // s_Intake = sIntake;6

        m_launcherLeft.restoreFactoryDefaults();
        m_launcherRight.restoreFactoryDefaults();

        m_LPID = m_launcherLeft.getPIDController();
        m_RPID = m_launcherRight.getPIDController();
        
        m_LPID.setP(Constants.Launcher.P);
        m_LPID.setI(Constants.Launcher.I);
        m_LPID.setD(Constants.Launcher.D);
        m_LPID.setIZone(0);
        m_LPID.setFF(Constants.Launcher.FF);
        m_LPID.setOutputRange(Constants.Launcher.MinOut, Constants.Launcher.MaxOut);

        
        m_RPID.setP(Constants.Launcher.P);
        m_RPID.setI(Constants.Launcher.I);
        m_RPID.setD(Constants.Launcher.D);
        m_RPID.setIZone(0);
        m_RPID.setFF(Constants.Launcher.FF);
        m_RPID.setOutputRange(Constants.Launcher.MinOut, Constants.Launcher.MaxOut);

        
        m_LPID.setReference(0, CANSparkMax.ControlType.kDutyCycle);
        m_RPID.setReference(0, CANSparkMax.ControlType.kDutyCycle);
    }


    public void startLaunch() {
        m_LPID.setReference(Constants.Launcher.LaunchP, CANSparkMax.ControlType.kDutyCycle);
        m_RPID.setReference(Constants.Launcher.LaunchP, CANSparkMax.ControlType.kDutyCycle);
    }

    public void endLaunch() {
        m_LPID.setReference(0, CANSparkMax.ControlType.kDutyCycle);
        m_RPID.setReference(0, CANSparkMax.ControlType.kDutyCycle);
    }

    
}
