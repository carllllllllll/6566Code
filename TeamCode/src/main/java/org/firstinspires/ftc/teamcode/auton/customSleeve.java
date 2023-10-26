package org.firstinspires.ftc.teamcode.auton;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//new imports





//new imports end
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.util.HardAuto;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.openftc.apriltag.AprilTagDetection;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;

import java.util.ArrayList;

@TeleOp
public class customSleeve extends LinearOpMode {
    HardAuto r = new HardAuto();
    private Mat grey = new Mat();
    OpenCvCamera camera;
    boolean run = true;

    @Override
    public void runOpMode() throws InterruptedException {


        r.init_robot(this);
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        camera = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);
        customSleevePipeline csp = new customSleevePipeline();

        camera.setPipeline(csp);
        camera.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {
            @Override
            public void onOpened() {
                camera.startStreaming(800, 448, OpenCvCameraRotation.UPRIGHT);
            }

            @Override
            public void onError(int errorCode) {

            }
        });

        telemetry.setMsTransmissionInterval(50);

        /*
         * The INIT-loop:
         * This REPLACES waitForStart!
         */






        while (run == true) {  //!isStarted() && !isStopRequested()
            int currentDetections = csp.getLatestDetections();
            // if 0 == idx RED
            // else if 1 == idx GREEN
            // else if 2 == idx BLUE
            // end mek
            // Convert to greyscale

            telemetry.addData("val=", String.valueOf(currentDetections));
            telemetry.update();
            if (0 == currentDetections) {
                r.runTime(1100, 0.7); // middle
                run = false;
            }
//            else if (2 == currentDetections) {

//                r.runTime(100, 0.7);
//                for (int i = 0; i < 28000; i++) {
//
//                    r.frontRight.setPower(-0.8);
//                    r.frontLeft.setPower(-0.8);
//                    r.backLeft.setPower(0.6);
//                    r.backRight.setPower(0.6);
//                }
//                run = false;
//                r.frontRight.setPower(0);
//                r.frontLeft.setPower(0);
//                r.backLeft.setPower(0);
//                r.backRight.setPower(0);
//                //right trajectory
//                r.runTime(1300, 0.7);
//                //right trajectory
//                r.runTime(1300, 0.7);
//            }
//            else if (1 == currentDetections) {
//                        r.runTime(100, 0.7);
//                        for (int i = 0; i < 28000; i++) {
//
//                            r.frontRight.setPower(-0.8);
//                            r.frontLeft.setPower(-0.8);
//                            r.backLeft.setPower(0.6);
//                            r.backRight.setPower(0.6);
//                        }
//                        run = false;
//                        r.frontRight.setPower(0);
//                        r.frontLeft.setPower(0);
//                        r.backLeft.setPower(0);
//                        r.backRight.setPower(0);
//                        //right trajectory
//                        r.runTime(1300, 0.7);
//                    }
//
            }


           }
      }



    //new code




    /**
     * Draw a 3D axis marker on a detection. (Similar to what Vuforia does)
     *
     * @param buf          the RGB buffer on which to draw the marker
     * @param length       the length of each of the marker 'poles'
     * @param rvec         the rotation vector of the detection
     * @param tvec         the translation vector of the detection
     * @param cameraMatrix the camera matrix used when finding the detection
     */






    /**
     * Extracts 6DOF pose from a trapezoid, using a camera intrinsics matrix and the
     * original size of the tag.
     *
     * @param points       the points which form the trapezoid
     * @param cameraMatrix the camera intrinsics matrix
     * @param tagsizeX     the original width of the tag
     * @param tagsizeY     the original height of the tag
     * @return the 6DOF pose of the camera relative to the tag
     */



    /*
     * A simple container to hold both rotation and translation
     * vectors, which together form a 6DOF pose.
     */
