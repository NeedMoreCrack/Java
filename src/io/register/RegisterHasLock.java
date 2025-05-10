package io.register;

import java.io.*;
import java.util.*;

public class RegisterHasLock {
    public static void main(String[] args) throws IOException {
        String path = "src/io/register/userinfo.txt";
/*
        Map<String,String> usersInfo = new HashMap<>(getInfo());
        Scanner sc = new Scanner(System.in);
        System.out.println("==========Login==========");
        System.out.println("Please enter username :");
        String userName = sc.next();
        System.out.println("Please enter userPassword :");
        String password = sc.next();
        boolean loginStatus = checkInfo(usersInfo, userName, password);
        String loginInfo = loginStatus ? "Login success" : "Login failed";
        System.out.println(loginInfo);
*/
        addLock("kelly",path);
    }
    public static Map<String,String> getInfo(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        Map<String,String> users = new HashMap<>();
        String len;
        while((len=br.readLine()) != null){
            String[] map = len.split("&");
            String key = map[0].split("=")[1];
            String value = map[1].split("=")[1];
            users.put(key,value);
        }
        br.close();
        return users;
    }
    public static void addErrorCount(String name,String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        List<String> list = new ArrayList<>();
        String line;
        while((line= br.readLine()) != null){
            list.add(line);
        }
        br.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        int errorCount = 0;
        for (String s : list) {
            bw.write(String.valueOf(s.matches(".+"+name+".+")));
        }
    }
    public static void getErrorCount(String name,String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));

    }
    public static void addLock(String name,String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        List<String> writeStr = new ArrayList<>();
        String line;
        while((line=br.readLine()) != null){
            writeStr.add(line);
        }
        br.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        for (String s : writeStr) {
            if(s.matches(".+"+name+".+")){
                bw.write(s+" Lock");
                bw.newLine();
            }else{
                bw.write(s);
                bw.newLine();
            }
        }
        bw.close();
    }
    public static boolean checkInfo(Map<String,String> map,String username,String password){
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            if(key.equals(username) && value.equals(password)){
                return true;
            }
        }
        return false;
    }
}
