package be.envano.adventofcode.day01;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HistorianHysteria {

    public static void main(String[] args) throws IOException, URISyntaxException {
        Data data = Data.read();
        System.out.println("Part 1: " + data.calculateTotalDistance());
        System.out.println("Part 2: " + data.calculateSimilarityScore());
    }

    record Data(List<Integer> leftList, List<Integer> rightList) {

        static Data read() throws URISyntaxException, IOException {
            URI uri = ClassLoader.getSystemResource("01-historian-hysteria-input.txt").toURI();
            return Files.readAllLines(Paths.get(uri)).stream()
                .map(line -> line.split(" {3}"))
                .collect(Collectors.teeing(
                    Collectors.mapping(lineItems -> Integer.parseInt(lineItems[0]), Collectors.toList()),
                    Collectors.mapping(lineItems -> Integer.parseInt(lineItems[1]), Collectors.toList()),
                    Data::new
                ));
        }

        Data {
            leftList = leftList.stream().sorted().toList();
            rightList = rightList.stream().sorted().toList();
        }

        int calculateTotalDistance() {
            return IntStream.range(0, leftList.size())
                .map(i -> Math.abs(leftList.get(i) - rightList.get(i)))
                .sum();
        }

        int calculateSimilarityScore() {
            return leftList.stream()
                .mapToInt(number -> number * Collections.frequency(rightList, number))
                .sum();
        }

    }

}
