package homework20.builder;

public class CarBuilderRunner {

    public static void main(String[] args) {

        System.out.println("Builder Demo");

        Car car1 = Car.builder()
                .addBrand("Toyota")
                .addModel("Corolla")
                .addFrame(Frame.BEARING_BODY)
                .addEngine(Engine.HYBRID)
                .addGearbox(Gearbox.MANUAL)
                .addDrive(Drive.FRONT_WHEEL_DRIVE)
                .build();
        System.out.println(car1);

        Car car2 = Car.builder()
                .addBrand("Tesla")
                .addEngine(Engine.HYBRID)
                .addDrive(Drive.REAR_WHEEL_DRIVE)
                .build();
        System.out.println(car2);

    }
}

