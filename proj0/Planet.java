public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static double g = 6.67 * Math.pow(10, -11);

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
}
