### 解题思路

使用队列

每次循环将之前队列中的元素（上一层元素）加入到结果列表中，同时将本层的元素放在队列后面，直到队列为空


#### 代码

```java
    public int[] levelOrder(TreeNode root) {
        if (root == null){
            return new int[0];
        }
        Deque<TreeNode> nodes = new ArrayDeque<>();
        nodes.add(root);
        ArrayList<Integer> ans = new ArrayList<>();
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                ans.add(node.val);
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
```
