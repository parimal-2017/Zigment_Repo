import java.util.ArrayList;
import java.util.List;

public class LeadManagement {
    private List<Lead> leads;

    public LeadManagement() {
        leads = new ArrayList<>();
    }

    public void addLead(Lead lead) {
        leads.add(lead);
        processLead(lead);
    }

    private void processLead(Lead lead) {
        if (lead.getScore() > 70) {
            sendWelcomeEmail(lead);
        } else {
            logNurturingLead(lead);
        }
    }

    private void sendWelcomeEmail(Lead lead) {
        System.out.println("Sending welcome email to: " + lead.getName());
        // Integrate with email API
    }

    private void logNurturingLead(Lead lead) {
        System.out.println("Logging nurturing for lead: " + lead.getName());
        // Integrate with CRM or logging system
    }
}
