package ua.nure.brykovets.dmytro.usermanagement.agent;

import jade.core.Agent;

public class SearchAgent extends Agent {
    @Override
    protected void setup() {
        System.out.println("INFO: " + getAID().getName() + " started");
    }

    @Override
    protected void takeDown() {
        System.out.println("INFO: " + getAID().getName() + " stopped");
    }
}
