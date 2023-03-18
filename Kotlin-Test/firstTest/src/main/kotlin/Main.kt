fun main() {
    var done: Boolean = false
    val player1: Char = '?'
    val player2: Char = '#'
    var count: Int = 0

    val pg = Playground()
    pg.show()

    while (done == false) {
        if (count % 2 == 0) {

            println("\nWo willst du deinen Spielstein hinwerfen?")

            val input = readLine()?.toInt()

            if (input != null) {
                pg.dropPiece(input, player1)
            }
            if (pg.gameIsOver()) {
                println("\n\nDer Spieler 1 hat GEWONNEN! Gratulation!\n\n")
                done = true
            }
            pg.show()

        } else {

            println("\nWo willst du deinen Spielstein hinwerfen?")

            val input = readLine()?.toInt()

            if (input != null) {
                pg.dropPiece(input, player2)
            }
            pg.show()

            if (pg.gameIsOver()) {
                println("\n\nDer Spieler 2 hat GEWONNEN! Gratulation!\n\n")
                done = true
            }

        }
        count++
    }
}