package com.codecool.raceresults;

import java.util.Comparator;


public class AnnualResult {
    public int year;
    public int schumacher;
    public int coultard;
    public int hakinnen;

    static class SchumacherComparator implements Comparator<AnnualResult> {

        @Override
        public int compare(AnnualResult o1, AnnualResult o2) {
            return o1.schumacher - o2.schumacher;
        }
    }

    static class CoultardComparator implements Comparator<AnnualResult> {

        @Override
        public int compare(AnnualResult o1, AnnualResult o2) {
            return o1.coultard - o2.coultard;
        }
    }

    static class HakkinenComparator implements Comparator<AnnualResult> {

        @Override
        public int compare(AnnualResult o1, AnnualResult o2) {
            return o1.hakinnen - o2.hakinnen;
        }
    }
}