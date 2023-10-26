package org.firstinspires.ftc.teamcode.auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.util.mariokartHardware;

@Autonomous(name="Timed Mario", group = "Auto")
public class marioKartTimed extends LinearOpMode {
    ElapsedTime time = new ElapsedTime();
    mariokartHardware r = new mariokartHardware();
    double turn_deflator;
    double deflator;
    double power1;
    double turn;
    double left;
    double right;
    @Override
    public void runOpMode() throws InterruptedException {
        r.init_robot(this);
        turn_deflator = 0.5;
        waitForStart();
        time.reset();
        while (time.milliseconds() < 30000 && !isStopRequested()){
            deflator = gamepad1.a ? 1:0.5;



            //legacy code that runs our mecanum drive wheels

            //this first section creates the variables that will be used later

            //first we must translate the rectangular values of the joystick into polar coordinates;


            power1 = gamepad1.right_trigger-gamepad1.left_trigger;
            turn = (gamepad1.left_stick_x)*turn_deflator;
            left = ((power1-turn)*deflator);
            right = ((power1+turn)*deflator);
            r.backLeft.setPower(left);
            r.frontLeft.setPower(left);
            r.frontRight.setPower(right);
            r.backRight.setPower(right);
            telemetry.addData("Time Left", (30000-time.milliseconds())/1000);
            telemetry.update();
        }
        r.backLeft.setPower(0);
        r.frontLeft.setPower(0);
        r.frontRight.setPower(0);
        r.backRight.setPower(0);

    }
}
