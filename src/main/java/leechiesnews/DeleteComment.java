package leechiesnews;

import leechiesnews.manager.SteemManager;
import leechiesnews.model.News;

public class DeleteComment {

	public static void main(String[] args) {
		System.setProperty("http.proxyHost", "proxy.recif.nc");
		System.setProperty("http.proxyPort", "80");
		System.setProperty("https.proxyHost", "proxy.recif.nc");
		System.setProperty("https.proxyPort", "80");
		
		News news = new News();
		news.author =    "cryptopress";
		news.postKey =   "5K1cmqnKrMqU37H5oqQrXP59gJL8acStcubZBDH9Qcv1tDHc695";
		news.activeKey = "5K9yBhdoM6fMG4Sq86PGyddHCm1iRjhjTMDAdV8hcY5FFcBdx8s";

		SteemManager.deleteNews("bitcoin-1", news);
	}
}
