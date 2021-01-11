package enumdemo;

public enum TrafficLight {
    RED{
        @Override
        public void printMessage() {
            System.out.println("steady!");
        }
    },
    YELLOW{
        @Override
        public void printMessage() {
            System.out.println("ready!");
        }
    },
    GREEN{
        @Override
        public void printMessage() {
            System.out.println("go!");
        }
    },
    BLUE {
        @Override
        public void printMessage() {
            System.out.println("I don't know");
        }
    };

    public abstract void printMessage();
}
