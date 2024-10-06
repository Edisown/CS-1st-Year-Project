package FirstYear.SecondSemester.Finals.Project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class MyProgramUtility implements CitizenDataManager {

    private static final List<Citizen> citizens = new ArrayList<>(600);


    public MyProgramUtility() throws FileNotFoundException {
        readCitizens();
    }

    public List<Citizen> getCitizens() {
        return citizens;
    }

    @Override
    public void readCitizens() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("res/data.csv"));

        while (scanner.hasNext()) {
            //split ignoring commas inside double quotation marks
            String[] parser = scanner.nextLine().split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

            //create new FirstYear.SecondSemester.Finals.Project2.Citizen
            Citizen citizen = new Citizen(
                    parser[0] + " " + parser[1],
                    parser[2],
                    parser[3].replaceAll("\"", ""),
                    Integer.parseInt(parser[4]),
                    parser[5].equals("Resident"),
                    Integer.parseInt(parser[6]),
                    parser[7].charAt(0));
            citizens.add(citizen);
        }
    }




    /**
     * A method that searches for FirstYear.SecondSemester.Finals.Project2.Citizen object with a full name contained by the provided "name".
     *
     * @param name The name to search for within the full name of the FirstYear.SecondSemester.Finals.Project2.Citizen object
     * @return a list of FirstYear.SecondSemester.Finals.Project2.Citizen objects whose full names contain char values of the provided name.
     * @author Edison Malasan
     */
    @Override
    public List<Citizen> searchCitizen(String name) throws IllegalArgumentException {
        // check if the provided name is null or empty
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("The provided name is empty");
        }

        return citizens.stream()
                .filter(c -> {
                    String[] fullNameParts = c.getFullName().split(" ");
                    return fullNameParts.length >= 2 &&
                            (((fullNameParts[0] + " " + fullNameParts[1]).toLowerCase().startsWith(name.strip())) ||
                                    fullNameParts[0].toLowerCase().startsWith(name.strip()) ||
                                    fullNameParts[1].toLowerCase().startsWith(name.strip()));
                })
                .collect(Collectors.toList());

    }




    /**
     * Returns a Map of Integer keys and Integer values where:
     * Integer keys correspond to the district number; and
     * Integer values correspond to the average age of citizens of that district.
     *
     * @return Map of average age of citizens per district.
     * @author Oliver Yu
     */
    @Override
    public Map<Integer, Integer> getAverageAgeOfCitizensPerDistrict() {
        Map<Integer, Integer> averageAgePerDistrict = new HashMap<>(20);

        //citizen counter per district.
        int citiCounter = 0;
        //average age per district.
        int average = 0;

        for (int district = 1; district <= 20; district++) {
            for (Citizen citizen : citizens) {
                if (citizen.getDistrict() == district) {
                    //get sum of citizen in a district first
                    average = average + citizen.getAge();
                    citiCounter++;
                }
            }
            //calculate average by dividing sum of citizen age in a district by number of citizens in a district.
            average = Math.round((float) average /citiCounter);
            //put to averageAgePerDistrict map.
            averageAgePerDistrict.put(district, average);

            //reset values of citiCounter and average to 0 to prepare for next district.
            citiCounter = 0;
            average = 0;
        }
        return averageAgePerDistrict;
    }


    /**
     * Returns a map where each key is a district number [Integer] and the associated value is
     * the average age of citizens residing in that district [Integer].
     *
     * @return A map containing the proportion of genders per district.
     * @author Edison Malasan
     */
    @Override
    public Map<Integer, Double[]> getProportionOfGendersPerDistrict() {
        Map<Integer, Double[]> proportionOfGenderPerDistrict = new HashMap<>(20);

        for (Citizen citizen : citizens) {
            int district = citizen.getDistrict();
            char gender = citizen.getGender();

            // Get the current count array for the district
            Double[] count = proportionOfGenderPerDistrict.getOrDefault(district, new Double[]{0.0, 0.0, 0.0, 0.0});

            // Increment based on the gender and residency of the citizen
            if (gender == 'M') {
                count[0]++; // Male count
            } else if (gender == 'F') {
                count[1]++; // Female count
            }

            proportionOfGenderPerDistrict.put(district, count);
        }

        // Calculate percentages
        proportionOfGenderPerDistrict.forEach((district, count) -> {
            double totalCitizens = count[0] + count[1]; // Total residents count

            count[2] = count[0] / totalCitizens * 100; // Percentage of residents
            count[3] = count[1] / totalCitizens * 100; // Percentage of non-residents

            proportionOfGenderPerDistrict.put(district, count);
        });

        return proportionOfGenderPerDistrict;
    }



    /*
     * Will Fix Tonight Wait Lang
     * */

    @Override
    public Map<Integer, Integer> getCitizensPerDistrict() {
        Map<Integer, Integer> citizensPerDistrict = new HashMap<>();
        for (Citizen citizen : citizens) {
            int districtNumber = citizen.getDistrict();
            citizensPerDistrict.put(districtNumber, citizensPerDistrict.getOrDefault(districtNumber, 0) + 1);
        }
        return citizensPerDistrict;
    }

    /**
     * Retrieves the proportion of residents and non-residents per district.
     * This method calculates the proportion of residents and non-residents in eacj district
     * and returns the result as a map. The keys of the map represent district numbers,
     * and the values represent arrays containing the counts of residents and non-residents
     * respectively.
     *
     * @return A map containing the proportion of residents and non-residents per district.
     *         The keys represent district numbers, and the values represent arrays where:
     *         - Index 0: count of residents
     *         - Index 1: count of non-residents
     * @author [Martin, Michael John Jr S]
     */
    @Override
    public Map<Integer, Double[]> getProportionOfNonResidentAndResidentPerDistrict() {
        // Initialize a map to store the proportion of residents and non-residents per district
        Map<Integer, Double[]> proportionMap = new HashMap<>();

        // Iterate over each district
        for (int district = 1; district <= 20; district++) {
            int residentCount = 0;
            int nonResidentCount = 0;

            // Count residents and non-residents in the current district
            for (Citizen citizen : citizens) {
                if (citizen.getDistrict() == district) {
                    if (citizen.isResident()) {
                        residentCount++;
                    } else {
                        nonResidentCount++;
                    }
                }
            }

            // Calculate proportions and store them in an array
            int totalCitizens = residentCount + nonResidentCount;
            double residentPercentage = (double) residentCount / totalCitizens * 100;
            double nonResidentPercentage = (double) nonResidentCount / totalCitizens * 100;
            Double[] proportions = { (double) residentCount, (double) nonResidentCount, residentPercentage, nonResidentPercentage };

            proportionMap.put(district, proportions);
        }

        return proportionMap;
    }



    /**
     * Retrieves the number of emails per domain in decreasing order.
     * This method counts the number of emails per domain for all citizens and returns
     * the result as a map of email counts. The keys of the
     * map represent domain names, and the values represent the count of emails for
     * each domain.
     *
     * @return A map containing the count of emails per domain in decreasing order.
     * @author Paul Pajara
     */
    @Override
    public Map<String, Integer> getNumberOfEmailsPerDomain() {
        // Initialize HashMap to store domain counts
        Map<String, Integer> domainCount = new HashMap<>();

        // Count emails per domain
        for (Citizen citizen : citizens) {
            String email = citizen.getEmail();
            String[] parts = email.split("@");
            String end = parts[1];
            String[] parts1 = end.split("\\.");
            String domain = parts1[1];

            domainCount.put(domain, domainCount.getOrDefault(domain, 0) + 1);
        }

        return domainCount;
    }


    public Citizen getCitizenByName(String fullName) {
        return citizens.stream().filter(c -> c.getFullName().equalsIgnoreCase(fullName))
                .findFirst().orElse(null);
    }




}
