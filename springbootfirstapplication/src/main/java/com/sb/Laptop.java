package com.sb;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("lap1") //if name is setting to component then autowired can be based on name.
public class Laptop {

		private int lid;
		private String lname;
		
		public int getLid() {
			return lid;
		}
		public void setLid(int lid) {
			this.lid = lid;
		}
		public String getLname() {
			return lname;
		}
		public void setLname(String lname) {
			this.lname = lname;
		}
		
		public void lapOsDetails() {
			System.out.println("windows");
		}
		
		
}
