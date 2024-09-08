package com.worktime;

public class worktime {
   private int wid;
   private int defaulthours;
   private int workinghours;
   private int OThours;
   private double OTbonuses;
   
   
   
public worktime(int wid, int defaulthours,int workinghours, int oThours, double oTbonuses) {
	
	this.wid = wid;
	this.defaulthours = defaulthours;
	this.workinghours = workinghours;
	this.OThours = oThours;
	this.OTbonuses = oTbonuses;
}

public int getWid() {
	return wid;
}

public int getDefaulthours() {
	return defaulthours;
}

public int getWorkinghours() {
	return workinghours;
}


public int getOThours() {
	return OThours;
}


public double getOTbonuses() {
	return OTbonuses;
}

   
}
