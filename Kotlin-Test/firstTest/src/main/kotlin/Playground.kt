class Playground {
    private var matrix = Array(6) { Array(7) {  '0'   } }

    fun show() {
        for (row in matrix) {
            for (element in row) {
                print(" $element ")
            }
            println()
        }
    }

    fun dropPiece(spalte: Int, player: Char) {
        var tempheight = 5
        while (matrix[tempheight][spalte] != '0') {
            tempheight--
        }
        matrix[tempheight][spalte] = player
    }

    fun hasFourSameDigitsBehindEachOther(): Boolean {
        for (row in matrix) {
            var count: Int = 1
            for (i in 1 until row.size) {
                if (row[i] == row[i - 1] && (row[i] == '?' || row[i]  == '#')) {
                    count++
                    if (count == 4) {
                        return true
                    }
                } else {
                    count = 1
                }
            }
        }

        for (i in 0 until matrix[0].size) {
            var count = 1
            for (j in 1 until matrix.size) {
                if (matrix[j][i] == matrix[j - 1][i] && (matrix[j][i] == '?' || matrix[j][i]  == '#')) {
                    count++
                    if (count == 4) {
                        return true
                    }
                } else {
                    count = 1
                }
            }
        }

        for (i in 0 until matrix.size - 3) {
            for (j in 0 until matrix[0].size - 3) {
                if (matrix[i][j] == matrix[i + 1][j + 1] &&
                    matrix[i + 1][j + 1] == matrix[i + 2][j + 2] &&
                    matrix[i + 2][j + 2] == matrix[i + 3][j + 3] &&
                    (matrix[i][j] == '?'|| matrix[i][j] == '#')) {
                    return true
                }
            }
        }

        // Überprüfen der Nebendiagonale
        for (i in 0 until matrix.size - 3) {
            for (j in 3 until matrix[0].size) {
                if (matrix[i][j] == matrix[i + 1][j - 1] &&
                    matrix[i + 1][j - 1] == matrix[i + 2][j - 2] &&
                    matrix[i + 2][j - 2] == matrix[i + 3][j - 3] &&
                    (matrix[i][j] == '?'|| matrix[i][j] == '#')) {
                    return true
                }
            }
        }

        return false
    }

    fun gameIsOver(): Boolean {
        if (hasFourSameDigitsBehindEachOther()) {
            return true
        }
        return false
    }
}
