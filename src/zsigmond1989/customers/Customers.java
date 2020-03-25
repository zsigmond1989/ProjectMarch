package zsigmond1989.customers;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Customers {
    public static void main(String[] args) {
        Reader ugyfelek = new Reader();
        ugyfelek.reader();
        ugyfelek.sortByAccDate();
        ugyfelek.saveCustomers("szamlanyitas.csv");
        ugyfelek.sortByNames();
        ugyfelek.saveCustomers("nevek.csv");
        ugyfelek.sortBySum();
        ugyfelek.saveCustomers("penzosszegek.csv");

    }
}

class Reader{
    private List<Customer> customers = new ArrayList<>();
    private String headLine;

    public void reader(){
        BufferedReader br = null;
        String line;
        String [] oneCustomer;
        Customer ugyfel;
        try{

            br = new BufferedReader(new FileReader(new File("src/zsigmond1989/ugyfelek.csv")));
            headLine = br.readLine();
            while ((line = br.readLine()) != null){
                oneCustomer = line.split(",");
                ugyfel = new Customer(oneCustomer[0],oneCustomer[1],oneCustomer[2],oneCustomer[3],oneCustomer[4],oneCustomer[5],Integer.parseInt(oneCustomer[6]),Integer.parseInt(oneCustomer[7]));
                customers.add(ugyfel);
            }

        } catch (IOException e){
            e.printStackTrace();
        }


    }
    public void sortByAccDate(){
        Collections.sort( customers , (c1, c2) -> c1.getAccDate().compareTo(c2.getAccDate()));
    }

    public void sortByNames(){
        Collections.sort( customers , (c1, c2) -> c1.getNames().compareTo(c2.getNames()));
    }

    public void sortBySum(){
        Collections.sort( customers , (c1, c2) -> c1.getSum().compareTo(c2.getSum()));
    }

    public void saveCustomers(String fileName){
        BufferedWriter bw = null;
        String oneLine;

        File outputFile = new File(fileName);
        try {
            bw = new BufferedWriter( new FileWriter(outputFile));
            bw.write(headLine); bw.newLine();
            for (Customer co: customers ) {
                oneLine = co.getName()+","+co.getMotherName()+","+co.getdOB()+","+co.getpOB()+","+
                        co.getAccDate()+","+co.getAccNo()+","+co.getBalance()+","+co.getDeposit();
                bw.write( oneLine ); bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
class Customer {
    private String name;
    private String motherName;
    private String dOB;
    private String pOB;
    private String accDate;
    private String accNo;
    private Integer balance;
    private Integer deposit;

    public Customer(String a, String b, String c, String d, String e, String f, Integer g, Integer h){
        this.name=a;
        this.motherName=b;
        this.dOB=c;
        this.pOB=d;
        this.accDate=e;
        this.accNo=f;
        this.balance=g;
        this.deposit=h;
    }

    public String getName() {
        return name;
    }

    public String getMotherName() {
        return motherName;
    }

    public String getdOB() {
        return dOB;
    }

    public String getpOB() {
        return pOB;
    }

    public String getAccDate() {
        return accDate;
    }

    public String getAccNo() {
        return accNo;
    }

    public Integer getBalance() {
        return balance;
    }

    public Integer getDeposit() {
        return deposit;
    }
    public String getNames() {
        return name + motherName;
    }

    public Integer getSum() {
        return balance + deposit;
    }

}

