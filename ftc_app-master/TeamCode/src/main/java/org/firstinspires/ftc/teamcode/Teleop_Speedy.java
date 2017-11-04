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
  //  double left = 0;
  //  double right = 0;

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

        double left;
        double right;
        
        left = -gamepad1.left_stick_y;
        right = -gamepad1.right_stick_y;

 /*       if(gamepad1.left_stick_y<0 && left<MAX_FWD)
            left = -gamepad1.left_stick_y;
        else if(gamepad1.left_stick_y==0 && left>0)
            left-=INCREMENT;

        if(gamepad1.right_stick_y<0 && right<MAX_FWD)
            right = -gamepad1.right_stick_y;
        else if(gamepad1.right_stick_y==0 && right>0)
            right-=INCREMENT;

        if(gamepad1.left_stick_y>0 && left>MAX_REV)
            left = -gamepad1.left_stick_y;
        else if(gamepad1.left_stick_y==0 && left<0)
            left+=INCREMENT;

        if(gamepad1.right_stick_y>0 && right>MAX_REV)
            right = -gamepad1.right_stick_y;
        else if(gamepad1.right_stick_y==0 && right<0)
            right+=INCREMENT;
*/
        //dpad = lift
        if(gamepad1.dpad_up)
            robot.liftMotor.setPower(.3);
        else if (gamepad1.dpad_down)
            robot.liftMotor.setPower(-.3);
        else
            robot.liftMotor.setPower(0);

        //right bumper = closed
        //left bumper = open
        if(gamepad1.right_bumper) {
            robot.rightGrabber.setPosition(.275);
            robot.leftGrabber.setPosition(.225);
        }
        else if (gamepad1.left_bumper) {
            robot.rightGrabber.setPosition(0);
            robot.leftGrabber.setPosition(0);
        }

        robot.leftMotor.setPower(left);
        robot.rightMotor.setPower(right);

        telemetry.addData("left", "%.2f", left);
        telemetry.addData("right", "%.2f", right);
        updateTelemetry(telemetry);
    }

    @Override
    public void stop() {

    }
}
