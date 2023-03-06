public class Main {
    public static void main(String[] args) {
        Universe solarSystem = new Universe(4);
        solarSystem.addPoint(0, 1, 2);
        solarSystem.addPoint(5, 6, 8);
        System.out.println(solarSystem);
        System.out.println("Center coordinates are: "+solarSystem.getCenter());
        System.out.println("Volume is: "+solarSystem.getVolume() + "\n");
        solarSystem.addPoint(1, 5, 25);
        System.out.println("Center coordinates are: "+solarSystem.getCenter());
        System.out.println("Volume is: "+solarSystem.getVolume()+ "\n");
        solarSystem.addPoint(37, -150, 0);
        System.out.println("Center coordinates are: "+solarSystem.getCenter());
        System.out.println("Volume is: "+solarSystem.getVolume());
    }
}