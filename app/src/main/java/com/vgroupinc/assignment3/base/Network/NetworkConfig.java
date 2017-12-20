package com.vgroupinc.assignment3.base.Network;

/**
 * Created by DELL on 12/4/2017.
 */

public class NetworkConfig {
    public static final String BASE_URL = "https://api.tournamentedition.com/tournamentapis/web/srf/services/";
    public static final String LOGIN = "network/login";
    public static final String LOGIN_PROD = "https://teapis.tournamentedition.com/tournamentapis/v1/services/network/login";
    public static final String PROFILE = "network/user/profile";
    public static final String HYPESEARCH = "hype/search";
    public static final String GETACTIVETOURNAMENT = "main/tournament/state/active/"; //+ USERID
    public static final String NOTIFICATIONLIST = "main/notifications";
    public static final String HEADER_API_VERSION = "api-version";
    public static final String HEADER_API_VERSION_VALUE = "TE_Android_";
    public static final String HEADER_AUTH = "AUTH-KEY";
    public static final String IMAGE_DOWNLOAD_URL = "https://s3.amazonaws.com/vgroup-tournament/";

}
