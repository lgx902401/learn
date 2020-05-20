package com.example.async;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

public class UUIDUtil {

    private static final int SHORT_LENGTH = 8;

    public static String uuid() {
        String str = UUID.randomUUID().toString();
        String temp = str.replace("-", "");
        return temp;
    }

    public static String getUniqueIdByUUId() {
        //最大支持1-9个集群机器部署
//            int machineId = 1;
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {
            hashCodeV = -hashCodeV;
        }
        return String.format("%d", hashCodeV);

        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
//            return machineId + String.format("%015d", hashCodeV);

    }

    public static Integer getUUIDInOrderId() {
        Integer orderId = UUID.randomUUID().toString().hashCode();
        orderId = orderId < 0 ? -orderId : orderId; //String.hashCode() 值会为空
        return orderId;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        for (int i = 0; i < 1000*1000; i++) {
            String str = generateShortUuid();
            list.add(str);
//                System.out.println(generateShortUuid());
        }
        long starTime = System.currentTimeMillis();
        System.out.println("去重前的大小" + list.size());
        List<String> newList = new ArrayList<String>(new HashSet<String>(list));
        System.out.println("去重后大小" + newList.size());
        long endTime = System.currentTimeMillis();
        System.out.println("用了"+(endTime - starTime)+"毫秒");

    }


    public static String[] chars = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};


    public static String generateShortUuid() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < SHORT_LENGTH; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 10]);
        }
        return shortBuffer.toString();

    }
}

