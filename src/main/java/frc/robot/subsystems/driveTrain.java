package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class driveTrain extends SubsystemBase     {
    
    //These line of code give the motors a name
    //This line of code tells the code that we are making a motor that is powered by a talonSRX then we name it as backleft motor 
    //"new" tells the code that we're making a new TalonSRX object which then the backleftmotor gets set from CANid which gets set from constant  
   public static TalonSRX backleftmotor = new TalonSRX(Constants.CANid.backleftmotorCAN);
   public static TalonSRX backrightmotor = new TalonSRX(Constants.CANid.backrightmotorCAN);
   public static TalonSRX frontrightmotor = new TalonSRX(Constants.CANid.frontrightmotorCAN); 
   public static TalonSRX frontleftmotor = new TalonSRX(Constants.CANid.frontleftmotorCAN);


//when a button is pressed the solenoid goes up and when you press another button it goes down.
  public static DoubleSolenoid driveshifter = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1); 
//When we press a button the flag goes up and when the second button is pressed it retacts.
    public static DoubleSolenoid Pushypush = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 3);

  //When a button is held down it will drive faster
    public static Command driveToggle() {      
        return new InstantCommand(
            () -> driveshifter.toggle()
    );
}

    //It sets the drive value forward
    public static void pneumaticENABLE(){
        driveshifter.set(Value.kReverse);
        Pushypush.set(Value.kReverse);
    }
    
    public static Command RighTriggerOn() {
        return new InstantCommand(
        () ->  Pushypush.set(Value.kForward)
        );
    }

    public static Command LefTriggerOff() {
        return new InstantCommand(
        () ->  Pushypush.set(Value.kReverse)
        );
    } 

    //Makes the left and right groups of motors move half speed
    public void drive(double left, double right){
    
        frontrightmotor.set(ControlMode.PercentOutput, right/2); 
        backrightmotor.set(ControlMode.PercentOutput, right/2);
        frontleftmotor.set(ControlMode.PercentOutput, -left/2);  
        backleftmotor.set(ControlMode.PercentOutput, -left/2);
    }

    //Akira will take a left and right value, and run the drive function using those values.
    //The left motors will move in the negative direction
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
        () -> Pushypush.getFwdChannel()
        );
    }

}

    
    


