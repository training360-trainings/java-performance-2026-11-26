package training.valueobject;

import org.openjdk.jmh.annotations.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(value = 2, jvmArgsAppend = "--enable-preview")
@State(Scope.Benchmark)
public class ValueObjectBenchmark {

    @Param({"1000", "100000", "10000000"})
    int size;

    Pixel[] valuePixels;

    IdentityPixel[] identityPixels;

    Point[] points;

    @Setup(Level.Trial)
    public void setup() {
        var random = new Random(42);
        valuePixels = new Pixel[size];
        identityPixels = new IdentityPixel[size];
        points = new Point[size];
        for (int i = 0; i < size; i++) {
            int x = random.nextInt();
            valuePixels[i] = new Pixel(x);
            identityPixels[i] = new IdentityPixel(x);
            int y = random.nextInt();
            points[i] = new Point(x, y);
        }
    }

    // A visszatérési értéket a JMH Blackhole-ba teszi, így nincs dead-code elimination

    @Benchmark
    public long valueRecord() {
        return ValueCsum.csum(valuePixels);
    }

    @Benchmark
    public long identityRecord() {
        return ValueCsum.csum(identityPixels);
    }

    @Benchmark
    public long point() {
        return ValueCsum.csum(points);
    }
}
