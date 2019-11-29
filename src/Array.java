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
        return this.data.length;
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty(){
        return this.size == 0;
    }

    /**
     * 在最后面插入元素
     * @param e
     */
    public void addLast(int e){
//        if (size == data.length){
//            throw new RuntimeException("AddLast failed. Array is full.");
//        }
//        data[size] = e;
//        size ++;
        this.add(size,e);
    }

    /**
     * 在指定索引位置插入元素
     * @param index
     * @param e
     */
    public void add(int index, int e){
        if (size == data.length){
            throw new RuntimeException("AddLast failed. Array is full.");
        }
        if (index <0 || index > size){
            throw new RuntimeException("AddLast failed. Require 0 =< index <= size.");
        }
        for (int i = size-1; i>=index; i--){
            // 元素移位
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 在数组头部添加元素
     * @param e
     */
    public void addFirst(int e){
        this.add(0, e);
    }

    /**
     * 获取指定索引的元素
     * @param index
     * @return
     */
    public int get(int index){
        if (index<0 || index>=size){
            throw new RuntimeException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    /**
     * 修改元素
     * @param index
     * @param e
     * @return
     */
    public void set(int index, int e){
        if (index<0 || index >= size){
            throw new RuntimeException("Set failed. Index is illegal.");
        }
        data[index] = e;
    }

    /**
     * 删除元素
     * @param index 要删除元素的索引
     * @return 删除的元素
     */
    public int remove(int index){
        if (index<0 || index>= size){
            throw new RuntimeException("Remove failed. Index is illegal.");
        }
        int temp = data[index];
        // 将指定索引后面的元素都向前移一位
        for (int i = index; i<size-1; i++){
            data[i] = data[i+1];
        }

        // data[size] 处还存在元素，只是访问不到，也不会被 jvm 垃圾回收，被称为闲逛对象，可以将 data[size] 置为空或默认值，来释放该元素
        data[size] = 0;

        this.size--;
        return temp;
    }

    /**
     * 删除首个元素
     * @return
     */
    public int removeFirst(){
        return remove(0);
    }

    /**
     * 删除末尾元素
     * @return
     */
    public int removeLast(){
        return remove(size-1);
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append(String.format("Array size: %d, capacity: %d.\n", size, data.length));
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1){
                sb.append(",");
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
