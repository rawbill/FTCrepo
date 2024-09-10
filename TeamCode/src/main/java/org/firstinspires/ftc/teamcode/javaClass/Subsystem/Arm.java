package org.firstinspires.ftc.teamcode.javaClass.Subsystem;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Arm {
    Servo arm;
    Servo claw;
    public static double CLAW_OUTTAKE = 0.5;
    public static double ARM_OUTTAKE = 0.5;

    public static double CLAW_INTAKE = 0.2;
    public static double ARM_INTAKE = 0.2;


    public Arm(HardwareMap map) {
        arm = map.get(Servo.class, "arm");
        claw = map.get(Servo.class, "claw");
    }

    public void setArm(double position) {
        arm.setPosition(position);
    }

    public void setClaw(double position) {
        claw.setPosition(position);
    }

    public void outtake() {
        claw.setPosition(CLAW_OUTTAKE);
        claw.setPosition(ARM_OUTTAKE);
    }

    public void intake() {
        claw.setPosition(CLAW_INTAKE);
        claw.setPosition(ARM_INTAKE);
    }

    public void update() {

    }
}
