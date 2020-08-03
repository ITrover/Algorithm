## 解题思路

- 使HashMap将旧结点和新结点一一对应
- 对next和random赋值，通过旧结点找到新结点，替换新结点的random和next

### 1. hashMap
#### 代码
```java
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<Node, Node>();
        Node p = head;
        while (p != null) {
            map.put(p, new Node(p.val));
            p = p.next;
        }
        p = head;

        while (p != null){
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
    }
```
### 2. hashMap和递归

#### 代码
```java
    public Map<Node,Node> map =  new HashMap<Node,Node>();

    public Node copyRandomList(Node head) {
        return copy(head);
    }
    public Node copy(Node node) {
        if (node == null) {
            return null;
        }
        Node res = new Node(node.val);
        // 记录结点，为了以后设置random
        // 旧结点与新结点，一一对应
        map.put(node, res);
        res.next = copy(node.next);
        // 设置random
        if (node.random != null) {
            // 找到以前random 对应的新结点
            res.random = map.get(node.random);
        } else {
            res.random = null;
        }
        return res;
    }
```

### 3. 把每一个复制结点通过next拼接到原结点的后面
推荐使用
