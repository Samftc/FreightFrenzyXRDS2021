package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name= "GroupAuto")
@Disabled
public class GroupAuto extends LinearOpMode {

    DcMotor BR;
    Servo HS;
    double Time = getRuntime();

    @Override
    public void runOpMode() throws InterruptedException {

        BR = hardwareMap.dcMotor.get("back_right_motor");
        HS = hardwareMap.servo.get("hand_servo");

        BR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        while(time < 5 && opModeIsActive()){
            BR.setPower(1);
            Time = getRuntime();
            telemetry.addData("Status", "" + Time);    //
            telemetry.update();
        }



    }
}
