public class Ellipse extends Shape {
    private double xradius;
    private double yradius;

    public Ellipse(double xradius, double yradius) {
        this.xradius = xradius;
        this.yradius = yradius;
    }

    public double getYradius() {
        return yradius;
    }

    public double getXradius() {
        return xradius;
    }
}
