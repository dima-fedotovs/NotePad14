package enumdemo;

public class EnumDemo {

    public static void main(String[] args) {
        TrafficLight tl1 = TrafficLight.GREEN;
        TrafficLight tl2 = TrafficLight.RED;

        Gender patient1 = Gender.FEMALE;
        Gender patient2 = Gender.MALE;

        if (tl1 == TrafficLight.YELLOW) {
            System.out.println("ready!");
        }

        if (tl1 == tl2) {
            System.out.println("Same signal");
        }

        for (TrafficLight l : TrafficLight.values()) {
            System.out.println(l);
        }

        System.out.println("------");
        for (Gender l : Gender.values()) {
            System.out.println(l);
        }
        System.out.println("-------");
        var color = "BLUE";
        var tl3 = TrafficLight.valueOf(color);
        switch(tl3) {
            case RED:
                System.out.println("steady!");
                break;
            case YELLOW:
                System.out.println("ready!");
                break;
            case GREEN:
                System.out.println("go!");
                break;
            case BLUE:
                System.out.println("don't know");
        }

        System.out.println("---------");

        for (TrafficLight tl : TrafficLight.values()) {
            tl.printMessage();
        }
    }
}
