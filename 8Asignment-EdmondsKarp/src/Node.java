import java.util.ArrayList;
public class Node {
	
	ArrayList<Links> links = new ArrayList<Links>();
	int distance = 1000000000;
	int index;
	int parent;
	boolean visible = false;

	public Node(int index) {
		this.index = index;
	}
	
	public int getIndex() {
		return index;
	}
	
	public int getDist() {
		return distance;
	}
	
	public int getParent() {
		return parent;
	}
	
	public void addLink(int node, int weight) {
		for(int i = 0; i < links.size(); i++) {
			if(links.get(i).toNode == node) {
				if(links.get(i).weight == 0) {
					links.get(i).setWeight(weight);
				}
			}
		}
		links.add(new Links(node, weight));
	}
	
	public ArrayList<Integer> readArrayList(){
		ArrayList<Integer> retArrayList = new ArrayList<Integer>();
		for(int i = 0; i < links.size(); i++) {
			retArrayList.add(links.get(i).toNode);
		}
		return retArrayList;
	}
	
	public boolean checkCon(int node) {
		for (int i = 0; i < links.size(); i++) {
			if(links.get(i).toNode == node) {
				return true;
			}
		}
		return false;
	}
	
	public int getWeight(int node) {
		for (int i = 0; i < links.size(); i++) {
			//System.out.println(links.get(i).toNode + "\n" + node +"\n" + index);
			if(links.get(i).toNode == node) {
				return links.get(i).weight;
			}
		}
		return -1;
	}
	
	public void reduceWeight(int node, int x) {
		for (int i = 0; i < links.size(); i++) {
			if(links.get(i).toNode == node) {
				links.get(i).reduceWeight(x);
				break;
			}
		}
	}
	
	public boolean isSeen() {
		return visible;
	}
	
	public void seen(boolean x) {
		visible = x;
	}
	
	public void checkDistance(int x) {
		if(x < distance) distance = x;
	}
	
	public void setParent(int p) {
		parent = p;
	}
}
