package backjoonHasing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha256 {

	 /**
     * SHA-256으로 해싱하는 메소드
     * 
     * @param bytes
     * @return
     * @throws NoSuchAlgorithmException 
     */
    public static String sha256(String msg) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(msg.getBytes());
        
        return bytesToHex(md.digest());
    }
   
    /**
     * 바이트를 헥스값으로 변환한다.
     * 
     * @param bytes
     * @return
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b: bytes) {
          builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
    
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
		System.out.println(sha256(new BufferedReader(new InputStreamReader(System.in)).readLine()));
	}//main() end
}
