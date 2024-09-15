import java.io.File
import java.text.SimpleDateFormat
import java.util.*


object BMICalculator {
    fun calculateBMI(weight: Float, height: Float): Float {
        return weight / (height * height)
    }

    fun saveToHistoryFile(date: Date, bmi: Float) {
        val file = File("bmi_history.txt")
        file.appendText("${SimpleDateFormat("dd-MM-yyyy HH:mm").format(date)} - ИМТ: %.2f\n".format(bmi))
    }

    fun getBMICategory(bmi: Float): String {
        return when {
            bmi < 18.5 -> "Недостаточная масса тела"
            bmi in 18.5..24.9 -> "Норма"
            bmi in 25.0..29.9 -> "Избыточная масса тела"
            else -> "Ожирение"
        }
    }

}