package main

import (
	"fmt"
	"math"
)

type Point struct {
	x int
	y int
}

func Distance(a, b Point) float64 {
	dx := float64(a.x - b.x)
	dy := float64(a.y - b.y)
	return math.Sqrt(dx*dx + dy*dy)
}

// https://open.kattis.com/problems/goatropes
func main() {
	var n int
	_, _ = fmt.Scan(&n)

	posts := make([]Point, n)
	for i := 0; i < n; i++ {
		var x, y int
		_, _ = fmt.Scan(&x, &y)
		posts[i] = Point{x: x, y: y}
	}

	cn2 := n * (n - 1) / 2

	variables := make([][]float64, cn2+1)
	constraintsCol := make([]float64, cn2+1)
	k := 0
	for i := 0; i < n-1; i++ {
		for j := i + 1; j < n; j++ {
			variables[k] = make([]float64, n+cn2)
			for r := 0; r < n; r++ {
				variables[k][i] = 1
				variables[k][j] = 1
			}
			variables[k][n+k] = 1
			constraintsCol[k] = Distance(posts[i], posts[j])
			k++
		}
	}
	variables[cn2] = make([]float64, n+cn2)
	for j := 0; j < n; j++ {
		variables[cn2][j] = -1
	}

	pivotColIdx := findPivotColumn(variables[cn2])
	for variables[cn2][pivotColIdx] < 0 {
		pivotRowIdx := findPivotRow(variables, pivotColIdx, constraintsCol)
		// normalize row
		pivot := variables[pivotRowIdx][pivotColIdx]
		constraintsCol[pivotRowIdx] /= pivot
		for j := 0; j < len(variables[pivotRowIdx]); j++ {
			variables[pivotRowIdx][j] = variables[pivotRowIdx][j] / pivot
		}

		for i := 0; i < len(variables); i++ {
			if i == pivotRowIdx {
				continue
			}
			factor := variables[i][pivotColIdx]
			if factor == 0 {
				continue
			}
			for j := 0; j < len(variables[i]); j++ {
				variables[i][j] -= factor * variables[pivotRowIdx][j]
			}
			constraintsCol[i] -= factor * constraintsCol[pivotRowIdx]
		}

		pivotColIdx = findPivotColumn(variables[cn2])
	}

	fmt.Printf("%.2f\n", constraintsCol[cn2])
}

func findPivotColumn(objectiveRow []float64) (minIdx int) {
	minIdx = 0
	minValue := objectiveRow[0]
	for i := 1; i < len(objectiveRow); i++ {
		if lt(objectiveRow[i], minValue) {
			minIdx = i
			minValue = objectiveRow[i]
		}
	}
	return minIdx
}

func findPivotRow(variables [][]float64, pivotColumnIdx int, constraintsCol []float64) (minIdx int) {
	minIdx = 0
	minValue := constraintsCol[minIdx] / variables[minIdx][pivotColumnIdx]
	for lt(minValue, 0) {
		minIdx++
		minValue = constraintsCol[minIdx] / variables[minIdx][pivotColumnIdx]
	}

	for i := minIdx + 1; i < len(variables)-1; i++ {
		q := constraintsCol[i] / variables[i][pivotColumnIdx]
		if lt(q, 0) {
			continue
		}
		if lt(q, minValue) {
			minIdx = i
			minValue = q
		}
	}
	return minIdx
}

func lt(a, b float64) bool {
	return a < b && math.Abs(a-b) > 0.000001
}

func gt(a, b float64) bool {
	return a > b && math.Abs(a-b) > 0.000001
}
