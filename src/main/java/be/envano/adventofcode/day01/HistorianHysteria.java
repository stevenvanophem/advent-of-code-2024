package be.envano.adventofcode.day01;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class HistorianHysteria {

    public static void main(String[] args) throws IOException, URISyntaxException {
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        URI uri = ClassLoader.getSystemResource("01-historian-hysteria-input.txt").toURI();
        for (String line : Files.readAllLines(Paths.get(uri))) {
            String[] items = line.split(" {3}");
            leftList.add(Integer.parseInt(items[0]));
            rightList.add(Integer.parseInt(items[1]));
        }

        System.out.println("Part 1: " + calculateTotalDistance(leftList, rightList));
        System.out.println("Part 2: " + calculateSimilarityScore(leftList, rightList));
    }

    public static int calculateTotalDistance(List<Integer> leftList, List<Integer> rightList) {
        List<Integer> sortedLeftList = leftList.stream().sorted().toList();
        List<Integer> sortedRightList = rightList.stream().sorted().toList();
        return IntStream.range(0, leftList.size())
            .map(i -> Math.abs(sortedLeftList.get(i) - sortedRightList.get(i)))
            .sum();
    }

    public static int calculateSimilarityScore(List<Integer> leftList, List<Integer> rightList) {
        return leftList.stream()
            .mapToInt(number -> number * Collections.frequency(rightList, number))
            .sum();
    }

}
