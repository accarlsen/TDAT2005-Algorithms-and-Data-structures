import java.util.Date;
import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        
        String[] s = 
        {"Adolfsen","JoakimMoe Andersen","Tobias Meyer Andersson","Vegard Bakken",
        "Cato Bastiansen","Hans Petter Årvik Baugerud","Magnus Berg","Henrik Mathias Bergebakken",
        "Tore Bergquist","Jon Åby Bjerke","Thomas Blichfeldt","Victoria Brevik","Magnus Bright",
        "Brigitt Gyamfi Bui","Aria Thuy Dung Carlsen","Alexander Dalheim","William Derouiche",
        "Emir Dokken","Nikolai Roede Eggum","Randi Eidsvaag","Mikael Nervik Evangelista",
        "Ian-Angelo Roman Evje","Kjerand Faksdal","Stine Olava Fornes","Mia Gjengedal","Helene Grande",
        "Trym Granli","Hans Kristian Olsen Gulaker","Kristian William Macdonald Gultvedt",
        "Even Gundersen","Kasper Vedal Harnes","Håkon Anthonsen Harnes","Vetle Kristaver Widnes Heggelund",
        "Mathias Oppedal Helgeland","Kevin Andre Hemstad","Eirik Hestmark","Bård Sørensen Hollum",
        "Jørgen Holt-Seeland","Per Høie","Svein Jakob Ikin","Sebastian Anthony Imran","Zaim Ul-Abrar Jacobsen",
        "Jonas Brager Jarbeaux","William Jonson","Helene Yuee Kalleberg","Espen Kallestad","Asbjørn Fiksdal Kalstad",
        "Mikael Karlsen","Audun Knutsen","Yair Day Koch","Carl Egil Kopperud","Pernille Lande","Maria Larsen",
        "Juni Leirvik Larsen","Michael Staff Larsson","Jonas Brunvoll Lauvvik","Torbjørn Bøe Legendre",
        "Patrick Øivind Helvik Liahagen","Ole Jonas Liland","Tiril Bjerkebakke Loennechen","Jan Luick",
        "Andine Madsen","Jakob Lønnerød Mahmood","Dilawar Markhus","Håvard Stavnås Mcculloch",
        "Maria Kleppestø Moe","Thomas Bakken Mohammad","Mahmoud Ibrahim Mohammadi","Sara Nayef",
        "Mohammad Nayef Al Nilsen","Martin Johannes Olsen","Mathias Årstad Pickel","Pascal Plahte",
        "Eirik Riksvold","Christian Rønning","Gaute Wierød Røstgård","Kim Richard Schau","Max Torre Seivaag",
        "Lasse Ivar Seljeseth","Sabine Sevaldsen","Marcus Solvoll","Kenneth Steig","Jørgen Sundfær",
        "Torstein Holmberget Thorkildsen","Torje Dahll-Larssøn Tolnes","Andreas Torbjørnsen",
        "Marius Tronstad","Henrik Wanderås Trømborg","Steffen Tverfjell","Julie Isabelle Malmedal Utne",
        "Sivert Vanebo","Kristoffer Willa","Lisa Yogalingam","Abilash Younger","Eric Østmo-Sæter","Lars Olsnes Årdal","Simon" };
        
        HashFunc hf = new HashFunc(s.length);
        System.out.println(hf.tableSize);
        
        for(int i = 0; i < s.length; i++){
            hf.addToHashTable(s[i]);
        }

        System.out.println("Size of hash-table: " + hf.tableSize);
        System.out.println("Number of collisions: " + hf.collisions);
        System.out.println("Average collisions per person: " + (double) hf.collisions/hf.tableSize);
        
        

        //Task 2
        int intSize = 5000000;
        int[] qed = new int[intSize];
        for(int i = 0; i < qed.length; i++){
            qed[i] = (int) (Math.random() * 100000000 + 1);
        }
        
        HashFuncInt hfi;

        Date start = new Date();
		Date end;
		int rounds = 0;
		double time;
		do{
            hfi = new HashFuncInt(intSize);
            for(int i = 0; i < qed.length; i++){
                hfi.addToHashTable(qed[i]);
            }

            end = new Date();
            rounds++;
		} while(end.getTime()-start.getTime() < 1000);
		time = (double)(end.getTime()-start.getTime())/rounds;
		System.out.println("Milliseconds per round: " + time);
		System.out.println("Size of hash-table: " + hfi.tableSize);
	    System.out.println("Number of collisions: " + hfi.collisions);
        System.out.println("Average collisions per person: " + (double) hfi.collisions/hfi.tableSize);
        

        //HashMap
        Date startDate = new Date();
	    Date endDate;
	    double time2;
	    int rounds2 = 0;
	    do {
	    	HashMap map = new HashMap();
	    	for(int i = 0; i < qed.length; i++) {
	    		map.put(qed[i], qed[i]);
	    	}
	    	endDate = new Date();
	    	rounds2++;
	    }while(endDate.getTime()-startDate.getTime() < 1000);
		time2 = (double)(endDate.getTime()-startDate.getTime())/rounds2;
		System.out.println("\nMilliseconds per round: " + time2);

    }
}