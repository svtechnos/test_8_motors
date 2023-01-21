// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;




/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  private  CANSparkMax m1;
  private  CANSparkMax m2;
  private  CANSparkMax m3;
  private  CANSparkMax m4;
  private  CANSparkMax m5;
  private  CANSparkMax m6;
  private  CANSparkMax m7;
  private  CANSparkMax m8;
  private Timer clock;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
    clock = new Timer();

    m1=new CANSparkMax(1, MotorType.kBrushless);
    m2=new CANSparkMax(2, MotorType.kBrushless);
    m3=new CANSparkMax(3, MotorType.kBrushless);
    m4=new CANSparkMax(4, MotorType.kBrushless);
    m5=new CANSparkMax(5, MotorType.kBrushless);
    m6=new CANSparkMax(6, MotorType.kBrushless);
    m7=new CANSparkMax(7, MotorType.kBrushless);
    m8=new CANSparkMax(8, MotorType.kBrushless);

    m1.restoreFactoryDefaults();
    m2.restoreFactoryDefaults();
    m3.restoreFactoryDefaults();
    m4.restoreFactoryDefaults();
    m5.restoreFactoryDefaults();
    m6.restoreFactoryDefaults();
    m7.restoreFactoryDefaults();
    m8.restoreFactoryDefaults();

  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {}

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {
    clock.reset();
    clock.start();
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    while(clock.get()<=60){
      m1.set(0.1);
      m2.set(0.1);
      m3.set(0.1);
      m4.set(0.1);
      m5.set(0.1);
      m6.set(0.1);
      m7.set(0.1);
      m8.set(0.1);

    }
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {
    m1.set(0);
    m2.set(0.);
    m3.set(0);
      m4.set(0);
      m5.set(0);
      m6.set(0);
      m7.set(0);
      m8.set(0);
  }

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {

  }

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
