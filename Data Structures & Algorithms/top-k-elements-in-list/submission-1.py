class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        dict = {}
        for element in nums:
            if element not in dict:
                dict[element] = 1
            else:
                dict[element] += 1
        arr = []
        for element, freq in dict.items():
            arr.append([freq, element])
        arr.sort()
        res = []
        while len(res) < k:
            res.append(arr.pop()[1])
        return res
