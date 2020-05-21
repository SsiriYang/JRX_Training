---
layout: Post
title: "Java集合"
date: 2020-5-15 0:44
comments: true
tags: 
	- Java集合(Java Util包)

---



**Java**集合类的四个体系，由两大接口衍生而来，Collection接口和Map接口。

**Collection ：**单个存放

**Map:成对存放 key  value** 

# Collection接口

单个存取。

接口定义的主要方法：

- size() - 集合内的对象数量
- add(E)/addAll(Collection) - 向集合内添加单个/批量对象
- remove(Object)/removeAll(Collection) - 从集合内删除单个/批量对象
- contains(Object)/containsAll(Collection) - 判断集合中是否存在某个/某些对象
- toArray() - 返回包含集合内所有对象的数组

等。

## List类集合

List接口继承自Collection,List接口为集合中的每个对象分配了一个索引(index)，标记该对象在List中的位置，并可以通过index定位到指定位置的对象。

List在Collection基础上增加的主要方法包括：

- get(int) - 返回指定index位置上的对象

- add(E)/add(int, E) - 在List末尾/指定index位置上插入一个对象

- set(int, E) - 替换置于List指定index位置上的对象

- indexOf(Object) - 返回指定对象在List中的index位置

- subList(int,int) - 返回指定起始index到终止index的子List对象

  等。

  



###   ArrayList 

类图：

![](/assets/blogImg/ArrayList.png)



基于数组实现的非线程安全的集合。查询元素快，插入，删除中间元素慢。

#### ArrayList的构造函数

ArrayList类支持3个构造方法。

- `Arraylist()`

这个构造方法构造了一个空的链表。

- `ArrayList(Collection c)`

这个构造方法构造了一个包含指定元素集合的链表。

- `ArrayList(int initialCapacity)`

这是第三个构造方法，构造了一个指定大小但内容为空的链表。initialCapacity参数就是初始容量大小。

举例来说，如果你要创建一个空的数组链表，用来存放String类型的对象，那么你可以像下面这样做：

```
ArrayList<String> list = new ArrayList<String>();
```

如果你需要创建一个指定初始容量的数组链表，你可以像下面这样做：

```
ArrayList<Integer> list = new ArrayList<Integer>(7);
```



#### ArrayList常用方法

下面是是一些比较常用的ArrayList类成员方法：

##### 增添元素

- `boolean add(Element e)`
  增加指定元素到链表尾部.

- `void add(int index, Element e)`
  增加指定元素到链表指定位置.

##### 删除元素

- `void clear()`
  从链表中删除所有元素.

- `E remove(int index)`
  删除链表中指定位置的元素.

- `protected void removeRange(int start, int end)`
  删除链表中从某一个位置开始到某一个位置结束的元素。

##### 查找元素

- `E get(int index)`
  获取链表中指定位置处的元素.
- `boolean contains(Object o)`
  如果链表包含指定元素，返回true.

- `int indexOf(Object o)`
  返回元素在链表中第一次出现的位置，如果返回-1，表示链表中没有这个元素。

- `int lastIndexOf(Object o)`
  返回元素在链表中最后一次出现的位置，如果返回-1，表示链表中没有这个元素。

##### 修改某个元素

- `E set(int index, E element)`
  将链表中指定位置上的元素替换成新元素。

##### 其他方法

- 检查链表是否为空
  - `boolean isEmpty()`
    返回true表示链表中没有任何元素.

- 获取链表大小
  - `int size()`
    返回链表长度（链表包含元素的个数）.
- 将链表转换为一个数组

`Object[] toArray()`
 	获取一个数组，数组中所有元素是链表中的元素.（即将链表转换为一个数组）

#### ArrayList学习Demo:

```Java
public static void main(String[] args) {
        // 创建一个空的数组链表对象list，list用来存放String类型的数据
        ArrayList<String> list = new ArrayList<String>();
        // 增加元素到list对象中
        list.add("One");
        list.add("Two");
        list.add(2, "Three"); // 此条语句将会把“Item3”字符串增加到list的第3个位置。
        list.add("Four");

        // 显示数组链表中的内容
        System.out.println("数组链表中的内容是: "
                + list);

        // 检索元素的位置
        int pos = list.indexOf("Two");
        System.out.println(" Two 再数组链表中的位置: " + pos);

        // 检查数组链表是否为空
        boolean check = list.isEmpty();
        System.out.println("检查数组链表是否为空: " + check);

        // 获取链表的大小
        int size = list.size();
        System.out.println("链表的大小: " + size);

        // 检查数组链表中是否包含某元素
        boolean element = list.contains("Five");
        System.out
                .println("数组链表中是否包含'Five'元素: "
                        + element);

        // 获取指定位置上的元素
        String item = list.get(0);
        System.out.println("数组链表中索引为零元素: " + item);

        // 遍历arraylist中的元素

        // 第1种方法: 循环使用元素的索引和链表的大小
        System.out.println("循环使用元素的索引和链表的大小");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Index: " + i + " - Item: " + list.get(i));
        }

        // 第2种方法:使用foreach循环
        System.out.println("使用foreach循环");
        for (String str : list) {
            System.out.println("Item is: " + str);
        }

        // 第三种方法:使用迭代器
        // hasNext(): 返回true表示链表链表中还有元素
        // next(): 返回下一个元素
        System.out.println("使用迭代器遍历:");
        for (Iterator<String> it = list.iterator(); it.hasNext();) {
            System.out.println("Item is: " + it.next());
        }

        // 替换元素
        list.set(1, "NewOne");
        System.out.println("替换过后的数组链表是 " + list);

        // 移除元素
        // 移除第0个位置上的元素
        list.remove(0);

        // 移除第一次找到的 "Item3"元素
        list.remove("Three");

        System.out.println("The final contents of the arraylist are: " + list);

        // 转换 ArrayList 为 Array
        String[] simpleArray = list.toArray(new String[list.size()]);
        System.out.println("arraylist的最终内容是: "
                + Arrays.toString(simpleArray));
    }
```



