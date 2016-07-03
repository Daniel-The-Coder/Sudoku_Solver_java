import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

/**
 * Created by Lord Daniel on 7/3/2016.
 */
public class SudokuConfig implements Configuration{

    private int[][] grid;
    private int row;
    private int col;

    public SudokuConfig(String filename) throws FileNotFoundException{
        this.grid = new int[9][9];
        Scanner in = new Scanner(new File(filename));
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                String n = in.next();
                if(n.equals(".")){
                    grid[i][j]=0;
                }
                else {
                    grid[i][j] = Integer.parseInt(n);
                }
            }
        }
        this.row=0;
        this.col=0;
    }

    public SudokuConfig(SudokuConfig other){
        int[][] ar = new int[9][9];
        for (int i=0;i<9;i++) {
            for (int j = 0; j < 9; j++) {
                ar[i][j]=this.grid[i][j];
            }
        }
        this.grid = ar;
        this.row=other.row;
        this.col=other.col;
    }

    public Collection<Configuration> getSuccessors(){
        ArrayList<Configuration> ar = new ArrayList<>();
        boolean flag=false;
        for (int i=1;i<9;i++){
            for(int j=0;j<9;j++){
                if(this.grid[i][j]==0){
                    for(int k=1;k<10;k++){
                        SudokuConfig SC = new SudokuConfig(this);
                        SC.grid[i][j]=k;
                        ar.add(SC);
                        flag=true;
                        break;
                    }
                }
                if(flag){
                    break;
                }
            }
            if(flag){
                break;
            }
        }
        return ar;
    }

    public boolean isValid(){
        int r = this.row;
        int c = this.col;
        return true;
    }

    public boolean isGoal(){
        for (int i=0;i<10;i++) {
            for (int j = 0; j < 10; j++) {
                if (grid[i][j]==0){
                    return false;
                }
            }
        }
        return true;
    }



}
