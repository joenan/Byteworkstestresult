
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nandom Gusen
 */
public class Whois {
    public static void main(String[] args) throws Exception{
        Socket s = new Socket("whois.internic.net",43);

        OutputStream os = s.getOutputStream();
        String domain = "byteworks.com.ng"+"\n";
        byte[] stringToByte = domain.getBytes();
        os.write(stringToByte);

        InputStream is = s.getInputStream();
        InputStreamReader reader = new InputStreamReader(is);
        BufferedReader buf = new BufferedReader(reader);

        String temp;
        while((temp=buf.readLine())!="\n"){
            System.out.println(temp);
        }
    }
    
}
