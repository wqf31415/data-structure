/**
 * 扩展 Java 数组
 * 解决在 java 中数组无法自动扩容的问题
 */
public class Array {
    private int size;
    private int[] data;

    public Array(int capacity) {
        this.data = new int[capacity];
        this.size = 0;
    }

    public Array(){
        this(10);
    }

    /**
     * 获取元素数量
     * @return
     */
    public int getSize(){
        return this.size;
    }

    /**
     * 获取容量
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在最后面插入元素
     * @param e
     */
    public void addLast(int e){
        if (size == data.length){
            throw new RuntimeException("AddLast failed. Array is full.");
        }
        data[size] = e;
        size ++;
    }


}
