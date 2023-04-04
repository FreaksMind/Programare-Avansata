package lab7;

public class Robot implements Runnable {
    private String name;
    private boolean isRunning;
    Exploration explore;
    

    public Robot(String name, int size) {
        this.name = name;
        isRunning = true;
        explore = new Exploration(size);
    }

    public String getName() {
        return name;
    }
    public int getNumTokens() {
    	int numOfTokens = (int) (Math.random() % 10);
    	return numOfTokens;
    }
    @Override
    public void run() {
        while (isRunning) {
            int row = (int) (Math.random() % 10);
            int col = (int) (Math.random() % 10);
            explore.getMap().visit(row, col, this);
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
