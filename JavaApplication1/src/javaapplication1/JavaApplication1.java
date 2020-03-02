package javaapplication1;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class JavaApplication1 {

    public static ArrayList fcfs(ArrayList<Process> array) {
        int time;
        time = array.get(0).getArrivale();
        for (int i = 0; i < array.size(); i++) {
            time += array.get(i).getBurst();
            array.get(i).setExittime(time);
        }
        for (int i = 0; i < array.size(); i++) {
            array.get(i).setTurnaroundtime(array.get(i).getExittime() - array.get(i).getArrivale());
            array.get(i).setWaitingtime(array.get(i).getTurnaroundtime() - array.get(i).getBurst());
        }

        return array;
    }

    public static ArrayList filter(ArrayList<Process> array, int time) {
        ArrayList<Process> result = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getArrivale() <= time && array.get(i).getRemaningtime() != 0) {
                result.add(array.get(i));
            }
        }
        return result;
    }

    public static void sortremaning(ArrayList<Process> L) {
        Collections.sort(L, (Object o1, Object o2) -> {
            if (((Process) o1).getRemaningtime() == ((Process) o2).getRemaningtime()) {
                return 0;
            } else if (((Process) o1).getRemaningtime() < ((Process) o2).getRemaningtime()) {
                return -1;
            } else {
                return 1;
            }
        });
    }

    public static void sortarrivale(ArrayList<Process> L) {
        Collections.sort(L, (Object o1, Object o2) -> {
            if (((Process) o1).getArrivale() == ((Process) o2).getArrivale()) {
                return 0;
            } else if (((Process) o1).getArrivale() < ((Process) o2).getArrivale()) {
                return -1;
            } else {
                return 1;
            }
        });
    }

    public static void sortchartarrivale(ArrayList<Process> L) {
        Collections.sort(L, (Object o1, Object o2) -> {
            if (((Process) o1).getChartarrival() == ((Process) o2).getChartarrival()) {
                return 0;
            } else if (((Process) o1).getChartarrival() < ((Process) o2).getChartarrival()) {
                return -1;
            } else {
                return 1;
            }
        });
    }

    public static ArrayList sjf(ArrayList<Process> array) {
        int time;
        time = array.get(0).getArrivale();
        ArrayList<Process> array3 = new ArrayList<>();
        while (true) {
            ArrayList<Process> array2 = filter(array, time);
            if (array3.size() == array.size()) {
                break;
            }
            if (array2.isEmpty()) {
                time++;
            } else {
                sortremaning(array2);
                time += array2.get(0).getBurst();
                array2.get(0).setRemaningtime(0);
                array2.get(0).setExittime(time);
                array3.add(array2.get(0));
            }

        }
        for (int i = 0; i < array3.size(); i++) {
            array3.get(i).setTurnaroundtime(array3.get(i).getExittime() - array3.get(i).getArrivale());
            array3.get(i).setWaitingtime(array3.get(i).getTurnaroundtime() - array3.get(i).getBurst());

        }
        sortarrivale(array3);
        return array3;
    }

    public static ArrayList srtf(ArrayList<Process> array) {
        int time;
        time = array.get(0).getArrivale();
        ArrayList<Process> array3 = new ArrayList<>();
        while (true) {
            ArrayList<Process> array2 = filter(array, time);
            if (array3.size() == array.size()) {
                break;
            }
            if (array2.isEmpty()) {
                time++;
            } else {
                sortremaning(array2);
                time += 1;
                array2.get(0).setRemaningtime(array2.get(0).getRemaningtime() - 1);
                if (array2.get(0).getRemaningtime() == 0) {
                    array2.get(0).setExittime(time);
                    array3.add(array2.get(0));
                }
            }

        }
        for (int i = 0; i < array3.size(); i++) {
            array3.get(i).setTurnaroundtime(array3.get(i).getExittime() - array3.get(i).getArrivale());
            array3.get(i).setWaitingtime(array3.get(i).getTurnaroundtime() - array3.get(i).getBurst());

        }
        sortarrivale(array3);
        return array3;
    }

    public static ArrayList rr(ArrayList<Process> array, int q) {
        int time;
        time = array.get(0).getArrivale();
        ArrayList<Process> array3 = new ArrayList<>();
        while (true) {
            ArrayList<Process> array2 = filter(array, time);
            if (array3.size() == array.size()) {
                break;
            }
            if (array2.isEmpty()) {
                time++;
            } else {
                sortchartarrivale(array2);
                if (array2.get(0).getRemaningtime() >= q) {
                    time += q;
                    array2.get(0).setRemaningtime(array2.get(0).getRemaningtime() - q);
                    array2.get(0).setChartarrival(time);
                    if (array2.get(0).getRemaningtime() == 0) {
                        array2.get(0).setExittime(time);
                        array3.add(array2.get(0));
                    }
                } else {
                    time += array2.get(0).getRemaningtime();
                    array2.get(0).setRemaningtime(0);
                    if (array2.get(0).getRemaningtime() == 0) {
                        array2.get(0).setExittime(time);
                        array3.add(array2.get(0));
                    }

                }

            }

        }
        for (int i = 0; i < array3.size(); i++) {
            array3.get(i).setTurnaroundtime(array3.get(i).getExittime() - array3.get(i).getArrivale());
            array3.get(i).setWaitingtime(array3.get(i).getTurnaroundtime() - array3.get(i).getBurst());

        }
        sortarrivale(array3);
        return array3;
    }

    public static void main(String[] args) {
        ArrayList<Process> array = new ArrayList<>();
        ArrayList<Process> array2 = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String l;
        System.out.println("Enter the type of Operation FCFS or SRTF or SJF or RR");
        l = sc.next();
        int n;
        int x;
        int y;
        float average = 0;
        float average2 = 0;
        System.out.println("Enter the number of Process");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the Arrive Time");
            x = sc.nextInt();
            System.out.println("Enter the Burst Time");
            y = sc.nextInt();
            array.add(new Process(x, y));
        }
        switch (l) {
            case "FCFS":
                array = fcfs(array);
                for (int i = 0; i < array.size(); i++) {
                    System.out.println("waiting time of P" + (i + 1) + " = " + array.get(i).getWaitingtime());
                    System.out.println("turning time of P" + (i + 1) + " = " + array.get(i).getTurnaroundtime());
                    average += array.get(i).getTurnaroundtime();
                    average2 += array.get(i).getWaitingtime();
                }
                System.out.println("Average of turnaround = " + average / n);
                System.out.println("Average of Waiting = " + average2 / n);
                break;
            case "SRTF":
                array2 = srtf(array);
                for (int i = 0; i < array2.size(); i++) {
                    System.out.println("waiting time of P" + (i + 1) + " = " + array2.get(i).getWaitingtime());
                    System.out.println("turning time of P" + (i + 1) + " = " + array2.get(i).getTurnaroundtime());
                    average += array2.get(i).getTurnaroundtime();
                    average2 += array.get(i).getWaitingtime();
                }
                System.out.println("Average of turnaround = " + average / n);
                System.out.println("Average of Waiting = " + average2 / n);
                break;
            case "SJF":
                array2 = sjf(array);
                for (int i = 0; i < array2.size(); i++) {
                    System.out.println("waiting time of P" + (i + 1) + " = " + array2.get(i).getWaitingtime());
                    System.out.println("turning time of P" + (i + 1) + " = " + array2.get(i).getTurnaroundtime());
                    average += array2.get(i).getTurnaroundtime();
                    average2 += array.get(i).getWaitingtime();
                }
                System.out.println("Average of turnaround = " + average / n);
                System.out.println("Average of Waiting = " + average2 / n);
                break;
            case "RR":
                System.out.println("Enter the quantum time");
                int q;
                q = sc.nextInt();
                array2 = rr(array, q);
                for (int i = 0; i < array2.size(); i++) {
                    System.out.println("waiting time of P" + (i + 1) + " = " + array2.get(i).getWaitingtime());
                    System.out.println("turning time of P" + (i + 1) + " = " + array2.get(i).getTurnaroundtime());
                    average += array2.get(i).getTurnaroundtime();
                    average2 += array.get(i).getWaitingtime();
                }
                System.out.println("Average of turnaround = " + average / n);
                System.out.println("Average of Waiting = " + average2 / n);
                break;
        }

    }
}
