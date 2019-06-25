package com.mycloud.auth.redis;

/**
 * @Author: hwz
 * @Date: 2018/6/7
 */
public class RedisKey {

    // redis jwttoken userId  key 前缀
    public static final String JWT_TOKEN_USER_ID_KEY = "JwtTokenUserIdKey:";

    // 最大房间数
    public static final String HOTEL_MAX_ROOM_KEY = "max_room";
    // 已预订数
    public static final String HOTEL_BOOK_ROOM_KEY = "book_room";

    public static final String COMPETITION_CLICK_COUNT = "competition_click_count";

    //上级组织的key
    public static final String GROUP_UP_KEY = "group:up:";

    //一级上级组织的key
    public static final String GROUP_FIRST_UP_KEY = "group:first:up:";

    //下级组织的key
    public static final String GROUP_DOWN_KEY = "group:down:";

    //一级下级组织的key
    public static final String GROUP_FIRST_DOWN_KEY = "group:first:down:";

}
