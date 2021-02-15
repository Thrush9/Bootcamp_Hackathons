package com.stackroute.javaStream.Model;

public class Player {

	private String playerId;
	private String playerName;
	private String password;
	private int yearExpr;

	public Player(String id, String name, String password, int years) {
		this.playerId = id;
		this.playerName = name;
		this.password = password;
		this.yearExpr = years;
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getYearExpr() {
		return yearExpr;
	}

	public void setYearExpr(int yearExpr) {
		this.yearExpr = yearExpr;
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", playerName=" + playerName + ", password=" + password + ", yearExpr="
				+ yearExpr + "]";
	}

}
