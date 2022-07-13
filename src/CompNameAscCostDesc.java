import java.util.*;
public class CompNameAscCostDesc implements Comparator{
    public int compare (Object ob1, Object ob2){
        Car car1 = (Car) ob1;
        Car car2 = (Car) ob2;
        if (car1.getName().compareTo(car2.getName())<0) return -1;
        else if (car1.getName().compareTo(car2.getName())> 0) return 1;

        else if (car1.getCost() < car2.getCost()) return 1;
        else if (car1.getCost() == car2.getCost()) return 0;
        else return -1;
    }

}