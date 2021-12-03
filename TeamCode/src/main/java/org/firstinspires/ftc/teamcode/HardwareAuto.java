package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
//hello

@Autonomous(name = "HardwareAuto")
public class HardwareAuto extends LinearOpMode {

    HardwareOmni        bot = new HardwareOmni();



    double pos = 0;
    int r = 0;

    double speed = 1;
    private ElapsedTime     runtime = new ElapsedTime();



    @Override
    public void runOpMode() throws InterruptedException {
        bot.init(hardwareMap);
        bot.markus.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bot.markus.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        waitForStart();


            //functions that control the drive motors, 
        duckdrive(speed, 4000, 0, false, 0);//for reverse 0 is  1 is backwards
        duckdrive(speed, 8000, 1, true,0);
        duckdrive(speed, 0, 0, true,10);
        duckdrive(speed, 2000, 0, false,0);
        duckdrive(speed, 2000, 1, false,0);





        telemetry.addData("stop","");





    }

    private void duckdrive(double speed, int forward, int reverse, boolean duckwheel, double extrawait) {
        bot.markus.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        bot.markus.setMode(DcMotor.RunMode.RUN_USING_ENCODER);



        if(reverse == 0) {
            bot.markus.setTargetPosition(forward);
        }
        else if (reverse == 1){
            bot.markus.setTargetPosition(forward*-1);
        }



        bot.markus.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        bot.markus.setPower(speed);

        runtime.reset();

        if(duckwheel){
            bot.Arm.setPower(1);
        }
        else{
            bot.Arm.setPower(0);
        }


        if (reverse == 0) {
            while (pos < forward && runtime.seconds() < 10 && opModeIsActive()) {


                pos = bot.markus.getCurrentPosition();
                telemetry.addData("forward", "" + pos);
                telemetry.addData("time", "" + runtime.seconds());


                telemetry.update();

            }


        }
        else if (reverse == 1){
            while (pos > forward*-1 && runtime.seconds() < 10 && opModeIsActive()) {


                pos = bot.markus.getCurrentPosition();
                telemetry.addData("forward", "" + pos);
                telemetry.addData("time", "" + runtime.seconds());


                telemetry.update();
            }
        }
        //added comment


        while(extrawait < runtime.seconds()){
            telemetry.addData("time", runtime.seconds());
            telemetry.update();
        }



    }




}
