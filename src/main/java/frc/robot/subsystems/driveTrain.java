package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class driveTrain extends SubsystemBase     {
    
   public static TalonSRX backleftmotor = new TalonSRX(Constants.CANid.backleftmotorCAN);
   public static TalonSRX backrightmotor = new TalonSRX(Constants.CANid.backrightmotorCAN);
   public static TalonSRX frontrightmotor = new TalonSRX(Constants.CANid.frontrightmotorCAN); 
   public static TalonSRX frontleftmotor = new TalonSRX(Constants.CANid.frontleftmotorCAN);


  public static DoubleSolenoid driveshifter = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);
    
  //When a button is held down it will drive faster
    public static Command driveToggle() {      

        return new InstantCommand(
            () -> driveshifter.toggle()
    );

    }

    //It sets the drive value forward
    public static void pneumaticENABLE(){
        driveshifter.set(Value.kReverse);
    }

    //Makes the left and right groups of motors move half speed
    public void drive(double left, double right){
    
        frontrightmotor.set(ControlMode.PercentOutput, right/2); 
        backrightmotor.set(ControlMode.PercentOutput, right/2);
        frontleftmotor.set(ControlMode.PercentOutput, -left/2);  
        backleftmotor.set(ControlMode.PercentOutput, -left/2);
    }

    public Command Akira (double left, double right){
        return new InstantCommand(
            () -> drive(-left, right)
        );
    }

    public Command ExampleCommand(){
        return new InstantCommand(
            () -> System.out.print("miles per hour")
        ); 
        
    }

    public Command HamburgerHelper(){
        return new InstantCommand(
        () -> System.out.print("Hamburger helper is help, Hamburger helper is love, Hamburgerhelper is life")
        );
    }

    /* 
    public Command Monkey_D_Luffy(){
        return new InstantCommand(
        () -> frontleftmotor.set(0)
        );

    }
public Command Spoong_boob(){
    return new InstantCommand(
        ()-> backleftmotor.set(0.5)
    );

}
public Command MAXIMUM_OVERDRIVE(){
    return new InstantCommand(
    () -> backleftmotor.set(1) 
    );   

}
*/
    }

    
    


