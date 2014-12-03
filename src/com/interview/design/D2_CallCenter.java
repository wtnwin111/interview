package com.interview.design;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created_By: stefanie
 * Date: 14-12-2
 * Time: 下午4:12
 */
public class D2_CallCenter {
    static class Call {
        int rank = 0; // minimal rank of employee who can handle this call

        public void reply(String message) {

        }

        public void disconnect() {

        }
    }

    static class Employee {
        CallHandler callHandler;
        int rank; // 0- fresher, 1 - technical lead, 2 - product manager
        boolean free;

        Employee(int rank) {
            this.rank = rank;
        }

        void receiveCall(Call call) {

        }

        void callHandled(Call call) {  // call is complete
        }

        void cannotHandle(Call call) { // escalate call
            call.rank = rank + 1;
            callHandler.dispatchCall(call);
            free = true;
            callHandler.getNextCall(this); // look for waiting call
        }
    }

    static class Fresher extends Employee {
        public Fresher() {
            super(0);
        }
    }

    static class TechLead extends Employee {
        public TechLead() {
            super(1);
        }
    }

    static class ProductManager extends Employee {
        public ProductManager() {
            super(2);
        }
    }

    static class CallHandler {
        static final int LEVELS = 3; // we have 3 levels of employees
        static final int NUM_FRESHERS = 5; // we have 5 freshers
        ArrayList<Employee>[] employeeLevels = new ArrayList[LEVELS]; // queues for each call’s rank
        Queue<Call>[] callQueues = new LinkedList[LEVELS];

        public CallHandler() {
            ArrayList<Employee> freshmans = new ArrayList<>();
            for (int i = 0; i < NUM_FRESHERS; i++) freshmans.add(new Fresher());
            employeeLevels[0] = freshmans;
            ArrayList<Employee> techlead = new ArrayList<>();
            techlead.add(new TechLead());
            employeeLevels[1] = techlead;
            ArrayList<Employee> pm = new ArrayList<>();
            pm.add(new ProductManager());
            employeeLevels[2] = pm;
        }

        private Employee getCallHandler(Call call) { // routes the call to an available employee, or adds to a queue
            for (int level = call.rank; level < LEVELS - 1; level++) {
                ArrayList<Employee> employeeLevel = employeeLevels[level];
                for (Employee emp : employeeLevel) {
                    if (emp.free) {
                        return emp;
                    }
                }
            }
            return null;
        }

        public void dispatchCall(Call call) {  // try to route the call to an employee with minimal rank
            Employee emp = getCallHandler(call);
            if (emp != null) {
                emp.receiveCall(call);
            } else {        // place the call into queue according to its rank
                callQueues[call.rank].add(call);
            }
        }

        void getNextCall(Employee e) {  // look for call for e’s rank
            if (callQueues[e.rank].size() > 0) {
                Call call = callQueues[e.rank].poll();
                e.receiveCall(call);
            }
        }
    }
}

