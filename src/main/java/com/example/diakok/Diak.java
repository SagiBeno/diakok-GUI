package com.example.diakok;

import java.time.LocalDate;

public class Diak {
    public int az;
    public String vnev;
    public String knev;
    public String neme;
    public String osztaly;
    public LocalDate datum;
    public String lakhely;
    public Integer magassag;

    public String fileLine;

    public Diak(String fileLine) {
        this.fileLine = fileLine;

        String[] split = fileLine.split(";");

        az = Integer.parseInt(split[0]);
        vnev = split[1];
        knev = split[2];
        neme = split[3];
        osztaly = split[4];

        //datum = LocalDate.parse(split[5]);
        String[] dateSplit = split[5].split("\\.");
        int year = Integer.parseInt(dateSplit[0]);
        int month = Integer.parseInt(dateSplit[1]);
        int day = Integer.parseInt(dateSplit[2]);
        datum = LocalDate.of(year, month, day);

        lakhely = split[6];
        magassag = Integer.parseInt(split[7]);
    }

    @Override
    public String toString() {
        return
                vnev +
                " " + knev +
                ", " + neme +
                ", " + osztaly +
                " (" + lakhely + " " + datum +
                ", " + magassag +
                " cm)";
    }
}
