import java.util.*;

public class CarPark  {

    private final static String PARK_FORMAT_STRING =
            "Автопарк: %s, число машин: %3d"; //формат записи о автопарке
    private String name; //название автопарка
    private List <Car> cars; // список автомобилей

    public CarPark() {
        name="";
        cars = new ArrayList <Car>(); //создается пустой список
    }
    public CarPark (String name){
        this.name=name;
        cars = new ArrayList <Car>();
    }
    public CarPark (String name, List list){
        this.name=name; //задается название автопарка
        cars = new ArrayList <Car>(list);

    }

    public void setName(String name)
    {this.name = name;}

    public String getName(){return name;}
    public List <Car> getCars(){
        return cars;
    }

    public String toString(){
        return String.format(PARK_FORMAT_STRING,name,getCarNum());
    }

    public boolean addCar(Car car){

        if (getCar(car.getId())!=null) return false; //дополнительная

        if (cars.add(car)) return true;
        else return false;
    }
    public boolean delCar(int id){

        if (cars.remove(new Car(id,"",0,0))) return true;
        else return false;
    }

    public Car getCar (int id){

        for (Car car:cars)
            if (car.getId() == id) return car;
        return null;
    }
    public int getCarNum(){

        return cars.size();
    }
    public double avgCost(){

        int num=cars.size();
        if (num==0) return 0;
        double avg=0;
        for (Car c:cars)
            avg=avg+c.getCost();
        return avg/num;
    }
    public CarPark  aboveAvgCost(){

        double avg=avgCost();
         CarPark park = new CarPark  (name+ "\nМашины, цена которых выше среднего : "+ avg);

        for (Car car:cars)
            if (car.getCost()>avg)park.addCar(car);
        return park;
    }
    public CarPark  betweenCost(double b1, double b2){

         CarPark park = new CarPark  (
                 String.format (
                         "Машины , цена которых в диапазоне от %.2f до %.2f: \n%s",
                        b1,b2,name));

        Iterator <Car> iter = cars.iterator();
        while (iter.hasNext()){
            Car car = iter.next();
            if ((car.getCost() >= b1)&&(car.getCost() <= b2))park.addCar(car);
        }
        return park;
    }

    public CarPark  sort(){

         CarPark park = new CarPark  (name, cars);
        Collections.sort(park.cars);
        return park;
    }
    public CarPark  sort(Comparator comp){

         CarPark park = new CarPark  (name, cars);
        Collections.sort(park.cars, comp);
        return park;
    }
    public void putBrand(){
        System.out.printf("Марки автомобилей:\n%s\n",name);
        for(Car car:cars) {
            System.out.printf("%14s\n", car.getName());
        }
    }
    public CarPark  delBetweenCars(double b1, double b2){

        CarPark park = new CarPark(String.format("Удалить машины с ценой от %.2f до %.2f:\n%s",b1,b2,name));
        Iterator <Car> iter = cars.iterator();
        while (iter.hasNext()){
            Car car = iter.next();
            if ((car.getCost() < b1)||(car.getCost() > b2))park.addCar(car);
        }
        return park;
    }
    public CarPark  filter1(){
        CarPark park = new CarPark  (String.format("Марки начинающихся с Au:\n%s",name ));

        for (Car car:cars)
            if (car.getName().startsWith("Au"))park.addCar(car);
        return park;
    }
    public CarPark  filter2(){
        CarPark park = new CarPark  (String.format("Автомобили с нечетным id:\n%s",name ));

        for (Car car:cars)
            if ((int)car.getId() % 2 == 1) park.addCar(car);
        return park;
    }

    public CarPark  delBelowAvgCost(){

        double avg=avgCost();
        CarPark park = new CarPark  (String.format("Удалить машины,цена которых ниже среднего: %f\n%s : ",avg,name));

        for (Car car:cars)
            if (car.getCost()>=avg)park.addCar(car);
        return park;
    }
    public CarPark  update (Car c) {
        CarPark park = new CarPark();
        int k=0;
        for (Car car : cars)
            if (car.getId() == c.hashCode()) {k++; continue;}
            else if (car.getId()==c.getId()) {car.setId(c.hashCode()) ;park.addCar(car);}
            else park.addCar(car);

        if (k!=0) park= new CarPark();System.out.print("\nНовый id не уникален");
        return park;

    }
    public void putCarPark(){

        System.out.println(name); //имя автопарка
        System.out.printf("%6s%25s%14s%22s%20s\n",
                "Номер", "Номер машины в каталоге ", "Марка", "Год выпуска", "Цена автомобиля");
        int i=1;
        for (Car car:cars){
            System.out.printf(" %2d %14d %30s %15d %20f\n",
                    i, car.getId(), car.getName(), car.getYear(), car.getCost());
            i=i+1;
        }
    }
}