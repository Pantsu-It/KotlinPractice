package fps.data

data class ChartData(
    val title: String,
    val categories: List<*>,
    val baseTitle: String,
    val baseData: List<Int>,
    val targetTitle: String,
    val targetData: List<Int>,
)

private const val DATA_SLIDE_HONGMI = """
红米-优化前
chat_fps_1615116893169.txt
红米-优化后
chat_fps_1615116523630.txt
红米-优化前
chat_fps_1615170183236.txt
红米-优化后
chat_fps_1615171012252.txt
"""

private const val DATA_SLIDE_OPPO = """
OPPO-优化前
chat_fps_1615172587752.txt
OPPO-优化后
chat_fps_1615173103926.txt

OPPO-优化前
chat_fps_1615174192433.txt
OPPO-优化后
chat_fps_1615173723981.txt

OPPO-优化前
chat_fps_1615174956097.txt
OPPO-优化后
chat_fps_1615175361118.txt

OPPO-优化前
chat_fps_1615179585823.txt
OPPO-优化后
chat_fps_1615179165840.txt
"""

private const val DATA_RECEIVE_MSG = """
OPPO-优化前(qps=3)
chat_fps_1615188157605.txt
OPPO-优化后(qps=3)
chat_fps_1615187684651.txt

OPPO-优化前(qps=6)
chat_fps_1615186808773.txt
OPPO-优化后(qps=6)
chat_fps_1615187243266.txt
"""