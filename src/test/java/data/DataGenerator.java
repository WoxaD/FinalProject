package data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.Locale;

public class DataGenerator {
    private DataGenerator() {
    }

    static Faker faker = new Faker((new Locale("ru")));

    public static String getCardNumber(int id) {
        String value;
        switch (id) {
            case 0:
                value = "";
                break;
            case 1:
                value = "1111 2222 3333 4444";
                break;
            case 2:
                value = "9999 8888 7777 6666";
                break;
            case 3:
                value = "0000 0000 0000 0000";
                break;
            case 4:
                value = "number";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + id);
        }
        return value;
    }

    public static String generateMonth(int month) {
        String value;
        switch (month) {
            case 0:
                value = "";
                break;
            case 1:
                value = String.valueOf(faker.number().numberBetween(10, 12));
                break;
            case 2:
                value = "15";
                break;
            case 3:
                value = "month";
                break;
            default:
                value = "00";
                break;
        }
        return value;
    }

    public static String generateYear(int year) {
        int yearStart = LocalDate.now().getYear() + 1;
        int yearFinish = yearStart + 5;
        String value;
        switch (year) {
            case 0:
                value = "";
                break;
            case 1:
                value = String.valueOf(faker.number().numberBetween(yearStart, yearFinish)).substring(2);
                break;
            case 2:
                value = "99";
                break;
            case 3:
                value = "year";
                break;
            default:
                value = "00";
                break;
        }
        return value;
    }

    public static String generateHolder(int holder) {
        String value;
        switch (holder) {
            case 0:
                value = "";
                break;
            case 1:
                value = "BERNARD ARNAULT";
                break;
            case 2:
                value = String.valueOf(faker.number().numberBetween(1, 99));
                break;
            case 3:
                value = faker.name().fullName().toUpperCase();
                break;
            default:
                value = "00";
                break;
        }
        return value;
    }

    public static String generateCode(int code) {
        String value;
        switch (code) {
            case 0:
                value = "";
                break;
            case 1:
                value = String.valueOf(faker.number().numberBetween(0, 99));
                break;
            case 2:
                value = String.valueOf(faker.number().numberBetween(100, 999));
                break;
            case 3:
                value = String.valueOf(faker.number().numberBetween(1000, 1999));
                break;
            case 4:
                value = "code";
                break;
            default:
                value = "000";
                break;
        }
        return value;
    }
}
