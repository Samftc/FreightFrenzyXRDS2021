package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "RunToPos")
public class RunToPos extends LinearOpMode {
    //FreightBot motors
    DcMotorEx BL, FL, FR, BR, arm, duc;

    double time;
    double pos;
    int rotate;
    double sop;
    double om;


    @Override
    public void runOpMode(){
        BL = hardwareMap.get(DcMotorEx.class, "back_left_motor");
        FL = hardwareMap.get(DcMotorEx.class, "front_left_motor");
        FR = hardwareMap.get(DcMotorEx.class, "front_right_motor");
        BR = hardwareMap.get(DcMotorEx.class, "back_right_motor");

        BR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        BL.setDirection(DcMotor.Direction.REVERSE);
        FL.setDirection(DcMotor.Direction.REVERSE);


        duc = hardwareMap.get(DcMotorEx.class, "duck");
        duc.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


        arm = hardwareMap.get(DcMotorEx.class, "arm_motor");
        arm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        time = getRuntime();


        waitForStart();

        omniturn(100,true,1);


        drive(-0.5,-2200);

        waitseconds(1, 0);

        omniturn(200,false,1);

        waitseconds(5, 1);

        omniturn(1400,true,1);//for omni, right should also be positive





        //turn(1,2100); //turn part is useless, 2,100 should be 90°



        //drive(0.5,4000);

       // omniturn(1500,true,1);

    }

    private void turn(int turn, int rotate) {


        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        BL.setTargetPosition(rotate);
        BR.setTargetPosition(rotate);
        FL.setTargetPosition(-rotate);
        FR.setTargetPosition(-rotate);

        BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FR.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while(Math.abs(sop) < Math.abs(rotate) && !isStopRequested()){

            sop = BL.getCurrentPosition();


            BL.setPower(1);
            FL.setPower(1);
            FR.setPower(-1);
            BR.setPower(-1);



            telemetry.addData("pos", pos);
            telemetry.update();


        }



    }

    private void omniturn(int omni,boolean left,double power) { //omni is similar to rotate, but for omni wheels

        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        if(left) {
            BL.setTargetPosition(-omni);
            BR.setTargetPosition(omni);
            FL.setTargetPosition(omni);
            FR.setTargetPosition(-omni);
        } else {
            BL.setTargetPosition(omni);
            BR.setTargetPosition(-omni);
            FL.setTargetPosition(-omni);
            FR.setTargetPosition(omni);
        }

        BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FR.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        if(left) {
            om = FL.getCurrentPosition(); //om is basically pos
        }else{
            om = BL.getCurrentPosition(); //om is basically pos
        }

        while(Math.abs(om) < Math.abs(omni) && !isStopRequested()){


            if(left) {
                om = FL.getCurrentPosition(); //om is basically pos
            }else{
                om = BL.getCurrentPosition(); //om is basically pos
            }

            if(left) {
                BL.setPower(-power);
                FL.setPower(power);
                FR.setPower(-power);
                BR.setPower(power);
            } else{
                BL.setPower(power);
                FL.setPower(-power);
                FR.setPower(power);
                BR.setPower(-power);
            }



            telemetry.addData("pos", pos);
            telemetry.update();


        }


    }



    private void waitseconds(int seconds, int duck) {
        resetStartTime();
        time = getRuntime();

        while(time < seconds && !isStopRequested()){
            time = getRuntime();
            telemetry.addData("time", time);
            telemetry.addData("seconds", seconds);
            telemetry.update();

            BL.setPower(0);
            BR.setPower(0);
            FL.setPower(0);
            FR.setPower(0);

            if (duck == 1) {
                duc.setPower(0.5);
            }
            else if (duck == 0){
                duc.setPower(0);
            }
        }


    }

    private void drive(double speed, int distance) {

        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        BL.setTargetPosition(distance);
        BR.setTargetPosition(distance);
        FL.setTargetPosition(distance);
        FR.setTargetPosition(distance);

        BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FR.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        pos = BL.getCurrentPosition();



        while(Math.abs(pos) < Math.abs(distance) && !isStopRequested()){

            if(distance >= 0) {
                pos = BL.getCurrentPosition();
            }
            else {
                pos = BL.getCurrentPosition()- 10;
            }
            duc.setPower(0);





            BL.setPower(speed);
            BR.setPower(speed);
            FL.setPower(speed);
            FR.setPower(speed);





            telemetry.addData("pos", pos);
            telemetry.addData("Distance", distance);
            telemetry.addData("speed",speed);
            telemetry.update();


        }

    }
}
