import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProductReader {
    public static void main(String[] args) throws IOException {
        Product[] products = new Product[4];
        String[] tab = new String[4];
        FileReader fileReader = new FileReader("produkty.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        for (int i = 0; i < products.length; i++) {
            tab[i] = bufferedReader.readLine();
        }

        for (int i = 0; i < products.length; i++) {
            products[i] = new Product();
            String[] output = tab[i].split(";");
            int j = 0;
            products[i].setName(output[j]);
            products[i].setProducent(output[j + 1]);
            products[i].setPrice(Double.parseDouble(output[j + 2]));
        }

        System.out.println("Suma wszytskich cen produktow to: "+ addPrice(products));
        System.out.println("Najdrozszy produkt to: "+mostExpensive(products).getName()+" producet: "
                +mostExpensive(products).getProducent()+" o cenie: "+mostExpensive(products).getPrice());
    }

    public static double addPrice(Product[] products) {
        double sumPrice = 0;
        for (int i = 0; i < products.length; i++) {
            sumPrice += products[i].getPrice();
        }
        return sumPrice;
    }

    public static Product mostExpensive(Product [] products){
        Product highest= products[0];
        double priceHighest=products[0].getPrice();
        for (int i = 0; i < products.length; i++) {
            if(products[i].getPrice()>priceHighest){
                highest=products[i];
                priceHighest=products[i].getPrice();
            }
        }

    return highest;}


}
