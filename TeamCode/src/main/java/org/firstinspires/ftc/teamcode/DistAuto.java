package org.firstinspires.ftc.teamcode;
import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@Autonomous (name = "DistAuto")

public class DistAuto extends LinearOpMode {

    HardwareOmni bot = new HardwareOmni();


    @Override
    public void runOpMode() {
        bot.init(hardwareMap);

        // you can use this as a r  egular DistanceSensor.
        DistanceSensor sensorRange = hardwareMap.get(DistanceSensor.class, "steven");

        // you can also cast this to a Rev2mDistanceSensor if you want to use added
        // methods associated with the Rev2mDistanceSensor class.
        Rev2mDistanceSensor sensorTimeOfFlight = (Rev2mDistanceSensor) sensorRange;

        telemetry.addData(">>", "Press start to continue");
        telemetry.update();

        waitForStart();
        while (opModeIsActive()) {
            // generic DistanceSensor methods.

            bot.BR = hardwareMap.dcMotor.get("back_right_motor");

            //variable for starting duck arm program

            boolean InDuckRange = false;

            telemetry.addData("deviceName", sensorRange.getDeviceName());
            telemetry.addData("range", String.format("%.01f in", sensorRange.getDistance(DistanceUnit.INCH)));
            double distance = sensorRange.getDistance(DistanceUnit.INCH);

            telemetry.addData("distance", distance);
            telemetry.addData("markus",""+bot.markus.getPower());

            // Rev2mDistanceSensor specific methods.
            telemetry.addData("ID", String.format("%x", sensorTimeOfFlight.getModelID()));
            telemetry.addData(" did time out", Boolean.toString(sensorTimeOfFlight.didTimeoutOccur()));

            telemetry.update();

            if (distance <= 8) {
                bot.BL.setPower(0);
                bot.FL.setPower(0);
                bot.BR.setPower(0);
                bot.FR.setPower(0);
                InDuckRange = true;

               // bot.Arm.setPower(1);

            } else if (distance < 15) {
              //  bot.markus.setPower(0.5);
                bot.BL.setPower(-0.25); //* 1.25);
                bot.FL.setPower(-0.25); //* 1.25);
                bot.BR.setPower(-0.25);// * 1.25);
                bot.FR.setPower(-0.25);// * 1.25);
               // bot.Arm.setPower(0);
            } else  if (distance < 25) {
               // bot.markus.setPower(0.75);
                bot.BL.setPower(-0.55);// * 1.25);
                bot.FL.setPower(-0.55);// * 1.25);
                bot.BR.setPower(-0.55);// * 1.25);
                bot.FR.setPower(-0.55);// * 1.25);
               // bot.Arm.setPower(0);
            } else if (distance >=25) {
                bot.BL.setPower(-0.6);// * 1.25);
                bot.FL.setPower(-0.6);// * 1.25);
                bot.BR.setPower(-0.6);// * 1.25);
                bot.FR.setPower(-0.6);// * 1.25);

               // bot.Arm.setPower(1);



            } else if (distance >=8) {
                bot.BL.setPower(-0.2);// * 1.25);
                bot.FL.setPower(-0.2);// * 1.25);
                bot.BR.setPower(-0.2);// * 1.25);
                bot.FR.setPower(-0.2);// * 1.25);
                InDuckRange = false;


                    }
            while (InDuckRange = true) {
             }
                }
            }


        }
