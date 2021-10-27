package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp (name = "GroupTeleop")
public class GroupTeleop extends OpMode {

    DcMotor BR;
    @Override
    public void init() {
        BR = hardwareMap.dcMotor.get("back_right_motor");



    }

    @Override
    public void loop() {

        BR.setPower(gamepad1.left_stick_y);

    }
}
