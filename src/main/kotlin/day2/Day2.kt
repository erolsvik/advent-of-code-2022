package day2

import java.io.File

val values = mapOf("A" to 1, "B" to 2, "C" to 3)
val values2 = mapOf("X" to 1, "Y" to 2, "Z" to 3)
val winValues = mapOf("X" to "C", "Y" to "A", "Z" to "B")
val lossValues = mapOf("X" to "B", "Y" to "C", "Z" to "A")
val drawValues = mapOf("X" to "A", "Y" to "B", "Z" to "C")
var totalScore = 0

fun main() {
    task2()
    println(totalScore)
}

fun task1() {
    loadFile().useLines {
        it.iterator().forEachRemaining { line ->
            val hand = line.split(" ")
            if (hand[0] == drawValues[hand[1]]) {
                totalScore += 3
            }
            else if(hand[0] == winValues[hand[1]]) {
                totalScore += 6
            }
            totalScore += values[drawValues[hand[1]]]!!.toInt()
        }
    }
}

fun task2() {
    loadFile().useLines {
        it.iterator().forEachRemaining { line ->
            val hand = line.split(" ")
            when(hand[1]) {
                "Y" -> totalScore += 3 + values2[invertMap(drawValues)[hand[0]]!!]!!.toInt()
                "Z" -> totalScore += 6 + values2[invertMap(winValues)[hand[0]]!!]!!.toInt()
                else -> totalScore += values2[invertMap(lossValues)[hand[0]]!!]!!.toInt()
            }
        }
    }
}

private fun loadFile(): File {
    return File("C:\\dev\\Advent_of_code_2022\\src\\main\\kotlin\\day2\\input.txt")
}

private fun invertMap(ogMap: Map<String, String>): Map<String, String> = ogMap.entries.associateBy({ it.value }) { it.key }