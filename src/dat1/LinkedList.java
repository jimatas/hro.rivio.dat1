package dat1;

/**
 * Implementation of a doubly-linked list. A <tt>LinkedList</tt> consists of 
 * a sequence of nodes, containing the list data, that link to one and other. 
 * <p>
 * A <tt>LinkedList</tt> implements relatively efficient insertion and removal
 * operations. But unlike an indexed structure such as an array, fast, random 
 * access to its elements is not possible.
 * 
 * @author K. Atas
 */
public class LinkedList<E> {
    private ListNode<E> first;
    private ListNode<E> last;
    private int size;
    
    /**
     * Constructs a new, empty <tt>LinkedList</tt>.
     */
    public LinkedList() {
        first = last = null;
        size = 0;
    }
    
    /**
     * Constructs a new <tt>LinkedList</tt> initialized with the items 
     * contained in the specified array.
     * 
     * @param items an array whose items are to be added to this 
     *  <tt>LinkedList</tt>.
     */
    public LinkedList(E[] items) {
        this();
        for (E item : items) {
            addLast(item);
        }
    }
    
    /**
     * Gets the size of this <tt>LinkedList</tt>.
     * 
     * @return the number of items in this <tt>LinkedList</tt>.
     */
    public int size() {
        return size;
    }
    
    /**
     * Adds a new item to the beginning (or head) of this <tt>LinkedList</tt>.
     * 
     * @param item the item to add to this <tt>LinkedList</tt>.
     */
    public void addFirst(E item) {
        ListNode<E> node = new ListNode<E>(item);
        if (first == null) {
            first = last = node;
        } else {
            first.setPrevious(node);
            first = node;
        }
        size++;
    }
    
    /**
     * Adds a new item to the end of this <tt>LinkedList</tt>.
     * 
     * @param item the item to add to this <tt>LinkedList</tt>.
     */
    public void addLast(E item) {
        ListNode<E> node = new ListNode<E>(item);
        if (last == null) {
            last = first = node;
        } else {
            last.setNext(node);
            last = node;
        }
        size++;
    }
    
