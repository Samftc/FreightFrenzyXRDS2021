package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "TestAuto")
@Disabled
public class TestAuto extends LinearOpMode {
    HardwareOmni        bot = new HardwareOmni();

    DcMotor Arm;
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
    @Override
    public void runOpMode() {
        bot.init(hardwareMap);
        bot.markus.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bot.markus.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        waitForStart();


        BlueAuto(4000, 0);

    }

    private void BlueAuto(int i, int i1) {

    }

}
