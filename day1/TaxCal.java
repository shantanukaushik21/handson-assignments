import java.util.HashMap;
public class TaxCal{
	public static void main(String[] args){
	int amt=Integer.parseInt(args[0]);
	HashMap<String, Integer> map = new HashMap<>(); 
	map.put("kerla", 5);
	map.put("up", 8);
	map.put("punjab", 15);
	map.put("jammu", 20);
	map.put("tamilnadu", 3);
	int size=args.length;
	for(int i=1;i<size;i++){
		int tax=map.get(args[i]);
		int cost=amt+(amt*tax)/100;
		System.out.println("Total cost in "+args[i]+"= " +cost);
}
}
}