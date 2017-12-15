package com.vgroupinc.assignment3.dashboard.bean.UserProfile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FbUser {

    @SerializedName("recordId")
    @Expose
    private Integer recordId;
    @SerializedName("personIdref")
    @Expose
    private Integer personIdref;
    @SerializedName("id")
    @Expose
    private Object id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("middleName")
    @Expose
    private Object middleName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("timezone")
    @Expose
    private Double timezone;
    @SerializedName("bio")
    @Expose
    private Object bio;
    @SerializedName("birthday")
    @Expose
    private Object birthday;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("hometown")
    @Expose
    private String hometown;
    @SerializedName("interestedIn")
    @Expose
    private String interestedIn;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("political")
    @Expose
    private Object political;
    @SerializedName("favoriteAthletes")
    @Expose
    private String favoriteAthletes;
    @SerializedName("favoriteTeams")
    @Expose
    private String favoriteTeams;
    @SerializedName("quotes")
    @Expose
    private Object quotes;
    @SerializedName("relationshipStatus")
    @Expose
    private Object relationshipStatus;
    @SerializedName("religion")
    @Expose
    private Object religion;
    @SerializedName("imageKey")
    @Expose
    private String imageKey;
    @SerializedName("friendsCount")
    @Expose
    private Integer friendsCount;

    /**
     * No args constructor for use in serialization
     */
    public FbUser() {
    }

    /**
     * @param recordId
     * @param middleName
     * @param interestedIn
     * @param lastName
     * @param birthday
     * @param friendsCount
     * @param hometown
     * @param political
     * @param location
     * @param personIdref
     * @param relationshipStatus
     * @param religion
     * @param id
     * @param username
     * @param timezone
     * @param imageKey
     * @param quotes
     * @param bio
     * @param email
     * @param favoriteTeams
     * @param name
     * @param gender
     * @param favoriteAthletes
     * @param firstName
     */
    public FbUser(Integer recordId, Integer personIdref, Object id, String name, String firstName, Object middleName, String lastName, String gender, String username, Double timezone, Object bio, Object birthday, String email, String hometown, String interestedIn, String location, Object political, String favoriteAthletes, String favoriteTeams, Object quotes, Object relationshipStatus, Object religion, String imageKey, Integer friendsCount) {
        super();
        this.recordId = recordId;
        this.personIdref = personIdref;
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.username = username;
        this.timezone = timezone;
        this.bio = bio;
        this.birthday = birthday;
        this.email = email;
        this.hometown = hometown;
        this.interestedIn = interestedIn;
        this.location = location;
        this.political = political;
        this.favoriteAthletes = favoriteAthletes;
        this.favoriteTeams = favoriteTeams;
        this.quotes = quotes;
        this.relationshipStatus = relationshipStatus;
        this.religion = religion;
        this.imageKey = imageKey;
        this.friendsCount = friendsCount;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public FbUser withRecordId(Integer recordId) {
        this.recordId = recordId;
        return this;
    }

    public Integer getPersonIdref() {
        return personIdref;
    }

    public void setPersonIdref(Integer personIdref) {
        this.personIdref = personIdref;
    }

    public FbUser withPersonIdref(Integer personIdref) {
        this.personIdref = personIdref;
        return this;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public FbUser withId(Object id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FbUser withName(String name) {
        this.name = name;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public FbUser withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Object getMiddleName() {
        return middleName;
    }

    public void setMiddleName(Object middleName) {
        this.middleName = middleName;
    }

    public FbUser withMiddleName(Object middleName) {
        this.middleName = middleName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public FbUser withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public FbUser withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public FbUser withUsername(String username) {
        this.username = username;
        return this;
    }

    public Double getTimezone() {
        return timezone;
    }

    public void setTimezone(Double timezone) {
        this.timezone = timezone;
    }

    public FbUser withTimezone(Double timezone) {
        this.timezone = timezone;
        return this;
    }

    public Object getBio() {
        return bio;
    }

    public void setBio(Object bio) {
        this.bio = bio;
    }

    public FbUser withBio(Object bio) {
        this.bio = bio;
        return this;
    }

    public Object getBirthday() {
        return birthday;
    }

    public void setBirthday(Object birthday) {
        this.birthday = birthday;
    }

    public FbUser withBirthday(Object birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public FbUser withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public FbUser withHometown(String hometown) {
        this.hometown = hometown;
        return this;
    }

    public String getInterestedIn() {
        return interestedIn;
    }

    public void setInterestedIn(String interestedIn) {
        this.interestedIn = interestedIn;
    }

    public FbUser withInterestedIn(String interestedIn) {
        this.interestedIn = interestedIn;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public FbUser withLocation(String location) {
        this.location = location;
        return this;
    }

    public Object getPolitical() {
        return political;
    }

    public void setPolitical(Object political) {
        this.political = political;
    }

    public FbUser withPolitical(Object political) {
        this.political = political;
        return this;
    }

    public String getFavoriteAthletes() {
        return favoriteAthletes;
    }

    public void setFavoriteAthletes(String favoriteAthletes) {
        this.favoriteAthletes = favoriteAthletes;
    }

    public FbUser withFavoriteAthletes(String favoriteAthletes) {
        this.favoriteAthletes = favoriteAthletes;
        return this;
    }

    public String getFavoriteTeams() {
        return favoriteTeams;
    }

    public void setFavoriteTeams(String favoriteTeams) {
        this.favoriteTeams = favoriteTeams;
    }

    public FbUser withFavoriteTeams(String favoriteTeams) {
        this.favoriteTeams = favoriteTeams;
        return this;
    }

    public Object getQuotes() {
        return quotes;
    }

    public void setQuotes(Object quotes) {
        this.quotes = quotes;
    }

    public FbUser withQuotes(Object quotes) {
        this.quotes = quotes;
        return this;
    }

    public Object getRelationshipStatus() {
        return relationshipStatus;
    }

    public void setRelationshipStatus(Object relationshipStatus) {
        this.relationshipStatus = relationshipStatus;
    }

    public FbUser withRelationshipStatus(Object relationshipStatus) {
        this.relationshipStatus = relationshipStatus;
        return this;
    }

    public Object getReligion() {
        return religion;
    }

    public void setReligion(Object religion) {
        this.religion = religion;
    }

    public FbUser withReligion(Object religion) {
        this.religion = religion;
        return this;
    }

    public String getImageKey() {
        return imageKey;
    }

    public void setImageKey(String imageKey) {
        this.imageKey = imageKey;
    }

    public FbUser withImageKey(String imageKey) {
        this.imageKey = imageKey;
        return this;
    }

    public Integer getFriendsCount() {
        return friendsCount;
    }

    public void setFriendsCount(Integer friendsCount) {
        this.friendsCount = friendsCount;
    }

    public FbUser withFriendsCount(Integer friendsCount) {
        this.friendsCount = friendsCount;
        return this;
    }

}
