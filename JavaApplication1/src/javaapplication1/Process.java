
package javaapplication1;


public class Process {
    private int arrivale;
    private int burst;
    private int remaningtime;
    private int exittime;
    private int waitingtime;
    private int turnaroundtime;
    private int chartarrival;

    public int getChartarrival() {
        return chartarrival;
    }

    public void setChartarrival(int chartarrival) {
        this.chartarrival = chartarrival;
    }

    public int getWaitingtime() {
        return waitingtime;
    }

    public void setWaitingtime(int waitingtime) {
        this.waitingtime = waitingtime;
    }

    public int getTurnaroundtime() {
        return turnaroundtime;
    }

    public void setTurnaroundtime(int turnaroundtime) {
        this.turnaroundtime = turnaroundtime;
    }
    private String name;

    public int getArrivale() {
        return arrivale;
    }

    public void setArrivale(int arrivale) {
        this.arrivale = arrivale;
    }

    public int getBurst() {
        return burst;
    }

    public void setBurst(int burst) {
        this.burst = burst;
    }

    public int getRemaningtime() {
        return remaningtime;
    }

    public void setRemaningtime(int remaningtime) {
        this.remaningtime = remaningtime;
    }

    public int getExittime() {
        return exittime;
    }

    public void setExittime(int exittime) {
        this.exittime = exittime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Process(int arrivale, int burst) {
        this.arrivale = arrivale;
        this.burst = burst;
        this.remaningtime = burst;
        this.waitingtime=0;
        this.turnaroundtime=0;
        this.chartarrival = arrivale;
    }
    
    
}
