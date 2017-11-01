package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Jeremy on 10/20/2017.
 */

@Autonomous(name = "BlueAUtoRefRight", group = "Test")
@Disabled
public class BlueAutoRef extends LinearOpMode
{
    private TankBase robot;
    private NewRobot newRobot;

    public void runOpMode()
    {
        float x = 0;
        float center = x;
        robot = new TankBase(hardwareMap);
        newRobot = new NewRobot(hardwareMap);
        waitForStart();

        // Close doors
        // Lift up doors to get glyph
        // Lower the left arm
        char cipher = newRobot.getGlyphCipher();
        // Look at the color of platform
        // Sense color of the jewel
        // if the jewel has the same color as the platform; move backwards; return to original position
        // else if the jewel isn't same color; move forward; return to original position
        // else (no color sense); do nothing
        // raise/retract arm
        robot.driveStraight_In(x);
        robot.pivot_IMU(-90,.25);
        switch (cipher)
        {
            case 'l':
                robot.driveStraight_In(x);
                break;
            case 'c':
                robot.driveStraight_In(x);
                break;
            case 'r':
                robot.driveStraight_In(x);
                break;
            default:
                robot.driveStraight_In(center);
                break;
        }

        robot.pivot_IMU(90, .25);
        robot.driveStraight_In(x);
        robot.driveStraight_In(x, .25);
        // lower door attachment to the ground
        //lower door attachment to ground
        //open door attachment to release glyph
        robot.driveStraight_In(-2); // back up
        robot.stopAllMotors();


        /* Old code
        //Need to identify the cipher picture
        //Spin to knock Jewel out
         robot.pivot_IMU(30, .25);
        robot.pivot(-30, .25);
        robot.driveStraight_In(36f);
        robot.pivot_IMU(-90f,.25);
        //Drive distance based on cipher
        robot.pivot_IMU(90f,.25);
        robot.driveStraight_In(12f,.3);
        //Drop cipher in box
        robot.stopAllMotors();
        */
    }
}
