package com.batch.job.batchtest

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.FileReader
import java.io.FileWriter


@SpringBootApplication
open class BatchTestApplication : CommandLineRunner {
	override fun run(vararg args: String?) {
		println("Executing Task1")
		println("Executing Task2")
		println("Executing Task3")
		val fileName = "opt/a.txt"
		val value = "Hello, world!"
		writeToFile(fileName,value)
		println("Written to file : $fileName")

		val readFromFile = readFromFile(fileName)
		println("Content read from file: $readFromFile")

	}

	private fun readFromFile(fileName : String) :String {
		val reader = BufferedReader(FileReader(fileName))
		val currentLine = reader.readLine()
		reader.close()
		return currentLine
	}

	private fun writeToFile(fileName : String, str : String) {
		
		val writer = BufferedWriter(FileWriter(fileName, true))
		writer.append(' ')
		writer.append(str)

		writer.close()
	}

}

fun main(args: Array<String>) {
	runApplication<BatchTestApplication>(*args)
}
