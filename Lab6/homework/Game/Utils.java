package lab6.compulsory.Game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import lab6.compulsory.Shape.Line;

public class Utils {

	public static boolean checkIntersection(Line line1, Line line2) {
		double x1 = line1.getV1().getX();
		double y1 = line1.getV1().getY();
		double x2 = line1.getV2().getX();
		double y2 = line1.getV2().getY();

		double x3 = line2.getV1().getX();
		double y3 = line2.getV1().getY();
		double x4 = line2.getV2().getX();
		double y4 = line2.getV2().getY();

		return (x2 == x3 && y2 == y3 || x2 == x4 && y2 == y4 || x1 == x3 && y1 == y3 || x1 == x4 && y1 == y4);

	}

	public static void print(BufferedImage image) {
		try {
			File f = new File("./img.png");
			ImageIO.write(image, "PNG", f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
