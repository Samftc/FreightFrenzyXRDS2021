/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
@Disabled
/**
 * This is NOT an opmode.
 *
 * This class can be used to define all the specific hardware for a single robot.
 * In this case that robot is a Pushbot.
 * See PushbotTeleopTank_Iterative and others classes starting with "Pushbot" for usage examples.
 *
 * This hardware class assumes the following device names have been configured on the robot:
 * Note:  All names are lower case and some have single spaces between words.
 */
//crossroads is password to control hub
          /* Motors:
  back_right_motor
  front_right_motor
  arm_motor
  front_left_motor
  back_left_motor
Servos:
  hand_servo*/


public class HardwareOmni
{
    /* Public OpMode members. */
    public DcMotor  BL   = null;
    public DcMotor  BR  = null;
    public DcMotor  FR     = null;
    public DcMotor  FL     = null;
    public DcMotor  Arm     = null;
    public DcMotor  duc     = null;
    public DcMotor  markus     = null;
    public Servo    HSL    = null;
    public Servo    HSR  = null;

    public static final double MID_SERVO       =  0.5 ;
    public static final double ARM_UP_POWER    =  0.45 ;
    public static final double ARM_DOWN_POWER  = -0.45 ;

    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public HardwareOmni(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        BL  = hwMap.get(DcMotor.class, "back_left_motor");
        BR = hwMap.get(DcMotor.class, "back_right_motor");
        FL = hwMap.get(DcMotor.class, "front_left_motor");
        FR = hwMap.get(DcMotor.class, "front_right_motor");
        Arm = hwMap.get(DcMotor.class, "arm_motor");
        duc = hwMap.get(DcMotor.class, "duck");

        BR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        BL.setDirection(DcMotor.Direction.REVERSE); // Set to REVERSE if using AndyMark motors
        FL.setDirection(DcMotorSimple.Direction.REVERSE);

        // Set all motors to zero power
      BR.setPower(0);
      BL.setPower(0);
      FR.setPower(0);
      FL.setPower(0);
      Arm.setPower(0);
      Arm.setPower(0);
      duc.setPower(0);


        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders arBR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //        FR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //        Arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //        BL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //        FL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);e installed.
        BR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        FR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        FL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        Arm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        duc.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Define and initialize ALL installed servos.
       HSL  = hwMap.get(Servo.class, "hand_servo_left");
       HSR = hwMap.get(Servo.class, "hand_servo_right");
    }
 }

