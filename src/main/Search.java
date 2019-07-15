package main;

import customer.Customer;

import java.util.*;
import java.util.stream.Collectors;

class Search {
    ArrayList<Customer> searchString(String s) {
       List<Customer> list = Main.customers.stream()
               .filter(customer -> customer.getSurname().equals(s) || customer.getThirdname().equals(s) || customer.getAdress().equals(s))
               .collect(Collectors.toList());

       return (ArrayList<Customer>) list;
    }

    Customer searchId(double id) {

        return Main.customers.stream().filter(customer -> customer.getId() == id ||customer.getCardnumber() == id)
                .findFirst()
                .orElse(null);
    }

    ArrayList<Customer> searchName(String name){
        List<Customer> list = Main.customers.stream().filter(c -> c.getName().equals(name)).sorted(Comparator.naturalOrder()).collect(Collectors.toList());

        return  (ArrayList<Customer>) list;
    }

    ArrayList<Customer> searchCardInterval(String interval){
        String[] crdNumber = interval.split("-");
        List<Customer> list = Main.customers.stream()
                                            .filter(customer -> customer.getCardnumber() > Integer.parseInt(crdNumber[0]) && customer.getCardnumber() < Integer.parseInt(crdNumber[1]))
                                            .sorted(Comparator.comparing(Customer::getCardnumber))
                                            .collect(Collectors.toList());

        return (ArrayList<Customer>)list;
    }

    ArrayList<Customer> searchDebt(){
        List<Customer> list = Main.customers.stream()
                .filter(customer -> customer.getBalance()<0)
                .sorted(Comparator.comparing(Customer::getBalance).reversed())
                .collect(Collectors.toList());

        return (ArrayList<Customer>)list;
    }

    ArrayList<Customer> sortByBalance(){
        List<Customer> list = Main.customers.stream().sorted((customer,other) -> {
            int compare = (int)(customer.getBalance() - other.getBalance());
            if (compare == 0) compare=customer.getCardnumber()-other.getCardnumber();

            return compare;
        })
                .collect(Collectors.toList());

        return (ArrayList<Customer>)list;
    }

    HashMap<String, ArrayList<Customer>> adressMap(){
        HashMap<String, ArrayList<Customer>> ardessMap = new HashMap<>();

        for (Customer customer : Main.customers){
            String adress = customer.getAdress();
            ArrayList<Customer> customers = ardessMap.computeIfAbsent(adress, k -> new ArrayList<>());
            customers.add(customer);
        }

        return ardessMap;
    }
}
