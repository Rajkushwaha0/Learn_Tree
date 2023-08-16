class Solution {
    int maxSum=0;
    // List<Integer> l = new ArrayList<>();
    public int maxAncestorDiff(TreeNode root) {
        return solve(root,root.val,root.val);
        // bruteforce(root);
        // return maxSum;
    }
    public void bruteforce(TreeNode root){
        if(root==null) return ;
        l.add(root.val);
        bruteforce(root.left);
        bruteforce(root.right);
        int n=l.get(l.size()-1);
        for(int i=0;i<l.size()-1;i++){
            maxSum=Math.max(maxSum,Math.abs(l.get(i)-n));
        }
        l.remove(l.size()-1);
        return ;
    }
    public int solve(TreeNode root,int currMax , int currMin){
        
        if(root==null) return currMax-currMin;

        currMax=Math.max(currMax,root.val);
        currMin=Math.min(currMin,root.val);

        return Math.max(solve(root.left,currMax,currMin),solve(root.right,currMax,currMin));

    }
}
