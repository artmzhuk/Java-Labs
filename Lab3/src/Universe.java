public class Universe implements Comparable<Universe > {
    private String name;
    private int count = 0;
    private Point[] points;
    private Point center;
    private double length;
    private Boolean centerRecalc;
    Universe(String name,int n){
        this.points = new Point[n];
        this.center = null;
        this.length = 0;
        this.centerRecalc = true;
        this.name = name;
    }
    private class Point{
        double x, y, z, m;

        Point(double x, double y,double z, double m){
            this.x = x;
            this.y = y;
            this.z = z;
            this.m = m;
        }
        public String toString(){
            StringBuilder result = new StringBuilder();
            result.append(this.x + "\t" + this.y +"\t"+this.z+"\t"+this.m);
            return result.toString();
        }
    }
    public int getCount(){
        return count;
    }
    public void addPoint(double x, double y, double z, double m){
        this.points[this.getCount()] = new Point(x, y, z, m);
        count++;
        this.centerRecalc = true;
        this.length = this.getLength();
    }
    private void calcCenter(){
        double sumX = 0;
        double sumY = 0;
        double sumZ = 0;
        double sumM = 0;
        for (int i = 0; i < count; i++){
            sumX += this.points[i].x * this.points[i].m;
        }
        for (int i = 0; i < count; i++){
            sumY += this.points[i].y * this.points[i].m;
        }
        for (int i = 0; i < count; i++){
            sumZ += this.points[i].z * this.points[i].m;
        }
        for (int i = 0; i < count; i++){
            sumM+= this.points[i].m;
        }
        this.center = new Point(sumX / sumM, sumY / sumM, sumZ / sumM, sumM);
        this.centerRecalc = false;
    }

    public Point getCenter(){
        if (this.centerRecalc){
            this.calcCenter();
        }
        Point res = new Point(this.center.x, this.center.y, this.center.z, this.center.m);
        return res;
    }

    public double getLength(){
        if (this.centerRecalc){
            this.calcCenter();
        }
        double len = Math.sqrt(Math.pow(this.center.x,2) + Math.pow(this.center.y, 2) + Math.pow(this.center.z, 2));
        this.length = len;
        return this.length;
    }
    public String getName(){
        return  this.name;
    }

    public int compareTo(Universe obj){
        if (this.length == obj.length){
            return 0;
        }
        return (int) (this.length - obj.length);
    }

    public double getVolume(){
        if (this.centerRecalc){
            this.calcCenter();
        }
        double maxX = this.points[0].x;
        double maxY = this.points[0].y;
        double maxZ = this.points[0].z;
        for (int i = 0; i < this.getCount(); i++){
            if(Math.abs(this.points[i].x) >Math.abs(maxX) ){
                maxX = this.points[i].x;
            }
            if(Math.abs(this.points[i].y) > Math.abs(maxY)){
                maxY = this.points[i].y;
            }
            if(Math.abs(this.points[i].z) > Math.abs(maxZ)){
                maxZ = this.points[i].z;
            }
        }
        double r = Double.max(  Math.abs(maxX- this.center.x), Math.abs(maxY - this.center.y));
        r = Double.max(r, Math.abs(maxZ - this.center.z));
        double volume = ((double) 4 / (double) 3)* Math.PI * Math.pow(r, 3);
        return volume;
    }

    public String toString(){
        StringBuilder result = new StringBuilder(new StringBuilder());
        for (int i = 0; i < count; i++){
            result.append(this.points[i].x).append("\t").append(this.points[i].y).append("\t").append(this.points[i].z).append("\n");
        }
        return result.toString();
    }
}
