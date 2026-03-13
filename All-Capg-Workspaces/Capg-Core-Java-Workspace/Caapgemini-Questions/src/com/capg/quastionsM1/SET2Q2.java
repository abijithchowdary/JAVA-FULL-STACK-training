package com.capg.quastionsM1;
import java.util.*;
import java.util.stream.*;

public class SET2Q2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		MarksManager m = new MarksManager();
		m.processCommand(sc,n);
		
	}
}
class MarksManager{
	Map<String,Map<String,Integer>> Students = new LinkedHashMap<>();
	Map<String,Map<String,Integer>> Subjects = new LinkedHashMap<>();
	
	public void processCommand(Scanner sc,int n) {
		
		while(n-- > 0) {
			String command = sc.next();
		switch(command) {
		case "ADD": addRecord(sc.next(),sc.next(),sc.nextInt());break;
		case "REMOVE": removeRecord(sc.next(),sc.next());break;
		case "SUBTOPSCORER" : System.out.println(topScorer(sc.next()));break;
		case "RESULT" : System.out.println(result());break;
		}
	}
	}
	
	public void addRecord(String student,String subject,int mark) {
		Students.putIfAbsent(student, new LinkedHashMap<>());
		Subjects.putIfAbsent(subject, new LinkedHashMap<>());
		
		int oldmarks = Students.get(student).getOrDefault(subject, -1);
		
		if(oldmarks < mark) {
			Students.get(student).put(subject,mark);
			Subjects.get(subject).put(student,mark);
		}
	}
	
	public void removeRecord(String student,String subject) {
		if(!Students.containsKey(student) || !Students.get(student).containsKey(subject)) {
			System.out.println("There is no record with this details");
		}
		
		Students.get(student).remove(subject);
		Subjects.get(subject).remove(student);
		
		if(Students.get(student).isEmpty()) {
			Students.remove(student);
		}
		if(Subjects.get(subject).isEmpty()) {
			Subjects.remove(subject);
		}
	}
	
	public String topScorer(String subject) {
		if(!Subjects.containsKey(subject)) {
			return "Subject not exist";
		}
		int max = Collections.max(Subjects.get(subject).values());
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<String,Integer> entry : Subjects.get(subject).entrySet()) {
			if(entry.getValue() == max) {
				sb.append("The top scorer in ").append(subject).append(" is : ").append(entry.getKey());
			}
		}
		return sb.toString().trim();
	}
	
	public String result() {
		if(Students.isEmpty()) {
			return "no records found";
		}
		List<String> ids = new ArrayList<>(Students.keySet());
		StringBuilder sb1 = new StringBuilder();
		for(String id : ids) {
			double avg = Students.get(id).values().stream().mapToInt(i -> i).average().orElse(0);
			sb1.append("Result of ").append(id).append(" is : ").append(String.format("%.2f",avg));
		}
		return sb1.toString().trim();
	}
}