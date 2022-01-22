package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp (name = "GroupTeleop")
@Disabled
public class GroupTeleop extends OpMode {

    DcMotor BR;
    Servo HS;
    double i=0;



    @Override
    public void init() {
        BR = hardwareMap.dcMotor.get("back_right_motor");
        HS = hardwareMap.servo.get("hand_servo");
        telemetry.addData("Status", "Initialized");
        telemetry.update();


    }

    @Override
    public void loop() {


        BR.setPower(gamepad1.left_stick_y);
        telemetry.addData("I", "" + i);

        telemetry.addData("BR",""+gamepad1.left_stick_y);
        telemetry.update();

        if(gamepad1.y){
            i = 1;
            HS.setPosition(i);

        }

        if(gamepad1.a){
            i= 0;
            HS.setPosition(i);

        }




        if(gamepad1.x){
            HS.setPosition(i);
            if(i>0)
                i-=0.005;
        }
        if(gamepad1.b){
            HS.setPosition(i);
            if(i<1)
                i+=0.005;
        }








    }
}
