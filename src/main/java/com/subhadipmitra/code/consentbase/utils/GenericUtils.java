package com.subhadipmitra.code.consentbase.utils;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.math.random.RandomData;
import org.apache.commons.math.random.RandomDataImpl;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class GenericUtils {
    public static String getRandomUUID()  {
        MessageDigest salt = null;
        try {
            salt = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        salt.update(UUID.randomUUID().toString().getBytes(StandardCharsets.UTF_8));
        return convertBytesToHex(salt.digest());
    }

    public static String convertBytesToHex(byte[] bytes) {

        char[] chars = Hex.encodeHex(bytes);
        return new String(chars);

    }

    public static String getRandomItemFromList(List<String> incomingList) {
        Random rand = new Random();
        return incomingList.get(rand.nextInt(incomingList.size()));
    }

    public static Date nextDate(Date min, Date max) {
        RandomData randomData = new RandomDataImpl();
        return new Date(randomData.nextLong(min.getTime(), max.getTime()));
    }

    public static String getRandomDtTime(boolean getFromDate){
        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        cal.add(Calendar.YEAR, 1); // to get previous year add -1
        String strDate = "";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

        if(getFromDate){
            Date nextYear = cal.getTime();
            strDate = dateFormat.format(nextYear);
        }
        else strDate = dateFormat.format(today);
        return strDate;
    }


    public static String getDuplicatbleId() {
        double randomDouble = Math.random();
        randomDouble = randomDouble * 512034 + 512794;
        int randomInt = (int) randomDouble;
        return String.valueOf(randomInt);
    }
}
