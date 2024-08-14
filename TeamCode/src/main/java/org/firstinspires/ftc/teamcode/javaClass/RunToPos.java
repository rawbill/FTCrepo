package org.firstinspires.ftc.teamcode.javaClass;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class RunToPos extends LinearOpMode {

    @Override
    public void runOpMode() {

        DcMotor motor = hardwareMap.get(DcMotor.class,"motor");
        Servo servo   = hardwareMap.get(Servo.class,"servo");

        int targetTicks = 1000;

        boolean circPressed = false;
        boolean triPressed  = false;

        waitForStart();

        while (opModeIsActive()) {

            motor.setTargetPosition(targetTicks);
            motor.setPower(0.5);
            motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            sleep(targetTicks);
            motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            if (gamepad1.circle && !circPressed) {
                servo.setPosition(0.5);
                circPressed = true;

            } else {
                circPressed = false;
            }

            if (gamepad1.triangle && !triPressed) {
                servo.setPosition(0.9);
                triPressed = true;

            } else {
                triPressed = false;
            }

        }

    }
}
