package universidad.pmd.pmd_grupo14.util;

import androidx.annotation.RequiresApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.ByteArrayOutputStream;

public class Utils {
    @RequiresApi(api = Build.VERSION_CODES.FROYO)
    public static Bitmap base64StringToImg(String input)
    {
        try {
            byte[] decodedBytes = Base64.decode(input, Base64.NO_WRAP);
            return BitmapFactory.decodeByteArray(decodedBytes, 0,
                    decodedBytes.length);
        } catch(Exception e) {
            e.getMessage();
            return null;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.FROYO)
    public static String imgToBase64String(Bitmap image)
    {
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.PNG;
        int quality = 100;
        ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream();
        image.compress(compressFormat, quality, byteArrayOS);
        return Base64.encodeToString(byteArrayOS.toByteArray(), Base64.NO_WRAP);
    }
}
