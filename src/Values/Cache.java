package Values;

import Model.Role;

import java.io.*;
import java.nio.CharBuffer;
import java.util.*;

public class Cache {
    private static String path = Paths.HOME+"/.cache/Auth/";
    private static File file = new File(path);
    public static void createCache(){
        try{
            if(!file.exists()){
                if (file.mkdirs()) {
                    System.out.println("Create!");
                    createCache();
                }else
                    System.out.println("Exists!");
            }else{
                path=Paths.HOME+"/.cache/Auth/cache.auth";
                file = new File(path);
                if(file.createNewFile())
                    System.out.println("Users cache");
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        System.out.println(path);
    }
    public static void addCache(Map<String, Role> value){
        try {
            FileWriter writer = new FileWriter(file);
            BufferedWriter bwriter = new BufferedWriter(writer);

            Iterator it = value.keySet().iterator();
            String newCache = "";
            while (it.hasNext()){
                Object key = it.next();

                newCache +=
                        "Name:" + value.get(key).getName()+"\n"+
                                "Email:" + value.get(key).getEmail()+"\n"+
                                "Celphone:" + value.get(key).getPhoneNumber()+"\n"+
                                "Address:" + value.get(key).getAddress()+"\n"+
                                "Role:" + value.get(key).getRole()+"\n"+
                                "***"+"\n";
            }
            bwriter.write(newCache);
            bwriter.flush();

            bwriter.close();
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static Map<String, String> readCache(){
        Map<String, String> map = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String current = "";
            String text = "";

            while ((current = br.readLine()) != null){
                if(current.startsWith("Name:"))
                    map.put("Name", getAfter(current,"Name:"));
                else if(current.startsWith("Email:"))
                    map.put("Email", getAfter(current,"Email:"));
                else if(current.startsWith("Celphone:"))
                    map.put("Celphone", getAfter(current,"Celphone:"));
                else if(current.startsWith("Address:"))
                    map.put("Address", getAfter(current,"Address:"));
                else if(current.startsWith("Role:"))
                    map.put("Role", getAfter(current,"Role:"));
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return map;
    }
    public static String getAfter(String text, String after){
        String value = text.substring(text.lastIndexOf(after) + 1);
        return value;
    }
}
