package FirstYear.SecondSemester.Finals.Project2;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

/**
 * Interface defining operations related to sorting and analyzing citizens' data.
 */
public interface CitizenDataManager {

    /**
     * Reads the citizens' data from a file.
     *
     * @throws FileNotFoundException if the file containing citizens' data is not found
     */
    void readCitizens() throws FileNotFoundException;




    /**
     * Searches for citizens by name.
     *
     * @param name the name to search for
     * @return a list of citizens matching the given name
     * @throws IllegalArgumentException if the provided name is invalid
     */
    List<Citizen> searchCitizen(String name) throws IllegalArgumentException;




    /**
     * Retrieves the average age of citizens per district.
     *
     * @return a map containing the district number as key and the average age as value
     */
    Map<Integer, Integer> getAverageAgeOfCitizensPerDistrict(); // initialize to this -> new HashMap<>(20);

    /**
     * Retrieves the proportion of genders per district.
     *
     * @return a map containing the district number as key and an array of proportions as value
     *     <p> The array contains:
     *     <ul>
     *         <li>Men count in the district
     *         <li>Women count in the district
     *         <li>Percentage of Men in the district
     *         <li>Percentage of Women in the district
     *     </ul>
     */
    Map<Integer, Double[]> getProportionOfGendersPerDistrict(); // initialize to this -> new HashMap<>(20);




    /**
     * Retrieves the number of citizens per district.
     *
     * @return a map containing the district number as key and the count of citizens as value
     */
    Map<Integer, Integer> getCitizensPerDistrict(); // initialize to this -> new HashMap<>(20);




    /**
     * Retrieves the proportion of non-residents and residents per district.
     *
     * @return a map containing the district number as key and an array of proportions as value
     *     <p> The array contains:
     *     <ul>
     *         <li>Resident count in the district
     *         <li>Non-resident count in the district
     *         <li>Percentage of Residents in the district
     *         <li>Percentage of Non-residents in the district
     *     </ul>
     */
    Map<Integer, Double[]> getProportionOfNonResidentAndResidentPerDistrict(); // initialize to this -> new HashMap<>(20);




    /**
     * Retrieves the number of emails per domain in decreasing order.
     *
     * @return a map containing the domain as key and the count of emails as value, sorted in decreasing order of count
     */
    Map<String, Integer> getNumberOfEmailsPerDomain(); // // initialize to this -> new TreeMap<>(6);

}
