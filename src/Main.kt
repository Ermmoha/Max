import java.io.BufferedReader
import java.io.FileReader

fun main() {
    try {
        var maxSum = 0
        var minDifference = Int.MAX_VALUE
        val inputFile = "C:\\file.txt"

        // Открываем файл и читаем его построчно
        BufferedReader(FileReader(inputFile)).use { bufferedReader ->
            var currentLine: String?
            while (bufferedReader.readLine().also { currentLine = it } != null) {
                // Преобразуем строку в список чисел
                val values = currentLine!!.split(" ").map { it.toInt() }
                val firstNumber = values[0]
                val secondNumber = values[1]

                // Добавляем большее из двух чисел к сумме
                maxSum += if (firstNumber > secondNumber) firstNumber else secondNumber

                // Проверяем, разность на кратность3
                val difference = kotlin.math.abs(firstNumber - secondNumber)
                if (difference % 3 != 0) {
                    minDifference = if (difference < minDifference) difference else minDifference
                }
            }
        }

        // Выводим результат в зависимости от кратности суммы чисел 3
        if (maxSum % 3 != 0) {
            println("Результат: $maxSum")
        } else {
            println("Результат: ${maxSum - minDifference}")
        }
    } catch (exception: Exception) {
        println("Произошла ошибка: ${exception.message}")
    }
}
