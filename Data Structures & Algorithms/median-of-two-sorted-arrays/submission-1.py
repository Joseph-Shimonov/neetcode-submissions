class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        A, B = nums1, nums2

        total = len(nums1) + len(nums2)
        half = total // 2

        if len(B) < len(A):
            A, B = B, A
        
        l, r = 0, len(A)-1
        while True:
            a_mid = (l + r) // 2
            b_mid = half - a_mid - 2

            a_left = A[a_mid] if a_mid >= 0 else float("-infinity")
            a_right = A[a_mid+1] if a_mid+1 < len(A) else float("infinity") 
            b_left = B[b_mid] if b_mid >= 0 else float("-infinity")
            b_right = B[b_mid+1] if b_mid+1 < len(B) else float("infinity")

            if a_left <= b_right and b_left <= a_right:
                if total % 2 == 1:
                    return min(a_right, b_right)
                return (max(a_left, b_left) + min(a_right, b_right)) / 2
            
            if b_left > a_right:
                l = a_mid + 1
            else:
                r = a_mid - 1