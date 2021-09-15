package top.parak.Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author KHighness
 * @since 2020-12-02
 * @apiNote 535. TinyURL 的加密与解密
 */
public class T535 {

    private Map<String, String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map.put(String.valueOf(longUrl.hashCode()), longUrl);
        return String.valueOf(longUrl.hashCode());
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }

}
