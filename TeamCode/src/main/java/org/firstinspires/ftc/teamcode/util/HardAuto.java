package org.firstinspires.ftc.teamcode.util;

import com.qualcomm.robotcore.util.ElapsedTime;

public class HardAuto extends Hardware{
    Hardware r = new Hardware();


    public void runTime(int time, double power){
        ElapsedTime Time = new ElapsedTime();
        Time.reset();
        while(time >= Time.milliseconds()) {
//            frontRight.setPower(power);
//            backLeft.setPower(power);
//            backRight.setPower(-power);
//            frontLeft.setPower(-power);
            //r.claw.setPosition(1);
            launcherOne.setPower(power);
            launcherTwo.setPower(power);
        }
//        frontRight.setPower(0);
//        backLeft.setPower(0);
//        backRight.setPower(0);
//        frontLeft.setPower(0);

    }



}