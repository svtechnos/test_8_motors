// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  private static final double sped=0.3;
  private static final double remp=6;
  private static final double fremp=0.2;
  private static final int DeviceID1 = 1; 
  private static final int DeviceID2 = 2;
  private static final int DeviceID3 = 3; 
  private static final int DeviceID4 = 4;
  private static final int DeviceID5 = 5; 
  private static final int DeviceID6 = 6;
  private static final int DeviceID7 = 7; 
  private static final int DeviceID8 = 8;
  private CANSparkMax m_1;
  private CANSparkMax m_2;
  private CANSparkMax m_3;
  private CANSparkMax m_4;
  private CANSparkMax m_5;
  private CANSparkMax m_6;
  private CANSparkMax m_7;
  private CANSparkMax m_8;
  private int counter;
  private Timer clock;
  private RelativeEncoder e_1;
  private RelativeEncoder e_2; 
  private RelativeEncoder e_3;
  private RelativeEncoder e_4;
  private RelativeEncoder e_5;
  private RelativeEncoder e_6;
  private RelativeEncoder e_7;
  private RelativeEncoder e_8;




  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);

    clock = new Timer();


    m_1 = new CANSparkMax(DeviceID1, MotorType.kBrushless);
    m_2 = new CANSparkMax(DeviceID2, MotorType.kBrushless);
    m_3 = new CANSparkMax(DeviceID3, MotorType.kBrushless);
    m_4 = new CANSparkMax(DeviceID4, MotorType.kBrushless);
    m_5 = new CANSparkMax(DeviceID5, MotorType.kBrushless);
    m_6 = new CANSparkMax(DeviceID6, MotorType.kBrushless);
    m_7 = new CANSparkMax(DeviceID7, MotorType.kBrushless);
    m_8 = new CANSparkMax(DeviceID8, MotorType.kBrushless);

    e_1 = m_1.getEncoder();
    e_2 = m_2.getEncoder();
    e_3 = m_3.getEncoder();
    e_4 = m_4.getEncoder();
    e_5 = m_5.getEncoder();
    e_6 = m_6.getEncoder();
    e_7 = m_7.getEncoder();
    e_8 = m_8.getEncoder();

    m_1.restoreFactoryDefaults();
    m_2.restoreFactoryDefaults();
    m_3.restoreFactoryDefaults();
    m_4.restoreFactoryDefaults();
    m_5.restoreFactoryDefaults();
    m_6.restoreFactoryDefaults();
    m_7.restoreFactoryDefaults();
    m_8.restoreFactoryDefaults();
    m_1.setOpenLoopRampRate(remp);
    m_2.setOpenLoopRampRate(remp);
    m_3.setOpenLoopRampRate(remp);
    m_4.setOpenLoopRampRate(remp);
    m_5.setOpenLoopRampRate(remp);
    m_6.setOpenLoopRampRate(remp);
    m_7.setOpenLoopRampRate(remp);
    m_8.setOpenLoopRampRate(remp);
    m_1.setIdleMode(IdleMode.kBrake);
    m_2.setIdleMode(IdleMode.kBrake);
    m_3.setIdleMode(IdleMode.kBrake);
    m_4.setIdleMode(IdleMode.kBrake);
    m_5.setIdleMode(IdleMode.kBrake);
    m_6.setIdleMode(IdleMode.kBrake);
    m_7.setIdleMode(IdleMode.kBrake);
    m_8.setIdleMode(IdleMode.kBrake);
   
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

  public void clear_Motors(){
    m_1.setOpenLoopRampRate(fremp);
    m_2.setOpenLoopRampRate(fremp);
    m_3.setOpenLoopRampRate(fremp);
    m_4.setOpenLoopRampRate(fremp);
    m_5.setOpenLoopRampRate(fremp);
    m_6.setOpenLoopRampRate(fremp);
    m_7.setOpenLoopRampRate(fremp);
    m_8.setOpenLoopRampRate(fremp);
    m_1.stopMotor();
    m_2.stopMotor();
    m_3.stopMotor();
    m_4.stopMotor();
    m_5.stopMotor();
    m_6.stopMotor();
    m_7.stopMotor();
    m_8.stopMotor();
    m_1.setOpenLoopRampRate(remp);
    m_2.setOpenLoopRampRate(remp);
    m_3.setOpenLoopRampRate(remp);
    m_4.setOpenLoopRampRate(remp);
    m_5.setOpenLoopRampRate(remp);
    m_6.setOpenLoopRampRate(remp);
    m_7.setOpenLoopRampRate(remp);
    m_8.setOpenLoopRampRate(remp);
  }

  @Override
  public void teleopInit() {
    counter = 1;
    clock.reset();
    clock.start();
    clear_Motors();
  }
  @Override
  public void teleopPeriodic() {
    switch(counter){
      case 1:
        m_1.set(sped);
        System.out.println("e_1 pos: "+e_1.getPosition());
        break;
      case 3:
        m_2.set(sped);
        System.out.println("e_2 pos: "+e_2.getPosition());
        break;
      case 5:
        m_3.set(sped);
        System.out.println("e_3 pos: "+e_3.getPosition());
        break;
      case 7:
        m_4.set(sped);
        System.out.println("e_4 pos: "+e_4.getPosition());
        break;
      case 9:
        m_5.set(sped);
        System.out.println("e_5 pos: "+e_5.getPosition());
        break;
      case 11:
        m_6.set(sped);
        System.out.println("e_6 pos: "+e_6.getPosition());
        break;
      case 13:
        m_7.set(sped);
        System.out.println("e_7 pos: "+e_7.getPosition());
        break;
      case 15:
        m_8.set(sped);
        System.out.println("e_8 pos: "+e_8.getPosition());
        break;
      case 17:
        clock.stop();
        break;
      default:
        clear_Motors();

    }
    
    if(clock.get()>=2){
      counter++;
      clear_Motors();
      clock.reset();
      clock.start();
    }
  }
  @Override
  public void disabledInit() {}
  @Override
  public void disabledPeriodic() {}
  @Override
  public void testInit() {}
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}
  @Override
  public void simulationPeriodic() {}
}
