package emailApp;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class Email {
    public Scanner scanner = new Scanner(System.in);
//    Setting variables as private
    private String fName, lName, dept;
    private String email, password, alter_email;
    private int mailCapacity = 500;

//    Constructor to receive first name and last name

    public Email(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
        System.out.println("New Employee: "+ this.fName + " " + this.lName);

//        calling methods
        this.dept = this.setDept();
        this.password = this.generatePassword(8);
        this.email = this.generateEmail();
    }

//    Generating email method

    private String generateEmail() {
        return this.fName.toLowerCase()+"."+this.lName.toLowerCase()+"@"+this.dept+".company.com";
    }

//    Asking for department

    public String setDept() {
        System.out.println("Department codes \n1 for Sales \n2 for Development \n3 for Accounting");
        boolean flag = false;
        do{
            System.out.println("Enter the department code: ");
            int choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    return "Sales";
                case 2:
                    return "Development";
                case 3:
                    return "Accounting";
                case 0:
                    return "None";
                default:
                    System.out.println("Invalid choice please choose again");
            }
        }while(!flag);
        return null;
    }

    private String generatePassword(int length) {
        Random r = new Random();
        String capital_letters = "ABCDEFGHIJKLMNOPQRUSTVWXYZ";
        String small_letters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%&?";
        String values = capital_letters + small_letters + numbers + symbols;
        String password = "";
        for(int i = 0; i<length; i++) {
            password = password + values.charAt(r.nextInt(values.length()));
        }
        return password;
    }

    public void setPassword() {
        boolean flag = false;
        do{
            System.out.println("Do you want to change your password!(Y/N)?");
            char choice = scanner.next().charAt(0);
            if(choice == 'Y' || choice == 'y'){
                flag = true;
                System.out.println("Enter current password: ");
                String temp = scanner.next();
                if(temp.equals(this.password)) {
                    System.out.println("Enter the new password: ");
                    this.password = scanner.next();
                    System.out.println("Password changed succesfully");
                } else {
                    System.out.println("Incorrect password");
                }
            }else if(choice == 'N' || choice == 'n') {
                flag = true;
                System.out.println("'password changed option cancelled");
            }else {
                System.out.println("Enter valid Choice");
            }
        }while (!flag);
    }
//    Set mailbox capacity method
    public void set_mailCap() {
        System.out.println("Current Capapcity= " + this.mailCapacity + "mb");
        System.out.println("Enter new mailbox capacity: ");
        this.mailCapacity = scanner.nextInt();
        System.out.println("Mailbox capacity is successfully changed");
    }
//    Set alternate mail
    public void setAlter_email() {
        System.out.println("Enter new alternate ail: ");
        this.alter_email = scanner.next();
        System.out.println("Alternate email is set");
    }

//    display user information
    public void getInfo() {
        System.out.println("New: "+this.fName + " " + this.lName);
        System.out.println("Department: "+ this.dept);
        System.out.println("Email: " + this.email);
        System.out.println("Password: "+ this.password);
        System.out.println("Mailbox capacity "+ this.mailCapacity);
        System.out.println("Alternate mail "+ this.alter_email);
    }

    public void storeFile() {
        try {
            FileWriter in = new FileWriter("C:\\Users\\yashj\\OneDrive\\Desktop\\info.txt");
            in.write("First Name: "+this.fName);
            in.append("\nLast Name: "+this.lName);
            in.append("\nEmail: "+this.email);
            in.append("\nPassword: "+this.password);
            in.append("\nCapacity" + this.mailCapacity);
            in.append("\nAlternate Mail: "+this.alter_email);
            in.close();
            System.out.println("Data is Stored..");
        }catch(Exception e) {
            System.out.println(e);
        }
    }
    public void read_file() {
        try{
            FileReader f1 = new FileReader("C:\\Users\\yashj\\OneDrive\\Desktop\\info.txt");
            int i;
            while((i = f1.read())!=-1){
                System.out.print((char)i);
            }
//            System.out.println("");
            f1.close();
        }catch(Exception e) {
            System.out.println(e);
        }
    }
}
