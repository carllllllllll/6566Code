package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.util.mariokartHardware;

public class speedTest extends LinearOpMode {
    mariokartHardware r = new mariokartHardware();
    @Override
    public void runOpMode() throws InterruptedException {
        r.init_robot(this);
        for (DcMotor motor: r.drive){
            motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
        ElapsedTime time = new ElapsedTime();
        waitForStart();
        time.reset();
        while (time.milliseconds() < 5000){
            r.frontRight.setPower(1);
            r.backRight.setPower(1);
            r.frontLeft.setPower(1);
            r.backLeft.setPower(1);
        }
        r.frontRight.setPower(0);
        r.backRight.setPower(0);
        r.frontLeft.setPower(0);
        r.backLeft.setPower(0);
        telemetry.addData("Speed",(((float)r.frontRight.getCurrentPosition()/(float)0.848484848484848484)*7200)/63360);
        telemetry.update();
        while(!isStopRequested());
    }
}
