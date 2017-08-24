package leechiesnews.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

public class News implements Serializable {
	private static final long serialVersionUID = 1L;

	public String url; // key unique
	public String titre;
	public String text;
	public boolean uploaded;
	public Date uploadedTime=null; // date d'envoi sur steem
	public boolean hasError=false;
	public String error="";
	
	@Override
	public boolean equals(Object o) {
		return url == ((News) o).url;
	}

	@Override
	public int hashCode() {
		return Objects.hash(text);
	}

	@Override
	public String toString() {
		String ret = "\nurl : "+ url;
		ret += "\ntitre : "+ titre;
		ret += "\ntexte : "+ StringUtils.substring(text, 0, 20) + "...";
		ret += "\nuploadedTime : "+ uploadedTime;
		ret += "\nuhasError : "+ hasError;
		String wtf = StringUtils.isEmpty(error) ? "none":error;
		ret += "\nerror : " + wtf;
		return ret;
	}
}
