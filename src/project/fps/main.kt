package fps

import fps.chart.FrameCountChart
import fps.chart.FramePercentChart
import java.io.File

fun main() {
    val dataDir = "/Users/pangcong/IdeaProjects/KotlinPractice/src/fps/data"

    val baseFile = "chat_fps_1615188157605.txt"
    val baseSample = DataReader.readFile(File("$dataDir/$baseFile"))

    val targetFile = "chat_fps_1615187684651.txt"
    val targetSample = DataReader.readFile(File("$dataDir/$targetFile"))

//    val frameCountChart = FrameCountChart.process(baseSample, targetSample)
    val framePersonChart = FramePercentChart.process(baseSample, targetSample)
}


interface Chart {
    fun process(base: SampleResult, target: SampleResult)
}