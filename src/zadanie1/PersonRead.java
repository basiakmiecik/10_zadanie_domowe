package zadanie1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PersonRead {
    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader("Data_person.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String[] personData = new String[4];
        String line;
        Person person= new Person();
            do{
                try {
                    person.setFirstName(bufferedReader.readLine());
                }catch (NameUndefinedException e){
                    System.err.println("Nie podano imienia lub podane imię składa się z 1 litery");
                }
                try {
                    person.setLastName(bufferedReader.readLine());
                }catch (NameUndefinedException e){
                    System.err.println("Nie podano nazwiska lub podane nazwisko składa się z 1 litery");
                }
                try {
                    person.setAge(bufferedReader.readLine());
                }catch (IncorrectAgeException e){
                    System.err.println("Nie podano wieku, lub podany wiek jest mniejszy od 1");
                }
            person.setPesel(bufferedReader.readLine());
        }while((line=bufferedReader.readLine()) != null);


            bufferedReader.close();

        System.out.println(person.getFirstName()+ " "+person.getLastName()+" "+person.getAge()+" "+person.getPesel());
        }
    }

