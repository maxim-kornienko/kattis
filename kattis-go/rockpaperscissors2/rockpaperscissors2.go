package main

import (
	"fmt"
)

// https://open.kattis.com/problems/rockpaperscissors2
func main() {
	var p1 string
	var p2 string

	_, _ = fmt.Scan(&p1)
	_, _ = fmt.Scan(&p2)

	var result = compare(p1, p2)
	if result > 0 {
		fmt.Println("Player 1")
	} else if result < 0 {
		fmt.Println("Player 2")
	} else {
		fmt.Println("Draw")
	}
}

func compare(p1, p2 string) int {
	if p1 == p2 {
		return 0
	}
	if p1 == "rock" {
		if p2 == "scissors" {
			return 1
		}
		if p2 == "paper" {
			return -1
		}
	}
	if p1 == "scissors" {
		if p2 == "rock" {
			return -1
		}
		if p2 == "paper" {
			return 1
		}
	}

	if p1 == "paper" {
		if p2 == "scissors" {
			return -1
		}
		if p2 == "rock" {
			return 1
		}
	}
	return 0
}
