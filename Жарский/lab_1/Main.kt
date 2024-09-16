import java.util.*

fun main() {
    val bmiHistory = mutableListOf<Pair<Date, Float>>()
    
    while (true) {
        println("Введите вес в килограммах (или введите 'exit' для завершения):")
        val weightInput = readlnOrNull()
        if (weightInput == "exit") break
        val weight = weightInput?.toFloatOrNull()

        println("Введите рост в метрах:")
        val heightInput = readlnOrNull()
        val height = heightInput?.toFloatOrNull()

        if (weight != null && height != null) {
            val bmi = BMICalculator.calculateBMI(weight, height)
            val currentDate = Date()


            println("Ваш ИМТ: %.2f".format(bmi))
            println("Ваша текущая категория ИМТ: ${BMICalculator.getBMICategory(bmi)}")
            BMICalculator.saveToHistoryFile(currentDate, bmi)
        } else {
            println("Неверный ввод. Попробуйте снова.")
        }
        WeightChart.plotBMIHistory()


    }

    HistoryExporter.exportHistoryToFile(bmiHistory)
}
