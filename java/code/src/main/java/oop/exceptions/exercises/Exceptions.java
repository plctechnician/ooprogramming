package oop.exceptions.exercises;

import oop.objectoriented.exercises.library.Rent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/**
 * You can find many more here:
 *
 *
 * Preferences -> Editor -> General -> Code folding -> One-line methods (uncheck)
 * Code -> Folding -> Collapse All
 * Code -> Folding -> Expand Doc Comments
 */
public class Exceptions {
    /**
     * Write a function to check if a String is an alternating sequence of letters and numbers (for example,
     * a0b3h4z1r4). The function delegates ParseException for notifying the caller about eventual malformations.
     * Note: Use can use Character.isDigit() and Character.isLetter() methods
     */
    public static void check(String s) throws ParseException {
        boolean waitingLetter = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c) && (waitingLetter)) {
                throw new ParseException(s, i);
            }
            if (Character.isLetter(c) && (!waitingLetter)) {
                throw new ParseException(s, i);
            }
            waitingLetter = !waitingLetter;
        }
    }

    /**
     * Write a function to remove from a List all the strings which are not an alternating sequence of letters and
     * numbers (for example, a0b3h4z1r4).
     */
    public static void check(List<String> strings) {
        for (Iterator<String> i = strings.iterator(); i.hasNext(); ) {
            try {
                check(i.next());
            } catch (ParseException e) {
                i.remove();
            }
        }
    }

    /**
     * Write a function receiving two strings as parameters and returning true if the first date is before the second
     * date. The function uses the SimpleDateFormat and java.util.Date classes. Eventual exceptions are delegated to
     * the caller.
     */
    public static boolean checkInterval(String begin, String end) throws ParseException {
        SimpleDateFormat reader = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date d1 = reader.parse(begin);
        Date d2 = reader.parse(end);
        return d1.before(d2);
    }

    /**
     * Write a function receiving two strings as parameters and returning true if the first date is before the second
     * date. The function uses the SimpleDateFormat and java.util.Date class. Eventual exceptions are managed locally
     * and false is returned.
     */
    public static boolean checkInterval_alternative(String begin, String end) {
        SimpleDateFormat reader = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        try {
            Date d1 = reader.parse(begin);
            Date d2 = reader.parse(end);
            return d1.before(d2);
        } catch (ParseException e) {
            return false;
        }
    }

    /**
     * Write a function receiving two double numbers (a, b) and returning their division. If b == 0, the function throws
     * IllegalArgumentException
     */
    public static double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException();
        }
        return a / b;
    }

    /**
     * Write a function receiving two double numbers (a, b) and returning their division squared (i.e., (a/b)^2). If
     * b == 0, the function returns 0.0
     */
    public static double compute(double a, double b) {
        try {
            return Math.pow(divide(a, b), 2);
        } catch (IllegalArgumentException e) {
            return 0.0;
        }
    }

    /**
     * Write a function reading the first line of a given file. In case of errors (IOException), the function applies
     * a complete delegation model.
     * Note: for reading a line from a text file, use readline() from the BufferedReader class
     */
    public static String completeDelegation(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();
        reader.close();
        return line;
    }

    /**
     * Write a function reading the first line of a given file. In case of errors (IOException), the function applies
     * a no-delegation model returning null.
     * Note: for reading a line from a text file, use readline() from the BufferedReader class
     */
    public static String noDelegation(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * Write a function reading the first line of a given file. In case of errors (IOException), the function applies
     * a partial delegation model throwing RunTimeException
     * Note: for reading a line from a text file, use readline() from the BufferedReader class
     */
    public static String partialDelegation(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}