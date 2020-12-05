package com.jmarkstar.cheqdemoproj.common.security;
import com.chrisney.enigma.EnigmaUtils;

public class Passphrases {

    public static String dbPassphrase = EnigmaUtils.enigmatization(new byte[]{6, -53, 14, -39, -80, -11, 99, 57, -53, -1, -124, -14, 26, 58, -52, -103, 30, -79, -89, -48, 34, -27, -27, 108, 0, 80, 92, -41, 16, -107, 71, 95});

    public static String spPassphrase = EnigmaUtils.enigmatization(new byte[]{-35, 102, 28, -17, -94, 31, -128, 96, 31, -99, 37, -76, 0, 63, -49, -104, -62, 91, 26, 55, 112, -95, -88, -7, 4, 9, -109, -121, 35, 5, -68, -19});
    
}
