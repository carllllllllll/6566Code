package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.util.HardAuto;

@Autonomous(name = "Test Auto", group = "Auto")
public class testAuto extends LinearOpMode {
    HardAuto r = new HardAuto();

    @Override
    public void runOpMode() throws InterruptedException {
        r.init_robot(this);
        waitForStart();
      //  r.runTime(3000);

        r.backRight.getCurrentPosition();
        r.backRight.setTargetPosition(500);
    }
}
