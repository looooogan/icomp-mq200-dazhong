package com.amistrong.express.common;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

import sun.misc.BASE64Decoder;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImageEdit {

	private final static int baseWidth = 100;
	private final static int baseHeight = 100;
	
	public static void writeFile(ByteArrayOutputStream bImg1, String fileName)
			throws Exception {
		if (bImg1 == null)
			return;
		File f = new File(fileName);
		FileOutputStream out = new FileOutputStream(f);
		bImg1.writeTo(out);
		bImg1.flush();
		out.flush();
		out.close();
	}

	public static ByteArrayOutputStream GenerateImage(String imgStr)
			throws Exception {
		if (CommonClass.strIsEmpty(imgStr)) { // 图像数据为空
			return null;
		}
		BASE64Decoder decoder = new BASE64Decoder();
		imgStr = imgStr.substring(imgStr.indexOf(",") + 1);

		// Base64解码
		byte[] bytes = decoder.decodeBuffer(imgStr);
		/*
		 * for (int i = 0; i < bytes.length; ++i) { if (bytes[i] < 0) {// 调整异常数据
		 * bytes[i] += 256; } }
		 */
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		// 生成图片
		out.write(bytes);
		out.flush();

		return out;
	}

	public static void createThum(ByteArrayOutputStream bImg1, String fileName)
			throws Exception {
		writeHighQuality(zoomImage(bImg1),fileName);
	}
	
	/**
	 * @param im
	 *            原始图像
	 * @param resizeTimes
	 *            倍数,比如0.5就是缩小一半,0.98等等double类型
	 * @return 返回处理后的图像
	 */
	private static BufferedImage zoomImage(ByteArrayOutputStream stream) {

		BufferedImage result = null;
		
		try {
			ByteArrayInputStream input = new ByteArrayInputStream(stream.toByteArray());
			BufferedImage im = ImageIO.read(input);
			Size size = getZoomSize(im.getWidth(),im.getHeight());
			
			/* 新生成结果图片 */
			result = new BufferedImage(size.getWidth(), size.getHeight(),
					BufferedImage.TYPE_INT_RGB);

			result.getGraphics().drawImage(
					im.getScaledInstance(size.getWidth(), size.getHeight(),
							java.awt.Image.SCALE_SMOOTH), 0, 0, null);

		} catch (Exception e) {
			System.out.println("创建缩略图发生异常" + e.getMessage());
		}

		return result;
	}
	
	private static boolean writeHighQuality(BufferedImage im, String fileFullPath) {
		try {
			/* 输出到文件流 */
			FileOutputStream newimage = new FileOutputStream(fileFullPath);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(newimage);
			JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(im);
			/* 压缩质量 */
			jep.setQuality(0.9f, true);
			encoder.encode(im, jep);
			/* 近JPEG编码 */
			newimage.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	private static Size getZoomSize(int width,int height)
	{
		int newWidth = 0;
		int newHeight = 0;
		
		if(width > height)
		{
			double d = (double)baseWidth / (double)width;
			newWidth = baseWidth;
			newHeight = (int) (height * d);
		}
		else
		{
			double d = (double)baseHeight / (double)height;
			newHeight = baseHeight;
			newWidth = (int) (width * d);
		}
		return new Size(newWidth, newHeight);
	}

}

class Size
{
	private int width;
	private int height;
	public Size(int width,int height)
	{
		this.width = width;
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
}
