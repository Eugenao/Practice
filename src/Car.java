public class Car implements Comparable <Car> {

    private final static String CAR_FORMAT_STRING = "Машина: %8d, %15s, %8d,%8f ";

    private int id ;
    private String name;
    private int year ;
    private double cost;


    public Car() {
        id = 0; name = ""; year = 0; cost =0.0;

    }
    public Car(int id,String name, int year, double cost){ this.id = id; this.name = name; this.year = year;this.cost = cost;}


    public Car (Car car) {
        id = car.id;
        name = car.name;
        year = car.year;
        cost = car.cost;
    }
    public int getId(){return id;}
    public String getName() {return name;}
    public int getYear() {return year;}
    public double getCost(){return cost;}

    public void setId(int id) {this.id=id;}
    public void setName(String name) {this.name=name;}
    public void setYear(int year) {this.year=year;}
    public void setCost(double cost){this.cost=cost;}

    public String toString(){
        return String.format(CAR_FORMAT_STRING,id,name,year,cost);
    }


    //Переопределяется метод equals класса Object
//(задает способ сравнения объектов на равенство,
//возвращает true, если запускающий объект
//равен объекту-параметру)
    public boolean equals (Object ob){
        if (ob==this) return true; // ссылки равны – один
// и тот же объект
        if (ob==null) return false; //в метод передана null-ссылка
        if (getClass()!=ob.getClass())return false; //объекты разных классов
        Car car=(Car)ob; // преобразуем Object в Car
        return id == car.id; //id – ключевое поле объекта
    }
    //Переопределяется метод hashCode класса Object
//Возвращает хэш-код объекта
//(у равных объектов должны быть равные hash-коды)
    public int hashCode(){
        return 7* (new Integer(id)).hashCode();
    }
    //Определяем метод СоmpareTo интерфейса Сomparable
//Для определения естественного порядка перечисления элементов
    public int compareTo(Car c){
        if (id < c.id) return -1;
        else if (id == c.id) return 0;
        else return 1;
    }
}