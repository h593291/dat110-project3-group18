package no.hvl.dat110.node.peers;

import java.util.ArrayList;
import java.util.List;

public class Starter {

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        threads.add(new Thread((() -> {try {Process1.main(args);} catch (Exception e){}})));
        threads.add(new Thread((() -> {try {Process2.main(args);} catch (Exception e){}})));
        threads.add(new Thread((() -> {try {Process3.main(args);} catch (Exception e){}})));
        threads.add(new Thread((() -> {try {Process4.main(args);} catch (Exception e){}})));
        threads.add(new Thread((() -> {try {Process5.main(args);} catch (Exception e){}})));

        for(Thread t : threads) {
            t.start();
        }

        for(Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
