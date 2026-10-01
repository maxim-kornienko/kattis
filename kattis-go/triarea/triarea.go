package main

import (
	"fmt"
)

// https://open.kattis.com/problems/triarea
func main() {
	var height, base int64

	_, _ = fmt.Scanln(&height, &base)

	area := area(height, base)

	fmt.Printf("%f", area)
}

func area(height, base int64) float64 {
	return float64(height*base) / 2
}
