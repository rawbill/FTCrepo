package org.firstinspires.ftc.teamcode.javaClass;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.Range;

@TeleOp
public class TankDrive extends LinearOpMode {

    @Override
    public void runOpMode(){

        DcMotor l_drive = hardwareMap.get(DcMotor.class, "l_drive");
        DcMotor r_drive = hardwareMap.get(DcMotor.class, "r_drive");

        l_drive.setDirection(DcMotorEx.Direction.REVERSE);
        r_drive.setDirection(DcMotorEx.Direction.FORWARD);

        while (opModeIsActive()) {

            l_drive.setPower(gamepad1.left_stick_y);
            r_drive.setPower(gamepad1.right_stick_y);

        }
    }
}