###   LinkedList

类图：

![](/assets/blogImg/LinkedList.png)

基于链表实现的非线程安全的集合。查询元素慢，插入，删除中间元素快。

#### LinkedList的构造函数

LinkedList类中有两个构造方法。

- `LinkedList()`

  这个构造方法创建一个空链表

- `LinkedList(Collection c)`

  由给定集合创建一个链表

#### LinkedList常用方法

##### 增添元素

- `boolean add(E e)`：将指定元素添加到链表末尾
- `void add(int index, E e)`：将指定元素插入到链表的指定位置
- `boolean addAll(Collection c)`：将指定集合中的所有元素添加到链表末尾
- `boolean addAll(int index, Collection c)`：将指定集合中的所有元素从指定位置开始插入链表
- `void addFirst(E e)`：将指定元素插入到链表的开始
- `void addLast(E e)`：将指定元素添加到链表的末尾

##### 删除元素

- `void clear()`：移除链表中的所有元素
- `E remove()`：移除链表的第一个元素，并返回该元素
- `E remove(int index)`：移除链表中指定位置处的元素，并返回该元素
- `boolean remove(E e)`：若元素存在则从链表中该元素第一次出现的位置移除该元素
- `E removeFirst()`：移除链表的第一个元素，并返回该元素
- `boolean removeFirstOccourence(E e)`：从链表中移除指定元素第一次出现位置处的元素（以正序遍历）
- `E removeLast()`：移除链表最后一个元素，并返回该元素
- `boolean removeLastOccourence(E e)`：从链表中移除指定元素最后一次出现位置处的元素（以正序遍历）

##### 查找元素

- `boolean contains(E e)`：判断链表中是否存在指定元素
- `E get(int index)`：返回链表中指定位置的元素
- `E getFirst()`：返回链表的第一个元素
- `E getLast()`：返回链表的最后一个元素
- `int indexOf(E e)`：返回指定元素在链表中第一次出现的位置，若未找到则返回-1
- `int lastIndexOf(E e)`：返回指定元素在链表中最后一次出现的位置，若未找到则返回-1

##### 修改元素

- `E set(int index, E e)`：将链表中指定位置处的元素修改为指定的元素，返回被替换的元素

##### 其他方法

- `int size()`：返回链表中包含的元素的数量
- `Object clone()`：返回该链表的浅拷贝
- `Object[] toArray()`：以适当的顺序（从第一个元素到最后一个元素）返回包含此链表中所有元素的数组

#### LinkedList学习Demo:

```Java
public static void main(String[] args) {
        // 创建一个空的双向链表对象linkedList
        LinkedList<String> linkedList = new LinkedList<>();
        System.out.println("新建的linkedList："+linkedList);
        //添加一个元素a
        boolean result = linkedList.add("a");
        System.out.println("添加元素a至链表末尾："+linkedList);
        //向头部插入一个元素b
        linkedList.addFirst("b");
        System.out.println("添加b元素至链表头部尾："+linkedList);
        //向指定位置插入一个元素c
        linkedList.add(1, "c");
        System.out.println("向索引1处添加c："+linkedList);

        //将指定集合中的所有元素添加到链表末尾
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        result = linkedList.addAll(list);
        System.out.println("将一个集合添加至链表末尾："+linkedList);
        //移除链表的第一个元素，并返回该元素
        String firstElement = linkedList.remove();
        System.out.println("移除链表的第一个元素，并返回该元素："+firstElement);
        //移除链表中指定位置处的元素，并返回该元素
        String specifiedIndexElement = linkedList.remove(3);
        System.out.println("移除链表中指定位置处的元素，并返回该元素："+specifiedIndexElement);
        //若元素存在则从链表中该元素第一次出现的位置移除该元素
        result = linkedList.remove("a");
        //判断链表中是否存在指定元素
        result = linkedList.contains("b");
        System.out.println("判断链表中是否存在'b'元素："+result);
        //返回链表中指定位置的元素
        String specifiedElement = linkedList.get(2);
        System.out.println("返回链表中位置2的元素："+result);
        //返回链表的最后一个元素
        String lastElement = linkedList.getLast();
        System.out.println("返回链表的最后一个元素："+lastElement);
        //返回指定元素在链表中第一次出现的位置，若未找到则返回-1
        int index = linkedList.indexOf("b");
        //将链表中指定位置处的元素修改为指定的元素，返回被替换的元素
        String element = linkedList.set(1, "a");
        //返回链表中包含的元素的数量
        int sizeOfLinkedList = linkedList.size();
        System.out.println("返回链表中包含的元素的数量："+sizeOfLinkedList);
        //以适当的顺序（从第一个元素到最后一个元素）返回包含此链表中所有元素的数组
        Object[] elements = linkedList.toArray();
//        System.out.println("将链表转为数组："+elements[1]);
    }
```

