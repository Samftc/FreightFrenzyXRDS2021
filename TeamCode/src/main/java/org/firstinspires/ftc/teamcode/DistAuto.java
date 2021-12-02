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

        // you can use this as a regular DistanceSensor.
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

            telemetry.addData("deviceName", sensorRange.getDeviceName());
            telemetry.addData("range", String.format("%.01f cm", sensorRange.getDistance(DistanceUnit.CM)));
            double distance = sensorRange.getDistance(DistanceUnit.CM);

            telemetry.addData("distance", distance);


            // Rev2mDistanceSensor specific methods.
            telemetry.addData("ID", String.format("%x", sensorTimeOfFlight.getModelID()));
            telemetry.addData("did time out", Boolean.toString(sensorTimeOfFlight.didTimeoutOccur()));

            telemetry.update();
bot.BR.setPower(1);
            if (distance < 8) {
                bot.BR.setPower(0);
                bot.Arm.setPower(1);

            } else if (distance < 10) {
                bot.BR.setPower(0.5);
            } else  if (distance < 15) {
                        bot.BR.setPower(0.75);
                    }
                }
            }


        }

    }
}