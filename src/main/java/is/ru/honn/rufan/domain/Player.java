package is.ru.honn.rufan.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Player {
    protected int playerId;
    protected String firstName;
    protected String lastName;
    protected int height;
    protected int weight;
    protected Date birthDate;
    protected Country nationality;
    protected int teamId;
    protected List<Position> positions = new ArrayList<Position>();

    /**
     * Empty default constructor
     */
    public Player() {
    }

    /**
     * Create new player with all the variables
     * @param playerId Id of the player
     * @param firstName First name of the player
     * @param lastName Last name of the player
     * @param teamId Team Id of the player
     */
    public Player(int playerId, String firstName, String lastName, int teamId) {
        this.playerId = playerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.teamId = teamId;
    }

    /**
     * Gets Player Id
     * @return player Id
     */
    public int getPlayerId() {
        return playerId;
    }

    /**
     * Sets player id
     * @param playerId Id of the player
     */
    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    /**
     * Gets the player name
     * @return name of player
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of player
     * @param firstName first name of player
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of player
     * @return Gets the last name of the player
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of player
     * @param lastName last name of player
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the height of player
     * @return the height of player
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets the height of player
     * @param height height of player
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Gets the Weight of the player
     * @return the weight of player
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Sets the weight of player
     * @param weight the weight of player
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Gets the birthdate of player
     * @return players birthdate
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the birthDate of player
     * @param birthDate birthdate of player
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Gets the nationality of a player
     * @return players nationality
     */
    public Country getNationality() {
        return nationality;
    }

    /**
     * Sets the nationality of a player
     * @param nationality players nationality
     */
    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    /**
     * Gets the players team id
     * @return players team id
     */
    public int getTeamId() {
        return teamId;
    }

    /**
     * Sets players team id
     * @param teamId players team id
     */
    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    /**
     * Gets all position that player can play
     * @return List of players postition
     */
    public List<Position> getPositions() {
        return positions;
    }

    /**
     * Set players postiions
     * @param positions list of postitions that player can play
     */
    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    /**
     * adds postions to players postion list
     * @param p postition that player can play
     */
    public void addPosition(Position p) {
        this.positions.add(p);
    }

    /**
     * Prints put player
     * @return string that can be printed
     */
    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", birthDate=" + birthDate +
                ", nationality=" + nationality +
                ", teamId=" + teamId +
                ", positions=" + positions +
                '}';
    }
}
