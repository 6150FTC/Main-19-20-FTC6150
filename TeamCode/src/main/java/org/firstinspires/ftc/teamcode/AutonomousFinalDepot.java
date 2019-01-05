package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@Autonomous(name = "!FinalDepot")
public class AutonomousFinalDepot extends LinearOpMode
{
    private CompRobot compRobot;
    VuforiaFunctions vuforiaFunctions;
    private float rightSensorDepth = 2;

    public void runOpMode()
    {
        compRobot = new CompRobot(hardwareMap, this);
        vuforiaFunctions = new VuforiaFunctions(this, hardwareMap);
        waitForStart();
        //sleep(5000);
        //compRobot.climbDown();
        //sleep(750);
        //compRobot.driveStraight(10, .5f);

        sleep(7000);
        char pos = vuforiaFunctions.getPositionOfGoldInTwoObjects();
        telemetry.addData("Will go in ", pos);
        telemetry.update();
        sleep(3000);
        switch (pos)
        {
            case 'l':
                compRobot.driveStraight(4, .7f);
                compRobot.pivotenc(30, .5f);
                compRobot.driveStraight(20, .7f);
                compRobot.pivotenc(-60, .5f);
                compRobot.deployMarker();
                compRobot.driveStraight(-5, 1);
                compRobot.pivotenc(165, .5f);
                break;
            case 'r':
                compRobot.driveStraight(4, .7f);
                compRobot.pivotenc(-30, .5f);
                compRobot.driveStraight(20, .7f);
                compRobot.pivotenc(30, .5f);

                break;
            default:
                compRobot.driveStraight(25, .8f);
                while (compRobot.getFrontDistSens().getDistance(DistanceUnit.INCH) > 20 && compRobot.getFrontRightDistSens().getDistance(DistanceUnit.INCH) > 20)
                {
                    compRobot.driveMotors(.4f, .4f);
                }
                compRobot.stopDriveMotors();
                compRobot.deployMarker();
                compRobot.driveStraight(-5, 1);
                compRobot.pivotenc(155, .5f);

                compRobot.driveStraight(16, .6f);

                compRobot.pivotenc(9, .5f);

                sleep(250);
        }
        compRobot.hugWallToRight(4 + rightSensorDepth, 8 + rightSensorDepth, 22, 60);
        compRobot.driveStraight(6, .8f);
        telemetry.addData("Stopped", null);
        telemetry.update();

        while (!isStopRequested())
        {
            compRobot.stopDriveMotors();
        }
    }
}



