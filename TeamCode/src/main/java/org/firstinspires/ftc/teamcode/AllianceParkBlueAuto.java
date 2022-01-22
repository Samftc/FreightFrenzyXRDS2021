package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@Autonomous (name = "AllianceParkBlueAuto")
@Disabled
public class AllianceParkBlueAuto extends LinearOpMode {

    HardwareOmni bot = new HardwareOmni();


    @Override
    public void runOpMode() {
        bot.init(hardwareMap);

        // you can use this as a regular DistanceSensor.
        DistanceSensor sensorRange = hardwareMap.get(DistanceSensor.class, "dist");

        // you can also cast this to a Rev2mDistanceSensor if you want to use added
        // methods associated with the Rev2mDistanceSensor class.
        Rev2mDistanceSensor sensorTimeOfFlight = (Rev2mDistanceSensor) sensorRange;

        telemetry.addData(">>", "Press start to continue");
        telemetry.update();

        waitForStart();
        while (opModeIsActive()) {
            // generic DistanceSensor methods.

            telemetry.addData("deviceName", sensorRange.getDeviceName());
            telemetry.addData("range", String.format("%.01f cm", sensorRange.getDistance(DistanceUnit.CM)));
            double distance = sensorRange.getDistance(DistanceUnit.CM);

            telemetry.addData("distance", distance);
            telemetry.addData("markus", "" + bot.markus.getPower());

            // Rev2mDistanceSensor specific methods.
            telemetry.addData("ID", String.format("%x", sensorTimeOfFlight.getModelID()));
            telemetry.addData("did time out", Boolean.toString(sensorTimeOfFlight.didTimeoutOccur()));

            telemetry.update();

            if (distance < 5) {
                bot.BL.setPower(0);
                bot.BR.setPower(0);
                bot.FR.setPower(0);
                bot.FL.setPower(0);


                // bot.Arm.setPower(1);

            } else if (distance > 5) {
                bot.BL.setPower(-0.3);
                bot.BR.setPower(-0.3);
                bot.FR.setPower(-0.3);
                bot.FL.setPower(-0.3);
            }
        }
    }


}