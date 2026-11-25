package training.valueobject;

public class ValueCsum {

    static long csum(Pixel[] points) {
        long sum = 0;
        for (Pixel p: points) {
            sum += p.value() & 0xff;
        }
        return sum;
    }

    static long csum(IdentityPixel[] points) {
        long sum = 0;
        for (IdentityPixel p: points) {
            sum += p.value() & 0xff;
        }
        return sum;
    }

    static long csum(Point[] points) {
        long sum = 0;
        for (Point p: points) {
            sum += p.x() & 0xff;
        }
        return sum;
    }

}
