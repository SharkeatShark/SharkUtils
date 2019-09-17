package com.shark.picture;

import com.alibaba.fastjson.JSONObject;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * 二维码工具类
 *
 * @author sharkeatshark@foxmail.com
 * @create 2019-04-18-14:05
 * @projectName SharkUtils
 * @packageName com.shark.picture
 */
public class QRCodeUtil {

    /**
     * 二维码解析
     * @param QRPath    文件地址
     * @param character 字符编码
     * @return  Result
     */
    public static Result QRencrypt(String QRPath, String character) {
        return QRencrypt(new File(QRPath), character);
    }

    /**
     * 二维码解析
     * @param QRFile    文件
     * @param character 字符编码
     * @return Result
     */
    public static Result QRencrypt(File QRFile, String character) {
        try {
            BufferedImage image = ImageIO.read(QRFile);
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            Binarizer binarizer = new HybridBinarizer(source);
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
            Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>(1);
            if (null == character)
                hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
            hints.put(DecodeHintType.CHARACTER_SET, character);
            // 对图像进行解码
            return new MultiFormatReader().decode(binaryBitmap, hints);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 二维码解析
     * @param QRFile    文件  默认编码 UTF-8
     * @return  Result
     */
    public static Result QRencrypt(File QRFile) {
        return QRencrypt(QRFile , null);
    }

    /**
     * 创建二维码
     * @param folder   目录
     * @param fileName 文件名称
     * @param content  内容
     * @param width    宽
     * @param height   高
     * @param bit      边框百分百比
     * @param format   图片格式: png,jpg
     * @throws WriterException
     * @throws IOException
     */
    public static void createQRCode(String folder, String fileName, String content, int width, int height, int bit, String format) throws WriterException, IOException {
        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hints.put(EncodeHintType.MARGIN, bit);
        // 生成矩阵
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
        Path path = FileSystems.getDefault().getPath(folder, fileName);
        // 输出图像
        MatrixToImageWriter.writeToPath(bitMatrix, format, path);
    }

    /**
     * 创建二维码
     *
     * @param url    url
     * @param width  宽
     * @param height 高
     * @param bit    边框厚度
     * @return BufferedImage
     * @throws WriterException
     * @throws IOException
     */
    @Deprecated
    public static BufferedImage createQRCode(String url, int width, int height, int bit) throws WriterException, IOException {
        BufferedImage image = null;
        // 二维码图片输出流
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        HashMap<EncodeHintType, Comparable> hints = new HashMap<EncodeHintType, Comparable>();
        // 设置编码方式
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        // 设置QR二维码的纠错级别（H为最高级别）具体级别信息
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        BitMatrix bitMatrix = multiFormatWriter.encode(url, BarcodeFormat.QR_CODE, width, height, hints);
        bitMatrix = updateBit(bitMatrix, bit);
        image = MatrixToImageWriter.toBufferedImage(bitMatrix);
        return image;
    }

    /**
     * 自定义白边边框宽度
     *
     * @param matrix 矩阵
     * @param margin 边缘
     * @return BitMatrix
     */
    private static BitMatrix updateBit(final BitMatrix matrix, final int margin) {
        int tempM = margin * 2;
        // 获取二维码图案的属性
        int[] rec = matrix.getEnclosingRectangle();
        int resWidth = rec[2] + tempM;
        int resHeight = rec[3] + tempM;
        // 按照自定义边框生成新的BitMatrix
        BitMatrix resMatrix = new BitMatrix(resWidth, resHeight);
        resMatrix.clear();
        // 循环，将二维码图案绘制到新的bitMatrix中
        for (int i = margin; i < resWidth - margin; i++) {
            for (int j = margin; j < resHeight - margin; j++) {
                if (matrix.get(i - margin + rec[0], j - margin + rec[1])) {
                    resMatrix.set(i, j);
                }
            }
        }
        return resMatrix;
    }


    public static void main(String[] args) throws WriterException, IOException, NotFoundException {
        createQRCode("C:\\Users\\SHARK\\Desktop", "nihao.png", "nihao", 250, 250, 100, "png");
    }
}
