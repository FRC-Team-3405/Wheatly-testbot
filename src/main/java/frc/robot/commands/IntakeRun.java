package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import java.util.function.BooleanSupplier;
import frc.robot.subsystems.Intake;

public class IntakeRun extends Command {

    private Intake s_Intake;
    private JoystickButton switchButton;
    // private Boolean end;
    private Boolean first;

    /**
     * Run intake untill note is obtained or manualy disabled
     * 
     * @param s_Intake Intake object
     */
    public IntakeRun(Intake s_Intake, JoystickButton switchButton) {
        this.s_Intake = s_Intake;
        this.switchButton = switchButton;
        
        // this.end = false;
        this.first = false;
        addRequirements(s_Intake);
    }

    @Override
    public void initialize() {
        // tell the intake to extend
        System.out.println("StartCmd");
        s_Intake.setDeploy(false);
        s_Intake.endIntake();
    }

    @Override
    public void execute() {
        if(switchButton.getAsBoolean() && !first) {
            first = true;
            s_Intake.toggleDeploy();
        } else if (switchButton.getAsBoolean()) {
            first = true;
        } else {
            first = false;
        }
        s_Intake.runIntake();
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        // this should trigger when a note is detected, or manualy triggerd
        // return(s_Intake.checkForNote() || switchButton.getAsBoolean());
        return false;
    }
    
}
