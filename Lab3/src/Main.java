import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MetaUniverse myMeta = new MetaUniverse(4);

        Universe myThirdSystem = new Universe("myThirdSystem",2);
        myThirdSystem.addPoint(1053, 1034, 7288, 54);
        myThirdSystem.addPoint(55584.6456, 542, 65, 281);
        myMeta.addUniverse(myThirdSystem);

        Universe solarSystem = new Universe("solarSystem",2);
        solarSystem.addPoint(0, 1, 2, 1);
        solarSystem.addPoint(5, 6, 8, 1);
        myMeta.addUniverse(solarSystem);
/*        System.out.println(solarSystem.getCenter());
        System.out.println(solarSystem.getLength());
        System.out.println();*/

        Universe mySecondSystem = new Universe("mySecondSystem",2);
        mySecondSystem.addPoint(10, 1077, 788, 5);
        mySecondSystem.addPoint(4, 554, 6, 2);
        myMeta.addUniverse(mySecondSystem);
/*
        System.out.println(mySecondSystem.getCenter());
        System.out.println(mySecondSystem.getLength());
        System.out.println();
*/

        Universe mySystem = new Universe("mySystem",2);
        mySystem.addPoint(10, 10, 788, 5);
        mySystem.addPoint(4, 5, 6, 2);
        myMeta.addUniverse(mySystem);
/*        System.out.println(mySystem.getCenter());
        System.out.println(mySystem.getLength());
        System.out.println();*/


        System.out.println(myMeta);

        Arrays.sort(myMeta.universes);

        System.out.println(myMeta);

    }
}