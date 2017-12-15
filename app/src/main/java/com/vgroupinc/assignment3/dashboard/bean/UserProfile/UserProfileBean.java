package com.vgroupinc.assignment3.dashboard.bean.UserProfile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserProfileBean {

    @SerializedName("person")
    @Expose
    private Person person;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("followers")
    @Expose
    private Integer followers;
    @SerializedName("followees")
    @Expose
    private Integer followees;
    @SerializedName("fbUser")
    @Expose
    private FbUser fbUser;
    @SerializedName("twitterUser")
    @Expose
    private TwitterUser twitterUser;
    @SerializedName("twitchUser")
    @Expose
    private Object twitchUser;
    @SerializedName("googleUser")
    @Expose
    private Object googleUser;
    @SerializedName("subscription")
    @Expose
    private Subscription subscription;
    @SerializedName("stripeConnected")
    @Expose
    private Boolean stripeConnected;
    @SerializedName("settings")
    @Expose
    private List<Setting> settings = null;
    @SerializedName("accolades")
    @Expose
    private List<Accolade> accolades = null;
    @SerializedName("previousTournaments")
    @Expose
    private List<String> previousTournaments = null;
    @SerializedName("teams")
    @Expose
    private List<String> teams = null;
    @SerializedName("twitterLink")
    @Expose
    private String twitterLink;
    @SerializedName("twitchLink")
    @Expose
    private Object twitchLink;

    /**
     * No args constructor for use in serialization
     */
    public UserProfileBean() {
    }

    /**
     * @param followees
     * @param person
     * @param settings
     * @param stripeConnected
     * @param accolades
     * @param teams
     * @param followers
     * @param twitterUser
     * @param twitchUser
     * @param subscription
     * @param email
     * @param googleUser
     * @param twitterLink
     * @param twitchLink
     * @param previousTournaments
     * @param fbUser
     */
    public UserProfileBean(Person person, String email, Integer followers, Integer followees, FbUser fbUser, TwitterUser twitterUser, Object twitchUser, Object googleUser, Subscription subscription, Boolean stripeConnected, List<Setting> settings, List<Accolade> accolades, List<String> previousTournaments, List<String> teams, String twitterLink, Object twitchLink) {
        super();
        this.person = person;
        this.email = email;
        this.followers = followers;
        this.followees = followees;
        this.fbUser = fbUser;
        this.twitterUser = twitterUser;
        this.twitchUser = twitchUser;
        this.googleUser = googleUser;
        this.subscription = subscription;
        this.stripeConnected = stripeConnected;
        this.settings = settings;
        this.accolades = accolades;
        this.previousTournaments = previousTournaments;
        this.teams = teams;
        this.twitterLink = twitterLink;
        this.twitchLink = twitchLink;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public UserProfileBean withPerson(Person person) {
        this.person = person;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserProfileBean withEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getFollowers() {
        return followers;
    }

    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    public UserProfileBean withFollowers(Integer followers) {
        this.followers = followers;
        return this;
    }

    public Integer getFollowees() {
        return followees;
    }

    public void setFollowees(Integer followees) {
        this.followees = followees;
    }

    public UserProfileBean withFollowees(Integer followees) {
        this.followees = followees;
        return this;
    }

    public FbUser getFbUser() {
        return fbUser;
    }

    public void setFbUser(FbUser fbUser) {
        this.fbUser = fbUser;
    }

    public UserProfileBean withFbUser(FbUser fbUser) {
        this.fbUser = fbUser;
        return this;
    }

    public TwitterUser getTwitterUser() {
        return twitterUser;
    }

    public void setTwitterUser(TwitterUser twitterUser) {
        this.twitterUser = twitterUser;
    }

    public UserProfileBean withTwitterUser(TwitterUser twitterUser) {
        this.twitterUser = twitterUser;
        return this;
    }

    public Object getTwitchUser() {
        return twitchUser;
    }

    public void setTwitchUser(Object twitchUser) {
        this.twitchUser = twitchUser;
    }

    public UserProfileBean withTwitchUser(Object twitchUser) {
        this.twitchUser = twitchUser;
        return this;
    }

    public Object getGoogleUser() {
        return googleUser;
    }

    public void setGoogleUser(Object googleUser) {
        this.googleUser = googleUser;
    }

    public UserProfileBean withGoogleUser(Object googleUser) {
        this.googleUser = googleUser;
        return this;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public UserProfileBean withSubscription(Subscription subscription) {
        this.subscription = subscription;
        return this;
    }

    public Boolean getStripeConnected() {
        return stripeConnected;
    }

    public void setStripeConnected(Boolean stripeConnected) {
        this.stripeConnected = stripeConnected;
    }

    public UserProfileBean withStripeConnected(Boolean stripeConnected) {
        this.stripeConnected = stripeConnected;
        return this;
    }

    public List<Setting> getSettings() {
        return settings;
    }

    public void setSettings(List<Setting> settings) {
        this.settings = settings;
    }

    public UserProfileBean withSettings(List<Setting> settings) {
        this.settings = settings;
        return this;
    }

    public List<Accolade> getAccolades() {
        return accolades;
    }

    public void setAccolades(List<Accolade> accolades) {
        this.accolades = accolades;
    }

    public UserProfileBean withAccolades(List<Accolade> accolades) {
        this.accolades = accolades;
        return this;
    }

    public List<String> getPreviousTournaments() {
        return previousTournaments;
    }

    public void setPreviousTournaments(List<String> previousTournaments) {
        this.previousTournaments = previousTournaments;
    }

    public UserProfileBean withPreviousTournaments(List<String> previousTournaments) {
        this.previousTournaments = previousTournaments;
        return this;
    }

    public List<String> getTeams() {
        return teams;
    }

    public void setTeams(List<String> teams) {
        this.teams = teams;
    }

    public UserProfileBean withTeams(List<String> teams) {
        this.teams = teams;
        return this;
    }

    public String getTwitterLink() {
        return twitterLink;
    }

    public void setTwitterLink(String twitterLink) {
        this.twitterLink = twitterLink;
    }

    public UserProfileBean withTwitterLink(String twitterLink) {
        this.twitterLink = twitterLink;
        return this;
    }

    public Object getTwitchLink() {
        return twitchLink;
    }

    public void setTwitchLink(Object twitchLink) {
        this.twitchLink = twitchLink;
    }

    public UserProfileBean withTwitchLink(Object twitchLink) {
        this.twitchLink = twitchLink;
        return this;
    }

}
