package com.pluralsight.util;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {
    public static void saveReceipt(String receiptText) {
        File folder = new File("src/main/resources/receipts");
        if (!folder.exists()) {
            folder.mkdir(); // create the folder if missing
        }

        // creating a timestamp for the files
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String timeStamp = now.format(formatter);

        File completeOrderFile = new File("src/main/resources/receipts", timeStamp + ".txt");

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(completeOrderFile))) {

            bufferedWriter.write(receiptText);
            System.out.println("Receipt saved");
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
    }


}
