import java.io.File
val hangman = listOf("""
    -----
    |   |
    |   o
    |  /|\
    |  / \
    |
    ------
""".trimIndent(),
    """
    -----
    |   |
    |   o
    |  /|\
    |  / 
    |
    ------
""".trimIndent(),
    """
    -----
    |   |
    |   o
    |  /|\
    |  
    |
    ------
""".trimIndent(),
    """
    -----
    |   |
    |   o
    |  /|
    |  
    |
    ------
""".trimIndent(),
    """
    -----
    |   |
    |   o
    |  /
    |
    |
    ------
""".trimIndent(),
    """
    -----
    |   |
    |   o
    |  
    |  
    |
    ------
""".trimIndent(),
    """
    -----
    |   |
    |   
    |  
    |  
    |
    ------
""".trimIndent(),
    """
    -----
    |  
    |   
    |  
    |  
    |
    ------
""".trimIndent(),
    """
    -----
    
    
    
    
    
    ------
""".trimIndent(),


    )
fun main() {
    val word = File("word.txt").readLines().random()
    var status = "_".repeat(word.length).toCharArray()
    var life = hangman.lastIndex
    while (String(status) != word && life > 0){
        println(hangman[life-1])
        println(status)
        val input = readln()
        if (input.length > 1 ){
//            compare whole word
            if (input == word) status = input.toCharArray()
            else life--
        }else if (input in word){
            word.forEachIndexed { index, c ->
                if (c in input) status[index] = c
            }
        }else life--
    }
    if (life > 0) println("Glückwunsch")
    else println("Wort ist: $word")
}