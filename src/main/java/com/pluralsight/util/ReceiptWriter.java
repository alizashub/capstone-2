package com.pluralsight.util;

import com.pluralsight.models.Order;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {
    public static void saveReceipt(Order order) {
        String receiptTimeStamp = createTimeStamp();
        String fileName = "src/main/resources/receipts" + receiptTimeStamp + ".txt";


        StringBuilder receiptContent = new StringBuilder();
        receiptContent.append("Deli Receipt");
        receiptContent.append("Order Time:").append(receiptTimeStamp).append("\n\n");
        receiptContent.append(order.getSummary());
        receiptContent.append("Thanks for your order.");

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/receipts" + receiptTimeStamp + ".txt"))) {
            bufferedWriter.write(receiptContent.toString());
            System.out.println("Receipt saved.");
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    private static String createTimeStamp() {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        return currentTime.format(dateTimeFormatter);

    }


}
