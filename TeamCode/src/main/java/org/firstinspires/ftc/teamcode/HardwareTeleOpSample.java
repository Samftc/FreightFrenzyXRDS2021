package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class HardwareTeleOpSample extends OpMode {

    /* Declare OpMode members. */
    HardwareOmni        bot = new HardwareOmni();



    @Override
    public void init() {
        bot.init(hardwareMap);



    }

    @Override
    public void loop() {
        bot.BR.setPower(1);


    }
}
