public class Project{
	public static void main(string[]args){
		ArrayList <String> Line = new ArrayList <String>();
		ArrayList <String> List = new ArrayList <String>();
		ArrayList <String> Itinerary = new ArrayList <String>();
		int time = 0;
		int min_time = 0;
		
		//user's input in List
		
		for (int i=0; i<List.length; i++){
			queue(Line, List, i);
		}
	}
	
	public static queue(line, list, i){
		line[line.length] = list[i];
		if (list.length > 0) {
			for (i=1; i<list.length; i++){
				queue(Line, List, i);
			}
			else {
				line[0] = ;
				line[line.length] = ;
				time = calc_time(line);
				if (time < min_time) {
				}
			}
		}
	}
		
}