package isa.ProgettoEsame;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.io.*;

public class PasswordGenerator {
    public static void main (String[] args)
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPw = "123456";
        String encodedPw = encoder.encode(rawPw);
        System.out.println(encodedPw);
    }
}
