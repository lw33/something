package lw.learn.lc.design;

import java.util.HashMap;

/**
 * @Author lw
 * @Date 2019-03-08 13:40:45
 **/
public class P535_EncodeAndDecodeTinyURL {

    public class Codec {

        private final String PREFIX = "http://tinyurl.com/";
        private final HashMap<Integer, String> index2url = new HashMap<>();
        private int id = 0;

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            index2url.put(id, longUrl);
            return PREFIX + id++;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            int id = Integer.parseInt(shortUrl.substring(shortUrl.lastIndexOf("/")));
            return index2url.get(id);
        }
    }
}
