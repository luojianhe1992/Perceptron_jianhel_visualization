package algorithm;

import java.util.ArrayList;
import java.util.List;

import io.DataLoader;

import interfaces.Tic_Tac_Toe_Data;

import model.PerceptronGameData;

public class PerceptronTesteor {

	//存储所有数据
	
	
	//store all the data from tic tac toe game
	List<Tic_Tac_Toe_Data> allData_Tic_Tac_Toe_Game;
	
	//store all the data from tic tac toe game in another way
	List<Tic_Tac_Toe_Data> allData_Tic_Tac_Toe_Game2;

	double [] theta = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
                          
        double [] firstTheta = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        
        double j = 0.0;
	double j_sign = 0.0;
	int correctness = 0;
	double precision = 0.0;
        
        int positivePositive = 0;
        int positiveNegative = 0;
        int negativePositive = 0;
        int negativeNegative = 0;
        
        public int getPositivePositive(){
            return positivePositive;
        }
        
        public int getPositiveNegative(){
            return positiveNegative;
        }
        public int getNegativePositive(){
            return negativePositive;
        }
        public int getNegativeNegative(){
            return negativeNegative;
        }
        
        public double getJ(){
            return j;
        }
        public double getJ_sign(){
            return j_sign;
        }
        public int getCorrectness(){
            return correctness;
        }
        public double getPrecision(){
            return precision;
        }
        
        
        public double [] getTheta(){
            return theta;
        }
        
        public double [] getFirstTheta(){
            return firstTheta;
        }
        
        public void setTheta(double [] t){
            this.theta = t;
        }
        
        public void setFirstTheta(double [] ft){
            this.firstTheta = ft;
        }
	
	//load the tic tac toe game data.
	public void loadData_Tic_Tac_Toe_Game(){
		
		System.out.println("invoke the function of loadData_Tic_Tac_Toe_Game");
		
		allData_Tic_Tac_Toe_Game = new ArrayList<Tic_Tac_Toe_Data>();
		
		List<int []> loadData0 = DataLoader.loadTicTacToeGameData("/Users/jianheluo/Downloads/tic_tac_toe_data_negative.dat");
		
		List<int []> loadData1 = DataLoader.loadTicTacToeGameData("/Users/jianheluo/Downloads/tic_tac_toe_data_positive.dat");
		
		for(int [] data:loadData0){
			PerceptronGameData pgd = new PerceptronGameData("negative",data);
			allData_Tic_Tac_Toe_Game.add(pgd);
		}
		
		for(int [] data:loadData1){
			PerceptronGameData pgd = new PerceptronGameData("positive", data);
			allData_Tic_Tac_Toe_Game.add(pgd);
		}
	}
	
	public void loadData_Tic_Tac_Toe_Game2(){
		
		System.out.println("invoke the function of loadData_Tic_Tac_Toe_Game2");
		
		allData_Tic_Tac_Toe_Game2 = new ArrayList<Tic_Tac_Toe_Data>();
		
		List<int []> loadData0 = DataLoader.loadTicTacToeGameData2("/Users/jianheluo/Downloads/tic_tac_toe_data_negative.dat");
		
		List<int []> loadData1 = DataLoader.loadTicTacToeGameData2("/Users/jianheluo/Downloads/tic_tac_toe_data_positive.dat");
		
		
		for(int [] data:loadData0){
			PerceptronGameData pgd = new PerceptronGameData("negative",data);
			allData_Tic_Tac_Toe_Game2.add(pgd);
		}
		
		for(int [] data:loadData1){
			PerceptronGameData pgd = new PerceptronGameData("positive", data);
			allData_Tic_Tac_Toe_Game2.add(pgd);
		}
	}

	
	
	public void trainAndDisplay_Tic_Tac_Toe_GameOffline(){
		PerceptionAlgorithm algorithm = new PerceptionAlgorithm();
		
		System.out.println("invoke the function of train_Tic_Tac_Toe_Game in the PerceptionAlgorithm class");
		
		
		//invoke the function
		algorithm.train_Tic_Tac_Toe_GameOffLine(allData_Tic_Tac_Toe_Game2);
		
                
                for (int i = 0; i < algorithm.getFirstTheta().length; i++) {
			firstTheta[i] = algorithm.getFirstTheta()[i];
		}
                
                for (int i = 0; i < algorithm.getTheta().length; i++) {
			theta[i] = algorithm.getTheta()[i];
		}
                
                this.j = algorithm.getJ();
                this.j_sign = algorithm.getJ_sign();
                this.correctness = algorithm.getCorrectness();
                this.precision = algorithm.getPrecision();
                
                this.positivePositive = algorithm.getPositivePositive();
                this.negativeNegative = algorithm.getNegativeNegative();
                this.positiveNegative = algorithm.getPositiveNegative();
                this.negativePositive = algorithm.getNegativePositive();
                 
                
		//System.out.println("star the online version training");
		
		//algorithm.train_Tic_Tac_Toe_GameOnLine(allData_Tic_Tac_Toe_Game2);
		
		System.out.println("end the invokement of the function of train_Tic_Tac_Toe_Game");
		
		System.out.print("the labels of PerceptronAlgorithm is:");
		for (int i = 0; i < algorithm.getLabels().length; i++) {
			System.out.print(algorithm.getLabels()[i] + "\t");
		}
		
		System.out.println();

		System.out.println("the firstTheta of PerceptronAlgorithm is:");
		for (int i = 0; i < algorithm.getFirstTheta().length; i++) {
			System.out.println(algorithm.getFirstTheta()[i] + "\t");
		}
		System.out.println();

		System.out.println("the theta of PerceptronAlgorithm is:");
		for (int i = 0; i < algorithm.getTheta().length; i++) {
			System.out.println(algorithm.getTheta()[i] + "\t");
		}
		System.out.println();
	}
        
