package com.stackroute.javaStream.Model;

public class PlayerTeam {

	private String playerId;
	private String teamTitle;
	private String season;
	private String yearExpr;

	public PlayerTeam(String id, String team, String season, String years) {
		this.playerId = id;
		this.teamTitle = team;
		this.season = season;
		this.yearExpr = years;
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public String getTeamTitle() {
		return teamTitle;
	}

	public void setTeamTitle(String teamTitle) {
		this.teamTitle = teamTitle;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getYearExpr() {
		return yearExpr;
	}

	public void setYearExpr(String yearExpr) {
		this.yearExpr = yearExpr;
	}

	@Override
	public String toString() {
		return "PlayerTeam [playerId=" + playerId + ", teamTitle=" + teamTitle + ", season=" + season + ", yearExpr="
				+ yearExpr + "]";
	}

}
