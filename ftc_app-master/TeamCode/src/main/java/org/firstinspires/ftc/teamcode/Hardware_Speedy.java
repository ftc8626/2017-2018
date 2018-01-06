package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Cameron on 9/15/17.
 */

public class Hardware_Speedy
{
    public DcMotor leftMotor = null;
    public DcMotor rightMotor = null;
    public DcMotor liftMotor = null;
    public Servo leftGrabber = null;
    public Servo rightGrabber = null;
    public Servo rightJewel = null;
    public Servo rightRamp = null;
    public Servo leftRamp = null;
    public ColorSensor rightColorSensor;


    public static final double START_SERVO = .2;

    HardwareMap hwMap = null;

    public Hardware_Speedy(){

    }
    public void init(HardwareMap ahwMap) {
        hwMap = ahwMap;

        leftMotor = hwMap.dcMotor.get("left motor");
        rightMotor = hwMap.dcMotor.get("right motor");
        liftMotor = hwMap.dcMotor.get("lift motor");

        leftGrabber = hwMap.servo.get("left grabber");
        rightGrabber = hwMap.servo.get("right grabber");
        rightJewel = hwMap.servo.get("right jewel");
        rightRamp = hwMap.servo.get("right ramp");
        leftRamp = hwMap.servo.get("left ramp");

        rightColorSensor = hwMap.colorSensor.get("right color");

        leftMotor.setDirection(DcMotor.Direction.REVERSE);
        rightMotor.setDirection(DcMotor.Direction.FORWARD);
        liftMotor.setDirection(DcMotor.Direction.FORWARD);

        leftMotor.setPower(0);
        rightMotor.setPower(0);
        liftMotor.setPower(0);

        leftGrabber.setPosition(START_SERVO);
        rightGrabber.setPosition(START_SERVO);
        rightJewel.setPosition(1);
        rightRamp.setPosition(0);
        leftRamp.setPosition(0);


    }

}
