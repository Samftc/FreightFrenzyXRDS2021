package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "EncoderAuto")
public class EncoderAuto extends LinearOpMode {


    DcMotor BR;
    Servo HS;
    @Override
    public void runOpMode() throws InterruptedException {


        BR = hardwareMap.dcMotor.get("back_right_motor");
        HS = hardwareMap.servo.get("hand_servo");



        // Wait for the game to start (driver presses PLAY)
        waitForStart();




    }
}
