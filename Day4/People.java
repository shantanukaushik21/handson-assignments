
public abstract class People {
	
	private String name;
	private String dob;
	private String gender;
	private long phone;
	Address address;
	 public People(String name, String dob, String gender, long phone){
		this.name=name;
		this.dob=dob;
		this.gender=gender;
		this.phone=phone;
	 }
	 public People(String name, String dob, String gender, long phone, Address address){
			this.name=name;
			this.dob=dob;
			this.gender=gender;
			this.phone=phone;
			this.address=address;
		 }
	 public String getName() {
		return name; 
	 }
	 public String getDob() {
		 return dob;
	 }
	 public String getGender() {
			return gender; 
		 }
	 public long getPhone() {
			return phone; 
		 }
	 public void getDetails() {
		 System.out.println("Name: "+name);
		 System.out.println("Dob: "+dob);
		 System.out.println("gender: "+gender);
		 System.out.println("Phone: "+phone);
		 
	 }
	
	
}
