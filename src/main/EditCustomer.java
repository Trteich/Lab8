package main;

import customer.Customer;

import java.util.List;
import java.util.Scanner;

class EditCustomer {
    static void addCustomer() {
        Scanner in = new Scanner(System.in);
        Customer cust = new Customer();
        System.out.print("Enter id:");
        cust.setId(in.nextInt());
        System.out.print("\nEnter name: ");
        cust.setName(in.next());
        System.out.print("\nEnter surame: ");
        cust.setSurname(in.next());
        System.out.print("\nEnter thirdame: ");
        cust.setThirdname(in.next());
        System.out.print("\nEnter adress: ");
        cust.setAdress(in.next());
        System.out.print("\nEnter cardnumber: ");
        cust.setCardnumber(in.nextInt());
        System.out.print("\nEnter balance: ");
        cust.setBalance(in.nextDouble());
        Main.customers.add(cust);
        Main.rw.writeAll(Main.customers);
        System.out.println("\nCustomer was added!\n");
    }

    static void deleteCustomer(Customer customer) {
        if (customer != null) {
            Main.customers.remove(customer);
            Main.rw.writeAll(Main.customers);
            System.out.println("\nCUSTOMER DELETED\n");
        }
    }

    static void editCustomerParameter(Customer customer){
        if (customer != null){
            System.out.println("Parameter to edit:");
            Menu menu = new Menu(List.of(
                    "1.Id",
                    "2.Name",
                    "3.Surname",
                    "4.Thirdname",
                    "5.Adress",
                    "6.Cardnumber",
                    "7.Balance",
                    "\n0.Up"
            ));
            Scanner scanner = new Scanner(System.in);
           int selection;
            while ((selection = menu.select()) != 0) {
                switch (selection) {
                    case 1:
                        System.out.print("Enter new Id: ");
                        customer.setId(scanner.nextInt());
                        break;

                    case 2:
                        System.out.print("Enter new name: ");
                        customer.setName(scanner.next());
                        break;

                    case 3:
                        System.out.print("Enter new surname: ");
                        customer.setSurname(scanner.next());
                        break;

                    case 4:
                        System.out.print("Enter new thirdname: ");
                        customer.setThirdname(scanner.next());
                        break;

                    case 5:
                        System.out.print("Enter new adres: ");
                        customer.setAdress(scanner.next());
                        break;

                    case 6:
                        System.out.print("Enter new cardnumber: ");
                        customer.setCardnumber(scanner.nextInt());
                        break;

                    case 7:
                        System.out.print("Enter new balance: ");
                        customer.setBalance(scanner.nextInt());
                        break;
                }

                Main.rw.writeAll(Main.customers);
                System.out.println("\nParameter edited\n");
            }

        }
//        scanner.close();
    }
}
