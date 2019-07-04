package it.contrader.dto;

public class StreetDTO {
	
	

		private int idstreet;

		private String streetname; 

		private String streettype;

		public StreetDTO () {
			
		}
		
		public StreetDTO ( String streetname, String streettype) {
			this.streetname = streetname;
			
			this.streettype = streettype;
		}
		
		public StreetDTO (int idstreet, String streetname, String streettype) {
			this.idstreet = idstreet;
			this.streetname = streetname;
			
			this.streettype = streettype;
		}
		
		public int getIdStreet() {
			return this.idstreet;	
		}
		
		public void setIdStreet(int idstreet) {
			this.idstreet = idstreet;
		
		}
		
		public String getStreetname() {
			return this.streetname;
			
		}
		
		public void setStreetname(String streetname) {
			this.streetname = streetname;
		}
		
		public String getStreettype() {
			return this.streettype;
			
		}
		
		public void setStreettype(String streetype) {
			this.streettype = streetype;
		}
		
		
		@Override
		public String toString() {
			return idstreet + "\t" + streetname + "\t\t" + streettype;
		}
	

	 

}
