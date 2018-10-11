package zadanie2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ProductReader {
    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader("produkty.csv");
        BufferedReader count = new BufferedReader(fileReader);

        int lineCount = 0;
        while (count.readLine() != null)
            lineCount++;
        count.close();

        String[] tab = new String[lineCount];

        File file = new File("produkty.csv");
        Scanner scanner = new Scanner(file);
        for (int i = 0; i < lineCount; i++) {
            tab[i] = scanner.nextLine();
        }

        System.out.println(tab[0]);
        Product[] products = new Product[lineCount];
        System.out.println(tab.length);
        for (int i = 0; i < lineCount; i++) {
            products[i] = new Product();
            String[] output = tab[i].split(";");
            int j = 0;
            products[i].setName(output[j]);
            products[i].setProducent(output[j + 1]);
            products[i].setPrice(Double.parseDouble(output[j + 2]));
        }

        System.out.println("Suma wszytskich cen produktow to: " + addPrice(products));
        System.out.println("Najdrozszy produkt to: " + mostExpensive(products).getName() + " producet: "
                + mostExpensive(products).getProducent() + " w cenie: " + mostExpensive(products).getPrice() +
                "\nNajbardziej powtarzający się producent to: " + greatestProd(products));
    }

    public static double addPrice(Product[] products) {
        double sumPrice = 0;
        for (int i = 0; i < products.length; i++) {
            sumPrice += Math.round(products[i].getPrice())/1.00;
        }
        return sumPrice;
    }

    public static Product mostExpensive(Product[] products) {
        Product highest = products[0];
        double priceHighest = products[0].getPrice();
        for (int i = 0; i < products.length; i++) {
            if (products[i].getPrice() > priceHighest) {
                highest = products[i];
                priceHighest = products[i].getPrice();
            }
        }

        return highest;
    }

    public static String greatestProd(Product[] products) {
        String bigProd = null;
        int reccurence = 0;
        for (int j = 0; j < products.length; j++) {
            int replication = 0;

            for (int i = 0; i < products.length; i++) {
                if (products[j].getProducent().equals(products[i].getProducent())) {
                    replication += 1;
                }
                if (replication > reccurence) {
                    bigProd = products[j].getProducent();
                    reccurence = replication;
                }
            }

        }

        return bigProd;
    }


}
