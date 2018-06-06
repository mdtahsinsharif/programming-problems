import java.util.*;

/* In a subway, given a long bench with individual seats, there are people sitting randomly and there are some empty seats. 
   For the next k number of incoming passengers, design an algorithm that places them as such that they are sitting furthest
   away from the other passengers.
*/

public class Triplet<T, U, V> {

	    private final T first;
	    private final U second;
	    private final V third;

	    public Triplet(T first, U second, V third) {
	        this.first = first;
	        this.second = second;
	        this.third = third;
	    }

	    public T getFirst() { return first; }
	    public U getSecond() { return second; }
	    public V getThird() { return third; }
}


public class SubwaySeats extends Triplet{

	public SubwaySeats() {
		super(1,2,3);
	}
	
	public static int[] insert_people(int[] arr, int k)
	{
	    ArrayList<Triplet<Integer, Integer, Integer>> list = new ArrayList<Triplet<Integer, Integer, Integer>>();
	    int start = 0, end = 0;
	    boolean b = false;
	    int i=0;
	    for(i=0; i<arr.length; i++){
	        if(arr[i] == 0 && b == false){
	            start = i;
	            b = true;
	        } else if(arr[i] == 1 && b == true){
	            end = i-1;
	            b = false;
	            list.add(new Triplet<Integer, Integer, Integer>(end-start+1, start, end));  
	        }  
	    }
	    if(i==arr.length && b!=false) {
	    	end = i-1;
	    	list.add(new Triplet<Integer, Integer, Integer>(end-start+1, start, end));
	    }
	    
	    ArrayList<Integer> sorted = new ArrayList<Integer>();
	    for (Triplet item : list) {   
	        sorted.add((int)(item.getFirst()));
	    }
	    Collections.sort(sorted); //descending order
	    
	    int emptySeats = 0;
	    ListIterator<Triplet<Integer, Integer, Integer>> listIterator = list.listIterator();
		while (listIterator.hasNext()) {
			emptySeats += listIterator.next().getFirst();
		}
	    
	    if(k >= emptySeats){
	        for(int m=0; m<arr.length; m++){
	            arr[m] = 1;
	        }
	        return arr;
	    }
	    
	    for(int j=0; j<k; j++){
	    	
	        Triplet<Integer, Integer, Integer> tr = list.get(0);
	        int x = -1;
	        boolean boolval = false;
	        ListIterator<Triplet<Integer, Integer, Integer>> listIterator1 = list.listIterator();
			while (x<list.size()-1 && boolval == false  ) {
				Triplet<Integer, Integer, Integer> temp = listIterator1.next();
				if (sorted.get(sorted.size()-1) == temp.getFirst()) {
					tr = temp;
					boolval = true;
				} 
				x++;
			}
	        
			int index = x;
	        int size = tr.getFirst();
	        start = tr.getSecond();
	        end = tr.getThird();
	        
	        int entering_index = (start+end)/2;
	        arr[entering_index] = 1;
	        size--;
	        int sizehalf = size/2;
	        sorted.remove(sorted.size()-1);
	        list.remove(index);
	        
	        if(size>0){
	            list.add(new Triplet<Integer, Integer, Integer>(sizehalf, start, entering_index-1));
	            sorted.add((int)(sizehalf));
	            if((size-sizehalf) > 0){
	                list.add(new Triplet<Integer, Integer, Integer>(size-sizehalf, entering_index+1, end));
	                sorted.add((int)(size-sizehalf));
	            }
	            Collections.sort(sorted); 
	        } 
	    }
	    return arr;
	}

	public static void main(String[] args) {
		
		int[] arr = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1, 1,1,0, 0, 0,1,0, 0, 1, 0};
		int[] inserted = insert_people(arr, 7);
		int empty = 0;
		for(int i=0; i<inserted.length; i++) {
			System.out.print(" " + inserted[i]);
			if(inserted[i] == 0) empty++;
		}
		System.out.println(" \nEmpty: " + empty);
	}

}
