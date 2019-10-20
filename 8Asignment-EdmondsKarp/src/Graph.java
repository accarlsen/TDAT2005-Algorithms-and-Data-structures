import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Graph {
			
		public static void main(String[]argStrings){
			int startNode = 0;
			int endNode = 1;
			//Set up file reader and buffered reader
			try(FileReader fileReader = new FileReader("flytgraf3.txt");
				BufferedReader reader = new BufferedReader(fileReader)) {
					String line;
					line = reader.readLine().trim();
					//Spilt opp for å fikse feil inline/format på flytgrafen -> leses riktig
					for (int i = 0; i < line.length(); i++) {
						if(line.charAt(i) == ' ' && line.charAt(i-1) == ' ') {
							line = line.substring(0, i-1) + line.substring(i, line.length());
						}
					}
					String[] thisLineStrings = line.split(" ");
					Node[] list = new Node[Integer.parseInt(thisLineStrings[0])];
					while((line = reader.readLine()) != null) {
						line = line.trim();
						for (int i = 0; i < line.length(); i++) {
							if(line.charAt(i) == ' ' && line.charAt(i-1) == ' ') {
								line = line.substring(0, i-1) + line.substring(i, line.length());
								i--;
							}
						}
						thisLineStrings = line.split(" ");
						if(list[Integer.parseInt(thisLineStrings[0])] == null) {
							list[Integer.parseInt(thisLineStrings[0])]= new Node(Integer.parseInt(thisLineStrings[0]));	
						}
						if(list[Integer.parseInt(thisLineStrings[1])] == null) {
							list[Integer.parseInt(thisLineStrings[1])] = new Node(Integer.parseInt(thisLineStrings[1]));	
						}
						list[Integer.parseInt(thisLineStrings[0])].addLink(Integer.parseInt(thisLineStrings[1]), Integer.parseInt(thisLineStrings[2]));
						list[Integer.parseInt(thisLineStrings[1])].addLink(Integer.parseInt(thisLineStrings[0]), 0);
					}
					int maxWeight = 0;
					System.out.println("Maxflyt fra " + startNode + " til " + endNode + "\nBruker Edmond-Karp metoden");
					ArrayList<Integer> routeArrayList = BFS(list, startNode, endNode);
					/*for (int i = 0; i < list.length; i++) {
						for (int j = 0; j < list[i].links.size(); j++) {
							System.out.println("Fra node: " + list[j].index + "\nTil node: " + list[j].links.get(j).toNode);
						}
						//System.out.println("RouteArr: " + list[i].index);
					}*/
					int weight = 1000000000;
					while(weight > 0) {
						weight = 1000000000;
						for (int i = 1; i < routeArrayList.size(); i++) {
							if(list[routeArrayList.get(i-1)].getWeight(routeArrayList.get(i)) < weight){
								weight = list[routeArrayList.get(i-1)].getWeight(routeArrayList.get(i));
								
							}
						}
						for (int i = 1; i < routeArrayList.size(); i++) {
							list[routeArrayList.get(i-1)].reduceWeight(routeArrayList.get(i), weight);
							list[routeArrayList.get(i)].reduceWeight(routeArrayList.get(i-1), (0-(weight)));
						}
						if(weight != 0) {
							System.out.println("Cap: " + weight);
							System.out.println("Route: ");
							for (int i = 0; i < routeArrayList.size(); i++) {
								System.out.print(" " + list[routeArrayList.get(i)].getIndex());
							}
							System.out.println("");
						}
						routeArrayList = BFS(list, startNode, endNode);
						maxWeight += weight;
					}
					System.out.println("Maxflyt ble: " + maxWeight);
					reader.close();
					fileReader.close();
				}catch (FileNotFoundException e) {
					System.out.println("Kunne ikke finne filen");
				}catch (IOException e) {
					System.out.println("Kunne ikke lese filen");
				}
		}
		
		
		public static ArrayList<Integer> BFS(Node[] nodes, int start, int endNode) {
			for (int i = 0; i < nodes.length; i++) {
				nodes[i].seen(false);
			}
			ArrayList<Node> queueArrayList = new ArrayList<Node>();
			ArrayList<Integer> linksArrayList = nodes[start].readArrayList();
			Node currentNode = nodes[start];
			//Set the distance for the 1st node
			currentNode.checkDistance(0);
			//Add the 1st node to the queue
			queueArrayList.add(currentNode);
			//Set 1st node to seen = true
			currentNode.seen(true);
			while(queueArrayList.size() > 0) {
				for (int i = 0; i < linksArrayList.size(); i++) {
					if(!(nodes[linksArrayList.get(i)].isSeen()) && currentNode.getWeight(linksArrayList.get(i)) > 0) {
						//Add the i-th node from i-th link
						queueArrayList.add(nodes[linksArrayList.get(i)]);
						//Check/set the parent node to curr node
						queueArrayList.get(queueArrayList.size()-1).setParent(currentNode.getIndex());
						//Set the visited node in queue to seen = true
						queueArrayList.get(queueArrayList.size()-1).seen(true);
						//Set the distance to that node
						queueArrayList.get(queueArrayList.size()-1).checkDistance(currentNode.getDist()+1);
					}	
				}
				//Pop queue
				queueArrayList.remove(0);
				if(queueArrayList.size() != 0) {
					linksArrayList = queueArrayList.get(0).readArrayList();
					currentNode = queueArrayList.get(0);
				}
			}
			ArrayList<Integer> routeArrayList = new ArrayList<Integer>();
			routeArrayList.addAll(addPrev(nodes, start, endNode));
			routeArrayList.add(endNode);
			return routeArrayList;

		}

		public static ArrayList<Integer> addPrev(Node[] nodes, int start, int endNode) {
			ArrayList<Integer> routeArrayList = new ArrayList<Integer>();
			int parent = nodes[endNode].getParent();
			if(parent != start) {
				routeArrayList.addAll(addPrev(nodes, start, parent));
			}
			routeArrayList.add(parent);
			return routeArrayList;
		}
}
