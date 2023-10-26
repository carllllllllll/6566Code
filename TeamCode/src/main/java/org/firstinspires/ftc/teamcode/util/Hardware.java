package org.firstinspires.ftc.teamcode.util;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

public class Hardware {
    OpMode opMode;
    public DcMotor launcherOne, launcherTwo, frontLeft, frontRight, backLeft, backRight ;
    public DcMotor[] drive;
    public Servo claw;
    public Servo pitchOne;
    public Servo pitchTwo;

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

        launcherOne = opMode.hardwareMap.dcMotor.get("LAO");
        launcherTwo = opMode.hardwareMap.dcMotor.get("LAT");

//        arm = opMode.hardwareMap.dcMotor.get("ARM");
//        Larm = opMode.hardwareMap.dcMotor.get("LRM");
//        pitchOne = opMode.hardwareMap.servo.get("PL");
//        //pitchTwo = opMode.hardwareMap.servo.get("PR");
//
//        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
//        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
//        //backRight.setDirection(DcMotorSimple.Direction.REVERSE);
//        //backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
//        drive = new DcMotor[]{frontLeft, frontRight, backLeft, backRight};
//        for (DcMotor motor: drive){
//            motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        }
    }
}

