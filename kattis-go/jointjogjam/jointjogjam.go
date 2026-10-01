package main

import (
	"fmt"
	"math"
)

type Point struct {
	x int64
	y int64
}

// https://open.kattis.com/problems/jointjogjam
func main() {
	var kariStart, kariEnd Point
	var olaStart, olaEnd Point

	_, _ = fmt.Scanln(&kariStart.x, &kariStart.y, &olaStart.x, &olaStart.y, &kariEnd.x, &kariEnd.y, &olaEnd.x, &olaEnd.y)

	distanceAtStart := distance(kariStart, olaStart)
	distanceAtEnd := distance(kariEnd, olaEnd)
	distance := math.Max(distanceAtStart, distanceAtEnd)

	fmt.Printf("%f", distance)
}

func distance(a Point, b Point) float64 {
	dx := a.x - b.x
	dy := a.y - b.y
	return math.Sqrt(float64(dx*dx + dy*dy))
}
