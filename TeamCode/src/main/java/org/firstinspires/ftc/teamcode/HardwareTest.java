package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous (name = "HardwareTest")
@Disabled
public class HardwareTest extends LinearOpMode {

    HardwareOmni        bot = new HardwareOmni();

    double pos = 0;

    @Override
    public void runOpMode(){
        bot.init(hardwareMap);
        bot.BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bot.markus.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bot.BR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bot.markus.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        waitForStart();

        bot.BR.setTargetPosition(1000);
        bot.markus.setTargetPosition(1000);

        bot.BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bot.markus.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bot.BR.setPower(1);
        bot.markus.setPower(1);

        while (pos< 90000 && opModeIsActive()){


           pos = bot.BR.getCurrentPosition();

           telemetry.addData("pos", ""+pos);
           telemetry.addData("markus", ""+bot.markus.getCurrentPosition());
           telemetry.update();


        }

    }
}
