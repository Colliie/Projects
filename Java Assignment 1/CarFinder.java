import java.util.*;
import java.io.*;

public class CarFinder {
    protected static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    protected static String UserMake;
    protected static String UserModel;
    protected static int UserOption;

    /* Prompts user for the make and model of the car their searching for */
    public static void getCar() {
        try {
            System.out.print("What is the make of the car? ");
            UserMake = reader.readLine();
            System.out.print("What is the model of the car? ");
            UserModel = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    String getUserMake() {
        return UserMake;
    }

    public void setUserMake(String userMake) {
        UserMake = userMake;
    }

    public String getUserModel() {
        return UserModel;
    }

    public void setUserModel(String userModel) {
        UserModel = userModel;
    }

    public int getUserOption() {
        return UserOption;
    }

    /* Prompts user for task */
    public void setUserOption() {
        try {
            System.out.print("\n(1)Search for a car\n(2)View all cars in the list\n(3)End program\n");
            UserOption = Integer.parseInt(reader.readLine());
        } catch (IllegalArgumentException | IOException e) {
            System.out.println("Invalid option");
        }
    }

    /* Compares users answers with car objects in car array */
    public static void searchForCar() {
        boolean found = false;
        while (!found) {
            try {
                for (Car car : CreateCarArray.cars) {
                    if (car.getMake().equalsIgnoreCase(UserMake) && car.getModel().equalsIgnoreCase(UserModel)) {
                        System.out.println(car.getMake() + " " + car.getModel() + "'s newest models were released the following years: " + car.getYear() + ".");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.out.print(UserMake + " or " + UserModel + " is not a valid make or model option.\n");
                getCar();
                continue;
            }
        }

    }

    /* Prints all cars in cars array */
    public static void viewAllCars() {
        for (Car car : CreateCarArray.cars) {
            System.out.println(car.getModel() + " " + car.getMake() + " " + car.getYear());
        }
    }

}
