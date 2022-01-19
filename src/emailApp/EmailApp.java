package emailApp;

import java.util.Scanner;

public class EmailApp {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

//        UserInfo
        System.out.println("Enter first Name: ");
        String f_name = s.next();
        System.out.println("Enter Last Name: ");
        String l_name = s.next();

        Email email1 = new Email(f_name, l_name);
        int choice = -1;
        do{
            System.out.println("\n****\nEnter your choice\n1 Show Info\n2 Change Password\n3 Change Mailbox Capacity\n4 Set Alternate Mail\n5 Storing Data\n6 Read afile\n7 Exit.");
            choice = s.nextInt();
            switch(choice) {
                case 1:
                    email1.getInfo();
                    break;
                case 2:
                    email1.setPassword();
                    break;
                case 3:
                    email1.set_mailCap();
                    break;
                case 4:
                    email1.setAlter_email();
                    break;
                case 5:
                    email1.storeFile();
                    break;
                case 6:
                    email1.read_file();
                    break;
                case 7:
                    System.out.println("Thank you for using system");
                    break;
                default:
                    System.out.println("invalid choice!! \nEnter proper choice");
            }
        }while(choice != 7);
    }
}
