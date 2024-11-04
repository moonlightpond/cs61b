public class NBody {
    /* Given a file name, it should return a double corresponding to the radius of the universe in that file */
    public static double readRadius(String filename) {
        In in = new In(filename);
        double first = in.readDouble();
        double second = in.readDouble();
        return second;
    }

    /* Given a file name, it should return an array of Planets corresponding to the planets in the file */
    public static Planet[]  readPlanets(String filename) {
        In in = new In(filename);
        double first = in.readDouble();
        double second = in.readDouble();
        Planet[] planets = new Planet[(int)first]; 
        for (int i = 0; i < (int)first; i++) {
            double px = in.readDouble();
            double py = in.readDouble();
            double vx = in.readDouble();
            double vy = in.readDouble();
            double m = in.readDouble();
            String f = in.readString();
            Planet p = new Planet(px, py, vx, vy, m, f);
            planets[i] = p;
        }
        return planets;
    }
}
