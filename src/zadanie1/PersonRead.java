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
        String pFirstName="";
        String pLastName="";
        String pAge="";
        String pPesel="";
        boolean data=false;
            do{
                try {

                   pFirstName = (bufferedReader.readLine());
                   pLastName= (bufferedReader.readLine());
                   pAge= (bufferedReader.readLine());
                   data = correctData(pFirstName,pLastName,pAge);

                }catch (IncorrectAgeException e){
                    System.err.println("Nie podano wieku, lub podany wiek jest mniejszy od 1");
                }
                catch (NameUndefinedException e){
                    System.err.println("Podane imię bądz nazwisko jest błędne. Wczytaj poprawne dane!");
                }
            pPesel= (bufferedReader.readLine());

            }while((line=bufferedReader.readLine()) != null);

            bufferedReader.close();

            if (data){
                Person person= new Person(pFirstName,pLastName,pAge,pPesel);
                System.out.println(person.getFirstName()+ " "+person.getLastName()+" "
                        +person.getAge()+" "+person.getPesel());}
                else {
                System.err.println("Dane były niepoprawne nie utworzono nowej osoby!");
            }

        }

        public static boolean correctData(String pFirstName,String pLastName, String pAge)
                throws NameUndefinedException, IncorrectAgeException{
        boolean data=true;
                if (pFirstName == null || pLastName == null || pFirstName.length() < 2 || pLastName.length() < 2){
                    data = false;
                    throw new NameUndefinedException();
                }
                if (pAge.equals("0")) {
                    data = false;
                    throw new IncorrectAgeException();
                }
        return data;}

}

