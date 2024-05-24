class Solution:
    def maxScoreWords(self, words: List[str], letters: List[str], score: List[int]) -> int:
        pool, n = LetterPool(letters, score), len(words)
        max_score = 0

        def backtrack(i, cur_score):
            nonlocal max_score
            if i >= n:
                return
            s = pool.remove(words[i])
            if s != -1:
                max_score = max(max_score, cur_score + s)
                backtrack(i + 1, cur_score + s)
                pool.add(words[i])
            backtrack(i + 1, cur_score)
        
        backtrack(0, 0)
        return max_score

class LetterPool:
    def __init__(self, letters, score):
        self.score = score
        self.counter = [0] * 26
        for letter in letters:
            self.counter[ord(letter) - ord('a')] += 1

    def remove(self, word):
        count = collections.Counter(word)
        s = 0
        for c, v in count.items():
            if v > self.counter[ord(c) - ord('a')]:
                return -1
            s += v * self.score[ord(c) - ord('a')]

        for c, v in count.items():
            self.counter[ord(c) - ord('a')] -= v
        return s

    def add(self, word):
        for c in word:
            self.counter[ord(c) - ord('a')] += 1 

