package training.valueobject;

import java.util.Objects;

public class ValueObjectApplication {

    static void main(String[] args) {
        var identity1 = new IdentityPixel(10);
        var identity2 = new IdentityPixel(10);
        System.out.println(identity1 == identity2);
        System.out.println(System.identityHashCode(identity1));
        System.out.println(System.identityHashCode(identity2));

        var value1 = new Pixel(10);
        var value2 = new Pixel(10);
        System.out.println(value1 == value2);
        System.out.println(System.identityHashCode(value1));
        System.out.println(System.identityHashCode(value2));
    }

}
