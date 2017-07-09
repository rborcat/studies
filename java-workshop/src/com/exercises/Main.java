package com.exercises;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Chapter 8.1
        // Exercises.stringJoin();

        // Chapter 8.2
        // Exercises.numberClasses();

        // Chapter 8.3
        // Exercises.newMathematicalFunctions();

        // Chapter 8.4
        // Exercises.collections();

        // Chapter 8.5
        // Exercises.workingWithFiles();

        // Chapter 8.6
        // Exercises.annotations();

        // Chapter 8.7
        // Exercises.minorChanges();

        try (Socket s = new Socket()) {
            s.setSoTimeout(100);
            s.connect(new InetSocketAddress("time-a.nist.gov", 13));

            try (Scanner input = new Scanner(s.getInputStream())) {
                while (input.hasNextLine()) {
                    System.out.println(input.nextLine());
                }
            }

            InetAddress[] addresses = InetAddress.getAllByName("google.com");
            InetAddress address = InetAddress.getByName("google.com");
            address.getAddress();

            address.isSiteLocalAddress();

            System.out.println(InetAddress.getLocalHost());
            System.out.println(InetAddress.getLoopbackAddress());



        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
