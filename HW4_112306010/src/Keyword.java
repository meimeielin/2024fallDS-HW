public class Keyword {
	public String name;
    public int count;
    public float weight;
    
    public Keyword(String name, int count, float weight){
      this.name = name;
      this.count = count;
      this.weight = weight;
    }
    
    @Override
    public String toString(){
    	return "["+name+","+count+","+weight+"]";
    }
    

    public int getCount(){
    	return count;
    }
    public String getName(){
    	return name;
    }
    public float getWeight(){
    	return weight;
    }
    public boolean isFind(String text, String pattern) {
		boolean isFind = false;
		
		int n = text.length();
		int m = pattern.length();
		
		for(int i = 0; i <= n-m; i++) {
			int k = 0;
			
			while(k < m && text.charAt(i + k) == pattern.charAt(k)) k++;
				
			
			if(k == m) isFind = true; 
				
		}
		
		return isFind;
    }
    
    
    
}