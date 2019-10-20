public class Links {
	
	public int toNode;
	public int weight;
	
	public Links(int toNode, int weight) {
		this.toNode = toNode;
		this.weight = weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public void reduceWeight(int x) {
		this.weight -= x;
	}
	
	

}
