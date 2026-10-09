package main

import "fmt"

// https://open.kattis.com/problems/islands3
func main() {
	var r, c int
	_, _ = fmt.Scanln(&r, &c)

	matrix := make([][]rune, r)
	for i := 0; i < r; i++ {
		matrix[i] = make([]rune, c)

		var str string
		fmt.Scanln(&str)
		copy(matrix[i][:], []rune(str))
	}

	for i := 0; i < r; i++ {
		for j := 0; j < c; j++ {
			fmt.Print(string(matrix[i][j]))
		}
		fmt.Println()
	}
}
