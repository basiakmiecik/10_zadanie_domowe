package zadanie1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PersonRead {
    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader("src/zadanie1/Data_person.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
      String line= "";

            do{
                try {

                   Person person= new Person(bufferedReader.readLine(),bufferedReader.readLine(),
                           bufferedReader.readLine(),bufferedReader.readLine());
                    System.out.println(person.getFirstName()+" "+person.getLastName()+" "+person.getAge()+" "+
                            person.getPesel());
                }catch (IncorrectAgeException e){
                    System.err.println("Nie podano wieku, lub podany wiek jest mniejszy od 1");

                }
                catch (NameUndefinedException e){
                    System.err.println("Podane imię bądz nazwisko jest błędne. Wczytaj poprawne dane!");
                }

            }while((line=bufferedReader.readLine()) != null);

            bufferedReader.close();



            }

        }



