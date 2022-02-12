package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@Autonomous (name = "Duckwheelspinblue")
@Disabled
public class Duckwheelspinblue extends LinearOpMode {

    double distance;
    double om;
    double time;

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

        resetStartTime();

        while (opModeIsActive() && !isStopRequested() && time < 20) {
            // generic DistanceSensor methods.

            time = getRuntime();

            telemetry.addData("deviceName", sensorRange.getDeviceName());
            telemetry.addData("range", String.format("%.01f cm", sensorRange.getDistance(DistanceUnit.CM)));
            double distance = sensorRange.getDistance(DistanceUnit.CM);

            telemetry.addData("distance", distance);

            // Rev2mDistanceSensor specific methods.
            telemetry.addData("ID", String.format("%x", sensorTimeOfFlight.getModelID()));
            telemetry.addData("did time out", Boolean.toString(sensorTimeOfFlight.didTimeoutOccur()));

            telemetry.update();

            if (distance < 22) {


                bot.BL.setPower(0);
                bot.BR.setPower(0);
                bot.FR.setPower(0);
                bot.FL.setPower(0);
                bot.duc.setPower(0.5);


                // bot.Arm.setPower(1);


            } else if (distance < 35) {
                bot.BL.setPower(-0.2);
                bot.BR.setPower(-0.3);
                bot.FR.setPower(-0.2);
                bot.FL.setPower(-0.2);
                bot.duc.setPower(0);

                // bot.Arm.setPower(0);

            } else if (distance >= 40) {
                bot.BL.setPower(-0.5);
                bot.BR.setPower(-0.6);
                bot.FR.setPower(-0.5);
                bot.FL.setPower(-0.5);
                bot.duc.setPower(0);

                // bot.Arm.setPower(0);

            }
        }

        omniturn(1500,true,1);
    }

    private void omniturn(int omni, boolean left, int power) {

        bot.BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bot.BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bot.FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bot.FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        if(left) {
            bot.BL.setTargetPosition(-omni);
            bot.BR.setTargetPosition(omni);
            bot.FL.setTargetPosition(omni);
            bot.FR.setTargetPosition(-omni);
        } else {
            bot.BL.setTargetPosition(omni);
            bot.BR.setTargetPosition(-omni);
            bot.FL.setTargetPosition(-omni);
            bot.FR.setTargetPosition(omni);
        }

        bot.BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bot.BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bot.FL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bot.FR.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        if(left) {
            om = bot.FL.getCurrentPosition(); //om is current position of motor
        }else{
            om = bot.BL.getCurrentPosition();
        }

        while(Math.abs(om) < Math.abs(omni) && !isStopRequested()){


            if(left) {
                om = bot.FL.getCurrentPosition();
            }else{
                om = bot.BL.getCurrentPosition();
            }

            if(left) {
                bot.BL.setPower(-power);
                bot.FL.setPower(power);
                bot.FR.setPower(-power);
                bot.BR.setPower(power);
            } else{
                bot.BL.setPower(power);
                bot.FL.setPower(-power);
                bot.FR.setPower(power);
                bot.BR.setPower(-power);
            }



            telemetry.addData("om", om); //om is current position of motor
            telemetry.update();


        }

        bot.BR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bot.BL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bot.FR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bot.FL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }

}


