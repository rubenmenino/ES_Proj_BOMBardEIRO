package com.project.ArmyEye.Models;

import java.time.ZonedDateTime;
import java.util.Date;

public class GPS {
	public String yMdHms;
	public String Lat;
	public String Long;
	public String tag;
	public String Alt;
	public String val;

    /*public String TimestampUTC;
    public String Timestampms;
    public String GPStime;
    public String Latitude;
    public String Longitude;
    public String Altitude;*/

	@Override
	public String toString() {
		return "GPS{" +
				"yMd='" + yMdHms + '\'' +
				", Lat='" + Lat + '\'' +
				", Long='" + Long + '\'' +
				", tag='" + tag + '\'' +
				", Alt='" + Alt + '\'' +
				", val='" + val + '\'' +
				'}';
	}

	public GPS() {
	}

	public GPS(String yMdHms, String lat, String aLong, String tag, String alt, String val) {
		this.yMdHms = yMdHms;
		Lat = lat;
		Long = aLong;
		this.tag = tag;
		Alt = alt;
		this.val = val;
	}

	public String getyMdHms() {
		return yMdHms;
	}

	public void setyMdHms(String yMd) {
		this.yMdHms = yMdHms;
	}

	public String getLat() {
		return Lat;
	}

	public void setLat(String lat) {
		Lat = lat;
	}

	public String getLong() {
		return Long;
	}

	public void setLong(String aLong) {
		Long = aLong;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getAlt() {
		return Alt;
	}

	public void setAlt(String alt) {
		Alt = alt;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}
}
