class Solution {
    public String solution(String new_id) {
        String answer = "";

        new_id = new_id.toLowerCase(); //소문자로 치환
        new_id = new_id.replaceAll("[^a-z0-9-_.]","");
        
        //연속되는 . 제거
        new_id = new_id.replaceAll("\\.+",".");
        
        if(new_id.charAt(0)=='.'){
            new_id = new_id.substring(1,new_id.length());
        }
        int last = new_id.length();
        if((last != 0)&&(new_id.charAt(last-1) =='.')){
            new_id = new_id.substring(0,last-1);
        }
        if(new_id.length() ==0){
            new_id = "a";
        }
        if(new_id.length() > 15){
            new_id = new_id.substring(0,15);
        }
        while(new_id.length() < 3){
            char c = new_id.charAt(new_id.length()-1);
            new_id = new_id+c;
        }
        
        last = new_id.length();
        if((last != 0)&&(new_id.charAt(last-1) =='.')){
            new_id = new_id.substring(0,last-1);
        }
        return new_id;
    }
}