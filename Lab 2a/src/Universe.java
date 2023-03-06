public class Universe {
    static int count = 0;
    private final Point[] points;
    private Point center;
    private Boolean centerRecalc;
    Universe(int n){
         this.points = new Point[n];
         this.center = null;
         this.centerRecalc = true;
    }
    private static class Point{
        double x, y, z;

        Point(double x, double y,double z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
        public String toString(){
            return this.x + "\t" + this.y + "\t" + this.z;
        }
    }
    public int getCount(){
        return count;
    }
    public void addPoint(double x, double y, double z){
        this.points[this.getCount()] = new Point(x, y, z);
        count++;
        this.centerRecalc = true;
    }
    private void calcCenter(){
        double sumX = 0;
        double sumY = 0;
        double sumZ = 0;
        for (int i = 0; i < count; i++){
            sumX += this.points[i].x;
        }
        for (int i = 0; i < count; i++){
            sumY += this.points[i].y;
        }
        for (int i = 0; i < count; i++){
            sumZ += this.points[i].z;
        }
        this.center = new Point(sumX / this.getCount(), sumY / this.getCount(), sumZ / this.getCount());
        this.centerRecalc = false;
    }

    public Point getCenter(){
        if (this.centerRecalc){
            this.calcCenter();
        }
        Point res = new Point(this.center.x, this.center.y, this.center.z);
        return res;
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
