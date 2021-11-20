package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous(name = "HardwareAuto")
public class HardwareAuto extends LinearOpMode {

    HardwareOmni        bot = new HardwareOmni();
    private ElapsedTime runtime = new ElapsedTime();


    double pos;



    @Override
    public void runOpMode() {
        bot.init(hardwareMap);

        bot.BR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bot.BL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bot.FL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bot.FR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        bot.BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bot.BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bot.FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bot.FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        waitForStart();

        while(pos < 1000 && opModeIsActive()){
            bot.BR.setPower(1);

            pos = bot.BR.getCurrentPosition();
            telemetry.addData("go","");

            telemetry.update();


        }

        bot.BR.setPower(0);
        telemetry.addData("stop","");





    }
}
