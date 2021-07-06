package br.com.meli.apilinktracker.apilinktracker.utils;

public class Id {

    public static long idLink = 1l;

    public static long generateIdLink() {
        return idLink++;
    }
}
