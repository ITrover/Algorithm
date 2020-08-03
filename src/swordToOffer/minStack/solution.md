### 解题思路

使用两个栈，一个栈保存数据（数据栈），一个栈保存当前数据栈中的最小元素（最小栈）

#### 数据栈

数据栈正常工作

#### 最小栈

1. `push(x)`时，比较x与最小栈栈顶元素的大小
2. 如果x小，那么当前数据栈中的最小值为x，`push(x)`
3. 如果x大，那么当前数据栈中的最小元素依然为最小栈之前的栈顶元素,`push(栈顶元素)`

### 代码

```java
class MinStack {

    public Stack<Integer> data;
    public Stack<Integer> min;

    public MinStack() {
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if (min.size() == 0 || x < min.peek()){
            min.push(x);
        }else {
            min.push(min.peek());
        }
    }

    public void pop() {
        data.pop();
        min.pop();

    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min.peek();
    }

}
```

