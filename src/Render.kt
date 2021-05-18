import java.awt.Color
import java.awt.Graphics2D
import java.awt.image.BufferedImage

class Render {


    fun draw( image: BufferedImage,  model: Model) {
           val graphics: Graphics2D = image.createGraphics()
           graphics.paint = Color.BLACK
           graphics.fillRect(0, 0, image.width, image.height)



        for (point: Point in model.getPoints()) {


            val sx = (image.width / 2f + ((image.width / 2f * point.x / point.z))).toInt()
            val sy = (image.height / 2f + ((image.height / 2f * point.y / point.z))).toInt()

            if (sx < image.width && sx > 0
                && sy < image.height && sy > 0
            ) {
                val color: Int = 255 + (point.z * (255 / Math.abs(Model.INITIAL_Z_CORD))).toInt()
                image.setRGB(sx, sy, 0xff00000 or color.shl(16) or color.shl(8) or color)

            }
        }

    }

}