package domain.model;

public enum Country {

	ITA(1,"Italy"), ESP(2,"Spain"), EGY(3,"Egypt");
	private String longName;
	private int intKey;
	Country(int intKey, String longName){
			this.longName = longName;
			this.intKey = intKey;
		}
	
    public String getLongName(){
        return longName;

    }
    
    public int getIntKey(){
    	return intKey;
}
}