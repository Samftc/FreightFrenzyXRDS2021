package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@Autonomous(name = "RedSpinALl")
public class RedSpinAll extends LinearOpMode {
    //FreightBot motors
    DcMotorEx BL, FL, FR, BR, arm, duc;
    Servo HSL;
    Servo HSR;

    double time;
    double pos;
    int rotate;
    double sop;
    double om;
    int location;

    double armheight;


    @Override
    public void runOpMode(){
        BL = hardwareMap.get(DcMotorEx.class, "back_left_motor");
        FL = hardwareMap.get(DcMotorEx.class, "front_left_motor");
        FR = hardwareMap.get(DcMotorEx.class, "front_right_motor");
        BR = hardwareMap.get(DcMotorEx.class, "back_right_motor");

        HSL = hardwareMap.servo.get("hand_servo_left");
        HSR = hardwareMap.servo.get("hand_servo_right");


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

        HSL.setPosition(0);
        HSR.setPosition(1);
        waitseconds(1,0);

        //we need the robot to get the distance sensor to the 27 inch mark, the 35, and  44 1/2
        //distance sensor is 8 1/2 inches from the back (basically 8 1/2 inch head start)

        drive(-0.5, -180);

        waitseconds(5,1);


        omniturn(1900,true,1);

        waitseconds(0.5,0);

        drive(-0.5, -200);

        drive(0.5,740); // goes to first object
        distcode(1,1);

        drive(0.5,320); // goes to second object
        distcode(1,2);

        if(location != 1 && location != 2){
            location = 3;
            duc.setPower(0);
        }
        omniturn(300,false,1);

        waitseconds(0.5,0);



        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        if (location == 1){
            armpos(0.5,900);//pos 1
        }else if (location == 2){
            armpos(0.5,2600);// pos 2   doesn't work for going down right now
        }else if(location == 3){
            armpos(0.5,4100);// pos 3
        }

        if(location == 1){
            drive(0.5, 400);
        }else if(location == 2){
            drive(0.5,400);
        }else if(location ==3){
            drive(0.5,400);
        }

        HSR.setPosition(0.70);
        HSL.setPosition(0.30);

        waitseconds(0.5,0);
        drive(-0.5,-500);
        waitseconds(0.5,0);
        armpdown(-1,-100);//armdown only works for lowering the arm

        drive(-0.5,-1500);


        waitseconds(0.5,0);

        waitseconds(0.5,0);

        omniturn(600,false,1);



        //go backworeds
        //armpdown(1,-100);//armdown only works for lowering the arm


        //thing is 50 inches away






        //1,150 position for first location
        //2,600 for second position
        //4,000






        //omniturn(100,true,1);// if left is true, then it will go to the left if you're looking at the robot from the servo side
        //drive(0.5,40); // around 1/2 of an inch
        //drive(0.5,80); //2 inches
        //drive(0.5, 220);// 5 1/2 inches forward
        //drive(0.5, 210);// 4 1/2 inches forward
        //drive(0.5, 500); // 13 1/2 inches
        //drive(0.5,920); // 23 inches (the aprroximate length of a  tile) kind of
        //drive(0.5,840); // about 22 inches
        //drive(0.5,460); // 11 1/2 inches
        //for the drive function, the position divided by inches gone aproaches 40 for bigger numbers
        //omniturn(500, false, 0.5); // at 500, then it will go 11 inches


        // waitseconds(0.5, 0);

        //turn(0.5, 2000); // 270° rotation probably
        //turn(0.5, 690); // 90°

        //waitseconds(1, 0);
        //turn(0.5, 690); // 90°

        //waitseconds(1, 0);

        //turn(0.5, 1355); // 180°

        //waitseconds(1, 0);
        //turn(0.5, 2751); // 360° theoretically
        //turn(1, 667); // 90° rotation probably

        //drive(-0.5,-400);
        //waitseconds(1, 0);
        //drive(0.5,800);
        //turn(0.5,1000);


        //drive(0.5,500);




        //omniturn(200,false,1);

        //waitseconds(5, 1);

        //omniturn(1400,true,1);//for omni, right should also be positive





        //turn(1,2100); //turn part is useless, 2,100 should be 90°



        //drive(0.5,4000);

        // omniturn(1500,true,1);

    }

    private void armpdown(double power, int position) {
        arm.setTargetPosition(position);

        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);



        armheight = arm.getCurrentPosition();



        while(  armheight > position && !isStopRequested()){

            armheight = arm.getCurrentPosition();


            arm.setPower(power);



            telemetry.addData("power", power);
            telemetry.update();


        }
    }

    private void armpos(double power, int position) {

        arm.setTargetPosition(position);

        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);



        armheight = arm.getCurrentPosition();



        while(  armheight < position && !isStopRequested()){

            armheight = arm.getCurrentPosition();


            arm.setPower(power);



            telemetry.addData("power", power);
            telemetry.update();


        }

    }

    private void distcode(double seconds, int loc) {// if the distance sensor sees an object, it does stuff


// you can use this as a regular DistanceSensor.
        DistanceSensor sensorRange = hardwareMap.get(DistanceSensor.class, "dist2");

        // you can also cast this to a Rev2mDistanceSensor if you want to use added
        // methods associated with the Rev2mDistanceSensor class.
        Rev2mDistanceSensor sensorTimeOfFlight = (Rev2mDistanceSensor) sensorRange;

        resetStartTime();
        time = getRuntime();

        while(time < seconds && !isStopRequested()){
            time = getRuntime();
            telemetry.addData("time", time);
            telemetry.addData("seconds", seconds);
            telemetry.update();



            telemetry.addData("deviceName", sensorRange.getDeviceName());
            telemetry.addData("range", String.format("%.01f cm", sensorRange.getDistance(DistanceUnit.CM)));
            double distance = sensorRange.getDistance(DistanceUnit.CM);

            telemetry.addData("distance", distance);

            // Rev2mDistanceSensor specific methods.
            telemetry.addData("ID", String.format("%x", sensorTimeOfFlight.getModelID()));
            telemetry.addData("did time out", Boolean.toString(sensorTimeOfFlight.didTimeoutOccur()));

            telemetry.update();


            if(distance < 40 && loc == 1){
                location = 1;
                telemetry.addData("location", location);
                telemetry.update();
                duc.setPower(0.5);

            }else if (distance < 40 && loc == 2){
                location = 2;
                telemetry.addData("location", location);
                telemetry.update();
                duc.setPower(0.5);
            }

        }


    }


    private void turn(double turn, int rotate) {


        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        BL.setTargetPosition(rotate);
        BR.setTargetPosition(-rotate);
        FL.setTargetPosition(rotate);
        FR.setTargetPosition(-rotate);

        BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        sop = BL.getCurrentPosition();

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



    private void waitseconds(double seconds, int duck) {

        resetStartTime();
        time = getRuntime();

        while(time < seconds && !isStopRequested()){
            time = getRuntime();
            telemetry.addData("time", time);
            telemetry.addData("seconds", seconds);
            telemetry.addData("location", location);
            telemetry.update();

            BL.setPower(0);
            BR.setPower(0);
            FL.setPower(0);
            FR.setPower(0);
            arm.setPower(0);

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

