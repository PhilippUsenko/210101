import HistoryExporter.loadHistoryFromFile
import org.knowm.xchart.SwingWrapper
import org.knowm.xchart.XYChart
import org.knowm.xchart.XYChartBuilder
import java.util.*

object WeightChart {


    fun plotBMIHistory() {
        val bmiHistory = mutableListOf<Pair<Date, Float>>()

        loadHistoryFromFile(bmiHistory)

        val chart: XYChart = XYChartBuilder()
            .width(800)
            .height(600)
            .title("Изменение ИМТ с течением времени")
            .xAxisTitle("Дата")
            .yAxisTitle("ИМТ")
            .build()

        chart.styler.setDatePattern("dd-MM-yyyy HH:mm")
        chart.styler.isLegendVisible = true

        val xData = bmiHistory.map { it.first.time.toDouble() }.toDoubleArray()
        val yData = bmiHistory.map { it.second.toDouble() }.toDoubleArray()
        chart.addSeries("ИМТ", xData, yData)

        SwingWrapper(chart).displayChart()
    }
}
