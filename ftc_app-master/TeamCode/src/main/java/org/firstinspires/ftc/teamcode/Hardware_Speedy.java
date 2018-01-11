package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Cameron on 9/15/17.
 */

public class Hardware_Speedy
{
    public DcMotor leftFrontMotor = null;
    public DcMotor rightFrontMotor = null;
    public DcMotor leftBackMotor = null;
    public DcMotor rightBackMotor = null;
    public DcMotor liftMotor = null;
    public Servo leftTopGrabber = null;
    public Servo rightTopGrabber = null;
    public Servo leftBottomGrabber = null;
    public Servo rightBottomGrabber = null;
    public Servo rightJewel = null;
//    public Servo rightRamp = null;
//    public Servo leftRamp = null;
    public ColorSensor rightColorSensor;


    public static final double START_SERVO = .2;

    HardwareMap hwMap = null;

    public Hardware_Speedy(){

    }
    public void init(HardwareMap ahwMap) {
        hwMap = ahwMap;

        leftFrontMotor = hwMap.dcMotor.get("left front motor");
        rightFrontMotor = hwMap.dcMotor.get("right front motor");
        leftBackMotor = hwMap.dcMotor.get("left back motor");
        rightBackMotor = hwMap.dcMotor.get("right back motor");
        liftMotor = hwMap.dcMotor.get("lift motor");

        leftTopGrabber = hwMap.servo.get("left top grabber");
        rightTopGrabber = hwMap.servo.get("right top grabber");
        leftBottomGrabber = hwMap.servo.get("left bottom grabber");
        rightBottomGrabber = hwMap.servo.get("right bottom grabber");
        rightJewel = hwMap.servo.get("right jewel");
//        rightRamp = hwMap.servo.get("right ramp");
//        leftRamp = hwMap.servo.get("left ramp");

        rightColorSensor = hwMap.colorSensor.get("right color");

        leftFrontMotor.setDirection(DcMotor.Direction.REVERSE);
        rightFrontMotor.setDirection(DcMotor.Direction.FORWARD);
        leftBackMotor.setDirection(DcMotor.Direction.REVERSE);
        rightBackMotor.setDirection(DcMotor.Direction.FORWARD);
        liftMotor.setDirection(DcMotor.Direction.FORWARD);

        leftFrontMotor.setPower(0);
        rightFrontMotor.setPower(0);
        leftBackMotor.setPower(0);
        rightBackMotor.setPower(0);
        liftMotor.setPower(0);


        leftTopGrabber.setDirection(Servo.Direction.REVERSE);
        leftTopGrabber.setPosition(START_SERVO);
        rightTopGrabber.setPosition(START_SERVO);
        leftBottomGrabber.setDirection(Servo.Direction.REVERSE);
        leftBottomGrabber.setPosition(START_SERVO);
        rightBottomGrabber.setPosition(START_SERVO);
        rightJewel.setPosition(1);
//        rightRamp.setPosition(0);
//        leftRamp.setPosition(0);


    }

}
