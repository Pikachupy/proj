package com.wspolbiegi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

// https://docs.spring.io/spring-framework/docs/4.2.x/spring-framework-reference/html/scheduling.html
public class RequestThreadPool {
    private ExecutorService execSvc = Executors.newFixedThreadPool(5);
    private AtomicInteger workerCounter;    // counter za pomocą którego zwracamy


    public void requestHandler() {
        execSvc.submit(() -> sendDataToClient(fileToSend()));
        execSvc.shutdown();
    }

    private void sendDataToClient(String fileToSend) {
        // trzeba napisac kod wysylajacy sczytany plik do klienta

    }

    private String fileToSend() {
        File ourFile = new File("src/main/resources/BigFile/jakisRandomBezpieczenstwo.txt");
        ourFile.getParentFile().mkdir();
        try {
            BufferedReader bR = new BufferedReader(
                    new FileReader(ourFile));
            StringBuilder fileContent = new StringBuilder();
            while (bR.readLine() != null) {
                fileContent.append(bR.readLine());
                fileContent.append("\n");
            }
//            System.out.println(fileContent.toString());
            return fileContent.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
