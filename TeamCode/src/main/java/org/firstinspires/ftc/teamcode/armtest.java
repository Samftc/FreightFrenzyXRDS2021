package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name = "armtest", group = "Sensor")
public class armtest extends OpMode{
    DcMotor A;
    DcMotor FL;
    DcMotor BL;
    DcMotor BR;
    DcMotor FR;
    com.qualcomm.robotcore.hardware.Servo HS;
    com.qualcomm.robotcore.hardware.Servo HSL;
    com.qualcomm.robotcore.hardware.Servo HSR;


    double LPower;
    double RPower;
    double Left;
    double turn;
    double slowmode = 1;
    double Turn;
    double Servo;
    double up;
    double down;
    double pos;
    boolean go = false;
    double i;
    double j;

    @Override
    public void init() {
        HSL = hardwareMap.servo.get("hand_servo_left");
        HSR = hardwareMap.servo.get("hand_servo_right");
    }

    @Override
    public void loop() {
        telemetry.addData("HSR", "+i" );
        telemetry.addData("HSL", "+i" );


        if(gamepad1.y){
            i= 1;
            j= 0;
            HSR.setPosition(i);
            HSL.setPosition(j);
        }

        if(gamepad1.a){
            i= 0;
            j= 1;
            HSR.setPosition(i);
            HSL.setPosition(j);
        }



        if(gamepad1.x){
            HSR.setPosition(i);
            HSL.setPosition(i*-1);
           // if(i>0)
               // i-=0.005;
        }
        if(gamepad1.b){
            HSR.setPosition(i);
            HSL.setPosition(i*-1);
          //  if(i<1)
            //    i+=0.005;
        }
    }
}
