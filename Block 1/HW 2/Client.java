public class Client 
{
    private String firstName;
    private String lastName;

    public Client(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Client()
    {
        this.firstName = "John";
        this.lastName = "Doe";
    }


    public String getFirstName()
    {
        return this.firstName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public void setFirstName(String newFirstName)
    {
        this.firstName = newFirstName;
    }

    public void setLastName(String newLastName)
    {
        this.lastName = newLastName;
    }
}