### Vector

类图：

![](/assets/blogImg/Vector.png)

Vector和ArrayList很像，都是基于数组实现的集合，它和ArrayList的主要区别在于

- Vector是线程安全的，而ArrayList不是
- 由于Vector中的方法基本都是synchronized的，其性能低于ArrayList
- Vector可以定义数组长度扩容的因子，ArrayList不能

Vector再实际中已基本不被使用，不做过多了解。



### CopyOnWriteArrayList

类图：

![](/assets/blogImg/CopyOnWriteArrayList.png)

与 Vector一样，CopyOnWriteArrayList也可以认为是ArrayList的线程安全版，不同之处在于 CopyOnWriteArrayList在写操作时会先复制出一个副本，在新副本上执行写操作，然后再修改引用。这种机制让 CopyOnWriteArrayList可以对读操作不加锁，这就使CopyOnWriteArrayList的读效率远高于Vector。 CopyOnWriteArrayList的理念比较类似读写分离，适合读多写少的多线程场景。但要注意，CopyOnWriteArrayList只能保证数据的最终一致性，并不能保证数据的实时一致性，如果一个写操作正在进行中且并未完成，此时的读操作无法保证能读到这个写操作的结果。

**Vector 和 CopyOnWriteArrayList异同**：

二者均是线程安全的、基于数组实现的List

Vector是【绝对】线程安全的，CopyOnWriteArrayList只能保证读线程会读到【已完成】的写结果，但无法像Vector一样实现读操作的【等待写操作完成后再读最新值】的能力

CopyOnWriteArrayList读性能远高于Vector，并发线程越多优势越明显

CopyOnWriteArrayList占用更多的内存空间

## Set类集合

Set 接口继承Collection，用于存储不含重复元素的集合。几乎所有的Set实现都是基于同类型Map的，简单地说，Set是阉割版的Map。每一个Set内都有一个同类型的Map实例（CopyOnWriteArraySet除外，它内置的是CopyOnWriteArrayList实例），Set把元素作为key存储在自己的Map实例中，value则是一个空的Object。Set的常用实现也包括 HashSet、TreeSet、ConcurrentSkipListSet等，原理和对应的Map实现完全一致。

### HashSet

类图：

![](/assets/blogImg/HashSet.png)

底层用HashMap实现，是一个无序，不可重复的数组散列。

#### HashSet的构造方法

HashSet提供了四个构造方法:

- HashSet（）

  无参数的构造函数，此构造函数创建一个大小为16的容器，加载因子为0.75

- HashSet(Collection<? extends E> c)
  构造一个包含指定集合中的元素的新集合。  

- HashSet(int initialCapacity)
  构造一个新的空集合; 背景HashMap实例具有指定的初始容量和默认负载因子（0.75）

- HashSet(int initialCapacity, float loadFactor)
  构造一个新的空集合; 背景HashMap实例具有指定的初始容量和指定的负载因子。 

#### HashSet的常用方法

- add(Object obj)方法（详述）：向Set集合中添加元素，添加成功返回true，否则返回false
- size() 方法：返回Set集合中的元素个数

- remove(Object  obj)方法 ： 删除Set集合中的元素，删除成功返回true，否则返回false。

- isEmpty()方法 ：如果Set不包含元素，则返回 true ，否则返回false

- clear() 方法： 移除此Set中的所有元素

- iterator() 迭代器：（它不保证 set 的迭代顺序；特别是它不保证该顺序恒久不变）
  - hashNext如果仍有元素可以返回就返回true
  - Next()返回迭代的下一个元素
  - remove()从迭代器指向的的collection中移除迭代器返回的最后一个元素
- contains(Object o)方法：如果Set包含指定的元素，则返回 true，否则返回false

#### HashSet的学习Demo

```
public static void main(String[] args) {
    HashSet<String> hashSet = new HashSet<String>();
    hashSet.add("张三");
    hashSet.add("李四");
    hashSet.add("王五");
    //打印当前set的size
    System.out.println(hashSet.size());
    Iterator it = hashSet.iterator();
    while (it.hasNext()){
        System.out.println(it.next());
    }
    for (String name : hashSet) {    //输出set集合中的元素
        System.out.println(name);
    }
    Boolean res = hashSet.add("王五");
    System.out.println("插入重复元素结果："+res);
}
```

### TreeSet

类图：

![](/assets/blogImg/TreeSet.png)

