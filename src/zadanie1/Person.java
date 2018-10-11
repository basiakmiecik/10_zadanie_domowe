package zadanie1;

public class Person{
    private String firstName;
    private String lastName;
    private String age;
    private String pesel;

    public Person() {
    }

    public Person(String firstName, String lastName, String age, String pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.pesel = pesel;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws NameUndefinedException{
        if(firstName.length()<=2 || firstName==null)
            throw new NameUndefinedException();
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws NameUndefinedException{
        if(lastName.length()<=2 || lastName==null)
            throw new NameUndefinedException();
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age)throws IncorrectAgeException {
        if(age.equals("0"))
            throw new IncorrectAgeException();
        this.age = age;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
}
