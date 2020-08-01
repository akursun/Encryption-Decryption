class TestDrive {
    public static void main(String[] args) throws InterruptedException {
        LaptopFactory laptopStore = new LaptopStore();

        Laptop laptop13 = laptopStore.orderLaptop("13 inch");
        Laptop laptop15 = laptopStore.orderLaptop("15 inch");
        Laptop laptop17 = laptopStore.orderLaptop("17 inch");

        System.out.println("Available laptops in the store:");
        System.out.println(laptop13 + " Laptop");
        System.out.println(laptop15 + " Laptop");
        System.out.println(laptop17 + " Laptop");
    }
}

abstract class LaptopFactory {

    abstract Laptop createLaptop(String type);

    Laptop orderLaptop(String type) throws InterruptedException {
        Laptop laptop = createLaptop(type);
        if (laptop == null) {
            System.out.println("Sorry, we are not able to create this kind of laptop\n");
            return null;
        }
        System.out.println("Making a " + laptop.getName() + " Laptop");
        laptop.attachKeyboard();
        laptop.attachTrackpad();
        laptop.attachDisplay();
        Thread.sleep(1500L);
        System.out.println("Done a " + laptop.getName() + " Laptop\n");
        return laptop;
    }
}

class LaptopStore extends LaptopFactory {
    Laptop laptop = null;

    @Override
    Laptop createLaptop(String type) {
        switch (type) {
            case "13 inch":
                laptop = new Laptop13(type);
                break;
            case "15 inch":
                laptop = new Laptop15(type);
                break;
            case "17 inch":
                laptop = new Laptop17(type);
                break;
        }
        return laptop;
    }
}

class Laptop {
    private String name;

    Laptop(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void attachKeyboard() {
        System.out.println("Attaching keyboard");
    }

    void attachTrackpad() {
        System.out.println("Attaching trackpad");
    }

    void attachDisplay() {
        System.out.println("Attaching display");
    }

    @Override
    public String toString() {
        return name;
    }
}

class Laptop13 extends Laptop {
    Laptop13(String name) {
        super(name);
    }
}

class Laptop15 extends Laptop {
    Laptop15(String name) {
        super(name);
    }
}

class Laptop17 extends Laptop {
    Laptop17(String name) {
        super(name);
    }
}