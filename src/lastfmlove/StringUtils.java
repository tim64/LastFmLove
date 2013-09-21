/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lastfmlove;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharacterCodingException;

/**
 *
 * @author Тим
 */
public class StringUtils {
  
  public static boolean isPureAscii(String v) {
    byte bytearray []  = v.getBytes();
    CharsetDecoder d = Charset.forName("US-ASCII").newDecoder();
    try {
      CharBuffer r = d.decode(ByteBuffer.wrap(bytearray));
      r.toString();
    }
    catch(CharacterCodingException e) {
      return false;
    }
    return true;
  }
}
