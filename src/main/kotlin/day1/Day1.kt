package day1

import java.io.File

fun main(args: Array<String>) {
    val list = mutableListOf<Int>()
    var sum = 0
    File("C:\\dev\\Advent_of_code_2022\\src\\main\\kotlin\\day1\\input.txt").useLines {
        it.iterator().forEachRemaining { value ->
            if (value == "") {
                list.add(sum)
                println("Fant en alv med kaloer: $sum")
                sum = 0
            }
            else {
                sum += value.toInt()
            }
        }
    }
    list.sortDescending()
    println("Top 3 calories: ${list[0] + list[1] + list[2]}")

}