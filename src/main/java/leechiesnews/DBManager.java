package leechiesnews;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import leechiesnews.model.News;

@SuppressWarnings("unchecked")
public class DBManager {
    final static Logger logger = LoggerFactory.getLogger("DBManager");
    
    private static String DB_URL = "D:\\AllAdsDB";
	private static File fileDB = new File(DB_URL);
	private static FileInputStream fis;
	private static ObjectInputStream ois;
	private static FileOutputStream fos;
	private static ObjectOutputStream oos;
	private static Map<String, News> allAds;

	public static void archiveDB() throws IOException {
		File f = new File(DB_URL);
		if(f.exists() && !f.isDirectory()) { 
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String textDate = LocalDate.now().format(formatter);
			String fileName = DB_URL+"_BACKUP_"+ textDate;
			fileName  = fileName.replaceAll("\\s+","");
			Files.copy(fileDB.toPath(), Paths.get(fileName), StandardCopyOption.REPLACE_EXISTING);
		} else {
			resetDB ();
		}		
	}
	
    public static void resetDB () throws IOException {
		try {
			fos = new FileOutputStream(fileDB);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(new HashMap<String, News>());
			oos.flush();
			fos.close();
			oos.close();
		} catch (Exception e) {
			logger.error("resetDB: " + e);
		}
    }

	public static void saveNews(News annonce) {
		// read from file
		try {
			Map<String, News> allAds = getAllNewsMap();
			//logger.info(" Saving " + annonce.url + "DB Size: " + allAds.size() );
			allAds.put(annonce.url, annonce);
			fos = new FileOutputStream(fileDB);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(allAds);
			oos.flush();
			fos.close();
			oos.close();
		} catch (Exception e) {
			logger.error("saveAnnonce: " + e);
		}
	}

	public static Map<String, News> getAllNewsMap() {
		// read from file
		try {
			fis = new FileInputStream(fileDB);
			ois = new ObjectInputStream(fis);
			if (allAds == null) {
				allAds = (Map<String, News>) ois.readObject();
			}
			fis.close();
			ois.close();
			return allAds;
		} catch (ClassNotFoundException | IOException e) {			
			logger.error("getAllNewsMap (Empty DB file?): " + e);
			return new HashMap<String, News>();
		}
	}

	public static Stream<News> getAllNews() {
			return getAllNewsMap().values().stream();		
	}

    public static News getNewsByUrl(String url) {
        return getAllNewsMap().get(url);
    }

	public static boolean newsExists(String url) {
		boolean rez = getAllNewsMap() != null ? getAllNewsMap().containsKey(url) : false;
		return rez;
	}

}
