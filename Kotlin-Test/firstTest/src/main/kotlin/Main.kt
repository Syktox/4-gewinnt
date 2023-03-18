var done: Boolean = false
val pg = Playground()

fun playerDropsPiece(player: Char) {
    println("\nWo willst du deinen Spielstein hinwerfen?")

    var input = readLine()?.toInt()
    while (input == null || input > 6 || input < 0 || !pg.dropPiece(input, player)) {
        println("\n\nWrong Input! Try again!")
        input = readLine()?.toInt()
    }

    pg.show()

    if (pg.gameIsOver()) {
        println("\n\nDer Spieler $player hat GEWONNEN! Gratulation!\n\n")
        done = true
    }
}
fun initalisePlayer(): Char {
    println("Gib ein Zeichen für deinen Spieler ein!")
    val player = readLine()?.length==1
    return player.toString()[0]
}

fun main() {
    val p1 = initalisePlayer()
    val p2 = initalisePlayer()

    var count = 0

    pg.show()
    while (!done) {
        if (count % 2 == 0) {
            playerDropsPiece(p1)
        } else {
            playerDropsPiece(p2)
        }
        count++
    }
}