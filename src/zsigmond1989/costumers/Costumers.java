package zsigmond1989.costumers;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Costumers {
    public static void main(String[] args) {
        Reader ugyfelek = new Reader();
        ugyfelek.reader();

    }
}

class Reader{
    private List<Costumer> costumers = new ArrayList<>();
    private String headLine;

    public void reader(){
        BufferedReader br = null;
        String line;
        String [] oneCostumer;
        Costumer ugyfel;
        try{

            br = new BufferedReader(new FileReader(new File("src/zsigmond1989/ugyfelek.csv")));
            headLine = br.readLine();
            while ((line = br.readLine()) != null){
                oneCostumer = line.split(",");
                ugyfel = new Costumer(oneCostumer[0],oneCostumer[1],oneCostumer[2],oneCostumer[3],oneCostumer[4],oneCostumer[5],Integer.parseInt(oneCostumer[6]),Integer.parseInt(oneCostumer[7]));
                costumers.add(ugyfel);
            }

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(costumers.size());

    }


}
class Costumer{
    private String name;
    private String motherName;
    private String dOB;
    private String pOB;
    private String accDate;
    private String accNo;
    private Integer balance;
    private Integer deposit;

    public Costumer(String a, String b, String c, String d, String e, String f, Integer g, Integer h){
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
}

