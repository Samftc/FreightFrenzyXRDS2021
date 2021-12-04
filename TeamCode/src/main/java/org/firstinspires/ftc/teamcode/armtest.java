package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name = "armtest", group = "Sensor")
public class armtest extends OpMode {
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
        telemetry.addData("HSR", "" + i);
        telemetry.addData("HSL", "" + j);


        if (gamepad1.y) {
            //arm close
            i = 0.70;//right
            j = 0.30;//left
            HSR.setPosition(i);
            HSL.setPosition(j);
        }

        if (gamepad1.a) {
            //arm open
            i = 1; //right
            j = 0; //left
            HSR.setPosition(i);
            HSL.setPosition(j);
        }


        if (gamepad1.b) {
            //arm close gradually
            if (i > 0.70)
                i -= 0.005;
            if (j < 0.30)  
                i += 0.005;
            HSR.setPosition(i);
            HSL.setPosition(j);
        }
        if (gamepad1.x) {
            //arm open gradually
            if (i < 1)
                i += 0.005;
            if (j > 0)
                i -= 0.005;
            HSR.setPosition(i);
            HSL.setPosition(j);
        }
        if (gamepad1.left_trigger == 1) {
            HSR.setPosition(1);
            HSL.setPosition(-1);
        }
    }
}

/* swivels claw
        if(gamepad2.y && go){
                pos = pos + 0.2;
                go = false;
                }

                if(gamepad2.a && go){
                pos = pos - 0.2;
                go = false;
                }
                if (!gamepad2.a && !gamepad2.y){

                if (pos > 1){
                pos = 1;
                }
                else if(pos < 0){
        pos = 0;
        }

        go = true;
        //ends claw swivel
        }
*/