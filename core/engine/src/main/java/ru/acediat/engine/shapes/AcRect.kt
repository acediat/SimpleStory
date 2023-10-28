package ru.acediat.engine.shapes

data class AcRect(
    val left: Float,
    val right: Float,
    val top: Float,
    val bottom: Float,
): Shape {

    override fun contains(point: AcPoint): Boolean = with(point) {
        return x in left..right && y in top..bottom
    }
}