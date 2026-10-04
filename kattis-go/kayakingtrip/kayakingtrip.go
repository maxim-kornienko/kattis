package main

import (
	"fmt"
)

type Segment struct {
	station int
	cost    int
}

// https://open.kattis.com/problems/kayakingtrip
func main() {
	var n int
	_, _ = fmt.Scan(&n)

	matrix := make([][]int, n)
	for i := 0; i < n; i++ {
		matrix[i] = make([]int, n)
		for j := i + 1; j < n; j++ {
			_, _ = fmt.Scan(&matrix[i][j])
		}
	}

	bestPath := make([]Segment, n-1)
	bestPath[n-2] = Segment{station: n - 1, cost: matrix[n-2][n-1]}
	for i := n - 3; i >= 0; i-- {
		bestPath[i] = Segment{station: n - 1, cost: matrix[i][n-1]}
		for j := n - 2; j > i; j-- {
			cost := matrix[i][j] + bestPath[j].cost
			if cost < bestPath[i].cost {
				bestPath[i].station = j
				bestPath[i].cost = cost
			}
		}
	}

	i := 0
	fmt.Print("1 ")
	for i < n-1 {
		i = bestPath[i].station
		fmt.Printf("%d", i+1)
		if i != n-1 {
			fmt.Print(" ")
		}
	}
	fmt.Println()
	fmt.Println(bestPath[0].cost)
}
