public class Lawyer 
{
    private String firstName;
    private String lastName;
    private Plan plan;
    private License license;

    public Lawyer(String firstName, String lastName, Plan plan, License license)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.plan = plan;
        this.license = license;
    }

    public Lawyer(Plan plan, License license)
    {
        this.firstName = "John";
        this.lastName = "Doe";
        this.plan = plan;
        this.license = license;
    }

    
    public String getFirstName()
    {
        return this.firstName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public Plan getPlan()
    {
        return this.plan;
    }

    public License getLicense()
    {
        return this.license;
    }

    public void setFirstName(String newFirstName)
    {
        this.firstName = newFirstName;
    }

    public void setLastName(String newLastName)
    {
        this.lastName = newLastName;
    }

    public void setPlan(Plan newPlan)
    {
        this.plan = newPlan;
    }

    public void setLicense(License newLicense)
    {
        this.license = newLicense;
    }
}
