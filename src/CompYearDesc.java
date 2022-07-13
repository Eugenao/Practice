import java.util.*;
public class CompYearDesc implements Comparator {
    public int compare(Object ob1, Object ob2) {
        Car car1 = (Car) ob1;
        Car car2 = (Car) ob2;
        if (car1.getYear() < car2.getYear()) return -1;
        else if (car1.getYear() == car2.getYear()) return 0;
        else return 1;
    }
}
