package main

import (
	"bufio"
	"fmt"
	"os"
)

// https://open.kattis.com/problems/bigboxes
func main() {
	var n, k int

	reader := bufio.NewReader(os.Stdin)

	_, _ = fmt.Fscanln(reader, &n, &k)

	weights := make([]int64, n)
	totalWeight := int64(0)
	maxWeight := int64(0)
	for i := 0; i < n; i++ {
		var weight int64
		_, _ = fmt.Fscanf(reader, "%d", &weight)
		weights[i] = weight
		totalWeight += weight
		if weight > maxWeight {
			maxWeight = weight
		}
	}

	minCapacity := maxWeight
	maxCapacity := totalWeight

	for minCapacity != maxCapacity {
		capacity := (maxCapacity + minCapacity) / 2
		if check(weights, k, capacity) {
			maxCapacity = capacity
		} else {
			minCapacity = capacity + 1
		}
	}
	fmt.Println(minCapacity)
}

func check(weights []int64, k int, capacity int64) bool {
	var currentWeight int64 = 0
	for i := 0; i < len(weights); i++ {
		if weights[i] > capacity {
			return false
		}
		if currentWeight+weights[i] > capacity {
			k--
			if k <= 0 {
				return false
			}
			currentWeight = weights[i]
		} else {
			currentWeight += weights[i]
		}
	}
	return true
}
