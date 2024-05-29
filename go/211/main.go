package main

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

/**
 * Your WordDictionary object will be instantiated and called as such:
 * obj := Constructor();
 * obj.AddWord(word);
 * param_2 := obj.Search(word);
 */
func main() {
	obj := Constructor()
	obj.AddWord("a")
	obj.AddWord("ab")
	print(obj.Search("a"))
	print(obj.Search(".es."))
}