底层用TreeMap实现的。是一个有序不可重复的二叉树

#### TreeSet的构造方法

TreeSet提供了四个构造方法:

- TreeSet()

  默认构造函数。使用该构造函数，TreeSet中的元素按照自然排序进行排列。

- TreeSet(Collection<? extends E> collection)

  此构造函数生成树的集合，它包含的元素的集合 c。

- TreeSet(Comparator<? super E> comparator)

  此构造函数构造一个空树集，将根据给定的比较器进行排序。

- TreeSet(SortedSet set)

  此构造函数生成包含给定 SortedSet 的元素 TreeSet

#### TreeSet的常用方法

- add()：向Set集合中添加元素，添加成功返回true，否则返回false
- addAll()：将指定集合中的所有元素添加到此集合中。
- remove()：删除Set集合中的元素，删除成功返回true，否则返回false。
- size()：	返回此集合中的元素数。
- isEmpty()：set判空
- ceiling()：返回此set中大于或等于给定元素的最小元素，或者null如果没有这样的元素。
- floor()：返回此set中小于或等于给定元素的最大元素，或者null如果没有这样的元素。
- lower()：返回此集合中的最大元素严格小于给定元素，或者null如果没有这样的元素。
- contains（Object  o）：如果Set包含指定的元素，则返回 true，否则返回false\

#### TreeSet的学习Demo

```
public static void testTreeSetAPIs() {
    String val;

    // 新建TreeSet
    TreeSet tSet = new TreeSet();
    // 将元素添加到TreeSet中
    tSet.add("aaa");
    // Set中不允许重复元素，所以只会保存一个“aaa”
    tSet.add("aaa");
    tSet.add("bbb");
    tSet.add("eee");
    tSet.add("ddd");
    tSet.add("ccc");
    System.out.println("TreeSet:"+tSet);

    // 打印TreeSet的实际大小
    System.out.printf("size : %d\n", tSet.size());

    // 导航方法
    // floor(小于、等于)
    System.out.printf("floor bbb: %s\n", tSet.floor("bbb"));
    // lower(小于)
    System.out.printf("lower bbb: %s\n", tSet.lower("bbb"));
    // ceiling(大于、等于)
    System.out.printf("ceiling bbb: %s\n", tSet.ceiling("bbb"));
    System.out.printf("ceiling eee: %s\n", tSet.ceiling("eee"));
    // ceiling(大于)
    System.out.printf("higher bbb: %s\n", tSet.higher("bbb"));
    // subSet()
    System.out.printf("subSet(aaa, true, ccc, true): %s\n", tSet.subSet("aaa", true, "ccc", true));
    System.out.printf("subSet(aaa, true, ccc, false): %s\n", tSet.subSet("aaa", true, "ccc", false));
    System.out.printf("subSet(aaa, false, ccc, true): %s\n", tSet.subSet("aaa", false, "ccc", true));
    System.out.printf("subSet(aaa, false, ccc, false): %s\n", tSet.subSet("aaa", false, "ccc", false));
    // headSet()
    System.out.printf("headSet(ccc, true): %s\n", tSet.headSet("ccc", true));
    System.out.printf("headSet(ccc, false): %s\n", tSet.headSet("ccc", false));
    // tailSet()
    System.out.printf("tailSet(ccc, true): %s\n", tSet.tailSet("ccc", true));
    System.out.printf("tailSet(ccc, false): %s\n", tSet.tailSet("ccc", false));


    // 删除“ccc”
    tSet.remove("ccc");
    // 将Set转换为数组
    String[] arr = (String[])tSet.toArray(new String[0]);
    for (String str:arr) {
        System.out.printf("for each : %s\n", str);
    }
    // 打印TreeSet
    System.out.printf("TreeSet:%s\n", tSet);

    // 遍历TreeSet
    for(Iterator iter = tSet.iterator(); iter.hasNext(); ) {
        System.out.printf("iter : %s\n", iter.next());
    }

    // 删除并返回第一个元素
    val = (String)tSet.pollFirst();
    System.out.printf("pollFirst=%s, set=%s\n", val, tSet);

    // 删除并返回最后一个元素
    val = (String)tSet.pollLast();
    System.out.printf("pollLast=%s, set=%s\n", val, tSet);

    // 清空HashSet
    tSet.clear();

    // 输出HashSet是否为空
    System.out.printf("%s\n", tSet.isEmpty()?"set is empty":"set is not empty");
}
```

## Queue/Deque类集合

Queue和Deque接口继承Collection接口，实现FIFO（先进先出）的集合。二者的区别在于，Queue只能在队尾入队，队头出队，而Deque接口则在队头和队尾都可以执行出/入队操作。

Queue接口常用方法：

- add(E)/offer(E)：入队，即向队尾追加元素，二者的区别在于如果队列是有界的，add方法在队列已满的情况下会抛出IllegalStateException，而offer方法只会返回false
- remove()/poll()：出队，即从队头移除1个元素，二者的区别在于如果队列是空的，remove方法会抛出NoSuchElementException，而poll只会返回null
- element()/peek()：查看队头元素，二者的区别在于如果队列是空的，element方法会抛出NoSuchElementException，而peek只会返回null

