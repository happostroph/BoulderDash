public class Main implements Runnable{
	
	static MapMaker maker = null;
	
	public void run(){
		System.out.println("Thread is running");
		
		maker.spritesCreation();
		Window window = new Window(maker);
	}
		
	public static void main(String[] args) {
		
		DAOTest connectionBDD = new DAOTest();
		
		connectionBDD.connection();
		connectionBDD.executeQuery();
		connectionBDD.setQueryIntoTable();
		TranslateMap translate = new TranslateMap(connectionBDD);
		maker = new MapMaker(translate);
		
		Main m1 = new Main();
		Thread t1 =new Thread(m1);  
		t1.start(); 
		
	}
}

