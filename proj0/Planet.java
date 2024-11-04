public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static double g = 6.67 * Math.pow(10, -11);

    /* first constructor */
    public Planet (double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    /* second constructor */
    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    /* calculate the distance between two planets */
    public double calcDistance(Planet p) {
        return Math.sqrt(Math.pow(xxPos-p.xxPos, 2) + Math.pow(yyPos-p.yyPos, 2));
    }

    /* returns a double describing the force exerted on this planet by the given planet */
    public double calcForceExertedBy(Planet p) {
        return g * mass * p.mass / Math.pow(this.calcDistance(p), 2);
    }

    public double calcForceExertedByX(Planet p) {
        return this.calcForceExertedBy(p) * (p.xxPos - xxPos) / this.calcDistance(p);
    }
    public double calcForceExertedByY(Planet p) {
        return this.calcForceExertedBy(p) * (p.yyPos - yyPos) / this.calcDistance(p);
    }

    /* take in an array of Planets and calculate the net X and net Y force exerted by all planets in that array upon the current Planet */
    public double calcNetForceExertedByX(Planet[] p) {
        double sum = 0;
        for (Planet pp : p) {
            if (this != pp) {
                sum += this.calcForceExertedByX(pp);
            }    
        }
        return sum;
    }
    public double calcNetForceExertedByY(Planet[] p) {
        double sum = 0;
        for (Planet pp : p) {
            if (this != pp) {
                sum += this.calcForceExertedByY(pp);
            }           
        }
        return sum;
    }

    /* adjust the velocity and position */
    public void update(double t, double fx, double fy) {
        double ax = fx / mass;
        double ay = fy / mass;
        xxVel += t * ax;
        yyVel += t * ay;
        xxPos += t * xxVel;
        yyPos += t * yyVel;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/"+imgFileName);
    }
}
