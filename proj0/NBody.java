public class NBody {
    /* Given a file name, it should return a double corresponding to the radius of the universe in that file */
    public static double readRadius(String filename) {
        In in = new In(filename);
        double first = in.readDouble();
        double second = in.readDouble();
        return second;
    }

    /* Given a file name, it should return an array of Planets corresponding to the planets in the file */
    public static Planet[] readPlanets(String filename) {
        In in = new In(filename);
        int first = in.readInt();
        double second = in.readDouble();
        Planet[] planets = new Planet[first]; 
        for (int i = 0; i < first; i++) {
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

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, "images/starfield.jpg");
        for (Planet p : planets) {
            p.draw();
        }
        StdDraw.show();
        
        StdDraw.enableDoubleBuffering();
        double time = 0;
        int len = planets.length;
        while (time != T) {
            double[] xForces = new double[len];
            double[] yForces = new double[len];

            for (int i=0; i < len; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for (int i=0; i < len; i++) {
                planets[i].update(time, xForces[i], yForces[i]);
            }

            StdDraw.setScale(-radius, radius);
            StdDraw.clear();
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Planet p : planets) {
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);

            time += dt;
        } 

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                        planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                        planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
        }
        
    }
}
