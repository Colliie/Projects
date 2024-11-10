import java.io.*;


/* Main program */
public class Main {
    public static void main(String[] args) throws IOException {
        FileInputSc.readFile("CarData.txt");
        CreateCarArray createCarArray = new CreateCarArray(FileInputSc.lines);
        CarFinder carFinder = new CarFinder();
        boolean done = false;

        while (!done) {
            carFinder.setUserOption();
            if (CarFinder.UserOption == 1) {
                CarFinder.getCar();
                CarFinder.searchForCar();
            }

            if (CarFinder.UserOption == 2) {
                CarFinder.viewAllCars();
            }

            if (CarFinder.UserOption == 3) {
                System.out.print("");
                done = true;
            }
        }

    }
}
