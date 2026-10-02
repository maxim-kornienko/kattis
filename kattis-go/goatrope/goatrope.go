package main

import (
	"fmt"
	"math"
)

// https://open.kattis.com/problems/goatrope
func main() {
	var x, y, x1, y1, x2, y2 int64

	_, _ = fmt.Scanln(&x, &y, &x1, &y1, &x2, &y2)

	dx := delta(x, x1, x2)
	dy := delta(y, y1, y2)
	d := math.Sqrt(math.Pow(float64(dx), 2) + math.Pow(float64(dy), 2))

	fmt.Println(d)
}

func delta(p, p1, p2 int64) int64 {
	if p < p1 {
		return p1 - p
	} else if p > p2 {
		return p2 - p
	} else {
		return 0
	}
}
