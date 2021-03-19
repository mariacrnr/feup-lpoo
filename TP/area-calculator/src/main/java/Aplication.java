public class Aplication {
    public static void main(String[] args){
        AreaAggregator aggregator = new AreaAggregator();

        Circle circle = new Circle(2);
        Square square = new Square(6);
        Triangle triangle = new Triangle(4,6);

        aggregator.addShape(circle);
        aggregator.addShape(square);
        aggregator.addShape(triangle);

        AreaStringOutputter stringOutputter = new AreaStringOutputter(aggregator);
        AreaXMLOutputter xmlOutputter = new AreaXMLOutputter(aggregator);

        System.out.println(stringOutputter.output());
        System.out.println(xmlOutputter.output());
    }
}
