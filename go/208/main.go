package main

type Trie struct {
	next  map[byte]*Trie
	exist bool
}

func Constructor() Trie {
	tree := new(Trie)
	tree.next = make(map[byte]*Trie)
	return *tree
}

func (this *Trie) Insert(word string) {
	for i := range word {
		nt, ok := this.next[word[i]]
		if ok {
			this = nt
		} else {
			tree := Constructor()
			this.next[word[i]] = &tree
			this = this.next[word[i]]
		}
	}
	this.exist = true
}

func (this *Trie) Search(word string) bool {
	for i := range word {
		nt, ok := this.next[word[i]]
		if !ok {
			return false
		}
		this = nt
	}
	return this.exist
}

func (this *Trie) StartsWith(prefix string) bool {
	for i := range prefix {
		nt, ok := this.next[prefix[i]]
		if !ok {
			return false
		}
		this = nt
	}
	return true
}

/**
 * Your Trie object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Insert(word);
 * param_2 := obj.Search(word);
 * param_3 := obj.StartsWith(prefix);
 */

func main() {
	obj := Constructor()
	obj.Insert("ok")
	obj.Search("ok")
	obj.StartsWith("o")
}
