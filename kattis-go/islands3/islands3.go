package main

import "fmt"

type UnionFind struct {
	ids        []int
	virtual    []bool
	components int
}

func NewUnionFind(size int) UnionFind {
	network := UnionFind{
		ids:        make([]int, size),
		virtual:    make([]bool, size),
		components: 0,
	}
	for i := 0; i < size; i++ {
		network.ids[i] = -1
	}
	return network
}

func (network *UnionFind) AddSite(id int, virtual bool) {
	network.ids[id] = id
	network.virtual[id] = virtual
	if !virtual {
		network.components++
	}
}

func (network *UnionFind) Count() int {
	return network.components
}

func (network *UnionFind) Union(idA, idB int) {
	if network.ids[idA] == network.ids[idB] {
		return
	}

	rootA, depthA := network.Find(idA)
	rootB, depthB := network.Find(idB)

	if rootA == rootB {
		return
	}

	virtualRootA := network.virtual[rootA]
	virtualRootB := network.virtual[rootB]
	if virtualRootA && !virtualRootB {
		network.ids[rootA] = rootB
		return
	}
	if !virtualRootA && virtualRootB {
		network.ids[rootB] = rootA
		return
	}

	if depthA > depthB {
		network.ids[rootB] = rootA
	} else {
		network.ids[rootA] = rootB
	}

	if !virtualRootA && !virtualRootB {
		network.components--
	}
}

func (network *UnionFind) Find(id int) (cursor int, depth int) {
	cursor = network.ids[id]
	depth = 0
	for cursor != network.ids[cursor] {
		cursor = network.ids[cursor]
		depth++
	}
	return cursor, depth
}

// https://open.kattis.com/problems/islands3
func main() {
	var r, c int
	_, _ = fmt.Scanln(&r, &c)

	matrix := make([][]rune, r)
	for i := 0; i < r; i++ {
		matrix[i] = make([]rune, c)

		var str string
		fmt.Scanln(&str)
		copy(matrix[i][:], []rune(str))
	}

	network := NewUnionFind(r * c)
	for i := 0; i < r; i++ {
		for j := 0; j < c; j++ {
			switch matrix[i][j] {
			case 'W':
				continue
			case 'L':
				network.AddSite(i*c+j, false)
			case 'C':
				network.AddSite(i*c+j, true)
			}
		}
	}

	for i := 0; i < r; i++ {
		for j := 0; j < c; j++ {
			switch matrix[i][j] {
			case 'W':
				continue
			case 'L', 'C':
				if i+1 < r {
					south := matrix[i+1][j]
					if south == 'L' || south == 'C' {
						network.Union(i*c+j, (i+1)*c+j)
					}
				}
				if j+1 < c {
					east := matrix[i][j+1]
					if east == 'L' || east == 'C' {
						network.Union(i*c+j, i*c+j+1)
					}
				}
			}
		}
	}
	fmt.Println(network.Count())
}
