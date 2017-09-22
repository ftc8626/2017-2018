package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by stephenmcconnell on 9/15/17.
 */

public class Hardware_Speedy
{
    public DcMotor leftMotor = null;
    public DcMotor rightMotor = null;

    HardwareMap hwMap = null;

    public Hardware_Speedy(){

    }
    public void init(HardwareMap ahwMap) {
        hwMap = ahwMap;

        leftMotor = hwMap.dcMotor.get("left motor");
        rightMotor = hwMap.dcMotor.get("right motor");

        leftMotor.setDirection(DcMotor.Direction.FORWARD);
        rightMotor.setDirection(DcMotor.Direction.REVERSE);

        leftMotor.setPower(0);
        rightMotor.setPower(0);

    }


}
