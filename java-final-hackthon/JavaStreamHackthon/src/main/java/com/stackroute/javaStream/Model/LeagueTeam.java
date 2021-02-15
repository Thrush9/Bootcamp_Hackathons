package com.stackroute.javaStream.Model;

public class LeagueTeam {

	private String teamTitle;
	private int year;
	private String season;

	public LeagueTeam(String title, int year, String season) {
		this.teamTitle = title;
		this.year = year;
		this.season = season;
	}

	public String getTeamTitle() {
		return teamTitle;
	}

	public void setTeamTitle(String teamTitle) {
		this.teamTitle = teamTitle;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	@Override
	public String toString() {
		return "LeagueTeam [teamTitle=" + teamTitle + ", year=" + year + ", season=" + season + "]";
	}

}
