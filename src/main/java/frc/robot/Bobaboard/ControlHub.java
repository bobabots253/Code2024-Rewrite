package frc.robot.Bobaboard;

import java.util.Optional;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Autonomous.AutoModeManager.DesiredMode;

public class ControlHub {
    private static ControlHub mInstance = null;

	public static ControlHub getInstance() {
		if (mInstance == null) {
			mInstance = new ControlHub();
        }
		return mInstance;
	}

	public SimpleXboxControllerSetup driverController;
	public SimpleXboxControllerSetup operatorController;
	public SimpleXboxControllerSetup tControllerSetup1;
	public SimpleXboxControllerSetup tControllerSetup2;
	// Optional<Integer> testController = Optional.of();

	boolean testBoolean = false;

	private ControlHub() {
		driverController = new SimpleXboxControllerSetup(Constants.OIConstants.kDriverControllerPort);
		operatorController = new SimpleXboxControllerSetup(Constants.OIConstants.kOperatorControllerPort);
	}

	public void verifyControllerIntegrity(){
		boolean driverIsConnected = driverController.isConnected();
		boolean operatorIsConnected = operatorController.isConnected();
		SmartDashboard.putBoolean("Controller Can Exist", testBoolean);
		SmartDashboard.putBoolean("Driver Controller Connected", driverIsConnected);
		SmartDashboard.putBoolean("Operator Controller Connected", operatorIsConnected);
	}

	public boolean verifyPossibleControllerInit(){
		tControllerSetup1 = new SimpleXboxControllerSetup(Constants.OIConstants.kDriverControllerPort);
		tControllerSetup2 = new SimpleXboxControllerSetup(Constants.OIConstants.kOperatorControllerPort);
		if (tControllerSetup1.isConnected() == false || tControllerSetup2.isConnected() == false){
			tControllerSetup1 = null;
			tControllerSetup2 = null;
			testBoolean = false;
			return testBoolean;
		}else{
			tControllerSetup1 = null;
			tControllerSetup2 = null;
			testBoolean = true;
			return testBoolean;
		}
	}

	public void update() {
		driverController.update();
		operatorController.update();
	}

}