        public void trainAndDisplay_Tic_Tac_Toe_GameOnline(){
		PerceptionAlgorithm algorithm = new PerceptionAlgorithm();
		
		System.out.println("invoke the function of train_Tic_Tac_Toe_Game in the PerceptionAlgorithm class");
		
		
		
		algorithm.train_Tic_Tac_Toe_GameOnLine(allData_Tic_Tac_Toe_Game2);
		
                this.j = algorithm.getJ();
                this.j_sign = algorithm.getJ_sign();
                this.correctness = algorithm.getCorrectness();
                this.precision = algorithm.getPrecision();
                
                this.positivePositive = algorithm.getPositivePositive();
                this.negativeNegative = algorithm.getNegativeNegative();
                this.positiveNegative = algorithm.getPositiveNegative();
                this.negativePositive = algorithm.getNegativePositive();
                
                
                for (int i = 0; i < algorithm.getFirstTheta().length; i++) {
			firstTheta[i] = algorithm.getFirstTheta()[i];
		}
                
                for (int i = 0; i < algorithm.getTheta().length; i++) {
			theta[i] = algorithm.getTheta()[i];
		}
                
		//System.out.println("star the online version training");
		
		//algorithm.train_Tic_Tac_Toe_GameOnLine(allData_Tic_Tac_Toe_Game2);
		
		System.out.println("end the invokement of the function of train_Tic_Tac_Toe_Game");
		
		System.out.print("the labels of PerceptronAlgorithm is:");
		for (int i = 0; i < algorithm.getLabels().length; i++) {
			System.out.print(algorithm.getLabels()[i] + "\t");
		}
		
		System.out.println();

		System.out.println("the firstTheta of PerceptronAlgorithm is:");
		for (int i = 0; i < algorithm.getFirstTheta().length; i++) {
			System.out.println(algorithm.getFirstTheta()[i] + "\t");
		}
		System.out.println();

		System.out.println("the theta of PerceptronAlgorithm is:");
		for (int i = 0; i < algorithm.getTheta().length; i++) {
			System.out.println(algorithm.getTheta()[i] + "\t");
		}
		System.out.println();
	}
	
	
	public List<Tic_Tac_Toe_Data> getAllData_Tic_Tac_Toe_Game2() {
		return allData_Tic_Tac_Toe_Game2;
	}

	public void setAllData_Tic_Tac_Toe_Game2(
			List<Tic_Tac_Toe_Data> allData_Tic_Tac_Toe_Game2) {
		this.allData_Tic_Tac_Toe_Game2 = allData_Tic_Tac_Toe_Game2;
	}

	

	public List<Tic_Tac_Toe_Data> getAllData_Tic_Tac_Toe_Game() {
		return allData_Tic_Tac_Toe_Game;
	}

	public void setAllData_Tic_Tac_Toe_Game(
			List<Tic_Tac_Toe_Data> allData_Tic_Tac_Toe_Game) {
		this.allData_Tic_Tac_Toe_Game = allData_Tic_Tac_Toe_Game;
	}
	
	

	public static void main(String[] args) {
		
		/*
		
		System.out.println("Process the outside data.");
		
		PerceptronTesteor testor = new PerceptronTesteor();

		testor.loadData();
		
		testor.trainAndDisplay();
		
		
		*/
		
		
		/*
		System.out.println("***************************************");
		
		System.out.println("Process the project data in the first way.");
		
		PerceptronTesteor testor_Tic_Tac_Toe_Game = new PerceptronTesteor();
		
		testor_Tic_Tac_Toe_Game.loadData_Tic_Tac_Toe_Game();
		
		
		testor_Tic_Tac_Toe_Game.trainAndDisplay_Tic_Tac_Toe_Game();
		*/
		
		
	
		System.out.println("***************************************&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		
		System.out.println("Process the project data in the second way.");
		
		PerceptronTesteor testor_Tic_Tac_Toe_Game2 = new PerceptronTesteor();
		
		testor_Tic_Tac_Toe_Game2.loadData_Tic_Tac_Toe_Game2();
		
		
	
		testor_Tic_Tac_Toe_Game2.trainAndDisplay_Tic_Tac_Toe_GameOffline();
		
		
	}
	
	
	
	
	
	

	

}
