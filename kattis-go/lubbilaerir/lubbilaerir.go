package main

import (
	"fmt"
	"unicode/utf8"
)

// https://open.kattis.com/problems/lubbilaerir
func main() {
	var str string

	_, _ = fmt.Scanln(&str)

	rune, _ := utf8.DecodeRuneInString(str)

	fmt.Printf("%c\n", rune)
}
