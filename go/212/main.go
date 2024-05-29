package main

import "fmt"

type WordDictionary struct {
	exists bool
	next   [26]*WordDictionary
}

func Constructor() WordDictionary {
	dict := new(WordDictionary)
	return *dict
}

func (this *WordDictionary) AddWord(word string) {
	for i := range word {
		idx := word[i] - 'a'
		if this.next[idx] == nil {
			this.next[idx] = new(WordDictionary)
		}
		this = this.next[idx]
	}
	this.exists = true
}

func (this *WordDictionary) Search(word string) bool {
	return this.search(word, 0)
}

func (this *WordDictionary) search(word string, start int) bool {
	if this == nil {
		return false
	}
	if start == len(word) {
		return this.exists
	}
	if word[start] == '.' {
		for i := 0; i < 26; i++ {
			if this.next[i].search(word, start+1) {
				return true
			}
		}
		return false
	} else {
		return this.next[word[start]-'a'].search(word, start+1)
	}
}

func (this *WordDictionary) grow(c byte) *WordDictionary {
	return this.next[c]
}

func findWords(board [][]byte, words []string) []string {
	wd := new(WordDictionary)
	for _, s := range words {
		wd.AddWord(s)
	}
	res := new(WordDictionary)
	m, n := len(board), len(board[0])
	v := make([][]bool, m)
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			v[i] = append(v[i], false)
		}
	}
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			path := make([]byte, 0)
			dfs(board, v, wd, i, j, res, &path)
		}
	}
	return wd2l(res)
}

func dfs(board [][]byte, v [][]bool, t *WordDictionary, i int, j int, res *WordDictionary, path *[]byte) {
	if 0 > i || 0 > j || len(board) <= i || len(board[0]) <= j {
		return
	}
	if v[i][j] {
		return
	}
	t = t.next[board[i][j]-'a']
	if t == nil {
		return
	}
	v[i][j] = true
	*path = append(*path, board[i][j])
	if t.exists {
		res.AddWord(string(*path))
	}
	dfs(board, v, t, i+1, j, res, path)
	dfs(board, v, t, i, j+1, res, path)
	dfs(board, v, t, i-1, j, res, path)
	dfs(board, v, t, i, j-1, res, path)
	*path = (*path)[:len(*path)-1]
	v[i][j] = false
}

func wd2l(wd *WordDictionary) []string {
	l := make([]string, 0)
	path := make([]byte, 0)
	dfs2(wd, &path, &l)
	return l
}

func dfs2(wd *WordDictionary, path *[]byte, l *[]string) {
	if wd == nil {
		return
	}
	if wd.exists {
		*l = append(*l, string(*path))
	}
	for i := 0; i < 26; i++ {
		if wd.next[i] != nil {
			*path = append(*path, byte(i+'a'))
			dfs2(wd.next[i], path, l)
			*path = (*path)[:len(*path)-1]
		}
	}
}

func main() {
	board := [][]byte{
		{'o', 'a', 'a', 'n'},
		{'e', 't', 'a', 'e'},
		{'i', 'h', 'k', 'r'},
		{'i', 'f', 'l', 'v'},
	}
	words := []string{"oath", "pea", "eat", "rain"}
	fmt.Print(findWords(board, words))
}
