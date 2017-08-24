package leechiesnews;

import java.io.File;
import java.io.FileReader;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.esotericsoftware.yamlbeans.YamlReader;

import leechiesnews.model.News;
import leechiesnews.model.WebSite;

public class App {
	final static Logger logger = LoggerFactory.getLogger("App");

	public static int statNbAnnoncesTraitees = 0;
	public static int statNbAnnoncesUploadees = 0;
	public static int statNbAnnoncesAlreadyInDB = 0;
	public static int statNbAnnoncesAlreadyUploaded = 0;
	public static int statNbNotAlreadyInDB = 0;
	public static AtomicInteger countAnnoncesTraitees = new AtomicInteger();
	public static AtomicLong avgTimeByAds = new AtomicLong();
	public static Instant start = Instant.now();
	public static Duration duration;

	public static String ALL_SOURCES[] = { "cryptopress.yml" };
	public static String SOURCES[] = ALL_SOURCES;

	// # !!!
	private static boolean RESET_DB = false; // reset local DB (backup old one)
	// # !!!

	public static void main(String[] args) {

		System.setProperty("http.proxyHost", "proxy.recif.nc");
		System.setProperty("http.proxyPort", "80");
		System.setProperty("https.proxyHost", "proxy.recif.nc");
		System.setProperty("https.proxyPort", "80");

		try {
			DBManager.archiveDB();

			if (RESET_DB) {
				logger.warn("Reseting DB...");
				DBManager.resetDB();
			}

			String initTrace = "\n### DEBUT ### ";
			initTrace += "\nSOURCES: " + SOURCES.length;
			initTrace += "\nRESET_DB: " + RESET_DB;
			initTrace += "\n### INFOS ### ";
			initTrace += "\n-- LOCAL DB";

			logger.info(initTrace);

			goLeech();

			logStats("\n### FIN ###");
		} catch (Exception e) {
			logger.error("\n### MAIN ERROR ### ", e);
		}
	}

	private static void goLeech() {
		logger.info("Starting goLeech...");
		App.getSourceStream().flatMap(s -> {
			return getNewsFromSource(s);
		}).forEach(a -> {
			DBManager.saveNews(a);
		});
		logger.info("... goLeech finished!");
	}

	public static void logStats(String m) {
		duration = Duration.between(start, Instant.now());
		String msg = m + "\nNb annonces traitées: " + countAnnoncesTraitees.get() + "\nTemps moyen par annonce: " + avgTimeByAds + " sec";
		msg += "\nTemps total: " + duration.getSeconds() / 60 + " min";
		msg += "\nstatNbAnnoncesTraitees: " + statNbAnnoncesTraitees;
		msg += "\nstatNbAnnoncesUploadees: " + statNbAnnoncesUploadees;
		msg += "\nstatNbAnnoncesAlreadyUploaded: " + statNbAnnoncesAlreadyUploaded;
		msg += "\nstatNbAnnoncesAlreadyInDB:" + statNbAnnoncesAlreadyInDB;
		msg += "\nstatNbNotAlreadyInDB:" + statNbNotAlreadyInDB;
		logger.info(msg);
	}

	private static Stream<News> getNewsFromSource(WebSite source) {
		logger.info("-url: " + source.url + " -linkSelector: " + source.linkSelector + " -titleSelector: " + source.titleSelector + " -textSelector: " + source.textSelector);
		Document doc = JSoupUtils.getDocumentFromUrl(source.url);
		Elements elemz = doc.select(source.linkSelector);
		Stream<String> urlz = elemz.stream().map(e -> e.attr("href"));
		Stream<News> newz = urlz.map(u -> getNewsFromUrl(u, source));

		newz.forEach(n -> {
			logger.info("n : " + n);
		});

		return null;
	}

	private static News getNewsFromUrl(String url, WebSite source) {
		if (DBManager.newsExists(url)) {
			App.statNbAnnoncesAlreadyInDB++;
			return DBManager.getNewsByUrl(url);
		}
		Document doc = JSoupUtils.getDocumentFromUrl(url);
		App.statNbNotAlreadyInDB++;
		News ret = new News();
		ret.url = url;
		ret.titre = doc.select(source.titleSelector).text();
		ret.text = doc.select(source.textSelector).text();
		return ret;
	}

	private static Stream<WebSite> getSourceStream() {
		Stream<WebSite> ret = Stream.empty();
		try {
			for (String source : SOURCES) {
				ClassLoader classLoader = App.class.getClassLoader();
				File file = new File(classLoader.getResource(source).getFile());
				logger.info("file : " + file);
				YamlReader reader = new YamlReader(new FileReader(file));

				@SuppressWarnings("unchecked")
				ArrayList<WebSite> wtf = (ArrayList<WebSite>) reader.read();
				ret = Stream.concat(ret, wtf.stream());
			}
		} catch (Exception e) {
			logger.error("App.getSourceStream - " + e);
		}
		return ret;
	}
}
