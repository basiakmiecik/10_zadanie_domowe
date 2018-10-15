package zadanie1;

public class Person{
    private String firstName;
    private String lastName;
    private String age;
    private String pesel;

    public Person() {
    }

    public Person(String firstName, String lastName, String age, String pesel)
            throws IncorrectAgeException,NameUndefinedException{
        if (firstName == null || lastName == null || firstName.length() < 2 || lastName.length() < 2)
            throw new NameUndefinedException();
        else{
            this.firstName = firstName;
            this.lastName = lastName;}
        if (age.equals("0")||age.equals(""))
            throw new IncorrectAgeException();
        else
            this.age = age;
        this.pesel = pesel;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
}
