package customer;

import java.util.Objects;

public class Customer implements Comparable<Customer> {

    private int id;
    private int cardnumber;
    private double balance;
    private String name, surname, thirdname, adress;

    public Customer() {
    }

    public Customer(int id, String name, String surname, String thirdname, String adress, int cardnumber, double balance) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.thirdname = thirdname;
        this.adress = adress;
        this.cardnumber = cardnumber;
        this.balance = balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setCardnumber(int cardnumber) {
        this.cardnumber = cardnumber;
    }

    public int getCardnumber() {
        return cardnumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setThirdname(String thirdname) {
        this.thirdname = thirdname;
    }

    public String getThirdname() {
        return thirdname;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getAdress() {
        return adress;
    }

    public String toString() {
        return "id: " + id + "\nName: " + name + "\nSurname: " + surname + "\nThirdname: "
                + thirdname + "\nAdress: " + adress + "\nCardnumber: "
                + cardnumber + "\nBalance: " + balance + "\n----------------------------------------------------------------------------";
    }

    public String str() {
        return id + " " + name + " " + surname + " " + thirdname + " " + adress + " " + cardnumber + " " + balance;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                cardnumber == customer.cardnumber &&
                Double.compare(customer.balance, balance) == 0 &&
                Objects.equals(name, customer.name) &&
                Objects.equals(surname, customer.surname) &&
                Objects.equals(thirdname, customer.thirdname) &&
                Objects.equals(adress, customer.adress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cardnumber, balance, name, surname, thirdname, adress);
    }

    @Override
    public int compareTo(Customer other) { return Integer.compare(id, other.id); }

}
