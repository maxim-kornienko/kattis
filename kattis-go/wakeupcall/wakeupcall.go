package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	var m, n int

	reader := bufio.NewReader(os.Stdin)

	_, _ = fmt.Fscanln(reader, &n, &m)

	button1 := int64(0)
	for i := 0; i < n; i++ {
		var x int
		_, _ = fmt.Fscanf(reader, "%d", &x)
		button1 += int64(x)
	}

	_, _ = reader.ReadString('\n')

	button2 := int64(0)
	for i := 0; i < m; i++ {
		var x int
		_, _ = fmt.Fscanf(reader, "%d", &x)
		button2 += int64(x)
	}

	if button1 > button2 {
		fmt.Println("Button 1")
	} else if button1 < button2 {
		fmt.Println("Button 2")
	} else {
		fmt.Println("Oh no")
	}
}
