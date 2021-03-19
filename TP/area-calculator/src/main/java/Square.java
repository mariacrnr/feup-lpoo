public class Square implements Shape{
    private double side;

    Square(double side){
       this.side = side;
    }

    public double getSide() {
        return side;
    }

    public double getArea() {
        return Math.pow(this.side,2);
    }
}
