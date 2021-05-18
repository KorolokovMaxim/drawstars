class Model {


    companion object {
        const val INITIAL_Z_CORD = -3f
        const val MOTION_SPEED = 0.001f
    }

    private val points: ArrayList<Point> = ArrayList()


    fun update(elapsedTime: Long) {

            val birthChance = 0.02f

            if (random(0f, 1f) < birthChance) {
                points.add(Point(random(-1f, 1f), random(-1f, 1f), INITIAL_Z_CORD))
            }

            for (point: Point in points) {
                point.z += elapsedTime * MOTION_SPEED
            }

            points.removeIf { point -> point.z >= 0 }



    }

    private fun random(from: Float, to: Float): Float {
        return ((from + (to - from) * Math.random()).toFloat())
    }

    fun getPoints(): ArrayList<Point> {
        return points
    }


}