import java.util.Locale;
import java.util.Scanner;
public class BuildEmail {
    private String firstname;
    private String lastname;
    private String password;
    private String email;
    private String department;
    private int MailboxCapacity = 500;
    private  int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "company.com";
    // constructor
    public BuildEmail(String firstname, String lastname){
        this.firstname =  firstname;
        this.lastname = lastname;
        System.out.println("Email created" + this.firstname + " " + this.lastname);
        this.department = setDepartment();
        System.out.println("department " + this.department);
        this.password = randomPassword(defaultPasswordLength);
        System.out.println(" your password is " + this.password);
        // combine all elements to create email
        email = firstname.toLowerCase() + "." + lastname.toLowerCase() + "@" + department + companySuffix;
        System.out.println(" your email is : " + email);

    }

    //ask for the departement
    private String setDepartment() {
        System.out.println("Enter the department\n1-for sales\n2- for developmemnt\n3- for accounting\n0_ for nothing");
        Scanner scanner = new Scanner(System.in);
        int depChoice = scanner.nextInt();
        if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "development";
        } else if (depChoice == 3) {
            return "accounting";
        } else {
            return "";
        }
    }
    // generate random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!#@&$%";
        //arraylist from 10 empity places
        char[] password = new char[length];
        for (int i=0; i<length; i++){
            int rand = (int)(Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String (password);

    }

    // set the mailbox capacity
public void setMailboxCapacity(int capacity){
        this.MailboxCapacity = capacity;
}
    // set  alternate email
public void setAlternateEmail(String alternateEmail) {
    this.alternateEmail = alternateEmail;
}

    // change the password
    public void changePassword(String password){
        this.password = password;
    }
    public int getMailboxCapacity(){return MailboxCapacity;}
    public String getAlternateEmail() {
        return alternateEmail;
    }
    public String getPassword() {
        return password;
    }
    public String showinfo(){
        return "Display name " + firstname + " " + lastname + "\n"
                + "company Email : " + email + "\n" +
                "mail box capacity " + MailboxCapacity + "mb";
    }
}
