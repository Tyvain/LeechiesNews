package leechiesnews;

import java.io.IOException;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import leechiesnews.manager.DBManager;

public class DisplayNews {
    final static Logger logger = LoggerFactory.getLogger("DisplayNews");
    
    public static void main(String[] args) throws JSONException, IOException {
       
        System.out.println("-- LOCAL DB");
        System.out.println("Nombre d'annonces: " + DBManager.getAllNews().count());
        System.out.println("========================");
        System.out.println(DBManager.getAllNews().findFirst().get().tags);
    }
}