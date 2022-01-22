package frc.robot.subsytems.Drivetrain;

import java.util.concurrent.TimeUnit;

import ca.team3161.lib.robot.motion.drivetrains.SpeedControllerGroup;
import ca.team3161.lib.robot.subsystem.RepeatingPooledSubsystem;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpiutil.math.Pair;
import frc.robot.RobotMap;

public class DriveImpl extends RepeatingPooledSubsystem implements Drive {
    
    

    SpeedControllerGroup leftSide;
    SpeedControllerGroup rightSide;
    DifferentialDrive drivetrain;
    Encoder leftEncoder;
    Encoder rightEncoder;

    public DriveImpl(SpeedControllerGroup leftSide, SpeedControllerGroup rightSide) {
        super(20, TimeUnit.MILLISECONDS);
        this.leftSide = leftSide;
        this.rightSide = rightSide;
        this.drivetrain = new DifferentialDrive(leftSide, rightSide);
        this.leftEncoder = new Encoder(RobotMap.LEFT_ENCODER_PORTS[0], RobotMap.LEFT_ENCODER_PORTS[1], false, Encoder.EncodingType.k2X);
        this.rightEncoder = new Encoder(RobotMap.RIGHT_ENCODER_PORTS[0], RobotMap.RIGHT_ENCODER_PORTS[1], false, Encoder.EncodingType.k2X);
    }

    @Override
    public void defineResources() {
        require(leftSide);
        require(rightSide);
    }

    @Override
    public void task() throws Exception {
        // TODO Auto-generated method stub
    }

    @Override
    public void driveTank(double leftSpeed, double rightSpeed) {
        this.drivetrain.tankDrive(leftSpeed, rightSpeed);
    }

    @Override
    public void driveArcade(double speed, double rotation) {
        this.drivetrain.arcadeDrive(speed, rotation);
    }

    @Override
    public double getHeading() {
        return 0;
    }

    @Override
    public void resetEncoderTicks() {
        // Done
        this.leftEncoder.reset();
        this.rightEncoder.reset();
    }

    @Override
    public Pair<Double, Double> distanceDriven() {
        // TODO Auto-generated method stub
        return Pair.of(0.0, 0.0);
    }
}
