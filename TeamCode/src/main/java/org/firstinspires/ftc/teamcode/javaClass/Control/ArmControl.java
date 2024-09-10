package org.firstinspires.ftc.teamcode.javaClass.Control;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.javaClass.Subsystem.Arm;

public class ArmControl {
    Gamepad gp1;
    Gamepad gp2;
    Arm arm;

    boolean crossBool = false;

    public ArmControl(Gamepad gp1, Gamepad gp2, Arm arm) {
        this.gp1 = gp1;
        this.gp2 = gp2;
        this.arm = arm;
    }

    public void update() {
        // falling edge detector
        if (gp1.cross) { //clicked
            crossBool = true;
        }

        if (crossBool && !gp1.cross) { // let go
            arm.outtake(); // outtaking the claw
            crossBool = false;
        }
    }
}
