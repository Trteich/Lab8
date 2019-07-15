package main;

import customer.Customer;

import java.util.*;

public class Main {
    static List<Customer> customers;
    static ReaderWriter rw;

    public static void main(String[] args) {
	    new Main().run("F://cus.txt");
    }

    private void run(String filename) {
        rw = new ReaderWriter(filename);
        customers = rw.readAll();
        Menu menu = new Menu(List.of(
                "1. Number Customers in List",
                "2. Get customer Information",
                "3. Edit customer Information",
                "0. Exit"
        ));
        int selection;
        while ((selection = menu.select()) != 0) {
            switch (selection) {
                case 1:
                    showNumberOfCustomers();
                    break;
                case 2:
                    showCustomerInformation();
                    break;
                case 3:
                    editCustomerInformation();
            }
        }
    }

    private void showNumberOfCustomers() {
        System.out.println("Total customers: " + customers.size());
    }

    private void showCustomerInformation() {
        Menu menu = new Menu(List.of(
                "1. Show all customers information",
                "2. Search customer",
                "3. Advanced",
                "0. Up"
        ));
        int selection;
        while ((selection = menu.select()) != 0) {
            switch (selection) {
                case 1:
                    customers.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
                    break;
                case 2:
                    searchCustomer();
                    break;

                case 3:
                    advanced();
            }
        }
    }

    private void searchCustomer(){
        Menu menu = new Menu(List.of(
                "1. Search by id",
                "2. Search by name",
                "3. Search by surname",
                "4. Search by thirdname",
                "5. Search by adress",
                "6. Search by cardnumber interval",
                "7. Search by debt",
                "0. Up"
        ));
        Scanner d = new Scanner(System.in);
        Search searcher = new Search();
        int selection;
        while ((selection = menu.select()) !=0){
            switch (selection){
                case 1:
                    System.out.print("Enter number:");
                    Customer c = searcher.searchId(d.nextDouble());
                    System.out.println((c != null) ? c: "Customer not found");
                    break;

                case 2:
                    System.out.print("Enter name:");
                    ArrayList<Customer> nameList = searcher.searchName(d.next());
                    if (nameList.isEmpty()) System.out.println("Customer nof found");
                    else{
                        nameList.forEach(System.out::println);
                    }
                    break;

                case 6:
                    System.out.println("enter cardnumber interval:");
                    ArrayList<Customer> cardIntervalList = searcher.searchCardInterval(d.next());
                    if (!cardIntervalList.isEmpty()) {
                        System.out.println("Number customers in intreval: " +cardIntervalList.size());
                        cardIntervalList.forEach(System.out::println);
                    }
                    else System.out.println("Customer not found");
                    break;

                case 7:
                    ArrayList<Customer> debtList = searcher.searchDebt();
                    if (!debtList.isEmpty()) {
                        System.out.println("Number customers with debt: " +debtList.size());
                        debtList.forEach(System.out::println);
                    }
                    else{
                        System.out.println("Customer nof found");
                    }
                    break;

                case 3:
                case 4:
                case 5:
                    System.out.print("Enter string:");
                    ArrayList<Customer> list = searcher.searchString(d.next());
                    if (!list.isEmpty()) list.forEach(System.out::println);
                    else System.out.println("Customer not found");
                    break;
            }
        }

//        d.close();
    }

    private void advanced() {
        Menu menu = new Menu(List .of(
                "1. Sort by Balance",
                "2. Show all adresses",
                "3. Show richest customer in each town",
                "0. UP"
        ));
        Search searcher = new Search();
        int selection;
        while ((selection= menu.select()) != 0){
            switch (selection){
                case 1:
                    searcher.sortByBalance().forEach(System.out::println);
                    break;

                case 2:
                    HashMap<String, ArrayList<Customer>> map = searcher.adressMap();
                    Set<String> addrMap = map.keySet();
                    addrMap.forEach(System.out::println);
                    System.out.println("------------------------------------------");
                    break;

                case 3:
                    HashMap<String, ArrayList<Customer>> map1 = searcher.adressMap();
                    for (Map.Entry<String, ArrayList<Customer>> entry : map1.entrySet()){
                        String adrr = entry.getKey();
                        Customer customer = entry.getValue().stream().max(Comparator.comparing(Customer::getBalance)).get();
                        System.out.println("In town " +adrr +" the richest customer is " +customer.getSurname() +" " +customer.getName()
                                +" id: " +customer.getId() +" cardnumber: " +customer.getCardnumber() +" balance: " +customer.getBalance());
                        System.out.println("------------------------------------------");
                    }
            }

        }
    }

    private void editCustomerInformation (){
        Menu menu = new Menu(List.of(
                "1.Add customer",
                "2.Delete customer",
                "3.Edit customer",
                "0. Up"
        ));
        Scanner id = new Scanner(System.in);
        Customer customer;
        Search searcher = new Search();
        int selection;
        while ((selection = menu.select()) != 0){
            switch (selection) {
                case 1:
                    EditCustomer.addCustomer();
                    break;
                case 2:
                    System.out.print("\nEnter customer's id or cardnumber:");
                        customer = searcher.searchId(id.nextDouble());
                    if (customer != null) EditCustomer.deleteCustomer(customer);
                    else System.out.println("Customer not found");
                    break;
                case 3:
                    System.out.print("\nEnter customer's id or cardnumber:");
                        customer = searcher.searchId(id.nextDouble());
                    if (customer != null) EditCustomer.editCustomerParameter(customer);
                    else System.out.println("Customer not found");
                    break;
            }
        }
    }



}
