
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nandom Gusen
 */
public class PrimeNumbers {

    public static void main(String args[]) {
        IntStream.rangeClosed(2, 1000000)
                .filter(i -> IntStream.rangeClosed(2, (int) Math.sqrt(i))
                .allMatch(j -> i % j != 0))
                .forEach(n -> {
                    System.out.print(n + " ");
                });
    }
}
