package fps.chart

import fps.Chart
import fps.SampleResult
import fps.data.ChartData
import kotlin.math.max
import kotlin.math.min

/**
 * https://jshare.com.cn/demos/hhhhxA
 */
object FrameCountChart : Chart {

    override fun process(base: SampleResult, target: SampleResult) {
        val baseCategories = IntArray(1000)
        base.toFrameRecords().forEach {
            baseCategories[it.interval.toInt()] += 1
        }
        val targetCategories = IntArray(1000)
        target.toFrameRecords().forEach {
            targetCategories[it.interval.toInt()] += 1
        }
        var categoryMin = 0
        for (i in 1 until 999) {
            if (baseCategories[i] > 0 || targetCategories[i] > 0) {
                categoryMin = i - 1
                break
            }
        }
        var categoryMax = 0
        for (i in 999 downTo 2) {
            if (baseCategories[i] > 0 || targetCategories[i] > 0) {
                categoryMax = i + 1
                break
            }
        }
        val size = categoryMax - categoryMin + 1
        val categories = IntArray(size) { it + categoryMin }.toList()

        val baseData = baseCategories.slice(categoryMin until categoryMax + 1)
        val targetData = targetCategories.slice(categoryMin until categoryMax + 1)

        ChartData(
            "帧耗时分布",
            categories,
            "9210版本（平均fps=${base.averageFps()}）",
            baseData,
            "优化版本（平均fps=${target.averageFps()}）",
            targetData
        )
            .let { it.getCode() }
            .also(::println)
    }
}

private fun ChartData.getCode(): String {
    return """
var chart = Highcharts.chart('container', {
	chart: {
		type: 'areaspline'
	},
	title: {
		text: '$title'
	},
	legend: {
		layout: 'vertical',
		align: 'left',
		verticalAlign: 'top',
		x: 150,
		y: 100,
		floating: true,
		borderWidth: 1,
		backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
	},
	xAxis: {
		categories: $categories
	},
	yAxis: {
		title: {
			text: '次数'
		}
	},
	tooltip: {
		shared: true,
		valueSuffix: '次'
	},
	plotOptions: {
		areaspline: {
			fillOpacity: 0.4
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



