package frc.robot.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import java.util.function.BooleanSupplier;
import frc.robot.subsystems.Intake;

public class IntakeRun extends Command {

    private Intake s_Intake;
    private DigitalInput LIM;
    private JoystickButton overrideButton;
    // private Boolean end;
    private Boolean bHold;

    /**
     * Run intake untill note is obtained or manualy disabled
     * 
     * @param s_Intake Intake object
     */
    public IntakeRun(Intake s_Intake, DigitalInput LIM, JoystickButton overrideButton) {
        this.s_Intake = s_Intake;
        this.LIM = LIM;
        this.overrideButton = overrideButton;
        // this.end = false;
        this.bHold = true;
        addRequirements(s_Intake);
    }

    @Override
    public void initialize() {
        // tell the intake to extend
        System.out.println("Start IntakeRun");
        s_Intake.setDeploy(true);
        s_Intake.startIntake();
        this.bHold = true;
    }

    @Override
    public void execute() {
        if (bHold) bHold = overrideButton.getAsBoolean();
    }

    @Override
    public void end(boolean interrupted) {
        System.out.println("End IntakeRun");
    }

    @Override
    public boolean isFinished() {
        // this should trigger when a note is detected, or manualy triggerd
        // return(s_Intake.checkForNote() || switchButton.getAsBoolean());
        if (!LIM.get()) System.out.println("LIM");
        if (overrideButton.getAsBoolean()) System.out.println("OVER");
        return !LIM.get() || (overrideButton.getAsBoolean() && !bHold);
    }
    
}
