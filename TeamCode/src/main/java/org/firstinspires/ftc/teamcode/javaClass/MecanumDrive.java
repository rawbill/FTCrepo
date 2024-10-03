package org.firstinspires.ftc.teamcode.javaClass;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

@TeleOp
public class MecanumDrive extends LinearOpMode {

    @Override
    public void runOpMode(){

        DcMotor lf_drive = hardwareMap.get(DcMotor.class, "lf_drive");
        DcMotor rf_drive = hardwareMap.get(DcMotor.class, "rf_drive");
        DcMotor lb_drive = hardwareMap.get(DcMotor.class, "lb_drive");
        DcMotor rb_drive = hardwareMap.get(DcMotor.class, "rb_drive");

        lf_drive.setDirection(DcMotor.Direction.REVERSE);
        rf_drive.setDirection(DcMotor.Direction.FORWARD);
        lb_drive.setDirection(DcMotor.Direction.REVERSE);
        rb_drive.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();

        while (opModeIsActive()) {

            double drive  = -gamepad1.left_stick_y;
            double strafe =  gamepad1.left_stick_x;
            double turn   =  gamepad1.right_stick_x;

            double lfPower = Range.clip(drive + strafe + turn, -1.0, 1.0);
            double rfPower = Range.clip(drive - strafe - turn, -1.0, 1.0);
            double lbPower = Range.clip(drive - strafe + turn, -1.0, 1.0);
            double rbPower = Range.clip(drive + strafe - turn, -1.0, 1.0);

            lf_drive.setPower(lfPower);
            rf_drive.setPower(rfPower);
            lb_drive.setPower(lbPower);
            rb_drive.setPower(rbPower);

        }
    }
}
