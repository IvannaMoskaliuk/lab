/*
 * Classname Main
 *
 * Version info 1
 *
 * Copyright Moskaliuk Ivanna KNUTE
 */
package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        String text = new String(Files.readAllBytes(Paths.get("E:\\progr\\harry.txt")));

        String cleanerText = text
                .replaceAll("\\.", "")
                .replaceAll(",", "")
                .replaceAll("\"", "")
                .replaceAll("!", "")
                .replaceAll(";", "")
                .replaceAll(":", "")
                .replaceAll("\\(", "")
                .replaceAll("\\)", "")
                .replaceAll("\\?", "")
                ;

        String[] words = cleanerText.split("[^a-zA-Z]");
        int i, size = words.length;
        int iMax = -1, iMaxLength = -1;
        for (i = 0; i < size; ++i)
            if (!"".equals(words[i]) && words[i].length() > iMaxLength) {
                iMax = i;
                iMaxLength = words[i].length();
            }
        if (iMax == -1)
            System.err.println("String has no contains words");
        else
            System.out.println("Index = " + iMax + " \tword = " + words[iMax]);

        int harryWords = 0;
        for (int l = 0; l < words.length; l++) {
            if (words[l].contains("Harry"))
                harryWords++;
        }

        System.out.println("Слово Harry повторюється " + harryWords + " разів");

        String distinktString = " ";

        for (int j = 0; j < words.length; j++) {

            if (!distinktString.contains(words[j])) {
                distinktString += words[j] + " ";
            }

        }

        String[] distrinctArray = distinktString.split(" ");

        for (int j = 0; j < distrinctArray.length; j++) {
            System.out.println(distrinctArray[j].hashCode());
        }
        int hash = distrinctArray.hashCode();
        System.out.println("хеш масиву " + hash);

        int intersections = 0;
        for (int s = 0; s < distrinctArray.length; s++) {
            for (int z = s + 1; z < distrinctArray.length; z++) {
                if (distrinctArray[s].equals(distrinctArray[z])) {
                    intersections++;
                }
            }
        }
        if ( intersections == 0 )
            System.out.println(intersections + " - Серед Хеш-кодів немає збігів");

    }
}