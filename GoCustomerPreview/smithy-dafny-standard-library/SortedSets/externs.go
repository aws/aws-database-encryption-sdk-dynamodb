package SortedSets

import (
	"sort"

	"github.com/dafny-lang/DafnyRuntimeGo/v4/dafny"
)

func SetToOrderedSequence(set dafny.Set, fn func(interface{}, interface{}) bool) dafny.Sequence {
	var arr []interface{}
	for i := set.Iterator(); ; {
		val, notEndOfSequence := i()
		if notEndOfSequence {
			arr = append(arr, val)
		} else {
			sort.Slice(arr, func(i, j int) bool {
				a := arr[i].(dafny.Sequence)
				b := arr[j].(dafny.Sequence)
				for ii, jj := dafny.Iterate(a), dafny.Iterate(b); ; {
					v1, notEndOfSequence1 := ii()
					v2, notEndOfSequence2 := jj()
					if notEndOfSequence1 && notEndOfSequence2 {
						if fn(v1, v2) {
							return true
						}
						if fn(v2, v1) {
							return false
						}
					} else if notEndOfSequence1 {
						return false
					} else if notEndOfSequence2 {
						return true
					} else {
						return false
					}
				}
			})
			return dafny.SeqOf(arr...)
		}
	}
}

func SetToOrderedSequence2(set dafny.Set, fn func(interface{}, interface{}) bool) dafny.Sequence {
	return SetToOrderedSequence(set, fn)
}

func SetToSequence(set dafny.Set) dafny.Sequence {
	var arr []interface{}
	for i := set.Iterator(); ; {
		val, ok := i()
		if ok {
			arr = append(arr, val)
		} else {
			return dafny.SeqOf(arr...)
		}
	}

}