Deque接口常用方法：

- addFirst(E) / addLast(E) / offerFirst(E) / offerLast(E)
- removeFirst() / removeLast() / pollFirst() / pollLast()
- getFirst() / getLast() / peekFirst() / peekLast()
- removeFirstOccurrence(Object) / removeLastOccurrence(Object)

### Queue接口的常用实现类：

#### ConcurrentLinkedQueue

类图：

![](/assets/blogImg/ConcurrentLinkedQueue.png)

ConcurrentLinkedQueue是基于链表实现的队列，队列中每个Node拥有到下一个Node的引用：

```cpp
private static class Node<E> {
        volatile E item;
        volatile Node<E> next;
}
```

由于Node类的成员都是volatile的，所以ConcurrentLinkedQueue自然是线程安全的。能够保证入队和出队操作的原子性和一致性，但在遍历和size()操作时只能保证数据的弱一致性。

#### LinkedBlockingQueue

类图：

![](/assets/blogImg/LinkedBlockingQueue.png)

与ConcurrentLinkedQueue不同，LinkedBlocklingQueue是一种无界的阻塞队列。所谓阻塞队列，就是在入队时如果队列已满，线程会被阻塞，直到队列有空间供入队再返回；同时在出队时，如果队列已空，线程也会被阻塞，直到队列中有元素供出队时再返回。LinkedBlocklingQueue同样基于链表实现，其出队和入队操作都会使用ReentrantLock进行加锁。所以本身是线程安全的，但同样的，只能保证入队和出队操作的原子性和一致性，在遍历时只能保证数据的弱一致性。

#### ArrayBlockingQueue

类图：

![](/assets/blogImg/ArrayBlockingQueue.png)

ArrayBlockingQueue是一种有界的阻塞队列，基于数组实现。其同步阻塞机制的实现与LinkedBlocklingQueue基本一致，区别仅在于前者的生产和消费使用同一个锁，后者的生产和消费使用分离的两个锁。

**ConcurrentLinkedQueue vsLinkedBlocklingQueue vs ArrayBlockingQueue**

> - ConcurrentLinkedQueue是非阻塞队列，其他两者为阻塞队列
> - 三者都是线程安全的
> - LinkedBlocklingQueue是无界的，适合实现不限长度的队列， ArrayBlockingQueue适合实现定长的队列

#### SynchronousQueue

类图：

![](/assets/blogImg/SynchronousQueue.png)

SynchronousQueue算是JDK实现的队列中比较奇葩的一个，它不能保存任何元素，size永远是0，peek()永远返回null。向其中插入元素的线程会阻塞，直到有另一个线程将这个元素取走，反之从其中取元素的线程也会阻塞，直到有另一个线程插入元素。

这种实现机制非常适合传递性的场景。也就是说如果生产者线程需要及时确认到自己生产的任务已经被消费者线程取走后才能执行后续逻辑的场景下，适合使用SynchronousQueue。

#### PriorityQueue & PriorityBlockingQueue

PriorityQueue 类图：

![](/assets/blogImg/PriorityQueue.png)

PriorityBlockingQueue类图：

![](/assets/blogImg/PriorityBlockingQueue.png)

这两种Queue并不是FIFO队列，而是根据元素的优先级进行排序，保证最小的元素最先出队，也可以在构造队列时传入Comparator实例，这样PriorityQueue就会按照Comparator实例的要求对元素进行排序。

PriorityQueue是非阻塞队列，也不是线程安全的，PriorityBlockingQueue是阻塞队列，同时也是线程安全的。

