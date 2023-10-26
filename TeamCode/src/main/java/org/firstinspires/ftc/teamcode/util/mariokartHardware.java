package org.firstinspires.ftc.teamcode.util;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

public class mariokartHardware {
    OpMode opMode;
    public DcMotor frontLeft, frontRight, backLeft, backRight;
    public DcMotor[] drive;

    public void init_robot(OpMode opMode){

        this.opMode = opMode;
        init_hardware();

    }

    public boolean getTolerance(double val1, double val2, double tolerance){
        return (val1+tolerance >val2) && (val1-tolerance < val2);
    }
    public void init_hardware(){
        frontLeft = opMode.hardwareMap.dcMotor.get("FLM");
        frontRight = opMode.hardwareMap.dcMotor.get("FRM");
        backLeft = opMode.hardwareMap.dcMotor.get("BLM");
        backRight = opMode.hardwareMap.dcMotor.get("BRM");

        //frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);
        //   backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        drive = new DcMotor[]{frontLeft, frontRight, backLeft, backRight};

    }
}

