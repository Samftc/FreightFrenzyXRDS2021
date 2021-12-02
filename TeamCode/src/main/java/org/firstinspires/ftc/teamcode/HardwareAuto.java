package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous(name = "HardwareAuto")
public class HardwareAuto extends LinearOpMode {

    HardwareOmni        bot = new HardwareOmni();



    double pos = 0;

    double speed = 1;
    private ElapsedTime     runtime = new ElapsedTime();



    @Override
    public void runOpMode() {
        bot.init(hardwareMap);
        bot.markus.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bot.markus.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bot.markus.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        waitForStart();


        bot.markus.setTargetPosition(1000);

        bot.markus.setPower(1);



        duckdrive(speed, 1500);
        bot.markus.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bot.markus.setMode(DcMotor.RunMode.RUN_TO_POSITION);



        rightdrive(speed, 2000);
        bot.markus.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bot.markus.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        duckdrive(speed, 1000);

        bot.markus.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bot.markus.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        duckdrive(speed, 500);





        telemetry.addData("stop","");





    }

    private void duckdrive(double speed, int left) {
        bot.markus.setPower(speed);
        bot.markus.setTargetPosition(left);


        runtime.reset();



        while(pos < left && runtime.seconds()< 10 && opModeIsActive()){


            pos = bot.markus.getCurrentPosition();
            telemetry.addData("left",""+pos);
            telemetry.addData("time",""+runtime.seconds());



            telemetry.update();

        }






    }

    private void rightdrive(double speed, int right) {
        bot.markus.setPower(speed);
        bot.markus.setDirection(DcMotorSimple.Direction.REVERSE);
        bot.markus.setTargetPosition(right);

        runtime.reset();

        while(pos < right && runtime.seconds() < 3 && opModeIsActive()){


            pos = bot.markus.getCurrentPosition();
            telemetry.addData("right",""+pos);
            telemetry.addData("time",""+runtime.seconds());


            telemetry.update();

        }
        bot.markus.setDirection(DcMotorSimple.Direction.FORWARD);





    }
}
