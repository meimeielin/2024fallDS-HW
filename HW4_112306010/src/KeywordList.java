
import java.util.*;
public class KeywordList {
	
	private LinkedList<Keyword> lst;
	
	public KeywordList(){
		this.lst = new LinkedList<Keyword>();		
	}
	
	public void add(Keyword keyword){
		//1. add keyword to proper index base on its count . DECENDING SORT BY COUNT AND WEIGHT
		
		int addindex = 0;
		

			for(int i = 0; i < lst.size(); i++) {
				Keyword compare = lst.get(i);
				
				if(compare.getCount() < keyword.getCount()) addindex += 1;
				else if(compare.getCount() == keyword.getCount() && compare.getWeight() < keyword.getWeight()) addindex += 1;
				else {break;}
			}
		
		
		lst.add(addindex, keyword);
		//printKeywordList(lst);		
						
	}
	
	public void outputIndex(int i){ 
		if(i > lst.size() || i == 0){
		    System.out.println("InvalidOperation");
		    return;
		}
		
		LinkedList<Keyword> results = new LinkedList<>();
		Keyword k = lst.get(i);		    
		results.add(k);		    		
		printKeywordList(results);
	}
		
	public void outputCount(int c){
		// 2. output all keywords whose keyword is equal to c
		LinkedList<Keyword> results = new LinkedList<>();
		for(int i = 0; i < lst.size(); i++){
		    Keyword k = lst.get(i);
		    if(k.getCount() == c){
		    	results.add(k);
		    }
		}
		if(results.isEmpty()){
		    System.out.println("NotFound");
		}else{
		    printKeywordList(results);
		}
		
	}
	
	public void outputHas(String pattern){
		LinkedList<Keyword> results = new LinkedList<>();
		for(int i = 0; i < lst.size(); i++){
		    Keyword k = lst.get(i);
		    if(k.name.contains(pattern)){
		    	results.add(k);
		    }
		}
		if(results.isEmpty()){
		    System.out.println("NotFound");
		}else{
		    printKeywordList(results);
		}
		
	}
	
	public void outputName(String pattern){
		
		LinkedList<Keyword> results = new LinkedList<>();
		for(int i = 0; i < lst.size(); i++){
		    Keyword k = lst.get(i);
		    if(k.name.equals(pattern)){
		    	results.add(k);
		    }
		}
		if(results.isEmpty()){
		    System.out.println("NotFound");
		}else{
		    printKeywordList(results);
		}
		
	}
	
	public void outputFirstN(int n){
		if(n > lst.size()){
		    System.out.println("InvalidOperation");
		    return;
		}
		String result ="";
		for(int i = 0; i < n; i++){
		    Keyword k = lst.get(i);
		    result = result + k + " ";
		}
		System.out.println(result);

	}
	
	public void outputScore(){
		float results = 0;
		for(int i = 0; i < lst.size(); i++){
		    Keyword k = lst.get(i);
		    results += k.weight * k.count;
		}
		
		System.out.println(results);
		
	}
	
	public void deleteIndex(int i){
		if(i >= lst.size()){
		    return;
		}	
		lst.remove(i);
	}

	public void deleteCount(int c){
		// 3. remove nodes that the count is equal to c
		Iterator<Keyword> iterator = lst.iterator();
		
		int deleteCount = 0;
		
	    // 使用 Iterator 來安全地遍歷和刪除元素
	    while (iterator.hasNext()) {
	        Keyword k = iterator.next();
	        
	        if (k.getCount() == c) {
	            iterator.remove(); // 用 Iterator 的 remove 方法來刪除
	            deleteCount++;
	        }
	    }
	    
	    if (deleteCount == 0) System.out.println("NotFound");
	        
	 	
	}

	public void deleteHas(String pattern){
		Iterator<Keyword> iterator = lst.iterator();
		
		// 4. remove nodes that the name contains input name
		int deleteCount = 0;
		while (iterator.hasNext()) {
	        Keyword k = iterator.next();
	        
	        if (k.isFind(k.getName(), pattern)) {
	            iterator.remove(); // 用 Iterator 的 remove 方法來刪除
	            deleteCount ++;
	        }
	    }
		
		if(deleteCount == 0) System.out.println("NotFound");

	}
	
	public void deleteName(String name){
		// 5. remove nodes that the name is equal to input name
		Iterator<Keyword> iterator = lst.iterator();
		
		int deleteCount = 0;
		while (iterator.hasNext()) {
	        Keyword k = iterator.next();
	        
	        if (k.getName().equals(name)) {
	            iterator.remove(); // 用 Iterator 的 remove 方法來刪除
	            deleteCount ++;
	        }
	    }
		if(deleteCount == 0) System.out.println("NotFound");
			
		
	}
	
	public void deleteFirstN(int n){
		//6. remove first n nodes
		if(n <= lst.size()) {
			for(int i = 0; i < n; i ++) {
				lst.removeFirst();
			}
		}else {
			System.out.println("InvalidOperation");
		}
		
	}
	
	public void deleteAll(){
		lst = new LinkedList<Keyword>();
	}
		
	private void printKeywordList(LinkedList<Keyword> kLst){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < kLst.size(); i++){
			Keyword k = kLst.get(i);
			if(i > 0) sb.append(" ");
			sb.append(k.toString());
		}
		System.out.println(sb.toString());
	}
	
	
}



