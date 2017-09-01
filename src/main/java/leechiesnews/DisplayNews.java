package leechiesnews;

import java.io.IOException;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import leechiesnews.manager.DBManager;

public class DisplayNews {
    final static Logger logger = LoggerFactory.getLogger("DisplayNews");
    
    public static void main(String[] args) throws JSONException, IOException {
       
    	String key = "https://www.cryptocoinsnews.com/john-cena-posts-about-bitcoin-on-instagram/";
    	
        System.out.println("-- LOCAL DB");
        System.out.println("Nombre d'annonces: " + DBManager.getAllNews().count());
        System.out.println("============ TITLE ============");
        System.out.println(DBManager.getAllNewsMap().get(key).cleanTitle);
        System.out.println("============ DESCR RAW ========");
        System.out.println(DBManager.getAllNewsMap().get(key).text);
        System.out.println("============ DESCR ============");
        System.out.println(DBManager.getAllNewsMap().get(key).cleanText);
        System.out.println("============ TAGS ============");
        System.out.println(DBManager.getAllNewsMap().get(key).cleanTags);
        System.out.println("============ IMG ============");
        System.out.println(DBManager.getAllNewsMap().get(key).cleanImgUrl);
        
    }
}