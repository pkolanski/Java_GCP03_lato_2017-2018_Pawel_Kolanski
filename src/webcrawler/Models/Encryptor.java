package webcrawler.Models;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Encryptor {

    public byte[] Encrypt(String pInput) {

        byte[] encrypted = new byte[0];
        try {

            KeyGenerator keygenerator = KeyGenerator.getInstance("Blowfish");

            SecretKey secretkey = keygenerator.generateKey();

            Cipher cipher = Cipher.getInstance("Blowfish");

            cipher.init(Cipher.ENCRYPT_MODE, secretkey);

            String inputText = pInput;

            encrypted = cipher.doFinal(inputText.getBytes());

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return encrypted;
    }
}
