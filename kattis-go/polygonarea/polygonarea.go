package main

import (
	"fmt"
)

type Point struct {
	x int64
	y int64
}

// https://open.kattis.com/problems/polygonarea
func main() {
	var n int

	_, _ = fmt.Scanln(&n)
	for n > 0 {
		var points []Point
		points = make([]Point, n)

		for i := 0; i < n; i++ {
			var x int64
			var y int64
			_, _ = fmt.Scanln(&x, &y)
			points[i] = Point{x, y}
		}

		area := calculateArea(points)
		if area >= 0 {
			fmt.Printf("CCW %.1f", area)
		} else {
			fmt.Printf("CW %.1f", -area)
		}
		fmt.Println()

		_, _ = fmt.Scanln(&n)
	}
}

func calculateArea(points []Point) float64 {
	var area int64
	area = 0
	for i := 0; i < len(points); i++ {
		area += points[i].x * points[(i+1)%len(points)].y
		area -= points[i].y * points[(i+1)%len(points)].x
	}
	return float64(area) / 2
}
