package com.joe.beginzero.strings.countwords;

import java.util.HashMap;
import java.util.Map;

/**
 * 535. TinyURL 的加密与解密
 *
 * @author ckh
 * @create 8/28/20 8:37 AM
 */
public class Codec {

    Map<Integer, String> map1 = new HashMap<>(16);
    Map<String, String> map2 = new HashMap<>(16);

    /**
     * Encodes a URL to a shortened URL.
     *
     * @param longUrl long url
     * @return short url
     */
    public String encode1(String longUrl) {
        map1.put(longUrl.hashCode(), longUrl);
        return "http://tinyurl.com/" + longUrl.hashCode();
    }

    /**
     * Decodes a shortened URL to its original URL.
     *
     * @param shortUrl short url
     * @return long url
     */
    public String decode1(String shortUrl) {
        return map1.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
    }

    public String encode2(String longUrl) {

        String target = String.valueOf(longUrl.hashCode());
        map2.put(target, longUrl);
        return target;
    }
    public String decode2(String shortUrl) {
        return map2.get(shortUrl);
    }
}
