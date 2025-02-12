# For-TEA-Simo Code - 2024 Crescendo - SVR & MBR
See [the online changelog](https://github.com/REVrobotics/MAXSwerve-Java-Template/blob/main/CHANGELOG.md) for information about updates to the template that may have been released since you created your project. 

# Description
Official 2024 Code for FRC 253 Boba Bots

- Auto: PathPlanner Routines with Scoring
- Tele-Op: Field Centric Swerve Drivetrain with WIP Auto-Align, Amp Scoring Only
- Endgame: Climb Only

# Physical Robot Subsystems:
* MAXSwerveModules - Creates the 4 Swerve Modules - DRIVE
* Drive Subsystem - Defines the characteristic of our drive type and setups drive type for Auto + Optimization - DRIVE
* Arm - PIDF Controlled, Relative Encoders, AMP SCORE
* Hook - PIDF Controlled, Absolute Encoders, AMP SCORE
* LEDs - State-Check with Arm to select colors, VISUALS
* Vision - WIP Vision with RoboRIO - VISION

#  Functionality
* Autonomous (15 secs) - Autonomous Routine chosen by Drive Team for Scoring and Movement Score Bonuses.
   1. All Routine Paths/Auto loaded from PathPlanner into Deploy Folder
   2. Routines are defined inside of our Auto.java file and handled/timed by a Sequential Command Group for Movement + Scoring
   3. Utilizes an UI-based Autonomous Chooser inside of SmartDashboard for On-demand Selection by Drive Team
   4. Result: 1 Note Auto with Leave. Playoff Auto is currently deployed.

 * Teleoperated Periodic ( 2 min 15 secs)
   1. Drive: Periodically updated odometry from AHRS NavX. Running main Drive Method for Field Centric Movement, Joystick Controlled from X-box Controllers
   2. Arm: PIDF controlled for Relative Encoder-based Scoring setpoints, Button Activated from X-Box Controllers
   3. Hook: PIDF controlled for Absolute Encoder-based Scoring setpoints, Button Activated from X-box Conttollers
   4. LED: Switch Statement Based StateCheck for Automatic Syncing based on Arm Setpoints. Changes based on Arm State.
  
  * Endgame (15 secs)
    1. Objective: Climb during Endgame using Arm without any additional mechanisms
    2. Solution: Hook onto the chain using metal hooks on the Arm
    3. Raises the Arm into the UP Position and drive the robot so it is positioned inside the hook-able zone
    4. Runs a PIDF Loop to perform a perpetual pull-up and maintain its on-stage postion.

# Important File Locations   
## Locations
   - Source Code: src/main -> java/fc -> robot -> Defauly Java Files Inside
   - Autos & Paths Config: src/main -> java/fc -> deploy -> All Json Files Inside 
   - Subsystems: src/main -> java/fc -> robot -> "subsystem" Folder -> All Subsystem Files Inside
   - Autos: src/main -> java/fc -> robot -> "Autonomous" Folder -> All Subsystem Files Inside
   - 3rd Party Libraries: "vendordeps" Folder -> All 3rd Party Vendor Dependancies
## Purpose of Files
   - Source Code:
        1. Constants.java - Contains all Constants, which are refered by "kVar", used throughout the codebase. Update persistent variables here in order to keep consistency and reduce ambugity when looking for values. Update this file to tune for PID loops in Drive Subsystem, Arm, and Hook.
        2. RobotContainer.java - Creates the Arm, Hook, and DriveSubsystem objects used to pass in commands for functionality. Button Bindings for both driver and operator controllers. Also determines the current alliance color used for autonomous.
        3. Robot.java - Contains core runtime and intitialization code used for all periodics and disabled states. Autochooser is utilized here for selecting autonomous routines through Smartdashboard for on-demand change by driveteam where deploying code is not available.
        4. States.java - Enumeration states for Arm and Hook Encoder positions. Utilizes switch statements in respective subsystem file to choose between desired position states.
## Prerequisites
* SPARK MAX Firmware v1.6.2 - Adds features that are required for swerve
* REVLib v2023.1.2 - Includes APIs for the new firmware features
* Template Ver: v202(4).1
