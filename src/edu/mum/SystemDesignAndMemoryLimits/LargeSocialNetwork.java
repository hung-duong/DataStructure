package edu.mum.SystemDesignAndMemoryLimits;

import java.util.ArrayList;

/**
 * Created by hungduong on 3/12/17.
 * Question: How would you design the data structures for a very large social network (Facebook, LinkedIn, etc)?
 * Describe how you would design an algorithm to show the connec- tion, or path, between two people
 * (e.g., Me -> Bob -> Susan -> Jason -> You).
 */
public class LargeSocialNetwork {
    public class Server {
        ArrayList<Machine> machines = new ArrayList<Machine>();
    }

    public class Machine {
        public ArrayList<Person> persons = new ArrayList<Person>();
        public int machineID;
    }

    public class Person {
        private ArrayList<Integer> friends; private int ID;
        private int machineID;
        private String info;
        private Server server = new Server();

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public int[] getFriends() {
            int[] temp = new int[friends.size()]; for (int i = 0; i < temp.length; i++) {
                temp[i] = friends.get(i); }
            return temp;
        }

        public int getID() {
            return ID;
        }

        public int getMachineID() {
            return machineID;
        }

        public void addFriend(int id) {
            friends.add(id);
        }

        // Look up a person given their ID and Machine ID
        public Person lookUpFriend(int machineID, int ID) {
            for (Machine m : server.machines) {
                if (m.machineID == machineID) {
                    for (Person p : m.persons) {
                        if (p.ID == ID){
                            return p;
                        }
                    }
                }
            }

            return null;
        }

        // Look up a machine given the machine ID
        public Machine lookUpMachine(int machineID) {
            for (Machine m:server.machines) {
                if (m.machineID == machineID)
                    return m;
            }

            return null;
        }

        public Person(int iD, int machineID) {
            ID = iD;
            this.machineID = machineID;
        }
    }
}
