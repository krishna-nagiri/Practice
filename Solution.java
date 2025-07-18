class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        int n = s.length();
        for(int i = 0;i<n;i++)
        {
            int currCharVal  = getValueOfChar(s.charAt(i));   
            if(i+1 < n && (currCharVal < getValueOfChar(s.charAt(i+1)))){
                sum += getValueOfChar(s.charAt(i+1)) - currCharVal;
                i++;  
            }else{
                sum += currCharVal;
            }
        }
        return sum;
    }
    public static int getValueOfChar(char c){
        switch(c){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default  : return 0;
        }
    }
    public static void main(String[] args){
	Solution s = new Solution();
	int result = s.romanToInt("MCMXCIV");
	System.out.println(result);

}
}