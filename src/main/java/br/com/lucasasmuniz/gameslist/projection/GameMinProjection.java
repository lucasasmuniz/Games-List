package br.com.lucasasmuniz.gameslist.projection;

public interface GameMinProjection {

    Long getId();
	String getTitle();
	Integer getYear();
	String getImgUrl();
	String getShortDescription();
	Integer getPosition();
} 