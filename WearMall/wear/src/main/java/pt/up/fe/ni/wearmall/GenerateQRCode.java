package pt.up.fe.ni.wearmall;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.jwetherell.quick_response_code.data.Contents;
import com.jwetherell.quick_response_code.qrcode.QRCodeEncoder;

public class GenerateQRCode {
    private String id_Produto;
    private String percentagem;
    private String id_User;
    private String empresa;
    Bitmap code;

    public GenerateQRCode(String id_p, String percnt, String id_usr, String empr)
    {
        id_Produto = id_p;
        percentagem = percnt;
        id_User = id_usr;
        empresa = empr;
        QRCodeEncoder qrCodeEncoder = new QRCodeEncoder(id_Produto + " " + percentagem + " " + id_User + " " + empresa,
                null,
                Contents.Type.TEXT,
                BarcodeFormat.QR_CODE.toString(),
                250);
        try {
            code = qrCodeEncoder.encodeAsBitmap();
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }

    public Bitmap getCode()
    {
        return code;
    }
}