    /**
     * Adds a new item to this <tt>LinkedList</tt> at the specified position.
     * 
     * @param index the offset at which to add the item.
     * @param item the item to add to this <tt>LinkedList</tt>.
     * @throws IndexOutOfBoundsException if <tt>index < 0</tt> or 
     *  <tt>index > size()</tt>.
     */
    public void add(int index, E item) {
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            ListNode<E> next = getNodeAt(index);
            ListNode<E> prev = next.getPrevious();
            ListNode<E> node = new ListNode<E>(item);
            node.setPrevious(prev);
            node.setNext(next);
            size++;
        }
    }
    
    /**
     * Gets the item at the beginning of this <tt>LinkedList</tt>.
     * 
     * @return the first item in this <tt>LinkedList</tt> or <tt>null</tt>, if 
     * there are no items.
     */
    public E getFirst() {
        if (first != null) {
            return first.getItem();
        }
        return null;
    }
    
    /**
     * Gets the item at the end of this <tt>LinkedList</tt>.
     * 
     * @return the last item in this <tt>LinkedList</tt> or <tt>null</tt>, if 
     * there are no items.
     */
    public E getLast() {
        if (last != null) {
            return last.getItem();
        }
        return null;
    }
    
    /**
     * Gets the item at the specified position in this <tt>LinkedList</tt>.
     * 
     * @param index the offset at which to retrieve the item.
     * @return the item at specified offset.
     * @throws IndexOutOfBoundsException if <tt>index < 0</tt> or 
     *  <tt>index >= size()</tt>.
     */
    public E get(int index) {
        return getNodeAt(index).getItem();
    }
    
    /**
     * Replaces the item at the specified position in this <tt>LinkedList</tt>
     * with another one.
     * 
     * @param index offset at which to replace the item.
     * @param item the item to replace with. 
     * @return the item that was previously at that position.
     * @throws IndexOutOfBoundsException if <tt>index < 0</tt> or
     *  <tt>index >= size()</tt>.
     */
    public E set(int index, E item) {
        ListNode<E> node = getNodeAt(index);
        E oldItem = node.getItem();
        node.setItem(item);
        return oldItem;
    }
    
    /**
     * Removes and returns the item at the beginning of this 
     * <tt>LinkedList</tt>.
     * 
     * @return the removed item or <tt>null</tt>, if the list is empty. 
     */
    public E removeFirst() {
        if (first == null) {
            return null;
        }
        E item = first.getItem();
        first = first.getNext();
        if (first == null) {
            last = null;
        }
        size--;
        return item;
    }
    
    /**
     * Removes and returns the item at the end of this <tt>LinkedList</tt>.
     * 
     * @return the removed item or <tt>null</tt>, if the list is empty. 
     */
    public E removeLast() {
        if (last == null) {
            return null;
        }
        E item = last.getItem();
        last = last.getPrevious();
        if (last == null) {
            first = null;
        }
        size--;
        return item;
    }
    
    /**
     * Removes and returns the item at the specified position in this 
     * <tt>LinkedList</tt>.
     * 
     * @param index the offset at which to remove the item.
     * @return the removed item.
     * @throws IndexOutOfBoundsException if <tt>index < 0</tt> or
     *  <tt>index >= size()</tt>.
     */
    public E remove(int index) {
        if (size >= 1) {
            if (index == 0) {
                return removeFirst();
            }
            if (index == size - 1) {
                return removeLast();
            }
        }
        ListNode<E> node = getNodeAt(index);
        node.getPrevious().setNext(node.getNext());
        size--;
        return node.getItem();
    }
    
    /**
     * Returns the offset in this <tt>LinkedList</tt> of the first occurrence 
     * of the specified item.
     * 
     * @param item the item to find the offset in this <tt>LinkedList</tt> of.
     * @return the offset in this <tt>LinkedList</tt> of the first occurrence 
     *  of the specified item. -1 if this <tt>LinkedList</tt> does not contain
     *  the item.
     */
    public int indexOf(E item) {
        int i = 0;
        ListNode<E> node = first;
        while (node != null) {
            if (item == null ? node.getItem() == null // handle null values
                    : item.equals(node.getItem())) {
                return i;
            }
            i++;
            node = node.getNext();
        }
        return -1;
    }
    
    /**
     * Returns the offset in this <tt>LinkedList</tt> of the last occurrence of
     * the specified item.
     * 
     * @param item the item to find the offset in this <tt>LinkedList</tt> of.
     * @return the offset in this <tt>LinkedList</tt> of the last occurrence of
     *  the specified item. -1 if this <tt>LinkedList</tt> does not contain the
     *  item.
     */
    public int lastIndexOf(E item) {
        int i = size - 1;
        ListNode<E> node = last;
        while (node != null) {
            if (item == null ? node.getItem() == null // handle null values
                    : item.equals(node.getItem())) {
                return i;
            }
            i--;
            node = node.getPrevious();
        }
        return -1;
    }
    
    /**
     * Returns a string representation of this <tt>LinkedList</tt>.
     */
    public String toString() {
        StringBuffer str = new StringBuffer();
        ListNode<E> node = first;
        while (node != null) {
            if (str.length() != 0) {
                str.append(", ");
            }
            str.append(node.getItem());
            node = node.getNext();
        }
        return String.format("[%s]", str);
    }
    
    /**
     * Gets the {@link ListNode} at the specified offset.
     * 
     * @param index the offset at which to retrieve the node.
     * @return the node at the specified offset.
     * @throws IndexOutOfBoundsException if <tt>index < 0</tt> or 
     *  <tt>index >= size()</tt>.
     */
    private ListNode<E> getNodeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.valueOf(index));
        }
        ListNode<E> node = null;
        if (index < size / 2) {
            node = first;
            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }
        } else {
            node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.getPrevious();
            }
        }
        return node;
    }
}