public class PriorityQueueTest {

```Java
public static void main(String[] args) {
    //声明一个PriorityQueue
    PriorityQueue priorityQueue = new PriorityQueue();
    priorityQueue.offer(6);//入队
    priorityQueue.offer(-3);
    priorityQueue.offer(20);
    priorityQueue.offer(18);
    System.out.println(priorityQueue);
    //队列不为空取出元素
    while(!priorityQueue.isEmpty()){
		//poll方法取出且删除
        //peek()方法取出队列头部元素时候，不删除该元素
        System.out.println(priorityQueue.poll());
    }
}
```



## Collections工具类

- addAll(Collection<? super T> c, T... elements) 

​     将所有指定元素添加到指定 collection 中。

- binarySearch(List<? extends Comparable<? super T>> list, T key) 

​     使用二分搜索法搜索指定列表，以获得指定对象。

- copy(List<? super T> dest, List<? extends T> src) 

​     将所有元素从一个列表复制到另一个列表。

- fill(List<? super T> list, T obj) 

​     使用指定元素替换指定列表中的所有元素。

- max(Collection<? extends T> coll) 

​     根据元素的自然顺序，返回给定 collection 的最大元素。

- replaceAll(List<T> list, T oldVal, T newVal) 

​     使用另一个值替换列表中出现的所有某一指定值。

- reverse(List<?> list) 

​     反转指定列表中元素的顺序。

- shuffle(List<?> list) 

​     使用默认随机源对指定列表进行置换。

- sort(List<T> list) 

​     根据元素的自然顺序 对指定列表按升序进行排序。  

- sort(List<T> list, Comparator<? super T> c) 

​     根据指定比较器产生的顺序对指定列表进行排序。  

- swap(List<?> list, int i, int j) 

​     在指定列表的指定位置处交换元素。

## Comparator比较器

Comparable 内部比较器，需要对象去实现该接口，重写其方法

Comparator  外部比较器，不需要参与比较的对象去实现该接口



## Arrays工具类

操作数组的工具类

- inarySearch(byte[] a, byte key) 

​     使用二分搜索法来搜索指定的 byte 型数组，以获得指定的值。

- asList(T... a) 

​     返回一个受指定数组支持的固定大小的列表。

- copyOf(boolean[] original, int newLength) 

​     复制指定的数组，截取或用 false 填充（如有必要），以使副本具有指定的长度。

- copyOfRange(boolean[] original, int from, int to) 

​     将指定数组的指定范围复制到一个新数组。

- equals(boolean[] a, boolean[] a2) 

​     如果两个指定的 boolean 型数组彼此相等，则返回 true。

- fill(boolean[] a, boolean val) 

​     将指定的 boolean 值分配给指定 boolean 型数组的每个元素。

- sort(long[] a) 

​     对指定的 long 型数组按数字升序进行排序。

- sort(T[] a, Comparator<? super T> c) 

​      根据指定比较器产生的顺序对指定对象数组进行排序。

# Map接口

成对存放(key,value)

Map接口在Collection的基础上，为其中的每个对象指定了一个key，并使用Entry保存每个key-value对，以实现通过key快速定位到对象(value)。Map接口的主要方法包括：

- size() - 集合内的对象数量
- put(K,V)/putAll(Map) - 向Map内添加单个/批量对象
- get(K) - 返回Key对应的对象
- remove(K) - 删除Key对应的对象
- keySet() - 返回包含Map中所有key的Set
- values() - 返回包含Map中所有value的Collection
- entrySet() - 返回包含Map中所有key-value对的EntrySet
- containsKey(K)/containsValue(V) - 判断Map中是否存在指定key/value

## HashMap

类图：

![](/assets/blogImg/HashMap.png)

HashMap将Entry对象存储在一个数组中，并通过哈希表来实现对Entry的快速访问：![img](https://upload-images.jianshu.io/upload_images/4840514-d6fce6bccc24a362.png?imageMogr2/auto-orient/strip|imageView2/2/w/243/format/webp)

由每个Entry中的key的哈希值决定该Entry在数组中的位置。以这种特性能够实现通过key快速查找到Entry，从而获得该key对应的value。在不发生哈希冲突的前提下，查找的时间复杂度是O(1)。

如果两个不同的key计算出的index是一样的，就会发生两个不同的key都对应到数组中同一个位置的情况，也就是所谓的哈希冲突。HashMap处理哈 希冲突的方法是拉链法，也就是说数组中每个位置保存的实际是一个Entry链表，链表中每个Entry都拥有指向链表中后一个Entry的引用。在发生哈希冲突时，将冲突的Entry追加至链表的头部。当HashMap在寻址时发现某个key对应的数组index上有多个Entry，便会遍历该位置上的 Entry链表，直到找到目标的Entry。

注意：JDK1.8 以后在解决哈希冲突时有了较大的变化，当链表长度大于阈值（默认为 8）时，将链表转化为红黑树（将链表转换成红黑树前会判断，如果当前数组的长度小于 64，那么会选择先进行数组扩容，而不是转换为红黑树），以减少搜索时间，具体可以参考 `treeifyBin`方法。

### HashMap的构造方法

HashMap提供了四个构造方法：

- HashMap()

  无参构造方法

- HashMap(int initialCapacity)

  有一个初始容量参数的构造方法

- HashMap(int initialCapacity, float loadFactor)

  参数：initialCapacity 初始容量

  参数：loadFactor 负载因子

- HashMap(Map<? extends K, ? extends V> m)

  有一个Map类型的参数的构造方法

### HashMap的常用方法

- put(K key, V value)：存放键值对
- containsKey(Object key)：键中是否包含这个数据
- get(Object key)：通过键拿值
- isEmpty()：判空、
- remove(Object key)：从键值中删除
- keySet()：获取key的集合
- map.values()：获取value的集合
- map.entrySet():获取映射集合（键值的集合）
- clear()：清空

### HashMap的学习Demo

```Java
public static void main(String[] args) {
    HashMap<String, String> map = new HashMap<>();
    map.put("zhang", "31");//存放键值对

    System.out.println(map.containsKey("zhang"));//键中是否包含这个数据
    System.out.println(map.containsKey("daniu"));
    System.out.println("=========================");

    System.out.println(map.get("zhang"));//通过键拿值
    System.out.println(map.get("daniu"));
    System.out.println("=========================");

    System.out.println(map.isEmpty());//判空
    System.out.println(map.size());
    System.out.println("=========================");

    System.out.println(map.remove("zhang"));//从键值中删除
    System.out.println(map.containsKey("zhang"));
    System.out.println(map.get("zhang"));//获取值
    System.out.println(map.isEmpty());
    System.out.println(map.size());
    System.out.println("=========================");

    map.put("zhang", "31");
    System.out.println(map.get("zhang"));
    map.put("zhang", "32");
    System.out.println(map.get("zhang"));
    System.out.println("=========================");

    map.put("zhang", "31");
    map.put("cheng", "32");
    map.put("yun", "33");
    //获取map集合的所有键的set集合，即为map中所有key值得集合
    for (String key : map.keySet()) {
        System.out.println(key);
    }
    System.out.println("=========================");
    //获取map集合的所有键的值集合，即为map中所有value值得集合
    for (String values : map.values()) {
        System.out.println(values);
    }
    System.out.println("=========================");

    map.clear();
    map.put("A", "1");
    map.put("B", "2");
    map.put("C", "3");
    map.put("D", "1");
    map.put("E", "2");
    map.put("F", "3");
    map.put("G", "1");
    map.put("H", "2");
    map.put("I", "3");
    //获取键和值的集合
    for (Entry<String, String> entry : map.entrySet()) {
        String key = entry.getKey();
        String value = entry.getValue();
        System.out.println(key + "," + value);
    }
    System.out.println("=========================");


    List<String> removeKeys = new ArrayList<String>();
    for (Entry<String, String> entry : map.entrySet()) {
        if (!entry.getValue().equals("1")) {
            removeKeys.add(entry.getKey());
        }
    }
    for (String removeKey : removeKeys) {
        map.remove(removeKey);
    }
    for (Entry<String, String> entry : map.entrySet()) {
        String key = entry.getKey();
        String value = entry.getValue();
        System.out.println(key + "," + value);
    }
    System.out.println("=========================");
}
```

## TreeMap

类图：

![](/assets/blogImg/TreeMap.png)

TreeMap是基于红黑树实现的Map结构，其Entry类拥有到左/右叶子节点和父节点的引用，同时还记录了自己的颜色，所以TreeMap是有序不可重复的二叉树。

注意：

TreeMap的排序 是排的Key，和value没有任何关系 

TreeMap要求 key必须是可排序的

### TreeMap的构造方法

- TreeMap()

  默认构造函数。使用该构造函数，TreeMap中的元素按照自然排序进行排列。

- TreeMap(Map<? extends K, ? extends V> copyFrom)

  该构造函数会调用putAll()将m中的所有元素添加到TreeMap中

- TreeMap(Comparator<? super K> comparator)

  指定Tree的比较器

- TreeMap(SortedMap<K, ? extends V> copyFrom)

  带SortedMap的构造函数，SortedMap会成为TreeMap的子集

### TreeMap的常用方法

- **ceilingEntry**(K key)：返回指定的Key大于或等于的最小值的元素，如果没有，则返回null
- **ceilingKey**(K key)： 返回指定的Key大于或等于的最小值的Key，如果没有，则返回null
- **clone**()：返回集合的副本
- **comparator**()：如果使用默认的比较器，就返回null，如果使用其他的比较器，则返回比较器的哈希码值
- **descendingKeySet**()：返回集合的全部Key，并且是逆序的
- **descendingMap**()：把集合逆序返回
- **firstEntry**()：返回集合中最小Key的元素
- **firstKey**()：返回集合中最小Key的key
- **floorEntry**(K key)：与ceilingEntry()方法相反，是返回小于等于key的最大Key的元素
- **floorKey**(K key)：返回小于等于key的最大Key的key
- **headMap**(K toKey)：返回Key小于toKey的所有元素

### TreeMap的学习Demo

```Java
public class TreeMapTest {
    public static void main(String[] args) {

        TreeMap<Student2, String> tm = new TreeMap<Student2, String>(new Comparator<Student2>() {
            @Override
            public int compare(Student2 s1, Student2 s2) {
                // 主要条件
                int num = s1.getAge() - s2.getAge();
                // 次要条件
                int num2 = num == 0 ? s1.getName().compareTo(s2.getName()) : num;
                return num2;
            }
        });

        // 创建学生对象
        Student2 s1 = new Student2("潘安", 30);
        Student2 s2 = new Student2("柳下惠", 35);
        Student2 s3 = new Student2("唐伯虎", 33);
        Student2 s4 = new Student2("燕青", 32);
        Student2 s5 = new Student2("唐伯虎", 33);

        // 存储元素
        tm.put(s1, "宋朝");
        tm.put(s2, "元朝");
        tm.put(s3, "明朝");
        tm.put(s4, "清朝");
        tm.put(s5, "汉朝");

        // 遍历
        Set<Student2> set = tm.keySet();
        for (Student2 key : set) {
            String value = tm.get(key);
            System.out.println(key.getName() + "---" + key.getAge() + "---"
                    + value);
        }
    }
}

class Student2 {
    private String name;
    private int age;

    public Student2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```

## Hashtable

类图：

![](/assets/blogImg/Hashtable.png)

Hashtable 可以说是HashMap的前身（Hashtable自JDK1.0就存在，而HashMap乃至整个Map接口都是JDK1.2引入的新特性），其实现思 路与HashMap几乎完全一样，都是通过数组存储Entry，以key的哈希值计算Entry在数组中的index，用拉链法解决哈希冲突。二者最大的不同在于，Hashtable是线程安全的，其提供的方法几乎都是同步的。

已基本不再使用，不做深入了解。

## LinkedHashMap

类图：

![](/assets/blogImg/LinkedHashMap.png)

LinkedHashMap与HashMap非常类似，唯一的不同在于前者的Entry在HashMap.Entry的基础上增加了到前一个插入和后一个插入的Entry的引用，以实现能够按Entry的插入顺序进行遍历。

# 总结

<table>
	<tr>
	    <th>分类</th>
	    <th>实现</th>
	    <th>是否线程安全</th>  
        <th>排序</th>  
        <th>特点</th>  
	</tr >
	<tr >
	    <td rowspan="4">List</td>
	    <td>ArrayList</td>
	    <td>否</td>
        <td>插入顺序</td>
	    <td>随机访问性能高</td>
	</tr>
	<tr>
	    <td>LinkList</td>
	    <td>否</td>
        <td>插入顺序</td>
	    <td>随机访问性能低，头尾操作性能高，不占用冗余空间</td>
	</tr>
	<tr>
	    <td>Vector</td>
	    <td>是</td>
        <td>插入顺序</td>
	    <td>并发性能不高，线程越多性能越差</td>
	</tr>
	<tr>
	    <td>CopyOnWriteArrayList</td>
	    <td>是</td>
        <td>插入顺序</td>
	    <td>并发读性能高，占用冗余内存空间</td>
	</tr>
    <tr >
	    <td rowspan="6">Map</td>
	    <td>HashMap</td>
	    <td>否</td>
        <td>无序</td>
	    <td>读写性能高，接近o(1)</td>
	</tr>
    <tr>
	    <td>LinkHashMap</td>
	    <td>否</td>
        <td>插入顺序</td>
	    <td>可按照插入顺序遍历，性能与HashMap接近</td>
	</tr>
    <tr>
	    <td>HashTabel</td>
	    <td>是</td>
        <td>无序</td>
	    <td>并发性能不高</td>
	</tr>
    <tr>
	    <td>ConcurrentHashMap</td>
	    <td>是</td>
        <td>无序</td>
	    <td>并发性能比Table高</td>
	</tr>
    <tr>
	    <td>TreeMap</td>
	    <td>否</td>
        <td>key升序或降序</td>
	    <td>有序读写性能o(logN)</td>
	</tr>
    <tr>
	    <td>ConcurrentSkipListMap</td>
	    <td>是</td>
        <td>key升序或降序</td>
	    <td>线程安全，性能与线程数无关，占用内存空间较大</td>
	</tr>
    <tr >
	    <td rowspan="4">Set</td>
	    <td>HashSet</td>
	    <td>否</td>
        <td>无序</td>
	    <td>同hashMap</td>
	</tr>
    <tr>
	    <td>LinkedHashSet</td>
	    <td>否</td>
        <td>插入顺序</td>
	    <td>同LinkedHashMap</td>
	</tr>
     <tr>
	    <td>TreeSet</td>
	    <td>否</td>
        <td>对象升序或者降序</td>
	    <td>同TreeMap</td>
	</tr>
     <tr>
	    <td>ConcurrentSkipListSet</td>
	    <td>否</td>
        <td>无序</td>
	    <td>同ConcurrentSkipListMap	</td>
	</tr>
    <tr >
	    <td rowspan="5">Queue</td>
	    <td>ConcurrentLinkedQueue</td>
	    <td>是</td>
        <td>插入顺序</td>
	    <td>非阻塞</td>
	</tr>
    <tr>
	    <td>LinkedBlockingQueue</td>
	    <td>是</td>
        <td>插入顺序</td>
	    <td>阻塞无界</td>
	</tr>
    <tr>
	    <td>ArrayBlockingQueue</td>
	    <td>是</td>
        <td>插入顺序</td>
	    <td>阻塞有界</td>
	</tr>
    <tr>
	    <td>SynchronousQueue</td>
	    <td>是</td>
        <td>--</td>
	    <td>向其中插入元素的线程会阻塞，直到有另一个线程将这个元素取走，反之从其中取元素的线程也会阻塞，直到有另一个线程插入元素</td>
	</tr>
    <tr>
	    <td>PriorityQueue</td>
	    <td>否</td>
        <td>对象自然序，或自定义排序</td>
	    <td>根据优先级排序，保证自然序或者自定义序的最小对象先出列</td>
	</tr>
     <tr >
	    <td rowspan="2">DeQueue</td>
	    <td>ConcurrentLinkedDeQueue</td>
	    <td>是</td>
        <td>插入顺序</td>
	    <td>非阻塞</td>
	</tr>
    <tr>
	    <td>LinkedBlockingDeQueue</td>
	    <td>是</td>
        <td>插入顺序</td>
	    <td>阻塞无界</td>
	</tr>

​    


​    	
​    

    </table>







