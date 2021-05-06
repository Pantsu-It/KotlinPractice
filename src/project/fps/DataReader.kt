package fps

import com.google.gson.Gson
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import java.io.File
import java.io.FileReader

object DataReader {

    fun readFile(file: File): SampleResult {
        val fileReader = FileReader(file)
        val jsonString = fileReader.readText()
        return Gson().fromJson(jsonString, SampleResult::class.java)
    }
}


data class SampleResult(
    @SerializedName("sampleRecords")
    val sampleRecords: List<SampleRecord>
) {
    fun toFrameRecords() = sampleRecords.flatMap { it.frameRecords }

    fun averageFps() = sampleRecords.fold(0) { sum, sampleRecord -> sum + sampleRecord.frameRecords.size} / sampleRecords.size.toFloat()
}

data class SampleRecord(
    @SerializedName("frameRecords")
    val frameRecords: List<FrameRecord>,
)

data class FrameRecord(
    @SerializedName("timestamp")
    val timestamp: Float,
    @SerializedName("interval")
    val interval: Float
)