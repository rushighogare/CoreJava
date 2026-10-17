package LibraryManagementSystem;

public class Member {
    private int memberId;
    private String name;
    private String email;
    private int phoneNumber;

    public Member() {
        this.memberId=0;
        this.name="";
        this.email="";
        this.phoneNumber=0000000000;
    }
    
    public Member(int memberId, String name, String email, int phoneNumber) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void displayMemberDetails(){
        System.out.println("Member id: "+getMemberId());
        System.out.println("Name of member: "+getName());
        System.out.println("Email: "+getEmail());
        System.out.println("Contact no. "+getPhoneNumber());
    }
}
