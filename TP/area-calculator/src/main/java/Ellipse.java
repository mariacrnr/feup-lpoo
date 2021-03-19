public class Ellipse implements Shape {
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

    public double getArea() {
        return Math.PI * this.xradius * this.yradius;
    }
}
