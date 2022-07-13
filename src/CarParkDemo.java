public class CarParkDemo{


    public static void main (String[ ] args) {
        CarPark gr1 = new CarPark ("1 автопарк");
        CarPark gr2 = new CarPark ("2 автопарк");

        int j = 0;

        for (int i = 0; i < 5; i++){
            int id = Integer.valueOf (args[ j ]); j++;
            String brand = args[ j ]; j++;
            int year=Integer.valueOf (args[ j ]); j++;

            double cost = Double.valueOf (args[ j ]); j++;

            gr1.addCar(new Car(id,brand, year,cost));
        }
        for (int i = 0; i < 5; i++){
            int id = Integer.valueOf (args[ j ]); j++;
            String brand = args[ j ]; j++;
            int year=Integer.valueOf (args[ j ]); j++;
            double cost = Double.valueOf (args[ j ]); j++;
            gr2.addCar(new Car(id,brand, year,cost));
        }

        System.out.println(" Машины из автопарка (без сортировки):");
        gr1.putCarPark();

        System.out.println("Попытка добавить машину 14589,BMW ,2012,500000");
        gr1.addCar(new Car (14589, "BMW ",2012,500000));
        gr1.putCarPark();
        System.out.println(
                "Автомобили из автопарка (с естественным порядком сортировки):");
        gr1.sort().putCarPark();

        System.out.println(
                "Автомобили из автопарка (с сортировкой по возрастанию цены):");
        gr1.aboveAvgCost().sort(new CompCostAsc()).putCarPark();
        System.out.println(



                "Автомобили из автопарка (с сортировкой по убыванию цены):");
        gr1.betweenCost(400000,3500000).sort(new CompCostDesc()).putCarPark();

        gr1.delCar(12345);

        System.out.println ("После удаления автомобиля c id=12345:");
        System.out.println(
                "Автомобили с автопарка (с естественным порядком сортировки):");
        gr1.sort().putCarPark();

        System.out.println(
                "Автомобили из автопарка (с сортировкой по возрастанию названия и");
        System.out.println(" убыванию цены):");
        gr2.sort(new CompNameAscCostDesc()).putCarPark();

        System.out.println(
                "Автомобили из автопарка (с сортировкой по возрастанию цены):");
        gr2.aboveAvgCost().sort(new CompCostAsc()).putCarPark();
        System.out.println(
                "Автомобили из автопарка (с сортировкой по убыванию цены):");
        gr2.betweenCost(400000,4000000).sort(new CompCostDesc()).putCarPark();

        int n=23345;
        Car s1=gr1.getCar(n);
        if (s1==null) System.out.printf ("В автопарке: %14s нет автомобиля с таким id %d:\n ",gr1.getName(),n);
        else System.out.println(s1);
        n=70000;
        s1=gr1.getCar(n);
        if (s1==null) System.out.printf ("В автопарке: %14s нет автомобиля с таким id %d:\n ",gr1.getName(),n);
        else System.out.println(s1);


        n=53349;
        s1=gr2.getCar(n);
        if (s1==null) System.out.printf ("В автопарке: %14s нет автомобиля с таким id %d:\n ",gr1.getName(),n);
        else System.out.println(s1);
        gr1.putBrand();
        gr2.putBrand();


        gr1.delBetweenCars(400000,2000000).putCarPark();


        gr1.delBelowAvgCost().putCarPark();


        gr2.delBetweenCars(200000,600000).putCarPark();


        gr2.delBelowAvgCost().putCarPark();


        gr1.filter().putCarPark();

        gr2.filter().putCarPark();

        int u= 12547;
        Car U1 =gr1.getCar(u);
        System.out.printf("Обновить id у заданного объекта: %d. Автопарк  до обновления id:\n",u);
        gr1.putCarPark();
        System.out.print("Автопарк после обновления id:") ;
        gr1.update(U1).putCarPark();
        Car U2 =gr2.getCar(u);
        System.out.printf("Обновить id у заданного объекта: %d. Автопарк  до обновления id:\n",u);
        gr2.putCarPark();
        System.out.print("Автопарк после обновления id:") ;
        gr2.update(U2).putCarPark();


    }}