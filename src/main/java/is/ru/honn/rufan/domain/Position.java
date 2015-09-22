package is.ru.honn.rufan.domain;

public class Position {
    protected int positionId;
    protected String name;
    protected String abbreviation;
    protected int sequence;

    /**
     * Constructor that takes in all variables
     * @param positionId id of the position
     * @param name name of position
     * @param abbreviation abbreviation of a position
     * @param sequence sequence of a position
     */
    public Position(int positionId, String name, String abbreviation, int sequence) {
        this.positionId = positionId;
        this.name = name;
        this.abbreviation = abbreviation;
        this.sequence = sequence;
    }

    /**
     * Gets position id
     * @return id of position
     */
    public int getPositionId() {
        return positionId;
    }

    /**
     * Sets position id
     * @param positionId id of position
     */
    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    /**
     * Gets name of position
     * @return positions name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets position name
     * @param name name of position
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets abbreviation of position
     * @return position abbreviation
     */
    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * Sets abbreviation of position
     * @param abbreviation position abbreviation
     */
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    /**
     * Gets position sequence
     * @return positions sequence
     */
    public int getSequence() {
        return sequence;
    }

    /**
     * Sets sequence of position
     * @param sequence position sequence
     */
    public void setSequence(int sequence) {
        this.sequence = sequence;
    }
}


