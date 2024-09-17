import java.io.File
import java.text.SimpleDateFormat
import java.util.*

object HistoryExporter {
    fun exportHistoryToFile(bmiHistory: List<Pair<Date, Float>>) {
        val file = File("bmi_export.txt")
        file.writeText("История ИМТ:\n")
        for(entry in bmiHistory){
            val date = entry.first
            val bmi = entry.second
            file.appendText("${SimpleDateFormat("dd-MM-yyyy HH:mm").format(date)} - ИМТ: %.2f\n".format(bmi))

        }

        println("История ИМТ успешно экспортирована в файл bmi_export.txt")
    }

    fun loadHistoryFromFile(bmiHistory: MutableList<Pair<Date, Float>>) {
        val file = File("bmi_history.txt")
        if (!file.exists()) {
            println("Файл истории не найден -> Пустая история")
            return
        }

        for (line in file.readLines()) {
            if (line.startsWith("История ИМТ:")) continue
            val parts = line.split(" - ИМТ: ")
            if (parts.size == 2) {
                val date = SimpleDateFormat("dd-MM-yyyy HH:mm").parse(parts[0])
                val bmi = parts[1].replace(",", ".").toFloatOrNull()
                if (bmi != null) {
                    bmiHistory.add(date to bmi)
                }
            }
        }

        println("История ИМТ успешно загружена из файла")
    }
}
