package org.example;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter name:");
        String name = sc.nextLine();
        System.out.println("Please enter surName:");
        String surName = sc.nextLine();
        System.out.println("Please enter file direction:");
        String direction = sc.nextLine();
        System.out.println("Please enter where you want send ip and port");
        String ipPort = sc.nextLine();

        String[] arr = ipPort.split(":");
        String ip = arr[0];
        int port = Integer.parseInt(arr[1]);

        Socket connection = new Socket(ip, port);
        OutputStream outputstream = connection.getOutputStream();
        DataOutputStream dataoutputstream = new DataOutputStream(outputstream);
        byte[] bytes = readBytes(direction);
        dataoutputstream.writeInt(bytes.length);
        dataoutputstream.write(bytes);
        System.out.println("SuccessFully operation");
        connection.close();
    }
    public static byte[] readBytes(String filename) throws Exception {
        File file = new File(filename);
        try (FileInputStream fileinputstream = new FileInputStream(file);) {
            byte[] byteArray = new byte[(int) file.length()];
            fileinputstream.read(byteArray);
            return byteArray;

        }


    }
}