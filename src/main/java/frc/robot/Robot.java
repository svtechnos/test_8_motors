// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.SparkMaxAlternateEncoder.Type;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxAlternateEncoder;
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
  private static final int MotorDeviceID[] = {1,2,3,4,5,6,7,8};
  private int i;
  private CANSparkMax m[];
  private RelativeEncoder e[];
  //private RelativeEncoder a[];
  private int counter;
  private Timer clock;
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
    clock = new Timer();
    CANSparkMax m[] = new CANSparkMax[8];
    RelativeEncoder e[] = new RelativeEncoder[8];
    //RelativeEncoder a[] = new RelativeEncoder[4];
    for(i=0;i<8;i++){
      m[i] = new CANSparkMax(MotorDeviceID[i], MotorType.kBrushless);
      m[i].restoreFactoryDefaults();
      m[i].setOpenLoopRampRate(remp);
      m[i].setIdleMode(IdleMode.kBrake);
      e[i] = m[i].getEncoder();
    }
    //for(i=0;i<8;i+=2){
      //a[i/2] = m[i].getAlternateEncoder(SparkMaxAlternateEncoder.Type.kQuadrature, 4096);
    //}
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
    for(i=0;i<8;i++){
      m[i].setOpenLoopRampRate(fremp);
      m[i].stopMotor();
      m[i].setOpenLoopRampRate(remp);
    }
  }
  public void test_Motors(){
    if(counter < 16){
      if(counter%2!=0){
        m[counter/2].set(sped);
        System.out.println("e_1 pos: "+e[counter/2].getPosition());
        //System.out.println("a "+((counter/2)%4)+"pos: "+a[(counter/2)%4].getPosition());
      } else {clear_Motors();}
      if(clock.get()>=1){
        counter++;
        clear_Motors();
        clock.reset();
        clock.start();
      }
    }
  }
  @Override
  public void teleopInit() {
    counter = 0;
    clock.reset();
    clock.start();
    clear_Motors();
  }
  @Override
  public void teleopPeriodic() {test_Motors();}
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
