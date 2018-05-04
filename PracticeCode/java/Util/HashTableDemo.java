package Util;

public class HashTableDemo implements Cloneable{
	private Entry[] bukets;
	private int size = 0;
	public HashTableDemo(int size) {
		this.size = size;
		this.bukets = new Entry[size];
	}
	private static class Entry{
		final Object key;
		Object value;
		Entry next;
		
		Entry(Object key,Object value,Entry next){
			this.key = key;
			this.value = value;
			this.next = next;
		}
		//递归调用，链表在不是很长的时候可以工作很好，一旦长了就容易导致栈溢出
		Entry deepCopy() {
			return new Entry(key,value,next == null?null:next.deepCopy());//注意一定是next.deeepCopy(),相当于重新定义了指向下一个数据节点的指针。
		}
		//利用迭代代替递归
		Entry deeeCopy2() {
			Entry result = new Entry(key,value,next);
			for(Entry p = result; p.next != null; p = p.next) {
				p.next = new Entry(p.next.key,p.next.value,p.next.next);
			}
			return result;
		}
		
	}
	
	
	@Override
	public HashTableDemo clone() {
		try {
			HashTableDemo result = (HashTableDemo)super.clone();
			result.bukets = new Entry[bukets.length];
			for(int i=0; i<bukets.length; i++) {
				if(bukets[i] != null)
					result.bukets[i] = bukets[i].deepCopy();
			return result;
			}
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}
}
