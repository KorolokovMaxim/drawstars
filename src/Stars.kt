import java.awt.BorderLayout
import java.awt.image.BufferedImage
import javax.swing.ImageIcon
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.SwingUtilities


class Stars : JFrame() {


    companion object {
        @Volatile
        var isFrameReadyToDraw = true
    }


    fun createStars() {

        val screenWidth = 1200
        val screenHeight = 800

        val frame = JFrame()
        frame.setSize(screenWidth, screenHeight)
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE

        val image = BufferedImage(screenWidth, screenHeight, BufferedImage.TYPE_INT_ARGB)

        val imageIcon = ImageIcon(image)
        val picLabel = JLabel(imageIcon)

        val borderLayout = BorderLayout()
        frame.contentPane.layout = borderLayout
        frame.contentPane.add(picLabel, BorderLayout.CENTER)
        frame.isVisible = true

        val model = Model()
        val render = Render()

        var lastTime: Long = System.currentTimeMillis()

        while (frame.isVisible) {
            val time: Long = System.currentTimeMillis()
            model.update(time - lastTime)
            lastTime = time
            if (isFrameReadyToDraw) {
                isFrameReadyToDraw = false
                render.draw(image, model)

                SwingUtilities.invokeLater {
                    frame.repaint()
                    isFrameReadyToDraw = true
                }

            }
        }
    }


}




