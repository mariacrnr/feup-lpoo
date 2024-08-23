public class Circle implements AreaShape{
    private double radius;

    Circle(double radius){
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    public void draw() {
        System.out.println("Circle");
    }
}
