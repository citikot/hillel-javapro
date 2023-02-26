package homework20.builder;

public class Car {

    private String brand;
    private String model;
    private Frame frame;
    private Engine engine;
    private Gearbox gearbox;
    private Drive drive;

    private Car(Builder builder) {
        this.brand = builder.brand;
        this.model = builder.model;
        this.frame = builder.frame;
        this.engine = builder.engine;
        this.gearbox = builder.gearbox;
        this.drive = builder.drive;

    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private String brand;
        private String model;
        private Frame frame;
        private Engine engine;
        private Gearbox gearbox;
        private Drive drive;

        private Builder() {
        }

        public Builder addBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder addModel(String model) {
            this.model = model;
            return this;
        }

        public Builder addFrame(Frame frame) {
            this.frame = frame;
            return this;
        }

        public Builder addEngine(Engine engine) {
            this.engine = engine;
            return this;
        }

        public Builder addGearbox(Gearbox gearbox) {
            this.gearbox = gearbox;
            return this;
        }

        public Builder addDrive(Drive drive) {
            this.drive = drive;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", frame=" + frame +
                ", engine=" + engine +
                ", gearbox=" + gearbox +
                ", drive=" + drive +
                '}';
    }
}
