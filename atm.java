import java.util.Scanner;

class atm {
    int actno, actbal, apin, cpin, npin;
    String uname;
    int wamt, damt, upin;
    
    // Created a single Scanner instance to reuse across methods
    Scanner sc = new Scanner(System.in);

    void set() {
        actno = 1234;
        actbal = 25000;
        apin = 2233;
        uname = "Default User";
        System.out.println("--- Profile Set! ---");
    }

    void withamt() {
        System.out.print("Enter Your ATM Pin: ");
        upin = sc.nextInt();
        
        if (upin == apin) {
            System.out.print("Enter Withdraw Amount: ");
            wamt = sc.nextInt();
            
            if (wamt <= actbal) {
                actbal = actbal - wamt;
                System.out.println("Your Balance: " + actbal);
            } else {
                System.out.println("Insufficient Balance!");
            }
        } else {
            System.out.println("Wrong Pin!");
        }
    }

    void depoamt() {
        System.out.print("Enter Your ATM Pin: ");
        upin = sc.nextInt();
        
        if (upin == apin) {
            System.out.print("Enter Deposit Amount: ");
            damt = sc.nextInt();
            actbal = actbal + damt;
            System.out.println("Your Balance: " + actbal);
        } else {
            System.out.println("Wrong Pin!");
        }
    }

    void balance() {
        System.out.print("Enter Your ATM Pin: ");
        upin = sc.nextInt();
        
        if (upin == apin) {
            System.out.println("Your Balance: " + actbal);
        } else {
            System.out.println("Wrong Pin!");
        }
    }

    void pin() {
        System.out.print("Enter Your Old ATM Pin: ");
        upin = sc.nextInt();
        
        if (upin == apin) {
            System.out.print("Enter New Pin: ");
            npin = sc.nextInt();
            System.out.print("Enter Confirm Pin: ");
            cpin = sc.nextInt();
            
            if (npin == cpin) {
                apin = cpin;
                System.out.println("Your Pin Changed!");
            } else {
                System.out.println("New Pin and Confirm Pin Should Be Same!");
            }
        } else {
            System.out.println("Wrong Pin!");
        }
    }
    public static void main(String arr[]) {
        atm obj = new atm();
        obj.set();
        int ch = 2;
        
        do {
            System.out.println("\nEnter Your Choice:\n1] Withdraw Amount\n2] Deposit Amount\n3] Balance Enquiry\n4] Pin Change\n");
            System.out.print("Choice: ");
            int in = obj.sc.nextInt();
            
            if (in == 1) {
                obj.withamt();
            } else if (in == 2) {
                obj.depoamt();
            } else if (in == 3) {
                obj.balance();
            } else if (in == 4) {
                obj.pin();
            } 
              else {
                System.out.println("Wrong Input!");
            }
            
            System.out.println("\nDo You Want Another Operation?\n1] Yes\n2] No");
            System.out.print("Choice: ");
            ch = obj.sc.nextInt();
            
        } while (ch == 1);
        
        if (ch == 2) {
            System.out.println("Thank You!");
        } else {
            System.out.println("Wrong Input!");
        }
    }
}
