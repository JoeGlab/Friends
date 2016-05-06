package net.yoogloo.friends;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by PhotoJoe on 5/4/2016.
 */
public class FriendsContract {
    interface FriendsColumns {
        String FRIENDS_ID = " id";
        String FRIENDS_NAME = "friends_name";
        String FRIENDS_EMAIL = "friends_email";
        String FRIENDS_PHONE = "friends_phone";
    }

    public static final String CONTENT_AUTHORITY = "net.yoogloo.friends.provider";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    private static final String PATH_FRIENDS = "friends";
    public static final Uri URI_TABLE = Uri.parse(BASE_CONTENT_URI.toString() + "/" + PATH_FRIENDS);

    public static final String[] TOP_LEVEL_PATHS = {
            PATH_FRIENDS
    };

    public static class Friends implements  FriendsColumns, BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendEncodedPath(PATH_FRIENDS).build();

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd." + CONTENT_AUTHORITY + ".friends";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd." + CONTENT_AUTHORITY + ".friends";

        public static Uri buildFriendUri(String friendsId) {
            return CONTENT_URI.buildUpon().appendEncodedPath(friendsId).build();
        }

        public static String getFriendId(Uri uri) {
            return uri.getPathSegments().get(1);
        }

    }

}
