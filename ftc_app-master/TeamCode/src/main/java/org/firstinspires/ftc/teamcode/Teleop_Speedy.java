package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by Cameron on 9/15/17.
 */
@TeleOp(name="Teleop_Speedy", group="Speedy")
public class Teleop_Speedy extends OpMode {

    static final double INCREMENT   = 0.1;     // amount to ramp motor each CYCLE_MS cycle
    static final int    CYCLE_MS    =   50;     // period of each cycle
    static final double MAX_FWD     =  1.0;     // Maximum FWD power applied to motor
    static final double MAX_REV     = -1.0;     // Maximum REV power applied to motor
    boolean PRECISE_DRIVE = true;
    double left = 0;
    double right = 0;

    Hardware_Speedy robot = new Hardware_Speedy();

    @Override
    public void init() {
        robot.init(hardwareMap);

        telemetry.addData("Say", "I think, therefore I am.");
 //       updateTelemetry(telemetry);

    }

    @Override
    public void init_loop() {

    }

    @Override
    public void start() {

    }

    @Override
    public void loop() {

//        double left;
 //       double right;

        if(PRECISE_DRIVE == false){
            left = -.9 * gamepad1.left_stick_y;
            right = -.9 * gamepad1.right_stick_y;}
        else if(PRECISE_DRIVE == true){
            left = -.2 * (gamepad1.left_stick_y);
            right = -.2 * (gamepad1.right_stick_y);}

        //jewel arm
       /* if(gamepad1.x)
            robot.rightJewel.setPosition(.3);
        else if(gamepad1.y)
            robot.rightJewel.setPosition(1);
*/
//        else if (gamepad1.a)
//        {
//            robot.leftRamp.setPosition(.8);
//            robot.rightRamp.setPosition(.8);
//        }
//        else if (gamepad1.b)
//        {
//            robot.leftRamp.setPosition(0);
//            robot.rightRamp.setPosition(0);
//        }

        //toggle precise drive
        //right trigger = sneaky
        //left trigger = speedy
       if(gamepad1.right_trigger > 0 && PRECISE_DRIVE == false)
            PRECISE_DRIVE = true;
        else if (gamepad1.left_trigger > 0 && PRECISE_DRIVE == true)
            PRECISE_DRIVE = false;

        //intake wheels
        if(gamepad1.x || gamepad2.x) {
            robot.leftIntakeWheel.setPower(.5);
            robot.rightIntakeWheel.setPower(.5);
        }
        if(gamepad1.y || gamepad2.y) {
            robot.leftIntakeWheel.setPower(-.5);
            robot.rightIntakeWheel.setPower(-.5);
        }
        if(gamepad1.dpad_left) {
            robot.leftIntakeWheel.setPower(0);
            robot.rightIntakeWheel.setPower(0);
        }

        //intake servos
        if(gamepad1.a || gamepad2.a) {
            robot.leftIntakeArm.setPosition(.7);
            robot.rightIntakeArm.setPosition(.7);
        }
        if(gamepad1.b || gamepad2.b) {
            robot.leftIntakeArm.setPosition(0);
            robot.rightIntakeArm.setPosition(0);
        }

        //dpad = lift
        if(gamepad1.dpad_up || gamepad2.dpad_up)
            robot.liftMotor.setPower(.6);
        else if (gamepad1.dpad_down || gamepad2.dpad_down)
            robot.liftMotor.setPower(-.6);
        else
            robot.liftMotor.setPower(0);

        //retract grabbers
        if(gamepad1.dpad_right) {
            robot.rightTopGrabber.setPosition(0);
            robot.leftTopGrabber.setPosition(0);
            robot.rightBottomGrabber.setPosition(0);
            robot.leftBottomGrabber.setPosition(0);
        }

        /*if(gamepad2.dpad_up)
            robot.liftMotor.setPower(.5);
        else if (gamepad2.dpad_down)
            robot.liftMotor.setPower(-.5);
        else
            robot.liftMotor.setPower(0);
*/
        //left bumper = closed
        //right bumper = open
       if(gamepad1.right_bumper) {
            robot.rightTopGrabber.setPosition(.27);
            robot.leftTopGrabber.setPosition(.22);
           robot.rightBottomGrabber.setPosition(.33);
           robot.leftBottomGrabber.setPosition(.3);
       }
        else if (gamepad1.left_bumper) {
            robot.rightTopGrabber.setPosition(0.1);
            robot.leftTopGrabber.setPosition(0.1);
           robot.rightBottomGrabber.setPosition(0.15);
           robot.leftBottomGrabber.setPosition(0.15);
        }

        robot.leftFrontMotor.setPower(left);
        robot.rightFrontMotor.setPower(right);
        robot.leftBackMotor.setPower(left);
        robot.rightBackMotor.setPower(right);

        //reset servos
        if(gamepad1.guide){
            robot.leftTopGrabber.setPosition(.1);
            robot.rightTopGrabber.setPosition(.1);
            robot.leftBottomGrabber.setPosition(.15);
            robot.rightBottomGrabber.setPosition(.15);
            robot.rightJewel.setPosition(1);
//            robot.rightRamp.setPosition(0);
//            robot.leftRamp.setPosition(0);
        }

        telemetry.addData("left", "%.2f", left);
        telemetry.addData("right", "%.2f", right);
        updateTelemetry(telemetry);
    }

    @Override
    public void stop() {

    }
}
