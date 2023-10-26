package org.firstinspires.ftc.teamcode;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.util.mariokartHardware;


@TeleOp(name="MarioDrive", group = "TeleOp")
public class mariokart extends OpMode {
    mariokartHardware r = new mariokartHardware();
    double turn_deflator;
    double deflator;
    double power1;
    double turn;
    double left;
    double right;
    @Override
    public void init() {
        r.init_robot(this);
        turn_deflator = 0.5;
    }

    @Override
    public void loop() {
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





    }
}
//getposition

