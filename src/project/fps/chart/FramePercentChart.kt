package fps.chart

import fps.Chart
import fps.SampleResult
import fps.data.ChartData
import kotlin.math.max
import kotlin.math.min

/**
 * https://jshare.com.cn/demos/hhhhD8
 */
object FramePercentChart : Chart {

    override fun process(base: SampleResult, target: SampleResult) {
        val categories = Array(7) { index ->
            when (index) {
                0 -> IntRange(0, 16)
                1 -> IntRange(16, 32)
                2 -> IntRange(32, 48)
                3 -> IntRange(48, 64)
                4 -> IntRange(64, 80)
                5 -> IntRange(80, 96)
                else -> IntRange(96, Int.MAX_VALUE)
            }
        }

        val baseData = IntArray(categories.size)
        base.toFrameRecords().forEach { record ->
            categories.forEachIndexed { index, intRange ->
                if (intRange.contains(record.interval)) {
                    baseData[index] += 1
                    return@forEach
                }
            }
        }

        val targetData = IntArray(categories.size)
        target.toFrameRecords().forEach { record ->
            categories.forEachIndexed { index, intRange ->
                if (intRange.contains(record.interval)) {
                    targetData[index] += 1
                    return@forEach
                }
            }
        }


        ChartData(
            "帧耗时分布",
            categories.asSequence().map { "'${it.first}~${it.last}'" }.toList(),
            "9210版本（平均fps=${base.averageFps()}）",
            baseData.toList(),
            "优化版本（平均fps=${target.averageFps()}）",
            targetData.toList()
        )
            .let { it.getCode() }
            .also(::println)
    }
}


private fun ChartData.getCode(): String {
    return """
var chart = Highcharts.chart('container',{
	chart: {
		type: 'column'
	},
	title: {
		text: '$title'
	},
	xAxis: {
		categories: $categories,
		crosshair: true
	},
	yAxis: {
		min: 0,
		title: {
			text: '$title'
		}
	},
	tooltip: {
		// head + 每个 point + footer 拼接成完整的 table
		headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
		pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
		'<td style="padding:0"><b>{point.y:.0f}</b></td></tr>',
		footerFormat: '</table>',
		shared: true,
		useHTML: true
	},
	plotOptions: {
		column: {
			borderWidth: 0
		}
	},
	series: [{
		name: '$baseTitle',
		data: $baseData
	}, {
		name: '$targetTitle',
		data: $targetData
	}]
});
"""
}



