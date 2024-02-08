package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Intake;

public class IntakeRun extends Command {

    private Intake s_Intake;
    private JoystickButton killButton;
    private Boolean end;
    private Boolean finish;

    /**
     * Run intake untill note is obtained or manualy disabled
     * 
     * @param s_Intake Intake object
     */
    public IntakeRun(Intake s_Intake, JoystickButton killButton) {
        this.s_Intake = s_Intake;
        this.killButton = killButton;
        this.end = false;
        this.finish = false;
        addRequirements(s_Intake);
    }

    @Override
    public void initialize() {
        // tell the intake to extend
        System.out.println("StartCmd");
        s_Intake.setDeploy(true);
        s_Intake.startIntake();
    }

    @Override
    public void execute() {
        // spin the intake 
        // s_Intake.runIntake();
        // if(s_Intake.checkForNote()) {
        //     end = true;
        //     s_Intake.toggleDeploy();
        // }
    }

    @Override
    public void end(boolean interrupted) {
        // tell the intake to retratct
        System.out.println("EndCmd");
        s_Intake.setDeploy(false);
        s_Intake.endIntake();
    }

    @Override
    public boolean isFinished() {
        // this should trigger when a note is detected, or manualy triggerd
        return(s_Intake.checkForNote() || killButton.getAsBoolean());
    }
    
}
