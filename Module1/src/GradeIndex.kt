class GradeIndex {
    fun getGradeIndex(grade: Int): String {
        return when (grade) {
            in 80..100 -> "A"
            in 70..79 -> "AB"
            in 60..69 -> "B"
            in 50..59 -> "BC"
            in 40..49 -> "C"
            in 30..39 -> "D"
            in 0..29 -> "E"
            else -> "Invalid grade"
        }
    }
}