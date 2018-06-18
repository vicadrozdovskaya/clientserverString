package by.drozdovskaya.serverstring.text;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.drozdovskaya.serverstring.file.WorkWithFile;



public class Text {
	private String text;
	private List <String> sentences; 
	private List <String> words; 
	
	public Text() {
		sentences = new ArrayList<String>();
		words = new ArrayList<String>();
	}

	public Text(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public List<String> getSentences() {
		return sentences;
	}

	public void setSentences(List<String> sentences) {
		this.sentences = sentences;
	}

	public List<String> getWords() {
		return words;
	}

	public void setWords(List<String> words) {
		this.words = words;
	}

	public void setSentences() {
		Matcher matcher = Pattern.compile("([^.!?]+[.!?])").matcher(text);
		while (matcher.find())
		{
		    sentences.add(matcher.group());
		}
	}
	
	public void readTextFromFile() {
		WorkWithFile file = new WorkWithFile();
		this.text = file.readFromFile("Text");
	}
	
	public  void splitWords(String str) {
	    Pattern pattern = Pattern.compile("(\\w+)|(\\.{3})|[^\\s]|[\\s]");
	    Matcher matcher = pattern.matcher(str);
	    while (matcher.find()) {
	        words.add(matcher.group());
	    }

	}
	
	public void setSymbol(int k, char symbol) {
		Pattern pattern = Pattern.compile("\\p{Punct}");
	    for (int i = 0; i < words.size(); i++) {
	    	Matcher matcher = pattern.matcher(words.get(i));
	    	if (!matcher.matches()) {
	    		if(words.get(i).length()-1 >= k) {
	    		StringBuilder s = new StringBuilder(words.get(i));
	    		s.setCharAt(k, symbol);
	    		words.set(i, s.toString());
	    		}
	    	}
	    }

	}
	
	public String doChange(int k, char symbol) {
		System.out.println("k = " + k);
		this.readTextFromFile();
		StringBuilder changedText = new StringBuilder();
		this.setSentences();
		for (int i = 0; i < sentences.size() ; i++) {
			this.splitWords(sentences.get(i));
			this.setSymbol(k, symbol);	
		}
		for (int j = 0 ; j < words.size(); j++) {
			changedText.append(words.get(j));
		}
		this.setText(changedText.toString());
		return text;
	}

}
