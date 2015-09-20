package is.ru.honn.rufan.domain;


public class Country {
    protected int countryId;
    protected String name;
    protected String abbreviation;

    /**
     * Empty Country Constructor
     */
    public Country() {
    }

    /**
     *
     * @return countryId
     */
    public int getCountryId() {
        return countryId;
    }

    /**
     * Sets the country id
     * @param countryId integer
     */
    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    /**
     * Gets the name of country
     * @return name of country
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of country
     * @param name name of country
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets contry abbreviation
     * @return Contry abbreviation
     */
    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * Sets country abbreviation
     * @param abbreviation abbreviaiton of country
     */
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
