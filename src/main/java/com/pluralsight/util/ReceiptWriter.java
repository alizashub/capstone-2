package com.pluralsight.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * ReceiptWriter
 * handles saving receipt text to a text file
 * creates a unique timestamped file for each order
 */
public class ReceiptWriter {
    public static void saveReceipt(String receiptText) {
        File folder = new File("src/main/resources/receipts");
        // makes sure to see if a receipts folder exists
        if (!folder.exists()) {
            folder.mkdir();
        }  // create the folder if missing


        // creating a timestamp for the files
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String timeStamp = now.format(formatter);

        // the file path for each new file that will be created based on new order
        File completeOrderFile = new File("src/main/resources/receipts", timeStamp + ".txt");

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(completeOrderFile))) {

            bufferedWriter.write(receiptText);
            System.out.println("Receipt has been saved");
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }


}

