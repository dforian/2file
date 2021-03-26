package com.codecool.raceresults;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



class RaceResult {

    static String calculateRacerResults(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            List<String> lines = null;

            lines = Files.readAllLines(Paths.get(fileName));

            List<AnnualResult> annualResults = new ArrayList<>(lines.size());
            for (String line : lines) {
                AnnualResult ar = new AnnualResult();
                String[] split = line.split(",");
                ar.schumacher = Integer.parseInt(split[0]);
                ar.coultard = Integer.parseInt(split[1]);
                ar.hakinnen = Integer.parseInt(split[2]);
                ar.year = Integer.parseInt(split[3]);
                annualResults.add(ar);
            }

            annualResults.sort(Collections.reverseOrder(new AnnualResult.SchumacherComparator()));
            sb.append("Schumacher => ");
            sb.append(annualResults.get(0).year);
            sb.append(", ");

            annualResults.sort(new AnnualResult.SchumacherComparator());
            sb.append(annualResults.get(0).year);
            sb.append(" ");

            annualResults.sort(Collections.reverseOrder(new AnnualResult.CoultardComparator()));
            sb.append("Coultard => ");
            sb.append(annualResults.get(0).year);
            sb.append(", ");

            annualResults.sort(new AnnualResult.CoultardComparator());
            sb.append(annualResults.get(0).year);
            sb.append(" ");

            annualResults.sort(Collections.reverseOrder(new AnnualResult.HakkinenComparator()));
            sb.append("Hakkinen => ");
            sb.append(annualResults.get(0).year);
            sb.append(", ");

            annualResults.sort(new AnnualResult.HakkinenComparator());
            sb.append(annualResults.get(0).year);

        } catch (IOException e) {
            System.out.println("File not found!");
            return "File not found!";
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(RaceResult.calculateRacerResults("src/main/resources/results.txt"));
    }
}
