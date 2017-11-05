package com.switchvov.chapter2.item5;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.stream.IntStream;

@BenchmarkMode(Mode.AverageTime)
@State(Scope.Benchmark)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
public class Sum {
    // Hideously slow program! Can you spot the object creation?
    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .forks(1)
                .include(Sum.class.getSimpleName())
                .build();
        new Runner(options).run();
    }

    @Benchmark
    public void measureForISumPackaging() {
        Long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    @Benchmark
    public void measureForISum() {
        long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    @Benchmark
    public void measureRangeSum() {
        long sum = IntStream.range(0, Integer.MAX_VALUE).parallel().mapToLong(i -> i).sum();
        System.out.println(sum);
    }
}
