// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import java.sql.Driver;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.driveTrain;

public class RobotContainer {

  private final driveTrain m_DriveTrain = new driveTrain();
  //joystick
  CommandJoystick righJoystick = new CommandJoystick(2);
  CommandJoystick lefJoystick = new CommandJoystick(1);
    public RobotContainer() {
      
    configureBindings();

    m_DriveTrain.setDefaultCommand(
      new RunCommand(
    () -> m_DriveTrain.drive(lefJoystick.getY(), righJoystick.getY()), m_DriveTrain)
    //driveTrain.drive(lefJoystick.getY(), righJoystick.getY()))
    );

    }


  private void configureBindings() {

    Trigger joyButtonLeft = lefJoystick.button(3);

    joyButtonLeft.whileTrue((driveTrain.driveToggle()));

    //joyButtonLeft.whileTrue(())
    
  }
  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }

}
