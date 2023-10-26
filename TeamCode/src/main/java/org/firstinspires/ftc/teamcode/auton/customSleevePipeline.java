package org.firstinspires.ftc.teamcode.auton;

import org.firstinspires.ftc.teamcode.util.HardAuto;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

public class customSleevePipeline  extends OpenCvPipeline {
    HardAuto r = new HardAuto();
    private Mat grey = new Mat();
    private int index = -1;
    @Override
    public Mat processFrame(Mat input) {

        Mat copy = new Mat();
        Imgproc.cvtColor(input, copy, Imgproc.COLOR_RGBA2RGB); // im getting an error with this line
        double val = 0;
        int idx = 0;
        double[] temp = copy.get(copy.width() / 2, copy.height() / 2); // if i remove 33 i get an error here
        int chan;

        if (100.0 < temp[0] && temp[0] < 225.0) {
            index = 0;
        } else if (100.0 < temp[1] && temp[1] < 225.0) {
            index =1;
        } else if (100.0 < temp[2] && temp[2] < 225.0) {
            index = 2;
        } else {
            index = -1;
        }
        // 100-140 = red , 60-90 = green, > 100 blue[2
        return input;
    }

    public int getLatestDetections() {
        return index;
    }
}
