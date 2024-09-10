package org.firstinspires.ftc.teamcode.javaClass.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.javaClass.Control.ArmControl;
import org.firstinspires.ftc.teamcode.javaClass.Subsystem.Arm;
import org.firstinspires.ftc.teamcode.javaClass.Control.ArmControl;
import org.firstinspires.ftc.teamcode.javaClass.Subsystem.Arm;

@TeleOp
public class MainTeleOp extends LinearOpMode {

    public enum States {
        INTAKE,
        OUTTAKE
    }

    @Override
    public void runOpMode() throws InterruptedException {
        Arm arm = new Arm(hardwareMap);
        ArmControl armControl = new ArmControl(gamepad1, gamepad2, arm);

        States state = States.INTAKE; // default state

        boolean intakeFall = false;
        ElapsedTime timer = new ElapsedTime(); // timer

        waitForStart();

        while (opModeIsActive()) {
            switch(state) {
                case INTAKE:
                    arm.intake(); // setting intake positions
                    armControl.update(); // watching button presses

                    // transition
                    if (gamepad1.x) {
                        intakeFall = true;
                    }

                    if (intakeFall && !gamepad1.x) {
                        // TRANSITION STATES
                        state = States.OUTTAKE;
                        timer.reset();
                        intakeFall = false;
                    }
                    break;

                case OUTTAKE:
                    arm.outtake();

                    if (timer.seconds() > 0.5) {
                        state = States.INTAKE;
                    }
                    break;
            }
        }
    }
}
