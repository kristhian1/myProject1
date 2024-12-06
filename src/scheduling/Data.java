
package scheduling;



public class Data {
    
    private String ipAdd;
    private String num;

    public Data(String ipAdd, String num){
        this.ipAdd = ipAdd;
        this.num = num;
    }
    public String getIP(){
        return ipAdd;
    }
    public String getNum(){
        return num;
    }
}
