class Spreadsheet {
    int arr[][];
    public Spreadsheet(int rows) {
        arr=new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        int col=(int)(cell.charAt(0)-'A');
        int row=0;
        for(int i=1;i<cell.length();i++){
            row=row*10+(int)(cell.charAt(i)-'0');
        }
        
        arr[row-1][col]=value;
    }
    
    public void resetCell(String cell) {
        int col=(int)(cell.charAt(0)-'A');
        int row=0;
        for(int i=1;i<cell.length();i++){
            row=row*10+(int)(cell.charAt(i)-'0');
        }
        arr[row-1][col]=0;
    }
    
    public int getValue(String formula) {
        int v1=0,v2=0,i=1;
        if(formula.charAt(i)>='A'&&formula.charAt(i)<='Z'){
            int col=(int)(formula.charAt(i)-'A');
            i++;
            int row=0;
            while(formula.charAt(i)!='+'){
                row=row*10+(int)(formula.charAt(i)-'0');
                i++;
            }
            v1=arr[row-1][col];

        }
        else{
            while(formula.charAt(i)!='+'){
                v1=v1*10+(int)(formula.charAt(i)-'0');
                i++;
            }
        }
        i++;
        if(formula.charAt(i)>='A'&&formula.charAt(i)<='z'){
            int col=(int)(formula.charAt(i)-'A');
            i++;
            int row=0;
            while(i<formula.length()){
                row=row*10+(int)(formula.charAt(i)-'0');
                i++;
            }
            v2=arr[row-1][col];

        }
        else{
            while(i<formula.length()){
                v2=v2*10+(int)(formula.charAt(i)-'0');
                i++;
            }
        }
        return v1+v2; 
    }
}


/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */