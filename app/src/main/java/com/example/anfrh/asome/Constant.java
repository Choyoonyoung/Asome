package com.example.anfrh.asome;

public class Constant {
    public static final String SOCKET_URL = "ws://45.32.55.218:8083/websocket/?request=";
    public static final int SELECT_PHOTO = 1;

    //일반 상수
    public static final String TAG_ACTION = "action";
    public static final String TAG_USER_TYPE = "user_type";
    public static final String TAG_MESSAGE_NO = "message_no";
    public static final String TAG_TIMESTAMP = "timestamp";
    public static final String TAG_ROOM_NO = "room_no";
    public static final String TAG_USER_NO = "user_no";
    public static final String TAG_MESSAGE = "message";
    public static final String TAG_CUSTOMER = "customer";
    public static final String TAG_IMG_MINE = "img_mine";
    public static final String TAG_READ = "read";
    public static final String TAG_UNREAD = "unread";

    //액션을 나타내는 상수
    public static final String ACTION_CONNECTED = "connected";
    public static final String ACTION_RECONNECTED = "reconnected";
    public static final String ACTION_RECEIVED = "received";
    public static final String ACTION_TEXT = "text";
    public static final String ACTION_MAP = "map";
    public static final String ACTION_IMG = "img";
    public static final String ACTION_TEMP_DISCONNECTED = "temp_disconnected";


    //쪽지 관련 URL
    public static final String INSERT_MSG_CONTENT = "http://www.giljabee.com/api/android_api/message/INSERT/msg_content.php";
    public static final String INSERT_MSG_ROOM = "http://www.giljabee.com/api/android_api/message/INSERT/msg_room.php";
    public static final String GET_MSG_CONTENT = "http://www.giljabee.com/api/android_api/message/GET/msg_content.php";//미완
    public static final String GET_MSG_ROOM = "http://www.giljabee.com/api/android_api/message/GET/msg_room.php";
    public static final String UPDATE_MSG_READ_URL = "http://www.giljabee.com/api/android_api/message/UPDATE/msg_read.php";//미완
    public static final String DELETE_MSG_ROOM_URL = "http://www.giljabee.com/api/android_api/message/DELETE/msg_room.php";//미완

    //채팅방 관련 URL
    public static final String INSERT_CHAT_ROOM_URL = "http://www.giljabee.com/api/android_api/management/INSERT/room.php";
    public static final String GET_CHAT_ROOM_URL = "http://www.giljabee.com/api/android_api/management/GET/room.php";
    public static final String DELETE_CHAT_ROOM_URL = "http://www.giljabee.com/api/android_api/management/DELETE/room.php";

    //유실 패킷 관련 URL
    public static final String GET_CHATTING_LOST_PACKET_URL = "http://www.giljabee.com/api/android_api/chatting/GET/lost_packet.php";

    //채팅 이미지 업로드 관련 URL
    public static final String IMAGE_BASE_URL = "http://www.giljabee.com/image/chatting_image/";//채팅으로 보낸 이미지를 업로드할 폴더
    public static final String IMAGE_UPLOAD_URL = "http://www.giljabee.com/api/android_api/chatting/chatting_image_upload.php";

    //채팅 맵 관련 URL
    public static final String INSERT_LOCATION_URL = "http://www.giljabee.com/api/android_api/chatting/INSERT/location.php";


    //프로필 관련 URL
    public static final String PROFILE_IMG_URL = "http://www.giljabee.com/image/profile_image/";
    public static final String GET_PROFILE_THUMBNAIL_IMG_URL = "http://www.giljabee.com/image/profile_thumbnail_image/";


    public static final String GET_SCHEDULE_URL = "http://www.giljabee.com/api/api_android_chat/getScheduleList.php";
    public static final String INSERT_BUY_PRODUCT_URL = "http://www.giljabee.com/api/android_api/product/INSERT/buy_product.php";
    public static final String GET_PRODUCT_IMAGE_URL = "http://www.giljabee.com/image/product_image/";
    public static final String INSERT_SCHEDULE_IMAGE_URL = "http://www.giljabee.com/image/schedule_image/";


    /**
     * 작성자 정동훈 작업일자 17-12-23 PM 03:03
     * 로그인, 회원가입, 카카오페이, 사용자 프로필 수정 및 조회 URL 정보 가 밑에 리스트로 있습니다.
     */

    public static final String INSERT_USER_ETC_INFO_URL = "http://www.giljabee.com/api/android_api/join/UPDATE/ETC_info_user_join.php";
    public static final String INSERT_USER_INFO_URL = "http://www.giljabee.com/api/android_api/join/INSERT/default_info_user_join.php";
    public static final String GET_LOGIN_GILJABEE_INFO_CHECK_URL = "http://www.giljabee.com/api/android_api/login/GET/giljabee_login.php";
    public static final String GET_LOGIN_API_INFO_CHECK_URL = "http://www.giljabee.com/api/android_api/login/GET/api_login.php";
    public static final String GET_GUIDE_PROFILE_URL = "http://www.giljabee.com//api/android_api/profile/GET/get_guide_profile.php";
    public static final String DELETE_USER_URL = "http://www.giljabee.com/api/android_api/profile/DELETE/user_delete.php";
    public static final String UPDATE_USER_INFO_URL = "http://www.giljabee.com/api/android_api/profile/UPDATE/user_update.php";

    public static final String DELETE_UPDATE_USER_LOGOUT_URL = "http://www.giljabee.com/api/android_api/login/DELETE/user_logout.php";
    public static final String INSERT_USER_PROFILE_IMAGE_URL = "http://www.giljabee.com/api/android_api/join/INSERT/join_upload_profile.php";
    public static final String GET_EMAIL_VALIDATE_URL = "http://www.giljabee.com/api/android_api/login/GET/email_validate_check.php";



    public static final String GET_SERVER_ROOT_API_URL = "http://www.giljabee.com/api/";


}
