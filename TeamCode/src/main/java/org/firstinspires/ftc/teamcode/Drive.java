package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.util.Hardware;


@TeleOp(name="Drive", group = "TeleOp")
public class Drive extends OpMode {
    Hardware r = new Hardware();

    @Override
    public void init() {
        r.init_robot(this);
    }

    @Override
    public void loop() {
        double deflator;
        deflator = gamepad1.left_bumper && gamepad1.right_bumper ? 0.1 : gamepad1.left_bumper ? 0.4 : 0.7;
        {


            //legacy code that runs our mecanum drive wheels

            //this first section creates the variables that will be used later

            //first we must translate the rectangular values of the joystick into polar coordinates;

            double y = -gamepad1.left_stick_y;
            double x = -gamepad1.left_stick_x;
            double angle = 0;
            boolean extended;

            if (y > 0 && x > 0)//quadrant 1
                angle = Math.atan(y / x);
            else {
                double angle1 = Math.toRadians(180) + Math.atan(y / x);
                if (y > 0 && x < 0)//quadrant 2
                    angle = angle1;
                else if (y < 0 && x < 0)//quadrant 3
                    angle = angle1;
                else if (y < 0 && x > 0)//quadrant 4
                    angle = Math.toRadians(360) + Math.atan(y / x);
            }

            if (y == 0 && x > 1)
                angle = 0;
            if (y > 0 && x == 0)
                angle = Math.PI / 2;
            if (y == 0 && x < 0)
                angle = Math.PI;
            if (y < 0 && x == 0)
                angle = 3 * Math.PI / 2;

            double velocity = Math.sqrt(Math.pow(gamepad1.left_stick_y, 2) + Math.pow(gamepad1.left_stick_x, 2));
            double rotation = -gamepad1.left_stick_x;
            double strafe = -gamepad1.right_stick_x;

            //equations taking the polar coordinates and turing them into motor powers
            double v1 = velocity * Math.cos(angle + (Math.PI / 4));
            double v2 = velocity * Math.sin(angle + (Math.PI / 4));
            double power1 = v1 - rotation;
            double power2 = v2 - rotation;
            double power3 = v2 - rotation;
            double power4 = v1 - rotation;
//            r.frontRight.setPower(power2 * deflator);
//            r.backLeft.setPower(power3 * deflator);
//            r.backRight.setPower(power4 * deflator);
//            r.frontLeft.setPower(power1 * deflator);



            if(gamepad1.right_bumper ) {
                r.launcherOne.setPower(0.4);
                r.launcherTwo.setPower(-0.4);
            }
//            }else if( gamepad1.left_bumper){
//                r.arm.setPower(-0.4);
//                r.Larm.setPower(-0.4);
//            }else{
//                r.arm.setPower(0);
//                r.Larm.setPower(0);
//            }

//            if (gamepad1.right_trigger == 1) {
//                r.pitchOne.setPosition(0);
//                //r.pitchTwo.setPosition(1);
//
//            } else if (gamepad1.left_trigger == 1) {
//                r.pitchOne.setPosition(1);
//                //r.pitchTwo.setPosition(0);
//            }
//            if (strafe > 0) {
//                r.frontRight.setPower(-0.4);
//                r.frontLeft.setPower(0.4);
//                r.backLeft.setPower(0.4);
//                r.backRight.setPower(-0.4);
//            } else if (strafe < 0) {
//                r.frontRight.setPower(0.4);
//                r.frontLeft.setPower(-0.4);
//                r.backLeft.setPower(-0.4);
//                r.backRight.setPower(0.4);
//            }
        }
    }
}
//getposition
//