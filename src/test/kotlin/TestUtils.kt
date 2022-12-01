
/**
 * Reads text from the given input txt file in resources folder.
 */
fun readResourceText(fileName: String) =
    object {}.javaClass.getResourceAsStream("$fileName.txt")?.bufferedReader()?.readText()!!
