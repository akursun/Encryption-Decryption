import java.util.Scanner;

class MotorStaticFactory {

    /**
     * It returns an initialized motor according to the specified type by the first character:
     * 'P' or 'p' - pneumatic, 'H' or 'h' - hydraulic, 'E' or 'e' - electric, 'W' or 'w' - warp.
     */
    public static Motor make(char type, String model, long power) {
        Motor motor;
        switch (Character.toLowerCase(type)) {
            case 'p':
                motor = new PneumaticMotor(model, power);
                break;
            case 'h':
                motor = new HydraulicMotor(model, power);
                break;
            case 'e':
                motor = new ElectricMotor(model, power);
                break;
            case 'w':
                motor = new WarpDrive(model, power);
                break;
            default:
                return motor = null;
        }
        return motor;
    }
}

/* Do not change code below */
class Motor {

    String model;
    long power;

    public Motor(String model, long power) {
        this.model = model;
        this.power = power;
    }
}

class PneumaticMotor extends Motor {

    public PneumaticMotor(String model, long power) {
        super(model, power);
    }
}

class HydraulicMotor extends Motor {

    public HydraulicMotor(String model, long power) {
        super(model, power);
    }
}

class ElectricMotor extends Motor {

    public ElectricMotor(String model, long power) {
        super(model, power);
    }
}

class WarpDrive extends Motor {

    public WarpDrive(String model, long power) {
        super(model, power);
    }
}

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final char type = scanner.next().charAt(0);
        final String model = scanner.next();
        final long power = scanner.nextLong();
        final Motor motor = MotorStaticFactory.make(type, model, power);
        if (motor == null) {
            System.out.println(motor);
        } else {
            System.out.println(motor.getClass().getName() + " " + motor.model + " " + motor.power);
        }
    }
}