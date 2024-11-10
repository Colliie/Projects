import java.util.ArrayList;
import java.util.List;

/* Creates car objects using the rows of text in "CarData" */
class CreateCarArray {
    protected static ArrayList<Car> cars;

    public CreateCarArray(List<String> lines) {
        cars = new ArrayList<>();
        for (String line : lines) {
                String[] parts = line.split("\\|");
                String model = parts[0].trim();
                String make = parts[1].trim();
                String years = parts[2].trim();
                cars.add(new Car(model, make, years));
        }
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        CreateCarArray.cars = cars;
    }
}