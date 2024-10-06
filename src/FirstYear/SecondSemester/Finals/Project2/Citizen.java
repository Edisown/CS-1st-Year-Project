package FirstYear.SecondSemester.Finals.Project2;

/**
 * Reference class that represents a citizen.
 * @author Oliver Yu
 */
public class Citizen implements Comparable<Citizen>{
    private String fullName;
    private String email;
    private String address;
    private int age;
    private boolean resident;
    private int district;
    private char gender;

    /**
     * Constructs a citizen object with given details.
     * @param fullName Full name of the citizen (first name, followed by the last name).
     * @param email Email address of the citizen.
     * @param address Address of the citizen.
     * @param age Age of the citizen.
     * @param resident Residency status of the citizen.
     * @param district District number of the citizen.
     * @param gender Gender of the citizen.
     */
    public Citizen(String fullName, String email, String address, int age, boolean resident, int district, char gender) {
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.age = age;
        this.resident = resident;
        this.district = district;
        this.gender = gender;
    }

    /**
     * Gets the full name of the citizen.
     * @return The full name of the citizen.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the full name of the citizen.
     * @param fullName The full name of the citizen to set.
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Gets the email of the citizen.
     * @return The email of the citizen.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the citizen.
     * @param email The email of the citizen to be set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the address of the citizen.
     * @return The address of the citizen.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the citizen.
     * @param address The address of the citizen to be set.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the age of the citizen.
     * @return The age of the citizen.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the citizen.
     * @param age The age of the citizen to be set.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the residency status of the citizen.
     * @return True if the citizen is a resident. Otherwise, false.
     */
    public boolean isResident() {
        return resident;
    }

    /**
     * Sets the residency status of the citizen.
     * @param resident The residency status of the citizen to be set.
     */
    public void setResident(boolean resident) {
        this.resident = resident;
    }

    /**
     * Gets the district number of the citizen.
     * @return The district number of the citizen.
     */
    public int getDistrict() {
        return district;
    }

    /**
     * Sets the district number of the citizen.
     * @param district The district number of the citizen to be set.
     */
    public void setDistrict(int district) {
        this.district = district;
    }

    /**
     * Gets the gender of the citizen.
     * @return The gender of the citizen.
     */
    public char getGender() {
        return gender;
    }

    /**
     * Sets the gender of the citizen.
     * @param gender The gender of the citizen to be set.
     */
    public void setGender(char gender) {
        this.gender = gender;
    }

    /**
     * Returns a formatted string representation of the data of the citizen.
     * @return data of the citizen.
     */
    public String toString() {
        return String.format("%-30s%-75s%-50s%10d%15s%10d%10s%n", fullName, email, address, age, resident, district, gender);
    }

    @Override
    public boolean equals(Object object){
        if (object instanceof Citizen){
            return fullName.compareTo(((Citizen) object).getFullName()) == 0;
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Citizen o) {
        return this.fullName.compareTo(o.fullName);
    }
}
